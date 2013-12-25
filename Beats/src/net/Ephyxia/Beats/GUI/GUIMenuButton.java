package net.Ephyxia.Beats.GUI;

import net.Ephyxia.Beats.Skin;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class GUIMenuButton extends GUIButton {

	private Color baseColor = Color.white;
	private Color hoverColor = Color.blue;
	private Color mouseDownColor = Color.red;

	private boolean hovered = false;
	private boolean mouseDown = false;
	
	private float xOffset = 0.0f;

	public GUIMenuButton(float x, float y, float width, float height, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
	}

	@Override
	void update(Input in, int delta) {
		resetFlags();
		updateState(in, delta);
		
		if(hovered) {
			if(xOffset > -40f) {
				xOffset -= .3f * delta;
			}
		}else {
			if(xOffset < 0) {
				xOffset += .3f * delta;
			}
		}
		
		if(xOffset > 0)
			xOffset = 0;
		if(xOffset < -40f)
			xOffset = -40f;

	}

	private void resetFlags() {
		hovered = false;
		mouseDown = false;
	}

	@Override
	void render(Graphics g) {
		pushColor(g);

		g.setColor(baseColor);

		if (hovered) {
			g.setColor(hoverColor);
		}
		if (mouseDown) {
			g.setColor(mouseDownColor);
		}
		
		g.fillRoundRect(x, y, width, height, 16);
		
		Image bLeft = Skin.buttonLeft.getScaledCopy(height / Skin.buttonLeft.getHeight());
		Image bMiddle= Skin.buttonMiddle.getScaledCopy((int) width, (int)(height/Skin.buttonMiddle.getHeight() * Skin.buttonMiddle.getHeight()));
		
		bMiddle.draw(x + bLeft.getWidth() + xOffset, y);
		bLeft.draw(x + xOffset, y);

		pushColor(g);
	}

	@Override
	public void onClick(Input in, int delta) {
		System.out.println("You clicked the " + text + " button!");
	}

	@Override
	public void onHover(Input in, int delta) {
		hovered = true;
	}

	@Override
	public void onMouseDown(Input in, int delta) {
		mouseDown = true;
	}
}
