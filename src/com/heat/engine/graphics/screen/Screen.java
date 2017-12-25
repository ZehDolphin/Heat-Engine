package com.heat.engine.graphics.screen;


public abstract class Screen {

	protected String id = "undefined";
	
	public String getID() {
		return id;
	}
	
	public Screen(String id) {
		this.id = id;
	}

	public abstract void draw(float delta);
	public abstract void resize(float width, float height);
	
}
