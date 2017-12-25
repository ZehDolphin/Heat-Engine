package com.heat.engine.old;

import com.heat.engine.math.Dimension;
import com.heat.engine.math.Point;
import com.heat.engine.math.Rectangle;
import com.heat.engine.math.Vector;

/**
 * A box is an instance of a <b>RigidBody</b> and also implements the <br>
 * <b>Collider</b>, this means that the box is affected by the physics engine <br>
 * and it will collide with other objects. <br>
 * <br>
 * A <b>Material</b> must be applied to the Box as it needs variables for the <br>
 * physics engine to use.
 * 
 * @author Pontus Wirsching
 * @since 2015-12-05
 * @deprecated
 *
 */
public class Box extends RigidBody implements Collider {

	/**
	 * The size of the <b>Box</b>. <br>
	 * This is used to get collision boundaries as well as <br>
	 * to get total mass.
	 * 
	 * @author Pontus Wirsching
	 * @since 2015-12-05
	 */
	public Dimension size = new Dimension();

	/**
	 * This box's material, as mentioned in the description of this class <br>
	 * the material sets some variables that decides how the <b>Box</b> should <br>
	 * behave. <br>
	 */
	public Material material = Material.DEFAULT;

	/**
	 * The drag <b>Vector</b> is the amount of drag that the <b>Box</b> is exposed to. <br>
	 */
	public Vector drag = new Vector();

	public Box(float x, float y, float width, float height) {
		position = new Point(x, y);
		size = new Dimension(width, height);
	}

	/**
	 * @return (<b>Rectangle</b>) - A rectangle object to get x, y, width and height in one object.
	 */
	public Rectangle getRectangle() {
		return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * @return (<b>float</b>) - The full width of the <b>Box</b>. <br>
	 */
	public float getWidth() {
		return size.getWidth();
	}

	/**
	 * @return (<b>float</b>) - The full height of the <b>Box</b>. <br>
	 */
	public float getHeight() {
		return size.getHeight();
	}

	/**
	 * @return (<b>float</b>) - The area (width * height) of the <b>Box</b>. <br>
	 */
	public float getArea() {
		return size.getArea();
	}

	@Override
	public boolean contains(float x, float y) {
		if (x > position.getX() && y > position.getY() && x < position.getX() + size.getWidth() && y < position.getY() + size.getHeight())
			return true;
		else
			return false;
	}

	@Override
	public boolean ovelaps(Rectangle rect) {
		if (getX() + getWidth() / 2 - 1 > rect.getX() - rect.getWidth() / 2 && getX() - getWidth() / 2 < rect.getX() + rect.getWidth() / 2) {
			if (getY() + getHeight() / 2 - 1 > rect.getY() - rect.getHeight() / 2 && getY() - getHeight() / 2 < rect.getY() + rect.getHeight() / 2) {
				return true;
			}
		}
		return false;
	}

}
