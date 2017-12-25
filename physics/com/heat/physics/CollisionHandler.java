package com.heat.physics;

import java.util.ArrayList;

import com.heat.engine.math.Math;

public class CollisionHandler {

	public ArrayList<Box> boxes = new ArrayList<>();
	
	public void add(Box b) {
		boxes.add(b);
	}
	
	public Box get(int index) {
		return boxes.get(index);
	}
	
	
	public void update(float delta) {
		
		for (Box b : boxes) {
			
			float distanceThisFrame = b.velocity.getMagnitude() * delta;
			
			float dx = b.velocity.getX() * delta;
			float dy = b.velocity.getY() * delta;

			float f = 1000;
			
			float stepSize = 1 / f;
			
			for (Box b2 : boxes) {
				if (b == b2) continue;
				
				System.out.println(stepSize);
				
				// Should always move ten steps every frame.
				for (float step = 0; step <= dx; step += stepSize) {
					
					System.out.println(step);
					
//					b.bounds.x += stepSize * b.velocity.x / Math.abs(b.velocity.x);
					
					b.bounds.setX(b.bounds.getX() + (stepSize * f) * b.velocity.x / Math.abs(b.velocity.x));
					
				}
				
				
				
			}
			
		}
		
	}
	
}
