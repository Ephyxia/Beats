package net.Ephyxia.Beats.GUI;

import static net.Ephyxia.Beats.Skin.*;
import net.Ephyxia.Beats.StateManager.StateHandler;
import net.Ephyxia.Beats.Utils.Fonts;

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

	private static Image[] buttonIcons = { skin.get("menu-play-icon"), skin.get("menu-edit-icon"), skin.get("menu-download-icon"), skin.get("menu-options-icon"), skin.get("menu-quit-icon") };

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

		if (hovered) {
			if (xOffset > -40f) {
				xOffset -= .3f * delta;
			}
		} else {
			if (xOffset < 0) {
				xOffset += .3f * delta;
			}
		}

		if (xOffset > 0)
			xOffset = 0;
		if (xOffset < -40f)
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

		}
		if (mouseDown) {

		}

		// g.fillRoundRect(x, y, width, height, 16);

		Image bLeft = skin.get("menu-button-left").getScaledCopy(height / skin.get("menu-button-left").getHeight());
		Image bMiddle = skin.get("menu-button-middle").getScaledCopy((int) width, (int) (height / skin.get("menu-button-middle").getHeight() * skin.get("menu-button-middle").getHeight()));

		bMiddle.draw(x + bLeft.getWidth() + xOffset, y);
		bLeft.draw(x + xOffset, y);

		skin.get(text).getScaledCopy((float) (skin.get(text).getHeight() / 175f)).draw(x + 96 + xOffset, y + 28);

		skin.get(text + "-icon").getScaledCopy(64, 64).draw(x + xOffset + 24, y + 20);

		popColor(g);
	}

	@Override
	public void onClick(Input in, int delta) {
		System.out.println("You clicked the " + text + " button!");

		if (text == "menu-play") {
			StateHandler.enterState(StateHandler.SONG_SELECT_STATE);
		}
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
