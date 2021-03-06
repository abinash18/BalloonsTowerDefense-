/**
 * Abinash Singh
 * Balloons Tower Defense Main Menu 
 */
package balloonsTowerDefence;

import static other.DrawInFrame.DrawQuadWithTexture;
import static other.DrawInFrame.GRID_SQUARE_SIZE;
import static other.DrawInFrame.HEIGHT;
import static other.DrawInFrame.LoadTexture;
import static other.DrawInFrame.WIDTH;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import handlers.ServerExplorer;
import other.StateManager;
import other.StateManager.GameState;
import userInterface.UserInterface;

/**
 * Starting screen for the game
 */
public class MainMenu {

	private Texture bg;
	private UserInterface menuUI;
	// private Menu mainMenu;

	/**
	 * constructor Creates a main menu object and initializes default textures
	 */
	public MainMenu() {
		bg = LoadTexture("mainMenu_BackGround");

		menuUI = new UserInterface();
		menuUI.createMenu("MainGameActions", GRID_SQUARE_SIZE / 2, GRID_SQUARE_SIZE / 4, 500, 500, 2, 2);

		// mainMenu = menuUI.getMenu("MainGameActions");
		// mainMenu.addMenuButton("play", "button_play");
		//
		// mainMenu.addMenuButton("LevelEdit", "button_LevelEdit");
		// mainMenu.addMenuButton("LeaderBoard", "button_LeaderBoard");
		// mainMenu.addMenuButton("Options", "button_Options");
		// mainMenu.addMenuButton("Exit", "button_Exit");
		// mainMenu.addMenuButton("Instructions", "button_Instructions");

		//menuUI.addButton("play", "button_play", (int) (WIDTH / 3.5f), (int) (HEIGHT * 0.35f));
		menuUI.addButton("play", "button_play", (int) (WIDTH / 3.5f), (int) (HEIGHT * 0.45f));
		menuUI.addButton("LevelEdit", "button_LevelEdit", (int) (WIDTH / 2.9f), (int) (HEIGHT * 0.53f));
		menuUI.addButton("LeaderBoard", "button_LeaderBoard", (int) (WIDTH / 3.5f), (int) (HEIGHT * 0.59f));
		menuUI.addButton("Options", "button_Options", (int) (WIDTH / 2.9f), (int) (HEIGHT * 0.66f));
		menuUI.addButton("Exit", "button_Exit", (int) (WIDTH / 1.1), (int) (HEIGHT * 0.88f));
		menuUI.addButton("Instructions", "button_Instructions", WIDTH / 180 - 20, (int) (HEIGHT * 0.88f));
		
	}

	/**
	 * Called every time the game loops and checks if the user has clicked a button
	 */
	public void checkClick() {
		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (menuUI.isButtonClicked("play")) {
					StateManager.setState(GameState.MAP_SELECT_SCREEN);
				}
				if (menuUI.isButtonClicked("playOnline")) {
//					StateManager.setState(GameState.GAME_ONLINE);
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							ServerExplorer.start();
						}
					}).start();
				}
				if (menuUI.isButtonClicked("LevelEdit")) {
					StateManager.setState(GameState.LEVEL_EDITOR);
				}
				if (menuUI.isButtonClicked("Exit")) {
					System.exit(0);
				}
				if (menuUI.isButtonClicked("Instructions")) {
					handlers.Informal.showInstructions();
				}
			}
		}
	}

	/**
	 * Called every time the game loops and dispatches events to update the menu
	 */
	public void tick() {
		DrawQuadWithTexture(bg, 0, 0, 2500, 1024);
		menuUI.drawOnScreen();
		checkClick();
	}

}
