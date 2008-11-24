package org.farpost.envy;

import org.farpost.envy.renderer.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class Main extends JFrame {

	private final Thread movingThread;
	private final Frame frame;

	private Main() throws HeadlessException {
		List<Player> players = new ArrayList<Player>();
		for ( int i = 0; i < 50; i++ ) {
			players.add(new Player(new org.farpost.geometry.Point(100, 100)));
		}
		List<Player> unmodifiablePlayers = Collections.unmodifiableList(players);

		PlayersMoveOn mover = new PlayersMoveOn(unmodifiablePlayers);
		movingThread = new Thread(mover, "Players moving thread");

		WorldRenderer renderer = new AwtWorldRendererImpl(unmodifiablePlayers);

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
