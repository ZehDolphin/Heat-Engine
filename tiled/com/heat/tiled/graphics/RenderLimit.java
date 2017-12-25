package com.heat.tiled.graphics;

import com.heat.tiled.map.Map;

public interface RenderLimit {

	public boolean renderIf(int tileX, int tileY, int tileWidth, int tileHeight, Map map);
	
}
