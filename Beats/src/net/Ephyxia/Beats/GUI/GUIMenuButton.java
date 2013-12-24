package net.Ephyxia.Beats.GUI;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GUIMenuButton extends GUIButton {

	private Color color = Color.white;
	
	public GUIMenuButton(float x, float y, float width, float height, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
	}

	@Override
	void update(Input in, int delta) {
		updateState(in, delta);
		
		
	}

	@Override
	void render(Graphics g) {
		g.pushTransform();
		g.setColor(color);
		g.fillRoundRect(x, y, width, height, 16);
		g.popTransform();
	}

	@Override
	public void onClick(Input in, int delta) {
		System.out.println("You clicked the " + text + " button!");
	}

	@Override
	public void onHover(Input in, int delta) {
		
	}

	@Override
	public void onMouseDown(Input in, int delta) {

	}
}
