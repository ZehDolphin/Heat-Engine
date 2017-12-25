package com.heat.engine.old;

import java.util.ArrayList;

import com.heat.engine.math.Rectangle;
import com.heat.engine.math.Vector;

/**
 * 
 * @author Pontus Wirsching
 * @deprecated
 */
public class World {

	public float GRAVITY = 5f;
	
	public ArrayList<RigidBody> objects = new ArrayList<>();

	public int getObjectCount() {
		return objects.size();
	}

	public void addObject(RigidBody object) {
		objects.add(object);
	}

	public RigidBody getObject(int index) {
		return objects.get(index);
	}

	public void removeObject(int index) {
		objects.remove(index);
	}

	private Vector grav = new Vector(0, GRAVITY);
	
	public void update(float delta) {
		grav = new Vector(0, GRAVITY);
		float stepSize = 0.2f;
		ArrayList<RigidBody> remove = new ArrayList<>();

		for (RigidBody r : objects) {
			if (!r.canMove)
				continue;
			if (r.affectedByGravity) {
				r.applyForce(grav);
			}
			
			if (r instanceof Box) {
				Box b = (Box) r;

				// float dx = (float) -(b.velocity.x / Math.abs(b.velocity.x));
				// float dy = (float) -(b.velocity.y / Math.abs(b.velocity.y));

				b.drag = new Vector(-b.velocity.x * b.material.drag, -b.velocity.y * b.material.drag);

				b.velocity.add(new Vector(b.drag.x * delta, b.drag.y * delta));

				for (float step = 0; step < Math.abs(b.velocity.getX()) * delta; step += stepSize) {

					boolean didCollide = false;

					for (RigidBody r2 : objects) {
						if (r2.equals(r))
							continue;
						if (r instanceof Box) {
							Box b2 = (Box) r2;
							if (b.ovelaps(new Rectangle(b2.position.x - (b.velocity.x / Math.abs(b.velocity.x)) * stepSize, b2.position.y, b2.size.getWidth(), b2.size.getHeight()))) {
								didCollide = true;
								b2.velocity.x = b.velocity.x;
								// b.velocity.x = -b.velocity.x / 2f;
								b.velocity.x = 0;
							}
						}
					}

					if (!didCollide)
						b.position.x += stepSize * b.velocity.x / Math.abs(b.velocity.x);

				}


				for (float step = 0; step < Math.abs(b.velocity.getY()) * delta; step += stepSize) {

					boolean didCollide = false;

					for (RigidBody r2 : objects) {
						if (r2.equals(r))
							continue;
						if (r instanceof Box) {
							Box b2 = (Box) r2;
							if (b.ovelaps(new Rectangle(b2.position.x, b2.position.y - (b.velocity.y / Math.abs(b.velocity.y) * stepSize), b2.size.getWidth(), b2.size.getHeight()))) {
								didCollide = true;
								if (!b2.canMove) {
									if (b.velocity.x > 0)
										b.velocity.x -= b.material.friction + b2.material.friction;
									if (b.velocity.x < 0)
										b.velocity.x += b.material.friction + b2.material.friction;
									if (Math.abs(b.velocity.x) < (b.material.friction + b2.material.friction) * 2) {
										b.velocity.x = 0;
									}
								} else {
									b2.velocity.x = b.velocity.x;
								}

//								if (Math.abs((double) r.velocity.y) > 1300) {
//									remove.add(r);
//									if (r2.canMove)
//										remove.add(r2);
//								}
//								b.velocity.y = -b.velocity.y / 5f;
								b.velocity.y = 0;
//								if (b.position.y < b2.position.y) {
//									b.velocity.y = b2.velocity.y;
//								} else {
//									b2.velocity.y = b.velocity.y;
//								}
								break;
							}
						}
					}

					if (!didCollide) {
						b.position.y += stepSize * b.velocity.y / Math.abs(b.velocity.y);
					}
				}

			}
		}
		for (RigidBody r : remove) {
			objects.remove(r);

//			if (r instanceof Box) {
//				Box b = (Box) r;
//
//				float f = 300 * (r.velocity.y * 2) * delta;
//				float ff = (float) (-500 * (r.velocity.y) * delta);
//				if (b.size.getWidth() * b.size.getHeight() > 100) {
//					Box bb = new Box(b.position.x, b.position.y, b.size.getWidth() / 2.2f, b.size.getHeight() / 2.2f);
//					bb.tag = "create";
//					bb.applyForce(new Vector((float) (-f * Math.random()), (float) (-ff * (Math.random() + 0.5f))));
//					addObject(bb);
//					Box bb2 = new Box(b.position.x + b.size.getWidth() / 2, b.position.y, b.size.getWidth() / 2.2f, b.size.getHeight() / 2.2f);
//					bb2.tag = "create";
//					bb2.applyForce(new Vector((float) (f * Math.random()), (float) (-ff * (Math.random() + 0.5f))));
//					addObject(bb2);
//
//					Box bb3 = new Box(b.position.x, b.position.y + b.size.getHeight() / 2, b.size.getWidth() / 2.2f, b.size.getHeight() / 2.2f);
//					bb3.tag = "create";
//					bb3.applyForce(new Vector((float) (-f * Math.random()), (float) (-ff * (Math.random() + 0.5f))));
//					addObject(bb3);
//					Box bb4 = new Box(b.position.x + b.size.getWidth() / 2, b.position.y + b.size.getHeight() / 2, b.size.getWidth() / 2.2f, b.size.getHeight() / 2.2f);
//					bb4.tag = "create";
//					bb4.applyForce(new Vector((float) (f * Math.random()), (float) (-ff * (Math.random() + 0.5f))));
//					addObject(bb4);
//
//				}
//
//			}

		}
	}

}
