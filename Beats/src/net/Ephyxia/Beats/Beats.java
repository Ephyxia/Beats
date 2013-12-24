package net.Ephyxia.Beats;

import net.Ephyxia.Beats.StateManager.StateHandler;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
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
		StateHandler.init();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input in = gc.getInput();
		
		StateHandler.update(in, delta);
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		StateHandler.render(g);
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Beats());
		app.setDisplayMode(width, height, false);
		app.setAlwaysRender(true);
		app.setUpdateOnlyWhenVisible(false);
		app.setTargetFrameRate(120);
		app.setShowFPS(false);
		
		app.start();
	}
}
