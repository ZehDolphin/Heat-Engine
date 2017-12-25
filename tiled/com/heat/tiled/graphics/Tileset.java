package com.heat.tiled.graphics;

import com.heat.engine.graphics.image.Texture;
import com.heat.engine.graphics.image.TextureCollection;

public class Tileset {


	private String path;

	private String name;

	private int firstgid = 0;

	private int tileWidth, tileHeight;

	private int imageWidth, imageHeight;

	private TextureCollection textures;
	
	public Tileset(TextureCollection t, String path, int tw, int th, int width, int height) {
		this.path = path;

		tileWidth = tw;
		tileHeight = th;
		setImageWidth(width);
		setImageHeight(height);

		// Commented out as I probably wanted it cus it was useful at some point, then I'll probably feel the same way again... :D
//		int tilesWide = getImageWidth() / getTileWidth() - 0;
//		int tilesHigh = getImageHeight() / getTileHeight() - 0;

		textures = t;
		
	}

	public String getPath() {
		return path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFirstgid() {
		return firstgid;
	}

	public void setFirstgid(int gid) {
		firstgid = gid;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setImageWidth(int w) {
		imageWidth = w;
	}

	public void setImageHeight(int h) {
		imageHeight = h;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public Texture getTile(int index) {
		return textures.get(index);
	}

}
