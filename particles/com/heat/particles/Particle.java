package com.heat.particles;

import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.math.Point;
import com.heat.engine.math.Vector;

/**
 * Abstract class, parent to all particles.
 * 
 * @author Pontus Wirsching
 * @since 2016-04-01
 */
public abstract class Particle {

	public Point position;

	public Vector velocity;

	public boolean delete = false;
	
	public Particle() {
		position = new Point();
		velocity = new Vector();
	}

	public void remove() {
		delete = true;
	}
	
	/**
	 * Draws the particle. This method will in most cases be called from the <b>ParticleHandler</b> or <b>ParticleEmitter</b>
	 * @param camera - Camera instance, can be null if you intend to use <i>com.heat.engine.graphics.Graphics</i> to draw the particle.
	 */
	public abstract void draw(Camera camera);
	
	public float getX() {
		return position.getX();
	}

	public float getY() {
		return position.getY();
	}

	public float getVX() {
		return velocity.x;
	}

	public float getVY() {
		return velocity.y;
	}

	public void setX(float x) {
		position.x = x;
	}

	public void setY(float y) {
		position.y = y;
	}

	public void setVX(float vx) {
		velocity.x = vx;
	}

	public void setVY(float vy) {
		velocity.y = vy;
	}

}
