package com.heat.tiled.map;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.heat.tiled.graphics.Tileset;
import com.heat.tiled.layer.Layer;

/**
 * The tiled map object, all values are just defaults and will be changed by the
 * parser.
 * 
 * @author Pontus Wirsching
 * @since 2015-09-23
 */
public class Map {

	private String version = "1.0";

	private String orientation = "orthogonal";

	private String renderorder = "right-down";

	private int width = 0;

	private int height = 0;

	private int tileWidth = 0;

	private int tileHeight = 0;

	private ArrayList<Layer> layers = new ArrayList<>();

	private ArrayList<Tileset> tilesets = new ArrayList<>();

	public Map(int width, int height, int tileWidth, int tileHeight) {
		this.width = width;
		this.height = height;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRenderorder() {
		return renderorder;
	}

	public void setRenderorder(String renderorder) {
		this.renderorder = renderorder;
	}

	public ArrayList<Layer> getLayers() {
		return layers;
	}

	public void setLayers(ArrayList<Layer> layers) {
		this.layers = layers;
	}

	public void addLayer(Layer layer) {
		layers.add(layer);
	}

	public Layer getLayer(int index) {
		return getLayers().get(index);
	}

	public Layer getLayer(String name) {
		for (Layer layer : getLayers()) {
			if (layer.getName().equals(name))
				return layer;
		}
		return null;
	}

	public void addTileset(Tileset tileset) {
		tilesets.add(tileset);
	}

	public Tileset getTileset(int index) {
		return tilesets.get(index);
	}

	public Tileset getTileset(String path) {
		for (Tileset t : tilesets) {
			if (t.getPath().equals(path))
				return t;
		}
		return null;
	}

	public String getOrientation() {
		return orientation;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void drawLayer(Graphics g, Layer layer) {
		g.setColor(Color.RED);
		g.translate(100, -100);

		for (int i = 0; i < layer.getData().length; i++) {
			int x = i % layer.getWidth();
			int y = i / layer.getWidth();
			int tile = layer.getData()[i];

			
			g.drawImage(getTileset(0).getTile(tile).getImage(), x * 10, y * 10, 10, 10, null);


//			g.drawRect(x * 10, y * 10, 10, 10);
			
		}
		g.translate(-100, 100);


	}

	public void serOrientation(String orientation2) {
		this.orientation = orientation2;
	}

}
