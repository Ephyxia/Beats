package net.Ephyxia.Beats.Utils;

import java.awt.Font;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Fonts {

	public static Map<Integer, TrueTypeFont> fonts = new HashMap<Integer, TrueTypeFont>();
	
	public static void init() {
		try {
			InputStream in = ResourceLoader.getResourceAsStream("res/fonts/Subway Black.ttf");
			Font ph = Font.createFont(Font.TRUETYPE_FONT, in);

			for (int i = 12; i <= 72; i += 4) {
				fonts.put(i, new TrueTypeFont(ph.deriveFont((float) i), true));
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TrueTypeFont get(int size) {
		if (size % 4 == 0) {
			return fonts.get(size);
		} else {
			System.out.println("Invalid font size try again buddy");
			return fonts.get(24);
		}
	}
}
