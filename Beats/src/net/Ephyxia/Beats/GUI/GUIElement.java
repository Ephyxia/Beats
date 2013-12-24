package net.Ephyxia.Beats.GUI;

import org.newdawn.slick.Input;

public interface GUIElement {
	abstract void onClick(Input in, int delta);
	abstract void onHover(Input in, int delta);
	abstract void onMouseDown(Input in, int delta);
}
