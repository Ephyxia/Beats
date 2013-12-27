package net.Ephyxia.Beats.StateManager;

import org.newdawn.slick.Image;

public class SongInfo {

	private String title;
	private String artist;
	private String creator;
	private float BPM;
	private float length;
	private float difficulty;

	private Image background;

	public SongInfo(String title, String artist, String creator, float difficulty, float BPM, float length, String path, Image bg) {
		this.title = title;
		this.artist = artist;
		this.creator = creator;
		this.BPM = BPM;
		this.length = length;
		this.difficulty = difficulty;
		if (bg != null)
			this.background = bg;
		// else backgroung = skin.default bg
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getCreator() {
		return creator;
	}

	public float getBPM() {
		return BPM;
	}

	public float getLength() {
		return length;
	}

	public float getDifficulty() {
		return difficulty;
	}
}
