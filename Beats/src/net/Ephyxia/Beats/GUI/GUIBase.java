package net.Ephyxia.Beats.GUI;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class GUIBase extends GUIComponent implements GUIElement {

	private Color tempColor;

	@Override
	void update(Input in, int delta) {

	}

	@Override
	void render(Graphics g) {

	}

	/**
	 * Handles the  detection of mouse states in relation to this GUIComponent.
	 * Put this in the update method of any element you want the user to be able to interact with.
	 */
	@Override
	void updateState(Input in, int delta) {
		int mx = in.getMouseX();
		int my = in.getMouseY();

		if (mx >= x && mx <= x + width && my >= y && my <= y + height) {
			onHover(in, delta);

			if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				onClick(in, delta);
			}
			if (in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				onMouseDown(in, delta);
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

	public void pushColor(Graphics g) {
		tempColor = g.getColor();
	}

	public void popColor(Graphics g) {
		g.setColor(tempColor);
	}
}
