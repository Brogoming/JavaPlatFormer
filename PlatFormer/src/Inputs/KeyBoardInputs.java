package Inputs;

import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener; 
import static utilz.Constants.Directions.*;

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
			gamePanel.setDirection(UP);
			break;
		case KeyEvent.VK_A:
			gamePanel.setDirection(LEFT);
			break;
		case KeyEvent.VK_S:
			gamePanel.setDirection(DOWN);
			break;
		case KeyEvent.VK_D:
			gamePanel.setDirection(RIGHT);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) { //when we release from the key it stops the animation
		case KeyEvent.VK_W:
		case KeyEvent.VK_A:
		case KeyEvent.VK_S:
		case KeyEvent.VK_D:
			gamePanel.setMoving(false);
			break;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
