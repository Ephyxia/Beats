package net.Ephyxia.Beats.StateManager;

import net.Ephyxia.Beats.GUI.GUIMenuButton;
import net.Ephyxia.Beats.GUI.Screen;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class StateMainMenu extends State {

	Screen screen;

	private String[] menuButtonText = { "Play", "Get Songs", "Edit Songs", "Options", "Exit" };

	private int buttonX = 940;
	private int buttonYStart = 240;
	private int buttonWidth = 560;
	private int buttonHeight = 96;
	private int buttonSpacing = 8;

	// 672 = height of all butttons
	// button height should be 1/6 of screen height

	@Override
	void init() {
		screen = new Screen();

		for (int i = 0; i <= menuButtonText.length - 1; i++) {
			screen.addComponent(new GUIMenuButton(buttonX, buttonYStart + i * (buttonHeight + buttonSpacing), buttonWidth, buttonHeight, menuButtonText[i]));
		}
	}

	@Override
	void update(Input in, int delta) {
		screen.update(in, delta);
	}

	@Override
	void render(Graphics g) {
		screen.render(g);
	}
}
