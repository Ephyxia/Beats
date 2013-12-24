package net.Ephyxia.Beats.GUI;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Screen {
	
	private ArrayList<GUIComponent> components;
	
	public Screen() {
		components = new ArrayList<GUIComponent>();
	}
	
	/**
	 * Adds a GUIComponent object to this screen.
	 * 
	 * @author Ephyxia
	 * @param c - Component to add to this screen
	 * 
	 */
	public void addComponent(GUIComponent c) {
		components.add(c);
	}
	
	public void update(Input in, int delta) {
		for(GUIComponent c : components)
			c.update(in, delta);
	}
	
	public void render(Graphics g) {
		for(GUIComponent c : components)
			c.render(g);
	}
}
