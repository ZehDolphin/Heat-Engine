package com.heat.tiled.layer;

public class Layer {

	private String name = "";

	private int width = 0;
	
	private int height = 0;
		
	private int[] data;
	
	protected boolean visible = true;
	
	protected double opacity = 1;
	
	protected String type = "UNDEFINED";
	
	public Layer(String name, int width, int height, int[] data) {
		setName(name);
		this.width = width;
		this.height = height;
		this.data = data;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setOpacity(double opacity2) {
		this.opacity = opacity2;
	}
	
	public double getOpacity() {
		return opacity;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getData() {
		return data;
	}
	
	
	
}
