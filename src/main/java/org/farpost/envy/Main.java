package org.farpost.envy;

import org.farpost.envy.renderer.*;
import org.farpost.geometry.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;
import static java.util.Collections.unmodifiableList;

public class Main extends JFrame {

	private final Thread movingThread;
	private final Frame frame;

	private Main() throws HeadlessException {
		List<Player> players = new ArrayList<Player>();
		final org.farpost.geometry.Point point = new org.farpost.geometry.Point(100, 100);
		for ( int i = 0; i < 100; i++ ) {
			Player player = new Player(point, 2.2f);
			PlayerController controller = new PlayerController(player);
			PlayerBehaviour behaviour = new PlayerBehaviourImpl(controller);
			players.add(player);
			new Thread(behaviour).start();
		}
		List<Player> frozenPlayers = unmodifiableList(players);

		PlayersMoveOn mover = new PlayersMoveOn(frozenPlayers);
		movingThread = new Thread(mover, "Players moving thread");

		WorldRenderer renderer = new AwtWorldRendererImpl(frozenPlayers);

		frame = new WorldFrame(renderer, "Events");

		PlayersEventObserver observer = new WorldRendererObserver(frame);
		mover.registerObserver(observer);

		frame.setSize(300, 300);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				movingThread.interrupt();
				try {
					movingThread.join();
				} catch ( InterruptedException e ) {
					throw new RuntimeException(e);
				}
				dispose();
				System.exit(0);
			}
		});
	}

	public void start() {
		frame.setVisible(true);
		movingThread.start();
	}

	public static void main(String[] args) {
		new Main().start();
	}
}
