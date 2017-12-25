package com.heat.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Keyboard implements KeyListener {

	private static boolean[] keys = new boolean[25565];
	public static ArrayList<Boolean> key = new ArrayList<>();
	public static ArrayList<Integer> keyEvents = new ArrayList<>();

	/**
	 * Adds a key to the key list.
	 */
	public static void addKey(int KeyEvent) {
		key.add(false);
		keyEvents.add(KeyEvent);
	}
	
	public static void removeKey(int KeyEvent) {
		keys[KeyEvent] = false;
	}

	/**
	 * Returns if the key is pressed.
	 *  @deprecated
	 */
	public static boolean getKey(int index) {
		return key.get(index);
	}

	public static boolean isKeyPressed(int key) {
		return keys[key];
	}
	
	public static void update() {
		for (int i = 0; i < key.size(); i++) {
			key.set(i, keys[keyEvents.get(i)]);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed: " + e.getKeyChar());
//		update();
		keys[e.getKeyCode()] = true;
//		update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Released: " + e.getKeyChar());
		keys[e.getKeyCode()] = false;
		update();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		update();
	}

}
