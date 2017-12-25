package com.heat.engine.math;

public class Rectangle {

	/**
	 * @return The area of a rectangle.
	 */
	public static float getArea(Rectangle r) {
		return r.getWidth() * r.getHeight();
	}

	private Point position;
	private Dimension size;

	public Rectangle(float x, float y, float width, float height) {
		position = new Point(x, y);
		size = new Dimension(width, height);
	}

	public Point getPosition() {
		return position;
	}
	
	public Rectangle() {
		position = new Point();
		size = new Dimension();
	}
	
	public Point[] getCorners() {
		Point[] corners = new Point[4];
		
		corners[0] = new Point(getX() - getWidth() / 2, getY() - getHeight() / 2);
		corners[1] = new Point(getX() + getWidth() / 2, getY() - getHeight() / 2);
		corners[2] = new Point(getX() + getWidth() / 2, getY() + getHeight() / 2);
		corners[3] = new Point(getX() - getWidth() / 2, getY() + getHeight() / 2);

		return corners;
	}

	public boolean contains(float x, float y) {
		if (x > getX() && y > getY() && x < getX() + getWidth() && y < getY() + getHeight())
			return true;
		else
			return false;
	}
	
	public boolean contains(Rectangle rect) {
		if (rect.getX() + rect.getWidth() > getX() && rect.getY() + rect.getHeight() > getY()) {
			if (rect.getX() < getX() + getWidth() && rect.getY() < getY() + getHeight()) {
				return true;
			}
		}
		return false;
	}

	public void translate(Vector v) {
		position.translate(v);
	}

	public void translate(float x, float y) {
		position.translate(x, y);
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public float getWidth() {
		return size.width;
	}

	public float getHeight() {
		return size.height;
	}

	public void setX(float x) {
		position.x = x;
	}

	public void setY(float y) {
		position.y = y;
	}

	public void setWidth(float width) {
		size.width = width;
	}

	public void setHeight(float height) {
		size.height = height;
	}

	public void scale(float scale) {
		size.width *= scale;
		size.height *= scale;
	}

}
