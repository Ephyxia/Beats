package net.Ephyxia.Beats;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Skin {
	
	// Making all images static so I don't have to create a million temporary Images which can be really slow.
	public static Image buttonLeft;
	public static Image buttonRight;
	public static Image buttonMiddle;
	
	/**
	 * @author Ephyxia
	 * @param dir - Root directory of the skin you want to load.
	 * 
	 */
	public static void loadSkin(String dir) {
		try {
			buttonLeft = new Image(dir + "button-left" + ".png");
			buttonLeft.setFilter(Image.FILTER_NEAREST);
			buttonRight = new Image(dir + "button-right" + ".png");
			buttonRight.setFilter(Image.FILTER_NEAREST);
			buttonMiddle = new Image(dir + "button-middle" + ".png");
			buttonMiddle.setFilter(Image.FILTER_NEAREST);
		} catch (SlickException e) {
			System.out.println(Errors.skinFailedToLoad);
		}
	}
}
