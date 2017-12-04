package gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Background {
	
	private BufferedImage backgroundImage;
	private int width;
	private int height;

	public Background(BufferedImage backgroundImage, int width, int height) {
		this.backgroundImage = backgroundImage;
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, width, height, null);
	}

}
