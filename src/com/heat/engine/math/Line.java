package com.heat.engine.math;

public class Line {

	public Point p1, p2;
	
	public Line() {
		p1 = new Point();
		p2 = new Point();
	}
	
	public Line(float x1, float y1, float x2, float y2) {
		p1 = new Point(x1, y1);
		p2 = new Point(x2, y2);
	}
	
	/**
	 * Returns the 'K' value from the line, this is used in basic linear algebra. <br>
	 * @return
	 */
	public float getK() {
		float  k = (p2.y - p1.y) / (p2.x - p1.x);
		return (k >= Float.POSITIVE_INFINITY || k <= Float.NEGATIVE_INFINITY) ? Float.MAX_VALUE : k;
	}
	
	/**
	 * Returns the 'M' value from the line, this is used in basic linear algebra. <br>
	 * 
	 * @return
	 */
	public float getM() {
		float m =  p1.y - getK() * p1.x;
		return (m >= Float.POSITIVE_INFINITY || m <= Float.NEGATIVE_INFINITY) ? Float.MAX_VALUE : m;
	}
	
	public float getAngle() {
		return Math.getAngle(getX2(), getY2(), getX1(), getY1());
	}
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public float getX1() {
		return p1.getX();
	}
	
	public float getY1() {
		return p1.getY();
	}
	
	public float getX2() {
		return p2.getX();
	}
	
	public float getY2() {
		return p2.getY();
	}
}
