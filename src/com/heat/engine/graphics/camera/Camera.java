package com.heat.engine.graphics.camera;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.heat.engine.Engine;
import com.heat.engine.graphics.Graphics;
import com.heat.engine.graphics.image.Texture;
import com.heat.engine.math.Line;
import com.heat.engine.math.Point;
import com.heat.engine.math.Rectangle;
import com.heat.engine.math.Vector;

public class Camera {

	public float viewportWidth, viewportHeight;
	public float x, y;
	public float mouseX, mouseY;
	
	private float scale = 1.0f;
	
	public float pixelWidth = 0, pixelHeight = 0;
	
	public float getScale() {
		return scale;
	}
	
	public void setColor(Color color) {
		Graphics.setColor(color);
	}
	
	public void adaptTo(float width, float height) {

		float w = Engine.getWidth();
		float h = Engine.getHeight();
		
		float aspectRatio = w / h;

		float minRatio = width / height;

		if (aspectRatio > minRatio) {
			resize((w / h) * height, height);
		} else {
			resize(width, (h / w) * width);
		}
	}
	
	public Point convertFromCameraPerspective(Point p) {
		float xx = (((p.getX() - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((p.getY() - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		return new Point(xx, yy);
	}
	
	public Vector convertFromCameraPerspective(Vector p) {
		float xx = (((p.getX() - this.x) / viewportWidth) * Engine.getWidth());
		float yy = (((p.getY() - this.y) / viewportHeight) * Engine.getHeight());
		return new Vector(xx, yy);
	}
	
	public Camera(int width, int height) {
		this.viewportWidth = width;
		this.viewportHeight = height;
	}
	
	public void resize(float width, float height) {
		this.viewportWidth = width;
		this.viewportHeight = height;
		
		scale = (viewportWidth * viewportHeight) / (Engine.getWidth() * Engine.getHeight());
		
		pixelWidth = (viewportWidth) / Engine.getWidth();
		pixelHeight = (viewportHeight) / Engine.getHeight();

		
	}
	
	
	
	public void drawStirng(String s, float x, float y) {
		float xx = (((x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawString(s, xx, yy);
	}
	
	public void fillOval(float x, float y, float width, float height) {
		float xx = (((x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		float w = width / viewportWidth * Engine.getWidth();
		float h = height / viewportHeight * Engine.getHeight();
		Graphics.fillOval(xx, yy, w, h);
	}
	
	public void drawOval(float x, float y, float width, float height) {
		float xx = (((x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		float w = width / viewportWidth * Engine.getWidth();
		float h = height / viewportHeight * Engine.getHeight();
		Graphics.drawOval(xx, yy, w, h);
	}
	
	public void drawCircle(float x, float y, float radius) {
		drawOval(x, x, radius, radius);
	}
	
	public void fillCircle(float x, float y, float radius) {
		fillOval(x, x, radius, radius);
	}
	
	public void drawCircle(Point p, float radius) {
		float xx = (((p.x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((p.y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		float r = radius / viewportWidth * Engine.getWidth();
		Graphics.drawCircle(xx, yy, r);
	}
	
	public void fillCircle(Point p, float radius) {
		float xx = (((p.x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((p.y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		float r = radius / viewportWidth * Engine.getWidth();
		Graphics.fillCircle(xx, yy, r);
	}
	

	
	
	
	public void drawLine(float x, float y, float x2, float y2) {
		float xx = (((x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		float xx2 = (((x2 - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy2 = (((y2 - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawLine(xx, yy, xx2, yy2);
	}
	
	public void drawLine(Point p1, Point p2) {
		float xx = (((p1.x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((p1.y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		float xx2 = (((p2.x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy2 = (((p2.y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawLine(xx, yy, xx2, yy2);
	}
	
	public void drawLine(float x, float y, Vector v) {
		float xx = (((x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		float xx2 = (((v.x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy2 = (((v.y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawLine(xx, yy, xx2, yy2);
	}
	
	public void drawLine(Line l) {
		float xx = (((l.getX1() - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((l.getY1() - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		float xx2 = (((l.getX2() - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy2 = (((l.getY2() - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawLine(xx, yy, xx2, yy2);
	}
	
	
	
	public void drawNode(float x, float y, Vector v) {
		float xx = (((x - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawNode(xx, yy, convertFromCameraPerspective(v));
	}
	
	public void drawTexture(Texture texture, Rectangle rect) {
		float xx = (((rect.getX() - rect.getWidth() / 2 - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((rect.getY() - rect.getHeight() / 2 - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawTexture(texture, xx, yy, rect.getWidth() / pixelWidth, rect.getHeight() / pixelHeight);
	}
	
	public void drawTexture(Texture texture, float x, float y, float width, float height) {
		float xx = (((x - width / 2 - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - height / 2 - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawTexture(texture, xx, yy, width / pixelWidth, height / pixelHeight);
	}
	
	public void drawTexture(Texture texture, float x, float y, float width, float height, float angle) {
		float xx = (((x - width / 2 - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - height / 2 - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawTexture(texture, xx, yy, width / pixelWidth, height / pixelHeight, angle);
	}
	
	public void drawTexture(Texture texture, float x, float y) {
		drawTexture(texture, x, y, texture.getWidth(), texture.getHeight(), 0.0f);
	}
	
	public void drawTexture(Texture texture, float x, float y, float angle) {
		drawTexture(texture, x, y, texture.getWidth(), texture.getHeight(), angle);
	}
	
	public void drawRect(float x, float y, float width, float height) {
		float xx = (((x - width / 2 - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - height / 2 - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawRect(xx, yy, width / pixelWidth, height / pixelHeight);
	}
	
	public void drawRect(Rectangle rect) {
		float xx = (((rect.getX() - rect.getWidth() / 2 - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((rect.getY() - rect.getHeight() / 2 - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawRect(xx, yy, rect.getWidth() / pixelWidth, rect.getHeight() / pixelHeight);
	}
	
	public void fillRect(float x, float y, float width, float height) {
		float xx = (x - width / 2 - this.x + viewportWidth / 2) / pixelWidth;
		float yy = (y - height / 2 - this.y + viewportHeight / 2) / pixelHeight;
		Graphics.fillRect(xx, yy, width / pixelWidth, height / pixelHeight);
	}
	
	
	public void drawImage(BufferedImage image, float x, float y, float width, float height) {
		float xx = (((x - width / 2 - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - height / 2 - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawImage(image, xx, yy, width / pixelWidth, height / pixelHeight);
	}
	
	public void drawImage(BufferedImage image, float x, float y, float width, float height, float angle) {
		float xx = (((x - width / 2 - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((y - height / 2 - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.drawImage(image, xx, yy, width / pixelWidth, height / pixelHeight, angle);
	}

	public void fillRect(Rectangle rect) {
		float xx = (((rect.getX() - rect.getWidth() / 2 - this.x + viewportWidth / 2) / viewportWidth) * Engine.getWidth());
		float yy = (((rect.getY() - rect.getHeight() / 2 - this.y + viewportHeight / 2) / viewportHeight) * Engine.getHeight());
		Graphics.fillRect(xx, yy, rect.getWidth() / pixelWidth, rect.getHeight() / pixelHeight);
	}
	
	
	

}
