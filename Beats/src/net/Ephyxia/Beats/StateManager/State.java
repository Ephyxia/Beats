package net.Ephyxia.Beats.StateManager;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public abstract class State {
	
	abstract void init();
	abstract void update(Input in, int delta);
	abstract void render(Graphics g);
	
}
