package com.heat.engine.graphics;

import java.awt.GraphicsEnvironment;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.heat.engine.Engine;
import com.heat.engine.graphics.screen.ScreenManager;
import com.heat.engine.graphics.windowEvents.OnWindowClose;
import com.heat.engine.graphics.windowEvents.ResizeListener;
import com.heat.engine.input.Keyboard;
import com.heat.engine.input.Mouse;
import com.heat.engine.io.FileUtils;

/**
 * The <b>Window</b> class will act as the window for the game. <br>
 * This window is where the frames from the engine will be displayed. <br>
 * 
 * @author Pontus Wirsching
 * @since 2015-11-25
 */
public class Window {

	/**
	 * JFrame instance.
	 */
	private JFrame frame;

	/**
	 * Custom <b>OnWindowClose</b> event.
	 */
	private OnWindowClose closeEvent;

	/**
	 * Custom <b>ResizeListener</b> event.
	 * 
	 * @see com.heat.engine.graphics.windowEvents.ResizeListener
	 */
	private ResizeListener resizeListener;
	
	public Window(int width, int height) {
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (closeEvent != null)
					closeEvent.onClose();
				else {
					Engine.exit();
				}
			}
		});
		frame.addMouseListener(new Mouse());
		frame.addMouseMotionListener(new Mouse());
		frame.addKeyListener(new Keyboard());
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				resize();
			}
		});
	}

	public Window setSize(int width, int height) {
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		return this;
	}
	
	/**
	 * 
	 * @param r - <b>(ResizeListener)</b> Sets the variable that will listen for the window resize.
	 */
	public Window setResizeListener(ResizeListener r) {
		this.resizeListener = r;
		return this;
	}
	
	/**
	 * This method is called whenever the window is resized. <br>
	 * Unless you know what you're doing, don't override this. <br>
	 * Use the <b>ResizeListener</b> instead. <br>
	 */
	public void resize() {
		if (resizeListener != null) 
			resizeListener.resize(getWidth(), getHeight());
			
		try {
			ScreenManager.resize(getWidth(), getHeight());
		} catch (Exception e) {

		}
	}

	/**
	 * @return <b>(int)</b> - The actual pixel width of the window.
	 */
	public int getWidth() {
		return frame.getWidth();
	}
	
	/**
	 * @return <b>(int)</b> - The actual pixel height of the window.
	 */
	public int getHeight() {
		return frame.getHeight();
	}

	/**
	 * Should the window have the abillity to resize? <br>
	 * @param b - <b>(boolean)</b> If true the window can be resized, otherwise it can't. 
	 * @return
	 */
	public Window setResizable(boolean b) {
		frame.setResizable(b);
		return this;
	}

	/**
	 * 
	 * @return <b>(JFrame)</b> - The JFrame instance that the window is based on.
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Sets the close event.
	 */
	public Window setCloseEvent(OnWindowClose c) {
		closeEvent = c;
		return this;
	}

	/**
	 * Sets the title of the window.
	 */
	public Window setTitle(String title) {
		frame.setTitle(title);
		return this;
	}

	/**
	 * Shows the window.
	 */
	public Window show() {
		frame.setVisible(true);
		return this;
	}

	/**
	 * Hides the window.
	 */
	public Window hide() {
		frame.setVisible(false);
		return this;
	}

	/**
	 * Enables fullscreen. <br>
	 */
	public Window enableFullscreen() {
		frame.setUndecorated(true);
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
		return this;
	}

	/**
	 * Sets the window to be borderless. <br>
	 * @param b - <b>(boolean)</b> The window will be borderless if this is true.
	 * @return
	 */
	public Window setBorderless(boolean b) {
		frame.setUndecorated(b);
		return this;
	}

}
