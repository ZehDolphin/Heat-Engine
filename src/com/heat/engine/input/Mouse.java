package com.heat.engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.heat.engine.Engine;
import com.heat.engine.graphics.camera.Camera;

public class Mouse implements MouseMotionListener, MouseListener {

	public static int BUTTON_LEFT = 1;
	public static int BUTTON_RIGHT = 3;
	public static int BUTTON_MIDDLE = 2;

	public static int mouseX = -1;
	public static int mouseY = -1;
	public static int justMovedX = -1;
	public static int justMovedY = -1;
	public static int mouseXOnScreen = -1;
	public static int mouseYOnScreen = -1;
	public static int button = -1;

	private static Camera camera;

	public static void fit(Camera camera) {
		Mouse.camera = camera;
	}

	/**
	 * Returns the mouse x position.
	 */
	public static float getX() {
		
		if (camera != null)
			return (float) (((mouseX - Engine.getWidth() / 2) / (float)Engine.getWidth()) * (float)camera.viewportWidth)  + camera.x;
		
		return mouseX;
	}

	/**
	 * Returns the mouse y position.
	 */
	public static float getY() {

		if (camera != null)
			return (float) (((mouseY - Engine.getHeight() / 2) / (float)Engine.getHeight()) * (float)camera.viewportHeight) + camera.y;
		
		
		return mouseY;
	}

	public static int getJustMovedX() {
		return justMovedX;
	}

	public static int getJustMovedY() {
		return justMovedY;
	}

	/**
	 * Returns the pressed button id.
	 */
	public static int getButton() {
		return button;
	}

	/**
	 * Returns true if the mouse is inside the selected area.
	 */
	public static boolean isInside(float f, float g, float h, float i) {
		if (getX() > f && getX() < f + h && getY() > g && getY() < g + i)
			return true;
		else
			return false;
	}

	// @formatter:off

	@Override
	public void mouseDragged(MouseEvent e) {
		justMovedX = mouseX - e.getX();
		justMovedY = mouseY - e.getY();
		mouseX = e.getX();
		mouseY = e.getY();
		mouseXOnScreen = e.getXOnScreen();
		mouseYOnScreen = e.getYOnScreen();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		justMovedX = mouseX - e.getX();
		justMovedY = mouseY - e.getY();
		mouseX = e.getX();
		mouseY = e.getY();
		mouseXOnScreen = e.getXOnScreen();
		mouseYOnScreen = e.getYOnScreen();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		button = e.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		button = -1;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	// @formatter:on

}
