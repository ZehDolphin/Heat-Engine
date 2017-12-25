package com.heat.engine.graphics.screen;

import java.util.HashMap;

public class ScreenManager {

	public static HashMap<String, Screen> screens = new HashMap<>();
	
	/**
	 * The screen with the id equal to the selected string will be rendered and updated.
	 */
	public static String selected = "undefined";
	
	/**
	 * Sets the selected screen to be the selected one.
	 */
	public static void setSelcted(String id) {
		selected = id;
	}
	
	/**
	 * Will return the selected screen if found, otherwise null.
	 * @return
	 */
	public static Screen getSelected() {
		return getScreens().get(selected);
	}
	
	/**
	 * Adds a screen to the HashMap
	 * 
	 * @param screen - New Screen instance.
	 */
	public static void add(Screen screen) {
		screens.put(screen.id, screen);
	}
	
	public static void resize(int width, int height) {
		getSelected().resize(width, height);
	}
	
	/**
	 * 
	 * @param id - String id of the requested screen.
	 * @return A screen instance with the same id as the argument.
	 */
	public static Screen get(String id) {
		return getScreens().get(id);
	}
	
	/**
	 * 
	 * @return The HashMap of screens.
	 */
	public static HashMap<String, Screen> getScreens() {
		return screens;
	}
	
	private static Screen temp = null;
	
	/**
	 * 
	 * @param delta
	 */
	public static void render(float delta) {
		temp = getSelected();
		if (temp == null) return;
		
		temp.draw(delta);
	}
	
}
