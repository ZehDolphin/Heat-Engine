package com.heat.particles;

import java.util.ArrayList;

import com.heat.engine.Engine;
import com.heat.engine.graphics.camera.Camera;
import com.heat.engine.math.Point;

/**
 * This class will spawn, render and maintain particles. <br>
 * 
 * @author Pontus Wirsching
 * @since 2016-04-01
 */
public abstract class ParticleEmitter {

	public ArrayList<Particle> particles = new ArrayList<>();

	public Point position;

	public ParticleEmitter(Point p) {
		position = p;
	}

	public abstract void draw(Camera camera);

	/**
	 * Draws all of the particles, if they're on screen that is. This will also update <br>
	 * the particles position, aka. add the velocity vector to the position. <br>
	 * 
	 * @param camera
	 */
	protected void drawParticles(Camera camera) {
		for (int index = 0; index < particles.size(); index++) {
			if (index >= particles.size())
				break;
			Particle p = particles.get(index);
			if (p == null)
				continue;
			if (p.delete)
				particles.remove(index);
			p.draw(camera);
			p.position.x += p.velocity.x * Engine.getDelta();
			p.position.y += p.velocity.y * Engine.getDelta();
		}
	}

}
