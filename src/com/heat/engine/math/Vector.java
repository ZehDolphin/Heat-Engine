package com.heat.engine.math;

public class Vector {

	public static Vector add(Vector v1, Vector v2) {
		return new Vector(v1.x + v2.x, v1.y + v2.y);
	}

	public static Vector subtract(Vector v1, Vector v2) {
		return new Vector(v1.x - v2.x, v1.y - v2.y);
	}

	/**
	 * Creates a new vector with an angle and a magnitude.
	 * @param angle
	 * @param magnitude
	 * @return The new vector instance.
	 */
	public static Vector create(float angle, float magnitude) {
		Point p = Math.getPosistionFromAngle(angle, magnitude);
		return new Vector(p.x, p.y);
	}

	public static Vector invert(Vector v) {
		return new Vector(-v.x, -v.y);
	}
	
	public float x, y;

	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector() {}

	/**
	 * @return The vector angle.
	 */
	public float getAngle() {
		return Math.getAngle(0, 0, x, y);
	}

	/**
	 * @return The magnitude of the vector.
	 */
	public float getMagnitude() {
		return Math.getDistance(0, 0, x, y);
	}

	public void add(Vector v) {
		this.x += v.x;
		this.y += v.y;
	}

	public void add(float x, float y) {
		this.x += x;
		this.y += y;
	}

	public void subtract(Vector v) {
		this.x -= v.x;
		this.y -= v.y;
	}

	public void subtract(float x, float y) {
		this.x -= x;
		this.y -= y;
	}

	public Vector scale(float scale) {
		this.x *= scale;
		this.y *= scale;
		return this;
	}

	public void scale(float sx, float sy) {
		this.x *= sx;
		this.y *= sy;
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

}
