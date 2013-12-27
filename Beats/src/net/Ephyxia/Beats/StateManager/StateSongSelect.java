package net.Ephyxia.Beats.StateManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import net.Ephyxia.Beats.Beats;
import net.Ephyxia.Beats.GUI.Screen;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.ResourceLoader;

public class StateSongSelect extends State {

	Screen screen;
	
	Music preview;

//	preview = new Music(songList.get(0)[0].getSong().getCanonicalPath(), false);
//	preview.play();
	
	private ArrayList<SongInfo[]> songList = new ArrayList<SongInfo[]>();

	@Override
	void init() {
		screen = new Screen();

		loadSongs();
	}

	private void loadSongs() {

		long startTime = System.currentTimeMillis();

		File file = new File(Beats.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		File file2 = new File(file.getParentFile().getPath() + "/Songs");

		// Check every folder in the Songs dir
		for (File f : file2.listFiles()) {
			if (f.isDirectory()) {
				if (containsMaps(f))
					songList.add(getSongInfo(f));
				System.out.println("Added " + f.getName() + " there are now " + songList.size() + " loaded");
			}
		}

		System.out.println("Loaded all songs in " + (System.currentTimeMillis() - startTime));
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

	private SongInfo parseSong(File ff) {

		SongInfo s = new SongInfo();

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
					System.out.println(ff.getParent() + "/" + line.split(":")[1].trim());
				}else if (line.startsWith("AudioFile")) {
					s.setSong(new File(ff.getParent() + "/" + line.split(":")[1].trim()));
					System.out.println(ff.getParent() + "/" + line.split(":")[1].trim());
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

	@Override
	void update(Input in, int delta) {
		screen.update(in, delta);
	}

	@Override
	void render(Graphics g) {
		screen.render(g);

		g.drawString("Number of loaded Songs: " + songList.size(), 16, 32);
		g.drawString("Number of loaded maps: " + getLoadedMaps(), 16, 48);
	}

	private int getLoadedMaps() {
		int num = 0;

		for (SongInfo[] s : songList) {
			num += s.length;
		}

		return num;
	}
}
