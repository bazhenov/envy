package org.farpost.envy;

import java.awt.*;

public class WorldRendererObserver implements PlayersEventObserver {

	private final Frame frame;

	public WorldRendererObserver(Frame frame) {
		this.frame = frame;
	}

	public void playersChangePosition() {
		frame.repaint();
	}
}
