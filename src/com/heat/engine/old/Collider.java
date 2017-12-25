package com.heat.engine.old;

import com.heat.engine.math.Rectangle;

/**
 * The interface <b>Collider</b> is used in the physics part of the engine <br>
 * to check collision between different shapes. <br>
 * 
 * @author Pontus Wirsching
 * @deprecated
 */
public interface Collider {

	/**
	 * Check if a point is inside our shape. If that's the case it will <br>
	 * return <b>true</b>, otherwise <b>false</b>. <br>
	 */
	public boolean contains(float x, float y);
	
	/**
	 * The overlaps method checks if this <b>Box</b> overlaps another <b>Rectangle</b>. <br>
	 * It will return <b>true</b> if another <b>Rectangle</b> is overlapping this one <br>
	 * and <b>false</b> otherwise. <br>
	 * 
	 * @param rect - <b>Rectangle</b> the rectangle to compare with.
	 */
	public boolean ovelaps(Rectangle rect);

}
