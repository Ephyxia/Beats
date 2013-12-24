package net.Ephyxia.Beats.StateManager;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class StateHandler {

	public static final int MAIN_MENU_STATE = 0;
	public static final int GAMEPLAY_STATE = 1;
	public static final int OPTIONS_STATE = 2;

	private static Map<Integer, State> states = new HashMap<Integer, State>();

	private static State currentState;

	public static void init() {
		states.put(MAIN_MENU_STATE, new StateMainMenu());
		states.put(GAMEPLAY_STATE, new StateGameplay());
		states.put(OPTIONS_STATE, new StateOptions());
		
		enterState(MAIN_MENU_STATE);
	}

	public static void enterState(int stateID) {
		currentState = states.get(stateID);
		currentState.init();
	}

	public static void update(Input in, int delta) {
		currentState.update(in, delta);
	}

	public static void render(Graphics g) {
		currentState.render(g);
	}
}
