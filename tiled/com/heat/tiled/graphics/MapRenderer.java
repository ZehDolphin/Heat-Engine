package com.heat.tiled.graphics;

import java.awt.Color;
import java.awt.Font;

import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.graphics.camera.PerspectiveCamera;
import com.heat.engine.graphics.image.DrawableTexture;
import com.heat.engine.graphics.image.DynamicRenderObject;
import com.heat.tiled.layer.Layer;
import com.heat.tiled.map.Map;

/**
 * The MapRenderer is used to draw maps. <br>
 * From here we can either draw full maps or individual layers. <br>
 * 
 * @author Pontus Wirsching
 * @since 2015-09-29
 */
public class MapRenderer {

	public Map map;

	/**
	 * How big each tile should be.
	 */
	public int tileSize = 32;

	public MapRenderer(Map m) {
		map = m;
	}

	public void drawLayer(int layerIndex, PerspectiveCamera camera, float zOffset) {
		Layer l = map.getLayer(layerIndex);

		for (int x = 0; x < l.getWidth(); x++) {
			for (int y = 0; y < l.getHeight(); y++) {
				int tile = l.getData()[x + y * l.getWidth()] - 1;

				if (tile == -1)
					continue;

				// camera.drawBox(x * (map.getTileWidth() - 0), y * (map.getTileHeight() - 0), 0, map.getTileWidth() + 0, map.getTileHeight() + 0.1f, zOffset);
				camera.drawTexture3D(map.getTileset(0).getTile(tile), x * (map.getTileWidth() - 0), y * (map.getTileHeight() - 0), zOffset, map.getTileWidth() + camera.pixelWidth, map.getTileHeight() + camera.pixelHeight);

			}
		}

	}

	public void loadLayer(DynamicRenderObject o, int layerIndex) {
		Layer l = map.getLayer(layerIndex);

		o.width = map.getWidth() * map.getTileWidth();
		o.height = map.getHeight() * map.getTileHeight();


		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; y < map.getHeight(); y++) {

				if (x < 0 || y < 0 || x > l.getWidth() - 1 || y > l.getHeight() - 1)
					continue;
				int tile = l.getData()[x + y * l.getWidth()] - 1;

				if (tile == -1)
					continue;
				
				o.add(new DrawableTexture(map.getTileset(0).getTile(tile), x * (map.getTileWidth() - 0), y * (map.getTileHeight() - 0), map.getTileWidth() + 0, map.getTileHeight() + 0));

//				camera.drawTexture(map.getTileset(0).getTile(tile), x * (map.getTileWidth() - 0), y * (map.getTileHeight() - 0), map.getTileWidth() + camera.pixelWidth, map.getTileHeight() + camera.pixelHeight);


			}
		}
		
		o.draw();
	}
	
	
	
	
	public void drawLayer(int layerIndex, Camera camera, RenderLimit rl) {
		Layer l = map.getLayer(layerIndex);


		int w = (int) (camera.viewportWidth / map.getTileWidth());
		int h = (int) (camera.viewportHeight / map.getTileHeight());

		int sx = (int) (camera.x / map.getTileWidth()) - w / 2 - 1;
		int sy = (int) (camera.y / map.getTileHeight()) - h / 2 - 1;
		int ex = (int) (camera.x / map.getTileWidth()) + w / 2 + 3;
		int ey = (int) (camera.y / map.getTileHeight()) + h / 2 + 3;

		for (int x = sx; x < ex; x++) {
			for (int y = sy; y < ey; y++) {

				if (x < 0 || y < 0 || x > l.getWidth() - 1 || y > l.getHeight() - 1)
					continue;
				int tile = l.getData()[x + y * l.getWidth()] - 1;

				if (tile == -1)
					continue;
				
				if (!rl.renderIf(x, y, map.getTileWidth(), map.getTileHeight(), map)) continue; 

				camera.drawTexture(map.getTileset(0).getTile(tile), x * (map.getTileWidth() - 0), y * (map.getTileHeight() - 0), map.getTileWidth() + camera.pixelWidth, map.getTileHeight() + camera.pixelHeight);


			}
		}

	}

	
	
	
	
	
	public void drawLayer(int layerIndex, Camera camera) {
		Layer l = map.getLayer(layerIndex);

		camera.setColor(Color.RED);
		com.heat.engine.graphics.Graphics.getGraphics2D().setFont(new Font("Consolas", 0, 20));

		int w = (int) (camera.viewportWidth / map.getTileWidth());
		int h = (int) (camera.viewportHeight / map.getTileHeight());

		int sx = (int) (camera.x / map.getTileWidth()) - w / 2 - 1;
		int sy = (int) (camera.y / map.getTileHeight()) - h / 2 - 1;
		int ex = (int) (camera.x / map.getTileWidth()) + w / 2 + 3;
		int ey = (int) (camera.y / map.getTileHeight()) + h / 2 + 3;

		for (int x = sx; x < ex; x++) {
			for (int y = sy; y < ey; y++) {

				if (x < 0 || y < 0 || x > l.getWidth() - 1 || y > l.getHeight() - 1)
					continue;
				int tile = l.getData()[x + y * l.getWidth()] - 1;

				if (tile == -1)
					continue;

				camera.drawTexture(map.getTileset(0).getTile(tile), x * (map.getTileWidth() - 0), y * (map.getTileHeight() - 0), map.getTileWidth() + camera.pixelWidth, map.getTileHeight() + camera.pixelHeight);

//				Point p = camera.convertFromCameraPerspective(new Point(x * map.getTileWidth(), y * map.getTileHeight()));
//				com.heat.engine.graphics.Graphics.getGraphics2D().drawString("" + tile, p.x, p.y);

			}
		}

	}

}
