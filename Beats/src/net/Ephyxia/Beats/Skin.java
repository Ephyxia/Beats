package net.Ephyxia.Beats;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Skin {
	
	public static Image buttonLeft;
	public static Image buttonRight;
	public static Image buttonMiddle;
	
	public static void loadSkin(String dir) {
		try {
			buttonLeft = new Image(dir + "button-left" + ".png");
			buttonLeft.setFilter(Image.FILTER_LINEAR);
			buttonRight = new Image(dir + "button-right" + ".png");
			buttonRight.setFilter(Image.FILTER_LINEAR);
			buttonMiddle = new Image(dir + "button-middle" + ".png");
			buttonMiddle.setFilter(Image.FILTER_LINEAR);
		} catch (SlickException e) {
			System.out.println("Error loading skin make sure you didn't mess with files.");
		}
	}
}
