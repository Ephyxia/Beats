package net.Ephyxia.Beats.Utils;

import java.awt.Font;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

public class Fonts {

	public static Map<Integer, UnicodeFont> fonts = new HashMap<Integer, UnicodeFont>();

	public static final int SHADOW = 100;

	@SuppressWarnings("unchecked")
	public static void init() {
//		try {
//			InputStream in2 = ResourceLoader.getResourceAsStream("res/fonts/Subway Black.ttf");
//			Font ph2 = Font.createFont(Font.TRUETYPE_FONT, in2);
//
//			for (int i = 12; i <= 48; i += 4) {
//				UnicodeFont font = new UnicodeFont(ph2.deriveFont(0, i));
//				font.addAsciiGlyphs();
//				ColorEffect e = new ColorEffect();
//				e.setColor(java.awt.Color.white);
//				font.getEffects().add(e);
//				font.loadGlyphs();
//				fonts.put(i, font);
//			}
//
//			in2.close();
//
//			InputStream in = ResourceLoader.getResourceAsStream("res/fonts/Subway Shadow.ttf");
//			Font ph = Font.createFont(Font.TRUETYPE_FONT, in);
//
//			for (int i = 12; i <= 48; i += 4) {
//				UnicodeFont font = new UnicodeFont(ph.deriveFont(0, i));
//				font.addAsciiGlyphs();
//				ColorEffect e = new ColorEffect();
//				e.setColor(java.awt.Color.white);
//				font.getEffects().add(e);
//				font.loadGlyphs();
//				fonts.put(i + SHADOW, font);
//			}
//
//			in.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static UnicodeFont get(int size) {
		if (size % 4 == 0) {
			return fonts.get(size);
		} else {
			System.out.println("Invalid font size try again buddy");
			return fonts.get(24);
		}
	}

	public static void drawShadowedString(Graphics g, String text, float x, float y, int size) {
		g.setFont(get(size));
		g.setColor(Color.white);
		g.drawString(text, x, y);
		g.setFont(get(size + SHADOW));
		g.setColor(Color.black);
		g.drawString(text, x, y);
	}
}
