package net.Ephyxia.Beats.GUI;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public abstract class GUIComponent {
	protected float x;
	protected float y;
	protected float width;
	protected float height;
	protected String text;
	
	abstract void updateState(Input in, int delta);
	abstract void update(Input in, int delta);
	abstract void render(Graphics g);
}
