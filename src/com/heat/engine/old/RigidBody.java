package com.heat.engine.old;

import com.heat.engine.math.Math;
import com.heat.engine.math.Point;
import com.heat.engine.math.Vector;

/**
 * 
 * @author Pontus Wirsching
 * @deprecated
 */
public class RigidBody {

	public Point position = new Point();
	public Vector velocity = new Vector();
	
	
	
	public String tag = "undefined";
	
	public boolean canMove = true;
	
	public boolean affectedByGravity = true;
	
	public RigidBody() {
		
	}
	
	public float getX() {
		return position.getX();
	}
	
	public float getY() {
		return position.getY();
	}
	
	/**
	 * Move this <b>RigidBody</b> towards the selected <b>Point</b>. <br>
	 * This will also detect collision between other objects. <br>
	 * 
	 * @param point - (<b>Point</b>) X and Y coordinates to move towards.
	 * @param speed - (<b>float</b>) Value in pixels/seconds to move with.
	 * 
	 * @author Pontus Wirsching
	 * @since 2016-02-04
	 */
	public void moveTowards(Point point, float speed) {
		float angle = Math.getAngle(position.x, position.y, point.getX() - 0, point.getY() - 0) + 90;
		float distance = Math.getDistance(position.x, position.y, point.getX() - 0, point.getY() - 0);
		float xx = Math.sin(angle) * distance / speed;
		float yy = Math.cos(angle) * distance / speed;
		if (Math.abs(xx) < 0.05)
			xx = 0;
		if (Math.abs(yy) < 0.05)
			yy = 0;
		velocity = new Vector(xx, yy);
	}
	
	public void applyForce(Vector v) {
		velocity.add(v);
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}
	
	
	
}
