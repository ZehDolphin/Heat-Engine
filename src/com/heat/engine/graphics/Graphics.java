package com.heat.engine.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import com.heat.engine.graphics.image.Texture;
import com.heat.engine.math.Line;
import com.heat.engine.math.Math;
import com.heat.engine.math.Point;
import com.heat.engine.math.Rectangle;
import com.heat.engine.math.Vector;

public class Graphics {

	private static Graphics2D g = null;

	/**
	 * This method will update the graphics variable.
	 */
	protected static void update(Graphics2D graphics) {
		g = graphics;
	}

	public static void setColor(Color color) {
		g.setColor(color);
	}

	public static Graphics2D getGraphics2D() {
		return g;
	}

	public static void setGraphics2D(Graphics2D g) {
		Graphics.g = g;
	}

	public static void drawArrow(float x, float y, Vector target) {
		drawLine(x, y, target);
		drawLine(target.x + x, target.y + y, Vector.create(135 + target.getAngle(), target.getMagnitude() / 4));
		drawLine(target.x + x, target.y + y, Vector.create(-135 + target.getAngle(), target.getMagnitude() / 4));

	}

	public static void drawHexagon(float x, float y, float width, float height) {
		int w = (int) width;
		int h = (int) height;
		float[] xx = new float[] { x, x + w / 2, x + w / 2, x, x - w / 2, x - w / 2 };
		float[] yy = new float[] { y - h / 2, y - h / 4, y + h / 4, y + h / 2, y + h / 4, y - h / 4 };
		drawPolygon(xx, yy);
	}

	public static void drawString(String text, float x, float y) {
		g.drawString(text, x, y);
	}

	public static void drawPolygon(float[] xx, float[] yy) {

		if (xx.length != yy.length)
			return;

		for (int i = 0; i <= xx.length - 1; i++) {
			if (i == xx.length - 1) {
				drawLine(xx[i], yy[i], xx[0], yy[0]);
			} else {
				drawLine(xx[i], yy[i], xx[i + 1], yy[i + 1]);
			}
		}

		drawLine(xx[1], yy[1], xx[2], yy[2]);

	}

	public static void drawLine(float x, float y, Vector target) {
		drawLine(x, y, target.x + x, target.y + y);
	}
	
	public static void drawLine(Line l) {
		drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
	}

