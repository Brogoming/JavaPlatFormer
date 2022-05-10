package Inputs;

import java.awt.event.MouseEvent; //new
import java.awt.event.MouseListener; //new
import java.awt.event.MouseMotionListener; //new

import main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener{

	private GamePanel gamePanel;
	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Mouse Clicked");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) { 
		
		
	}

}
