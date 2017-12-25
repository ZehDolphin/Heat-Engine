package com.heat.engine.graphics.image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * The TextureCollection is a class that can hold textures. <br>
 * This is used to group textures and have them on a location that can easily
 * <br>
 * be shared among other classes as a static object. <br>
 * This class itself is not static and has to be initiated. <br>
 * 
 * @author Pontus Wirsching
 * @since 2015-12-02
 */
public class TextureCollection {

	/**
	 * A HashMap that contains the held textures. <br>
	 */
	protected LinkedHashMap<String, Texture> textures = new LinkedHashMap<>();

	/**
	 * Puts a Texture into the textures HashMap.
	 * 
	 * @param key
	 *            <b>(String)</b> - Key that will identify the texture.
	 * @param texture
	 *            <b>(Texture)</b>
	 */
	public void put(String key, Texture texture) {
		textures.put(key, texture);
	}

	/**
	 * Loads a texture directly into the HashMap. <br>
	 * This avoids the need of first loading a texture <br>
	 * and then putting it into the TextureCollection. <br>
	 * 
	 * @param key
	 *            </b>(String)</b> - Key that will identify the texture.
	 * @param path
	 *            <b>(String)</b> - Relative path to the image file.
	 */
	public void loadTexture(String key, String path) {
		put(key, TextureLoader.loadTexture(path));
	}

	/**
	 * 
	 * @param key
	 *            <b>(String)</b> - Key to identify the requested texture.
	 * @return <b>(Texture)</b> <br>
	 *         The texture connected to the key inserted in the first parameter.
	 *         <br>
	 */
	public Texture get(String key) {
		return textures.get(key);
	}

	public Texture get(int index) {
		Texture result = null;
		result = (new ArrayList<Texture>(textures.values())).get(index);
		return result;
	}

	/**
	 * Retrieves the BufferedImage object inside the texture. <br>
	 * This method might be removed if proved unnecessary.
	 * 
	 * @param key
	 *            <b>(String)</b> - Key to identify the texture.
	 * @return <b>(BufferedImage)</b> <br>
	 *         The BufferedImage contained inside the Texture class. <br>
	 */
	public BufferedImage getImage(String key) {
		return textures.get(key).getImage();
	}

}
