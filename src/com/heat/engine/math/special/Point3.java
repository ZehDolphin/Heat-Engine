package com.heat.engine.math.special;

import com.heat.engine.math.Point;

/**
 * <b>Point3</b> stores three values: <i>x</i>,  <i>y</i> and  <i>z</i>. <br>
 * Two of these (<i>x</i> and <i>y</i>) is just passed in from the super class <b>Point</b>. <br>
 * 
 * @author Pontus Wirsching
 * @since 2016-03-06
 */
public class Point3 extends Point {

	public float z;
	
	public Point3(float x, float y, float z) {
		super(x, y);
		this.z = z;
	}
	
	public Point3() {
		super();
		this.z = 0;
	}
	
	/**
	 * Moves the coordinates by the amount specified in the parameters. <br>
	 */
	public void translate(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "["+ x + ", " + y +", " + z + "]";
	}
	
}
