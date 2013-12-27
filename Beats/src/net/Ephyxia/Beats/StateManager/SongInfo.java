package net.Ephyxia.Beats.StateManager;

import java.io.File;

import org.newdawn.slick.Image;

public class SongInfo {

	private File dir;
	private File song;
	private String title = "Title";
	private String artist = "Artist";
	private String creator = "Creator";
	private float BPM = 100;
	private float length = 100;
	private float difficulty = 10;

	private Image background;

	public SongInfo(File dir, File song, String title, String artist, String creator, float difficulty, float BPM, float length, String path, Image bg) {
		this.title = title;
		this.artist = artist;
		this.creator = creator;
		this.BPM = BPM;
		this.length = length;
		this.difficulty = difficulty;
		this.song = song;
		if (bg != null)
			this.background = bg;
		// else backgroung = skin.default bg
	}

	public SongInfo() {

	}

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}

	public File getSong() {
		return song;
	}

	public void setSong(File song) {
		this.song = song;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public float getBPM() {
		return BPM;
	}

	public void setBPM(float bPM) {
		BPM = bPM;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}

	public Image getBackground() {
		return background;
	}

	public void setBackground(Image background) {
		this.background = background;
	}

	
}
