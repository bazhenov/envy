package org.farpost.envy.renderer;

import org.farpost.envy.Player;

import java.awt.*;
import static java.lang.Math.round;

public class AwtWorldRendererImpl implements WorldRenderer {

	private final Iterable<? extends Player> players;

	public AwtWorldRendererImpl(java.util.List<Player> players) {
		this.players = players;
	}

	public void update(Graphics2D g2) {
		for ( Player player : players ) {
			org.farpost.geometry.Point location = player.getLocation();
			int size = 5;
			int x = round(location.getX());
			int y = round(location.getY());
			g2.drawRect(x, y, size, size);
		}
	}
}
