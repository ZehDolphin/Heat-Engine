package com.heat.engine.old;

/**
 * A material can be applied to a PhysicsObject. <br>
 * The material will set the objects physics variables. <br>
 * 
 * @see com.heat.engine.old.World
 * @see com.heat.engine.old.Box
 * @author Pontus Wirsching
 * @since 2015-12-07
 * @deprecated
 */
public class Material {

	public static final Material DEFAULT = new Material();

	/**
	 * How dens each pixel is. <br>
	 * A material with a high density will have a higher gravitational
	 * pull. This means that it will attract other objects with a greater force. <br>
	 * 
	 * @author Pontus Wirsching
	 * @since 2015-12-07
	 */
	public float density = 1.0f;

	/**
	 * This is the friction constant. <br>
	 * How friction is calculated in the physics engine is that this variable <br>
	 * will be subtracted from the objects velocity as it touches something. <br>
	 * This applies both on vertical and horizontal surfaces. <br>
	 * 
	 * @author Pontus Wirsching
	 * @since 2015-12-07
	 */
	public float friction = 1.0f;

	/**
	 * This is the <b>drag</b> constant. <br>
	 * How drag is calculated in the physics engine is that this variable will <br>
	 * be subtracted along with the overall world "drag constant". <br>
	 * 
	 * @author Pontus Wirsching
	 * @since 2015-12-07
	 */
	public float drag = 1f;

	public Material() {
	}

	public Material setDensity(float d) {
		density = d;
		return this;
	}
	
	public Material setFriction(float f) {
		friction = f;
		return this;
	}
	
	public Material setDrag(float d) {
		drag = d;
		return this;
	}
	
}
