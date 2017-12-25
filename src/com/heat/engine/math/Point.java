package com.heat.engine.math;

/**
 * Basic math class to store two coordinates.
 * 
 * @author Pontus Wirsching
 * @since 2015-11-26
 */
public class Point {

	public float x, y;

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public void translate(Vector v) {
		translate(v.x, v.y);
	}
	
	public void translate(float x, float y) {
		this.x += x;
		this.y += y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void add(Point p) {
		translate(p.x, p.y);
	}
	
	public void subtract(Point p) {
		this.x -= p.x;
		this.y -= p.y;
	}
	
	@Override
	public String toString() {
		return "["+ x + ", " + y +"]";
	}
	
}
