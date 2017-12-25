package com.heat.engine.graphics.camera;

import com.heat.engine.graphics.image.Texture;
import com.heat.engine.math.Point;
import com.heat.engine.math.special.Point3;

public class PerspectiveCamera extends Camera {

	public PerspectiveCamera(int width, int height) {
		super(width, height);
	}

	
	public void drawBox(float x, float y, float z, float width, float height, float depth) {
		drawRect(x, y, z, width, height);

		drawLine(x - width / 2, y - height / 2, z, x - width / 2, y - height / 2, z + depth);
		drawLine(x + width / 2, y - height / 2, z, x + width / 2, y - height / 2, z + depth);
		drawLine(x - width / 2, y + height / 2, z, x - width / 2, y + height / 2, z + depth);
		drawLine(x + width / 2, y + height / 2, z, x + width / 2, y + height / 2, z + depth);

		drawRect(x, y, z + depth, width, height);

	}

	float depth = 150.0f;

	public Point get3dPos(Point3 p) {
		return new Point(p.x * p.z, p.y * p.z);
	}

	public Point get3dPos(float x, float y, float z) {
		float zz = (z / depth);
		return new Point((x - this.x) * zz + x, (y - this.y) * zz + y);
	}

	public void drawLine(float x1, float y1, float z1, float x2, float y2, float z2) {
		drawLine(get3dPos(x1, y1, z1), get3dPos(x2, y2, z2));
	}

	public void drawRect(float x, float y, float z, float width, float height) {
		float zz = ((z) / depth) + 1;

		Point p = get3dPos(x, y, z);
		drawRect(p.x, p.y, width * zz, height * zz);
	}
	
	public void fillRect(float x, float y, float z, float width, float height) {
		float zz = ((z) / depth) + 1;

		Point p = get3dPos(x, y, z);
		fillRect(p.x, p.y, width * zz, height * zz);
	}
	
	public void drawTexture3D(Texture texture, float x, float y, float z, float width, float height) {
		float zz = ((z) / depth) + 1;
		Point p = get3dPos(x, y, z);
		drawTexture(texture, p.x, p.y, width * zz, height * zz);
	
	}

	
}
