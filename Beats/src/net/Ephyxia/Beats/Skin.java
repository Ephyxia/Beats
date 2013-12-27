package net.Ephyxia.Beats;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Skin {

	public static Map<String, Image> skin = new HashMap<String, Image>();

	/**
	 * @author Ephyxia
	 * @param dir - Root directory of the skin you want to load.
	 * 
	 */
	public static void loadSkin(String dir) {

		// Button parts for main menu
		skin.put("menu-button-right", load(dir + "button-right" + ".png", false));
		skin.put("menu-button-left", load(dir + "button-left" + ".png", false));
		skin.put("menu-button-middle", load(dir + "button-middle" + ".png", false));
		// Menu text
		skin.put("menu-play", load(dir + "MainMenu/Play" + ".png", true));
		skin.put("menu-edit", load(dir + "MainMenu/Edit" + ".png", true));
		skin.put("menu-download", load(dir + "MainMenu/GetSongs" + ".png", true));
		skin.put("menu-options", load(dir + "MainMenu/Options" + ".png", true));
		skin.put("menu-quit", load(dir + "MainMenu/Quit" + ".png", true));
		// Menu icons
		skin.put("menu-play-icon", load(dir + "MainMenu/play-icon" + ".png", true));
		skin.put("menu-edit-icon", load(dir + "MainMenu/edit-icon" + ".png", true));
		skin.put("menu-download-icon", load(dir + "MainMenu/download-icon" + ".png", true));
		skin.put("menu-options-icon", load(dir + "MainMenu/options-icon" + ".png", true));
		skin.put("menu-quit-icon", load(dir + "MainMenu/quit-icon" + ".png", true));
		// Menu background
		skin.put("menu-background", load(dir + "MainMenu/background" + ".png", true));
		
		// TODO: create a glow effect for the main menu
	}

	private static Image load(String path, boolean alias) {
		try {
			Image temp = new Image(path);
			if (alias)
				temp.setFilter(Image.FILTER_LINEAR);
			else
				temp.setFilter(Image.FILTER_NEAREST);
			return temp;
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return null;
	}
}
