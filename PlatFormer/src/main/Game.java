package main;

public class Game {
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	
	public Game() { //constructor - head method of the class
		gamePanel = new GamePanel(); //needs to create the game panel before th window
		gameWindow = new GameWindow(gamePanel);
		
	}
	
}
