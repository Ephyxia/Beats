package net.Ephyxia.Beats;

import java.awt.Font;
import java.io.File;

import net.Ephyxia.Beats.Songs.SongInfo;
import net.Ephyxia.Beats.StateManager.StateHandler;
import net.Ephyxia.Beats.Utils.Fonts;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Beats extends BasicGame {

	public static final String TITLE = "Beats";
	public static final int width = 1360;
	public static final int height = 768;

	public Beats() {
		super(TITLE);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		Skin.loadSkin("res/images/skin/");
		StateHandler.init();
		Fonts.init();
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		File file = new File(Beats.class.getProtectionDomain().getCodeSource().getLocation().getFile());

		File file2 = new File(file.getParentFile().getPath() + "/Songs");

		if (!file2.exists()) {
			file2.mkdirs();
		}
		
		System.out.println(file2.getPath());
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input in = gc.getInput();

		StateHandler.update(in, delta);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		StateHandler.render(g);

		g.setFont(Fonts.get(24));
		g.setColor(Color.white);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Beats());
		app.setDisplayMode(width, height, false);
		app.setAlwaysRender(true);
		app.setUpdateOnlyWhenVisible(false);
		app.setTargetFrameRate(120);
//		app.setShowFPS(false);

		app.start();
	}
}
