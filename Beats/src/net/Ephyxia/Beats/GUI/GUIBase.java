package net.Ephyxia.Beats.GUI;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GUIBase extends GUIComponent implements GUIElement {

	@Override
	void update(Input in, int delta) {

	}

	@Override
	void render(Graphics g) {

	}

	@Override
	void updateState(Input in, int delta) {
		int mx = in.getMouseX();
		int my = in.getMouseY();
		
		if(mx >= x && mx <= x + width && my >= y && my <= y + height) {
			if(in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				onClick(in, delta);
			} else if(in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				onMouseDown(in, delta);
			} else {
				onHover(in, delta);
			}
		}
	}
	@Override
	public void onClick(Input in, int delta) {
		
	}

	@Override
	public void onHover(Input in, int delta) {
		
	}

	@Override
	public void onMouseDown(Input in, int delta) {
		
	}
}
