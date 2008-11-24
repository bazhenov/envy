package org.farpost.envy.renderer;

import org.farpost.envy.PlayerController;

import java.awt.*;
import static java.lang.Math.round;

public class AwtWorldRendererImpl implements WorldRenderer {

	private final Iterable<? extends PlayerController> players;
	private int xOffset = 30;
	private int yOffset = 30;
	private int width = 130;
	private int height = 130;

	public AwtWorldRendererImpl(Iterable<? extends PlayerController> players) {
		this.players = players;
	}

	public void update(Graphics2D g2) {
		for ( PlayerController player : players ) {
			org.farpost.geometry.Point location = player.getLocation();
			int size = 5;
			int x = round(location.getX());
			int y = round(location.getY());
			g2.drawRect(x, y, size, size);
		}
	}
}
