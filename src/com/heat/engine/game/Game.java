package com.heat.engine.game;

import java.awt.Color;
import java.awt.Font;

import com.heat.engine.Engine;
import com.heat.engine.graphics.Drawable;
import com.heat.engine.graphics.Graphics;
import com.heat.engine.graphics.Renderer;
import com.heat.engine.graphics.Window;

/**
 * The <b>Game</b> class is created to simplify the creation of games with <br>
 * the engine. <br>
 * Instead of just importing and using static methods, this will give you a <br>
 * class to extend to, this makes it easier. <br>
 * <br>
 * Also this class contains game specific methods and variables. <br>
 * The core <b>Engine</b> class is just the main engine. <br>
 * 
 * @author Pontus Wirsching
 * @since 2016-02-17
 */
public abstract class Game extends Engine {

	public final static int DEBUG_DISABLE = 0;
	public final static int DEBUG_SIMPLE = 1;
	public final static int DEBUG_STANDARD = 2;
	public final static int DEBUG_DETAILED = 3;
	public final static int DEBUG_ALL = 4;

	/**
	 * Debug variable. <br>
	 * There are different kinds of debug levels: <br>
	 * 
	 * <pre>
	 * ----------------------
	 * | value |   about
	 * ----------------------
	 * |   0   | Disabled
	 * |   1   | Simple info
	 * |   2   | Standard info
	 * |   3   | Detailed info
	 * |   4   | Everything
	 * ----------------------
	 * </pre>
	 */
	private static int debug = 0;
	
	public static int getDebug() {
		return debug;
	}

	/**
	 * Local instance of the game class.
	 */
	private Game local = null;
	
	private String runtimeString = "";

	
	public Game(int width, int height, String title) {
		setWindow(new Window(width, height).setTitle(title));

		local = this;
		
		setRenderer(new Renderer(new Drawable() {

			@Override
			public void draw() {
				Graphics.setColor(Color.BLACK);
				Graphics.fillRect(0, 0, getWidth(), getHeight());
				
				local.draw();
				
				if (debug >= 1) {
					Graphics.setColor(Color.YELLOW);
					Graphics.getGraphics2D().setFont(new Font("Arial", 0, 20));
					Graphics.drawString("FPS: " + getFPS(), 10, 50);
				}
				if (debug >= 2) {
					Graphics.getGraphics2D().setFont(new Font("Arial", 0, 10));
					Graphics.drawString("Window size: " + getWidth() + " x " + getHeight(), 10, 60);
					String s = Float.toString(getRuntime());
					try {
						runtimeString = s.substring(0, s.indexOf('.') + 2);
					} catch(Exception e) {
					}
					Graphics.drawString("Runtime: " + runtimeString + "s", 10, 70);
				}
				
				
			}
		}));
	}

	public abstract void draw();
	
	/**
	 * Enables the game debug mode. <br>
	 * This will also set the debug level to 1 which is the most basic one. <br>
	 * 
	 * 
	 * @since 2016-02-17
	 */
	public void enableDebugging() {
		debug = 1;
	}

	/**
	 * Set debug mode to a certain value. <br>
	 * 
	 * @since 2016-02-17
	 */
	public void enableDebugging(int debug) {
		this.debug = debug;
	}

}
