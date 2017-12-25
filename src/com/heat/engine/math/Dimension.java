package com.heat.engine.math;

/**
 * A <b>Dimension</b> is, as suggested by the name, an object that contains <br>
 * a width and a height. <br>
 * The class is really simple and there's not anything special about it really. <b>
 * 
 * @author Pontus Wirsching
 *
 */
public class Dimension {

	/**
	 * Adds two dimensions together and returns the result. <br>
	 * 
	 * @param d1 - <b>(Dimension)</b> First dimension to add.
	 * @param d2 - <b>(Dimension)</b> Second dimension to add.
	 * 
	 * @return <b>(Dimension)</b> Result of the two added dimensions.
	 * 
	 */
	public static Dimension add(Dimension d1, Dimension d2) {
		return new Dimension(d1.width + d2.width, d1.height + d2.height);
	}
	
	public float width, height;
	
	/**
	 * Creates a new instance of the class <b>Dimension</b> using a width and a height. <br>
	 * 
	 * @param width - <b>(float)</b> Width.
	 * @param height - <b>(float)</b> Height.
	 */
	public Dimension(float width, float height) {
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Creates a new instance with the width and height set to zero.
	 */
	public Dimension() {
		width = 0;
		height = 0;
	}
	
	/**
	 * 
	 * @return <b>(float)</b> - Area of the dimension.
	 */
	public float getArea() {
		return width * height;
	}
	
	/**
	 * Scales the <b>(Dimension)</b> by the parameter "scale". <br>
	 * 
	 * @param scale - <b>(float)</b> Amount to scale the dimension by.
	 */
	public void scale(float scale) {
		width *= scale;
		height *= scale;
	}

	/**
	 * 
	 * @return <b>(float)</b> - Width variable from dimension. <br>
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * 
	 * @param width <b>(float)</b> - Sets the width of the dimension. <br>
	 */
	public void setWidth(float width) {
		this.width = width;
	}
	
	/**
	 * 
	 * @return <b>(float)</b> - Height variable from dimension. <br>
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * 
	 * @param height <b>(float)</b> - Sets the height of the dimension. <br>
	 */
	public void setHeight(float height) {
		this.height = height;
	}
	
	
	
}
