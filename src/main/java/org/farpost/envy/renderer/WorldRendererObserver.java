package org.farpost.envy.renderer;

import org.farpost.envy.PlayersEventObserver;

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
