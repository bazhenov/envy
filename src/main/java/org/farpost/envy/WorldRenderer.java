package org.farpost.envy;

import java.awt.*;

/**
 * WorldRenderer строит визуальное отображение мира
 */
public interface WorldRenderer {

	/**
	 * Обновить визуальное отображение
	 * @param g2
	 */
	void update(Graphics2D g2);
}