	public static void drawOval(Point p, float width, float height) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.drawOval((int) (p.x - width), (int) (p.y - height), (int) width * 2, (int) height * 2);
	}

	public static void fillOval(Point p, float width, float height) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.fillOval((int) (p.x - width), (int) (p.y - height), (int) width * 2, (int) height * 2);
	}
	
	public static void drawOval(float x, float y, float width, float height) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.drawOval((int) (x - width), (int) (y - height), (int) width * 2, (int) height * 2);
	}

	public static void fillOval(float x, float y, float width, float height) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.fillOval((int) (x - width), (int) (y - height), (int) width * 2, (int) height * 2);
	}
	
	
	public static void drawCircle(Point p, float radius) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.drawOval((int) (p.x - radius), (int) (p.y - radius), (int) radius * 2, (int) radius * 2);
	}

	public static void fillCircle(Point p, float radius) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.fillOval((int) (p.x - radius), (int) (p.y - radius), (int) radius * 2, (int) radius * 2);
	}
	
	public static void drawCircle(float x, float y, float radius) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.drawOval((int) (x - radius), (int) (y - radius), (int) radius * 2, (int) radius * 2);
	}

	public static void fillCircle(float x, float y, float radius) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.fillOval((int) (x - radius), (int) (y - radius), (int) radius * 2, (int) radius * 2);
	}

	public static void drawLine(float x1, float y1, float x2, float y2) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
	}

	public static void drawImage(Image image, float x, float y, float width, float height) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
	}

	public static void drawImage(Image image, float x, float y, float width, float height, float angle) {
		translate(x + width / 2, y + height / 2);
		g.rotate(Math.toRadians(angle));
		drawImage(image, -width / 2, -height / 2, width, height);
		g.rotate(-Math.toRadians(angle));
		translate(-(x + width / 2), -(y + height / 2));
	}

	public static void drawTexture(Texture texture, float x, float y, float width, float height) {
		drawImage(texture.getImage(), x, y, width, height);
	}

	public static void drawTexture(Texture texture, float x, float y) {
		drawImage(texture.getImage(), x, y, texture.getWidth(), texture.getHeight());
	}

	public static void drawTexture(Texture texture, float x, float y, float scale) {
		drawImage(texture.getImage(), x, y, texture.getWidth() * scale, texture.getHeight() * scale);
	}

	public static void drawTexture(Texture texture, Rectangle rectangle) {
		drawTexture(texture, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
	}

	/**
	 * 
	 * @param texture
	 *            <b>(Texture)</b> - The texture to draw.
	 * @param rectangle
	 *            <b>(Rectangle)</b> - Size and position, defined by a Rectangle.
	 * @param rotation
	 *            <b>(float)</b> - Angle in degrees.
	 */
	public static void drawTexture(Texture texture, Rectangle rectangle, float rotation) {
		translate(rectangle.getX() + rectangle.getWidth() / 2, rectangle.getY() + rectangle.getHeight() / 2);
		g.rotate(Math.toRadians(rotation));
		drawTexture(texture, -rectangle.getWidth() / 2, -rectangle.getHeight() / 2, rectangle.getWidth(), rectangle.getHeight());
		g.rotate(-Math.toRadians(rotation));
		translate(-(rectangle.getX() + rectangle.getWidth() / 2), -(rectangle.getY() + rectangle.getHeight() / 2));
	}

	public static void drawTexture(Texture texture, float x, float y, float width, float height, float rotation) {
		translate(x + width / 2, y + height / 2);
		g.rotate(Math.toRadians(rotation));
		drawImage(texture.getImage(), -width / 2, -height / 2, width, height);
		g.rotate(-Math.toRadians(rotation));
		translate(-(x + width / 2), -(y + height / 2));

	}

	public static void translate(float x, float y) {
		g.translate((int) x, (int) y);
	}

	/**
	 * Drawing a rectangle to screen.
	 * 
	 * @param x
	 *            - Top left position.
	 * @param y
	 *            - Top left position.
	 * @param width
	 *            - Width in pixels.
	 * @param height
	 *            - Height in pixels.
	 */
	public static void drawRect(float x, float y, float width, float height) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.drawRect((int) x, (int) y, (int) width, (int) height);
	}

	/**
	 * Filling a rectangle to screen.
	 * 
	 * @param x
	 *            - Top left position.
	 * @param y
	 *            - Top left position.
	 * @param width
	 *            - Width in pixels.
	 * @param height
	 *            - Height in pixels.
	 */
	public static void fillRect(float x, float y, float width, float height) {
		if (g == null)
			throw new NullPointerException("Graphics.g cannot be null! Engine is not updating properly!");
		g.fillRect((int) x, (int) y, (int) width, (int) height);
	}

	public static void drawNode(float x, float y, Vector target) {
		drawLine(x, y, target);
		Vector v = Vector.create(90.0f + target.getAngle(), target.getMagnitude() / 4);
		drawLine(x, y, v);
		drawLine(x + v.x, y + v.y, target.x + x, target.y + y);
		drawLine(x, y, Vector.invert(v));
		drawLine(x - v.x, y - v.y, target.x + x, target.y + y);
		drawCircle(target.x + x, target.y + y, target.getMagnitude() / 8);
		// drawCircle(x, y, target.getMagnitude() / 8);

	}

	/**
	 * Draws a rectangle from a rectangle instance.
	 * 
	 * @param rect
	 *            - Rectangle instance.
	 */
	public static void drawRect(Rectangle rect) {
		drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
	}

	/**
	 * Draws a rectangle from a rectangle instance.
	 * 
	 * @param rect
	 *            - Rectangle instance.
	 */
	public static void drawRect(Rectangle rectangle, float rotation) {
		translate(rectangle.getX() + rectangle.getWidth() / 2, rectangle.getY() + rectangle.getHeight() / 2);
		g.rotate(Math.toRadians(rotation));
		drawRect(-rectangle.getWidth() / 2, -rectangle.getHeight() / 2, rectangle.getWidth(), rectangle.getHeight());
		g.rotate(-Math.toRadians(rotation));
		translate(-(rectangle.getX() + rectangle.getWidth() / 2), -(rectangle.getY() + rectangle.getHeight() / 2));
	}

	/**
	 * Draws a rectangle from a rectangle instance.
	 * 
	 * @param rect
	 *            - Rectangle instance.
	 */
	public static void fillRect(Rectangle rectangle, float rotation) {
		translate(rectangle.getX() + rectangle.getWidth() / 2, rectangle.getY() + rectangle.getHeight() / 2);
		g.rotate(Math.toRadians(rotation));
		fillRect(-rectangle.getWidth() / 2, -rectangle.getHeight() / 2, rectangle.getWidth(), rectangle.getHeight());
		g.rotate(-Math.toRadians(rotation));
		translate(-(rectangle.getX() + rectangle.getWidth() / 2), -(rectangle.getY() + rectangle.getHeight() / 2));
	}

	/**
	 * Draws a rectangle from a rectangle instance.
	 * 
	 * @param rect
	 *            - Rectangle instance.
	 */
	public static void fillRect(Rectangle rectangle) {
		fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
	}

}
