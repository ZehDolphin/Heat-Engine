package com.heat.engine;

import com.heat.engine.graphics.Renderer;
import com.heat.engine.graphics.Window;
import com.heat.engine.io.FileUtils;

/**
 * This is the core of the "Heat Engine" <br>
 * <br>
 * Legal notice: <br>
 * This software <b>(Heat Engine)</b> is written by Pontus Wirsching and all
 * rights <br>
 * are reserved for the code and assets used in the main engine files. <br>
 * The project is open source and may be downloaded, viewed and modified but
 * only for <br>
 * personal usage. <br>
 * 
 * @author Pontus Wirsching
 * @since 2015-11-25
 * @version Check <b><code>Engine.VERSION</code></b> for latest.
 *
 */
public class Engine {

	/**
	 * Current engine version. <br>
	 * Use this variable to display version and/or do auto updates. <br>
	 */
	public static final String VERSION = "0.0.1";

	/**
	 * Software ID. <br>
	 * This is something I (Pontus Wirsching) use to check what libraries <br>
	 * different games use.
	 */
	public static final String ID = "heat_engine";

	/**
	 * How many milliseconds since start. <br>
	 */
	public static float runtime = 0.0f;

	private static long startTime = System.currentTimeMillis();
	private static long doneTime;
	
	protected Engine() {
	}

	/**
	 * The main window to render the engine inside. <br>
	 * This variable must be set through the <b>setWindow()</b> method. <br>
	 * 
	 * @author Pontus Wirsching
	 */
	private static Window window;

	/**
	 * Sets the window to a new custom window. <br>
	 * 
	 * @param w
	 *            - <b>(Window)</b> Custom window to render the engine inside.
	 */
	public static void setWindow(Window w) {

		window = w;
	}

	/**
	 * @return <b>(int)</b> - The actual pixel width of the window.
	 */
	public static int getWidth() {
		return getWindow().getWidth();
	}

	/**
	 * @return <b>(int)</b> - The actual pixel height of the window.
	 */
	public static int getHeight() {
		return getWindow().getHeight();
	}

	/**
	 * The <b>delta</b> value is used to make sure that everything moves at the
	 * <br>
	 * same speed if you're running the game on 10 fps or 3000 fps. <br>
	 * <br>
	 * If you would have a variable that gets increased by <b>delta</b> every
	 * frame <br>
	 * that variable would reach 1000 after exactly one second. (1000
	 * milliseconds) <br>
	 * 
	 * @return <b>(float)</b> - The time in between frames, this value is in
	 *         milliseconds.
	 */
	public static float getDelta() {
		return (float) getRenderer().getDelta();
	}

	/**
	 * 
	 * @return <b>(int)</b> - number of frames that have been rendered during
	 *         the past second.
	 */
	public static int getFPS() {
		return (int) getRenderer().fps;
	}

	/**
	 * 
	 * @return <b>(float)</b> - number of milliseconds since start.
	 */
	public static float getRuntime() {
		return runtime;
	}
	
	/**
	 * 
	 * @return <b>(Window)</b> - the main engine window.
	 */
	public static Window getWindow() {
		return window;
	}

	/**
	 * The engine needs a renderer. This takes care of keeping the game updated
	 * <br>
	 * as well as drawing the frames. <br>
	 * 
	 * @see com.heat.engine.graphics.Renderer
	 */
	private static Renderer renderer;

	/**
	 * Sets the renderer to the variable r. <br>
	 * 
	 * @param r
	 *            - <b>(Renderer)</b> renderer instance.
	 */
	public static void setRenderer(Renderer r) {
		renderer = r;
	}

	/**
	 * 
	 * @return <b>(Renderer)</b> - The renderer instance that was passed in
	 *         through <b>setRenderer()</b>
	 */
	public static Renderer getRenderer() {
		return renderer;
	}

	/**
	 * Exits the game.
	 */
	public static void exit() {
		FileUtils.clearTemps();
		System.exit(0);
	}
	
	/**
	 * Starts the engine, this will auto check if the window and renderer is set
	 * or not. <br>
	 * If that's not the case, it will throw a NullPointerException. <br>
	 */
	public static void start() {

		System.out.println("This game is running on \"Heat Engine\" version " + VERSION);
		System.out.println("If you find any engine based bugs, please report them to me at:");
		System.out.println("flash13records@gmail.com\n");
		System.out.println("This message cannot be removed. This must be left in the final version");
		System.out.println("of your game!");

		if (window == null)
			throw new NullPointerException("Window cannot be equal to null!");
		if (renderer == null)
			throw new NullPointerException("Renderer cannot be equal to null!");

		window.resize();

		window.show();
		renderer.start();
		
		doneTime = System.currentTimeMillis();

		long loadingTime = doneTime - startTime;

		System.out.println("\nEngine done loading, took " + loadingTime + "ms");
		
	}

}
