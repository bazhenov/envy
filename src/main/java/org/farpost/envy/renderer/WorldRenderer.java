package org.farpost.envy.renderer;

import java.awt.*;

/**
 * WorldRenderer строит визуальное отображение мира
 */
public interface WorldRenderer {

	/**
	 * Обновить визуальное отображение
	 * @param g2 канвас
	 */
	void update(Graphics2D g2);
}
