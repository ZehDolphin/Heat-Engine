package com.heat.engine.graphics.image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.heat.engine.graphics.Graphics;

public class DynamicRenderObject {

	public ArrayList<DrawableTexture> textures = new ArrayList<>();
	
	public BufferedImage image;
	
	public int width, height;
	
	public DynamicRenderObject() {
		
	}
	
	public void add(DrawableTexture texture) {
		textures.add(texture);
	}
	
	public float getMinX() {
		
		
		Collections.sort(textures, new Comparator<DrawableTexture>() {
			@Override
			public int compare(DrawableTexture o1, DrawableTexture o2) {
				return (int) ((o1.getX() < o2.getX()) ? o1.getX() : o2.getX());
			}
		});
		
		
		return 0;
	}
	
	public void draw() {
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		java.awt.Graphics g = image.getGraphics();
		System.out.println(width + " x " + height);
		
		
		for (DrawableTexture t : textures) {
			g.drawImage(t.texture.getImage(), (int)t.getX(), (int)t.getY(), (int)t.getWidth(), (int)t.getHeight(), null);
		}
		
		System.out.println(getMinX());
		
		
	}
	
	
	
}
