package com.heat.engine.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.heat.engine.Engine;
import com.heat.engine.input.Keyboard;

public class Renderer implements Runnable {

	
	/**
	 * Variable to set the FPS cap, if you want this disabled, simply set it to -1. <br>
	 * @since 2016-03-06
	 */
	public float fpsCap = 1000;
	
	public void setFPScap(float fpsCap) {
		this.fpsCap = fpsCap;
	}
	
	
	protected Drawable drawable;
	protected Thread thread;

	public Renderer(Drawable drawable) {
		this.drawable = drawable;
		thread = new Thread(this, "renderer");
		w = Engine.getWindow();
		if (w == null) throw new NullPointerException("Window not set! Call 'setWindow()' before creating a renderer!");
	}

	public int frames = 0;

	public int fps = 0;

	long a, b;
	double delta = 0;

	double t = 0;

	private Window w;
	private JFrame frame;

	private Graphics2D g;

	public Graphics2D getGraphics() {
		return g;
	}

	public double getDelta() {
		return delta;
	}
	
	protected long start;
	protected long end;

	public void run() {
		while (true) {
			
			Keyboard.update();

			a = System.nanoTime();

			frame = w.getFrame();

			BufferStrategy bs = frame.getBufferStrategy();

			if (bs == null) {
				frame.createBufferStrategy(2);
				bs = frame.getBufferStrategy();
			}
			
			try {
				g = (Graphics2D) bs.getDrawGraphics();
			} catch(Exception e) {
				
			}

			/* Update the graphics library. */
			Graphics.update(g);

			g.clearRect(0, 0, w.getFrame().getWidth(), w.getFrame().getHeight());

			drawable.draw();
			
			try {
				g.dispose();
				bs.show();
			}catch(Exception e) {
				
			}
			
			if (fpsCap != -1) {
				double wait = 1000000000.0d / (double) fpsCap;
				
				start = System.nanoTime();
				while ((end = System.nanoTime()) - start <= wait) {
				}
				
			}

			
			

			frames++;

			b = System.nanoTime();

			delta = (double) (b - a) / 1000000000.0d;
			t += delta;
			Engine.runtime += delta;
			if (t >= 1) {
				fps = frames;
				frames = 0;
//				System.out.println("FPS: " + fps);
				t = 0;
			}

		}
	}

	public void start() {
		thread.start();
	}

	public Renderer setDrawable(Drawable drawable) {
		this.drawable = drawable;
		return this;
	}

	public Drawable getDrawable() {
		return drawable;
	}

}
