package org.farpost.envy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class Test extends JFrame {

	private final List<Player> players = new ArrayList<Player>();
	private final Thread movingThread;
	private final Frame frame;
	private final WorldRenderer renderer;

	private Test() throws HeadlessException {
		players.add(new Player(new org.farpost.geometry.Point(100, 100)));
		players.add(new Player(new org.farpost.geometry.Point(110, 110)));
		List<Player> unmodifiablePlayers = Collections.unmodifiableList(players);

		PlayersMoveOn mover = new PlayersMoveOn(unmodifiablePlayers);
		movingThread = new Thread(mover, "Players moving thread");

		renderer = new AwtWorldRendererImpl(unmodifiablePlayers);

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
		new Test().start();
	}
}
