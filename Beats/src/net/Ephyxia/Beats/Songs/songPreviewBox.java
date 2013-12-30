package net.Ephyxia.Beats.Songs;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class songPreviewBox {
	
	private int ID;
	private String song;
	private String title;
	private String artist;
	private String creator ;
	private float BPM;
	private float difficulty;
	private Object length;
	private Image background;
	
	public songPreviewBox(int ID, String dir, String song, String title, String artist, String creator, float difficulty, float BPM, String bg) {
		this.title = title;
		this.artist = artist;
		this.creator = creator;
		this.BPM = BPM;
//		this.length = length;
		this.difficulty = difficulty;
		this.song = song;
		this.ID = ID;
		try {
		background = new Image(bg);
		} catch (SlickException e) {
			e.printStackTrace();
			// else background = skin.defaultBG
		}
	}
	
	public void draw(Graphics g, float x, float y, float width, float height) {
		g.setColor(Color.red);
		g.fillRoundRect(x, y, width, height, 16);
	}
}
