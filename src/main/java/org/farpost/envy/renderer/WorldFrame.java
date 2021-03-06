package org.farpost.envy.renderer;

import javax.swing.*;
import java.awt.*;

public class WorldFrame extends JFrame {

	private final WorldRenderer renderer;

	public WorldFrame(WorldRenderer renderer, String title) {
		super(title);
		this.renderer = renderer;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;
		renderer.update(g2);
	}
}
