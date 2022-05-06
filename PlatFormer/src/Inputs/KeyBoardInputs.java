package Inputs;

import java.awt.event.KeyEvent; //new
import java.awt.event.KeyListener; //new

import main.GamePanel;

public class KeyBoardInputs implements KeyListener {
	
	private GamePanel gamePanel;
	public KeyBoardInputs(GamePanel gamePanel) { //constructor
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) { //e. gets the key that was pressed
		case KeyEvent.VK_W:
			gamePanel.changeYDelta(-5);
			break;
		case KeyEvent.VK_A:
			gamePanel.changeXDelta(-5);
			break;
		case KeyEvent.VK_S:
			gamePanel.changeYDelta(5);
			break;
		case KeyEvent.VK_D:
			gamePanel.changeXDelta(5);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
