package net.Ephyxia.Beats;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Skin {
	
	public static Image buttonLeft;
	public static Image buttonRight;
	public static Image buttonMiddle;
	
	public static void loadSkin(String dir) {
		try {
			buttonLeft = new Image(dir + "");
			buttonRight = new Image(dir + "");
			buttonMiddle = new Image(dir + "");
		} catch (SlickException e) {
			System.out.println("Error loading skin make sure you didn't mess with files.");
		}
	}
}
