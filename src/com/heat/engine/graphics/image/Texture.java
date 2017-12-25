package com.heat.engine.graphics.image;

import java.awt.image.BufferedImage;

public class Texture {

	protected BufferedImage image = null;

	public Texture() {
		
	}

	public BufferedImage getImage() {
		return image;
	}

	protected Texture(BufferedImage image) {
		this.image = image;
	}

	public float getWidth() {
		return image.getWidth();
	}

	public float getHeight() {
		return image.getHeight();
	}
	
	public Texture getSubtexture(int x, int y, int width, int height) {
		Texture t = new Texture();
		t.image = image.getSubimage(x, y, width, height);
		return t;
	}


}
