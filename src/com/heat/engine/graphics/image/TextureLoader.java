package com.heat.engine.graphics.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.heat.engine.io.FileUtils;

public class TextureLoader {

	/**
	 * Loads a texture collection based on a tile size. <br>
	 * This texture collection will contain all of the images, <br>
	 * so for example the top left most image would be named "00" <br>
	 * and the one to the right would be "10". <br>
	 */
	public static TextureCollection loadTextureSheet(String path, int tileSize) {
		TextureCollection result = new TextureCollection();
		BufferedImage image = ImageLoader.loadBufferedImage(path);

		
		for (int y = 0; y < image.getHeight() / tileSize; y++) {
			for (int x = 0; x < image.getWidth() / tileSize; x++) {
				result.put(x +""+ y, new Texture(image.getSubimage(x * tileSize, y * tileSize, tileSize, tileSize)));
			}
		}
		
		return result;
	}
	
	/**
	 * Loads a texture collection based on a tile width and height. <br>
	 * This texture collection will contain all of the images, <br>
	 * so for example the top left most image would be named "00" <br>
	 * and the one to the right would be "10". <br>
	 */
	public static TextureCollection loadTextureSheet(String path, int tileWidth, int tileHeight) {
		TextureCollection result = new TextureCollection();
		BufferedImage image = ImageLoader.loadBufferedImage(path);

		
		for (int y = 0; y < image.getHeight() / tileHeight; y++) {
			for (int x = 0; x < image.getWidth() / tileWidth; x++) {
				result.put(x +""+ y, new Texture(image.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight)));
			}
		}
		
		return result;
	}
	
	public static TextureCollection loadTextureSheet(String path) {
		TextureCollection result = new TextureCollection();
		BufferedImage image = ImageLoader.loadBufferedImage(path + ".png");
		
		
		try {
			File file = FileUtils.getLocal(path + ".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Node node = dBuilder.parse(file).getFirstChild();

			NodeList children = node.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node n = children.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					Element c = (Element) n;
					result.put(c.getAttribute("id"), new Texture(image.getSubimage(Integer.parseInt(c.getAttribute("x")), Integer.parseInt(c.getAttribute("y")), Integer.parseInt(c.getAttribute("width")), Integer.parseInt(c.getAttribute("height")))));
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static Texture loadTexture(String path) {
		Texture t = null;
		try {
			t = new Texture(ImageIO.read(TextureLoader.class.getResource("/" + path)));
		} catch (Exception e) {
			throw new NullPointerException("Could not load texture '" + path + "'");
		}
		return t;
	}

}
