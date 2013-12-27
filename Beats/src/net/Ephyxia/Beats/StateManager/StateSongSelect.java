package net.Ephyxia.Beats.StateManager;

import net.Ephyxia.Beats.Beats;
import net.Ephyxia.Beats.Skin;
import net.Ephyxia.Beats.GUI.GUIMenuButton;
import net.Ephyxia.Beats.GUI.Screen;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class StateSongSelect extends State {

	Screen screen;
	
	

	@Override
	void init() {
		screen = new Screen();

	}

	@Override
	void update(Input in, int delta) {
		screen.update(in, delta);
	}

	@Override
	void render(Graphics g) {
		// Skin.skin.get("song-select-background").getScaledCopy(Beats.width, Beats.height).draw();
		screen.render(g);
	}
}
