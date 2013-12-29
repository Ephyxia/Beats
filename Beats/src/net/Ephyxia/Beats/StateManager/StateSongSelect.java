package net.Ephyxia.Beats.StateManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import net.Ephyxia.Beats.Beats;
import net.Ephyxia.Beats.GUI.Screen;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class StateSongSelect extends State {

	Screen screen;

	Music preview;

	// preview = new Music(songList.get(0)[0].getSong().getCanonicalPath(),
	// false);
	// preview.play();

	private ArrayList<SongInfo[]> songList = new ArrayList<SongInfo[]>();
	private ArrayList<String> songs = new ArrayList<String>();

	@Override
	void init() {
		screen = new Screen();

		loadSongs();
	}

	/**
	 * Loads song data from SongList.sapp and stores it into the songs ArrayList as a set of strings.
	 */
	private void loadSongs() {
		try {
			File par = new File(Beats.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			File dir = new File(par.getParentFile().getPath() + "/Songs/SongList.sapp");

			BufferedReader in = new BufferedReader(new FileReader(dir));

			String line;

			while ((line = in.readLine()) != null) {
				songs.add(line);
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	void update(Input in, int delta) {
		screen.update(in, delta);

		if (in.isKeyPressed(Input.KEY_F5)) {
			refreshSongList();
		}
	}

	@Override
	void render(Graphics g) {
		screen.render(g);

		g.drawString("Number of loaded Songs: " + songs.size(), 16, 32);
		// g.drawString("Number of loaded maps: " + getLoadedMaps(), 16, 48);
	}

	
	/**
	 *  Does a complete scan of the Songs folder and stores the song metadata into the SongList.sapp file.
	 */
	private void refreshSongList() {
		long startTime = System.currentTimeMillis();

		songList = new ArrayList<SongInfo[]>();

		File file = new File(Beats.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		File file2 = new File(file.getParentFile().getPath() + "/Songs");

		// Check every folder in the Songs dir
		for (File f : file2.listFiles()) {
			if (f.isDirectory()) {
				if (containsMaps(f))
					songList.add(getSongInfo(f));
			}
		}

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file2.getCanonicalPath() + "/SongList.sapp", false));

			for (SongInfo[] s : songList) {
				for (SongInfo ss : s) {
					out.write(ss.getTitle() + ":" + ss.getArtist() + ":" + ss.getCreator() + ":" + ss.getDir().getCanonicalPath() + ":" + ss.getSong().getName() + ":" + ss.getBgPath() + ":" + ss.getDifficulty() + ":");
					out.newLine();
				}
			}

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		songList = null;

		Runtime.getRuntime().gc();

		System.out.println("Loaded all songs in " + (System.currentTimeMillis() - startTime));

		loadSongs();
	}

	/**
	 * Helper method for reading an .eph file and retrieving basic info from it.
	 * @param ff
	 * @return
	 */
	private SongInfo parseSong(File ff) {

		SongInfo s = new SongInfo();

		s.setDir(ff.getParentFile());

		try {
			BufferedReader in = new BufferedReader(new FileReader(ff));

			String line;

			while ((line = in.readLine()) != null) {
				if (line.startsWith("Title")) {
					s.setTitle(line.split(":")[1].trim());
				} else if (line.startsWith("Artist")) {
					s.setArtist(line.split(":")[1].trim());
				} else if (line.startsWith("Creator")) {
					s.setCreator(line.split(":")[1].trim());
				} else if (line.startsWith("Background")) {
					s.setBackground(new Image(ff.getParent() + "/" + line.split(":")[1].trim()));
					s.setBgPath(ff.getParent() + "/" + line.split(":")[1].trim());
				} else if (line.startsWith("AudioFile")) {
					s.setSong(new File(ff.getParent() + "/" + line.split(":")[1].trim()));
				} else if (line.startsWith("BPM")) {
					s.setBPM(Float.parseFloat(line.split(":")[1].trim()));
				} else if (line.startsWith("Difficulty")) {
					s.setDifficulty(Float.parseFloat(line.split(":")[1].trim()));
				}
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return s;
	}

	private boolean containsMaps(File f) {
		for (File ff : f.listFiles())
			if (ff.getName().endsWith(".eph"))
				return true;
		return false;
	}

	private SongInfo[] getSongInfo(File f) {

		ArrayList<SongInfo> maps = new ArrayList<SongInfo>();

		for (File ff : f.listFiles()) {
			if (ff.getName().endsWith(".eph")) {
				maps.add(parseSong(ff));
			}
		}
		return maps.toArray(new SongInfo[maps.size()]);
	}

}
