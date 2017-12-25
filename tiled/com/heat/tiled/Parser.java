package com.heat.tiled;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.heat.engine.graphics.image.TextureLoader;
import com.heat.engine.io.FileUtils;
import com.heat.tiled.graphics.Tileset;
import com.heat.tiled.layer.Layer;
import com.heat.tiled.map.Map;


/**
 * The tiled parser isn't complete for this version of the <b>Heat Engine</b> <br>
 * and is therefore not working properly. The only reason this code is left inside the engine <br>
 * is because it's a work in progress. <br>
 * <br>
 * This was a separate API created to parse Tiled (.tmx) files. These files are generated from the software <br>
 * called <b>Tiled</b>, the mentioned software can be found here: <i>"http://www.mapeditor.org/"</i> <br>
 * <br>
 * 
 * @author Pontus Wirsching
 * @version incomplete
 * @since 2015-09-23
 */
public class Parser {

	
	public static int getValueAsInt(String name, JSONObject parent) {
		return Math.toIntExact((long) parent.get(name));
	}
	
	public static String getValueAsString(String name, JSONObject parent) {
		return (String) parent.get(name);
	}

	@SuppressWarnings("unused")
	public static Map parse(String path) {

		Map map = null;

		JSONParser parser = new JSONParser();

		try {

			File dataFile = null;
			
			FileReader fr = null;
			
			Object obj = parser.parse(fr = new FileReader(dataFile = FileUtils.getLocal(path)));

			fr.close();
			
			JSONObject js = (JSONObject) obj;

			

			String version = String.valueOf(js.get("version"));

			long width = (long) js.get("width");
			long height = (long) js.get("height");

			long tileWidth = (long) js.get("tilewidth");
			long tileHeight = (long) js.get("tileheight");

			String renderOrder = (String) js.get("renderorder");
			String orientation = (String) js.get("orientation");

			map = new Map((int) width, (int) height, (int) tileWidth, (int) tileHeight);

			
			JSONArray tilesets = (JSONArray) js.get("tilesets");
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> tilesetsIterator = tilesets.iterator();
			while (tilesetsIterator.hasNext()) {

				// Get tileset data.
				JSONObject t = (JSONObject) tilesetsIterator.next();

				int columns = getValueAsInt("columns", t);
				int firstgid = getValueAsInt("firstgid", t);
				String image = getValueAsString("image", t);
				int imageWidth = getValueAsInt("imagewidth", t);
				int imageHeight = getValueAsInt("imageheight", t);
				int margin = getValueAsInt("margin", t);
				String name = getValueAsString("name", t);
				JSONObject properties = (JSONObject) t.get("properties");
				int spacing = getValueAsInt("spacing", t);
				int tileCount = getValueAsInt("tilecount", t);
				int tileWidth2 = getValueAsInt("tilewidth", t);
				int tileHeight2 = getValueAsInt("tileheight", t);
				
				String[] ss = path.split("/");
				File imageFile = FileUtils.getLocal(path.replace(ss[ss.length - 1], "") + image);
				
				Tileset tileset = new Tileset(TextureLoader.loadTextureSheet(path.replace(ss[ss.length - 1], "") + image, tileWidth2, tileHeight2), path.replace(ss[ss.length - 1], "") + image, tileWidth2, tileHeight2, imageWidth, imageHeight);
				
				map.addTileset(tileset);
			}
			
			map.setVersion(version);
			map.setRenderorder(renderOrder);
			map.serOrientation(orientation);

			JSONArray layers = (JSONArray) js.get("layers");
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = layers.iterator();
			while (iterator.hasNext()) {
				JSONObject layer = iterator.next();

				JSONArray data = (JSONArray) layer.get("data");
				int[] d = new int[(int) (width * height)];

				int index = 0;

				@SuppressWarnings("unchecked")
				Iterator<Long> dataIterator = data.iterator();
				while (dataIterator.hasNext()) {
					d[index] = Math.toIntExact((long) dataIterator.next());
					index++;
				}

				String name = (String) layer.get("name");

				Layer l = new Layer(name, (int) width, (int) height, d);

				double opacity = (long) layer.get("opacity");
				String type = (String) layer.get("type");
				boolean visible = (boolean) layer.get("visible");

				l.setOpacity(opacity);
				l.setType(type);
				l.setVisible(visible);

				map.addLayer(l);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	

}
