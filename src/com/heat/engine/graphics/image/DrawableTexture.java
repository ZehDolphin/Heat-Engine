package com.heat.engine.graphics.image;

import java.awt.image.BufferedImage;

import com.heat.engine.math.Rectangle;

public class DrawableTexture extends Rectangle {

	public Texture texture;
	
	protected DrawableTexture(BufferedImage image) {
		texture = new Texture(image);
	}
	
	public DrawableTexture(Texture t, Rectangle r) {
		super(r.getX(), r.getY(), r.getWidth(), r.getHeight());
		texture = t;
	}
	
	public DrawableTexture(Texture t, float x, float y, float width, float height) {
		super(x, y, width, height);
		texture = t;
	}
	
}
