package com.heat.physics;

import com.heat.engine.math.Rectangle;
import com.heat.engine.math.Vector;

/**
 * This is the <b>Box</b> object used in the physics engine for collision detection. <br>
 * At this state of the physics system it will only support boxes. Later once I decide to <br>
 * add more shapes I'll make a complete shape system for them. <br>
 * 
 * @author Pontus Wirsching
 * @since 2016-02-17
 * @version 0.1
 *
 */
public class Box {

	public Rectangle bounds;
	
	public Vector velocity = new Vector();

	public Box(float x, float y, float width, float height) {
		bounds = new Rectangle(x, y, width, height);
	}
	
}
