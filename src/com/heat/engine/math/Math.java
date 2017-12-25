package com.heat.engine.math;

/**
 * This class is meant to be a wrapper for the class <b>java.lang.Math</b> this
 * is because <br>
 * The original Math class uses doubles, in Heat Engine floats is used and for
 * coding convenience this <br>
 * class casts it to floats for you. Another feature in this class is the extra
 * methods that does not exist <br>
 * in the <b>java.lang.Math</b> class. <br>
 * <br>
 * Any method that is just a wrapper from the Java's version of the method will
 * not be commented. <br>
 * 
 * 
 * @author Pontus Wirsching
 *
 */
public class Math {

	public static final float PI = (float) java.lang.Math.PI;

	public static float random() {
		return (float) java.lang.Math.random();
	}

	/**
	 * Calculates a point using a start position, an angle and a distance. <br>
	 * 
	 * @author Pontus Wirsching
	 * 
	 * @param angle
	 *            - <b>(float)</b> Angle to calculate the point with.
	 * @param distance
	 *            - <b>(float)</b> Distance from base point to get the point.
	 * @return <b>(Point)</b> Point that is located at a certain distance from
	 *         the base point, calculated with the specified angle.
	 */
	public static Point getPosistionFromAngle(float angle, float distance) {
		return new Point(((cos(angle) * distance)), ((sin(angle) * distance)));
	}

	public static Point[] getIntersectionPoint(Line line, Rectangle r) {

		Point[] p = new Point[4];

		// Top line
		p[0] = getIntersectionPoint(line, new Line(r.getX() - r.getWidth() / 2, r.getY() - r.getHeight() / 2, r.getX() + r.getWidth() / 2, r.getY() - r.getHeight() / 2));
		// Bottom line
		p[1] = getIntersectionPoint(line, new Line(r.getX() - r.getWidth() / 2, r.getY() + r.getHeight() / 2, r.getX() + r.getWidth() / 2, r.getY() + r.getHeight() / 2));
		// Left side...
		p[2] = getIntersectionPoint(line, new Line(r.getX() - r.getWidth() / 2, r.getY() - r.getHeight() / 2, r.getX() - r.getWidth() / 2, r.getY() + r.getHeight() / 2));
		// Right side
		p[3] = getIntersectionPoint(line, new Line(r.getX() + r.getWidth() / 2, r.getY() - r.getHeight() / 2, r.getX() + r.getWidth() / 2, r.getY() + r.getHeight() / 2));

		return p;

	}

	public static boolean doesIntersect(double l1x1, double l1y1, double l1x2, double l1y2, double l2x1, double l2y1, double l2x2, double l2y2) {
		double denom = ((l2y2 - l2y1) * (l1x2 - l1x1)) - ((l2x2 - l2x1) * (l1y2 - l1y1));

		if (denom == 0.0f) {
			return false;
		}

		double ua = (((l2x2 - l2x1) * (l1y1 - l2y1)) - ((l2y2 - l2y1) * (l1x1 - l2x1))) / denom;
		double ub = (((l1x2 - l1x1) * (l1y1 - l2y1)) - ((l1y2 - l1y1) * (l1x1 - l2x1))) / denom;

		return ((ua >= 0.0d) && (ua <= 1.0d) && (ub >= 0.0d) && (ub <= 1.0d));
	}

	public static Point getIntersectionPoint(Line lineA, Line lineB) {

		
		float x = (lineB.getM() - lineA.getM()) / (lineA.getK() - lineB.getK());
		float y = lineA.getK() * x + lineA.getM();
		
		return new Point(x, y);
		
		
		
		
//		if (!doesIntersect(lineA.getX1(), lineA.getY1(), lineA.getX2(), lineA.getY2(), lineB.getX1(), lineB.getY1(), lineB.getX2(), lineB.getY2())) {
//			return null;
//		}
//		
//		float x1 = lineA.getX1();
//		float y1 = lineA.getY1();
//		float x2 = lineA.getX2();
//		float y2 = lineA.getY2();
//
//		float x3 = lineB.getX1();
//		float y3 = lineB.getY1();
//		float x4 = lineB.getX2();
//		float y4 = lineB.getY2();
//
//		Point p = null;
//
//		float d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
//
//		if (d != 0) {
//
//			float xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
//			float yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;
//
//			p = new Point(xi, yi);
//
//		}
//		return p;
	}

	public static int round(float f) {
		return (int) java.lang.Math.round(f);
	}
	
	public static float sin(float angle) {
		return (float) java.lang.Math.sin((double) toRadians(angle));
	}

	public static float cos(float angle) {
		return (float) java.lang.Math.cos((double) toRadians(angle));
	}

	public static float toRadians(float angle) {
		return (float) java.lang.Math.toRadians((double) angle);
	}

	public static float sqrt(float f) {
		return (float) java.lang.Math.sqrt((float) f);
	}

	public static float abs(float f) {
		return (float) java.lang.Math.abs((float) f);
	}

	public static float toDegrees(float angle) {
		return (float) java.lang.Math.toDegrees((double) angle);
	}

	/**
	 * Returns the distance between point one to point two. <br>
	 * 
	 * @author Pontus Wirsching
	 * 
	 * 
	 * @param x1
	 *            - <b>(float)</b> X at point one.
	 * @param y1
	 *            - <b>(float)</b> Y at point one.
	 * @param x2
	 *            - <b>(float)</b> X at point two.
	 * @param y2
	 *            - <b>(float)</b> Y at point two.
	 * @return <b>(float)</b> Distance in pixels from the point.
	 */
	public static float getDistance(float x1, float y1, float x2, float y2) {
		return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	private static float angle;

	/**
	 * Returns the angle between point one and point two.
	 * 
	 * @author Pontus Wirsching
	 * 
	 * @param x1
	 *            - <b>(float)</b> X at point one.
	 * @param y1
	 *            - <b>(float)</b> Y at point one.
	 * @param x2
	 *            - <b>(float)</b> X at point two.
	 * @param y2
	 *            - <b>(float)</b> Y at point two.
	 * 
	 * @return <b>(float)</b> Angle in degrees.
	 */
	public static float getAngle(float x1, float y1, float x2, float y2) {
		angle = -(float) (java.lang.Math.atan2(x2 - x1, y2 - y1) * 180.0f / PI) + 90.0f;
		if (angle < 0) {
			angle += 360.0f;
		}
		return angle;
	}

}
