package main;

import java.awt.Graphics; //new
import java.awt.event.KeyEvent; //new
import java.awt.event.KeyListener; //new

import javax.swing.JPanel; //new

import Inputs.KeyBoardInputs; //allows the panel to access KeyBoardInputs
import Inputs.MouseInputs; //allows the panel to access MouseInputs

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	private int xDelta = 100, yDelta = 100; //changes the x and y value

	public GamePanel() {
		
		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyBoardInputs(this)); //looks(listens) for KeyBoardInputs	
		addMouseListener(mouseInputs); //looks(listens) for MouseInputs	
		addMouseMotionListener(mouseInputs); //looks(listens) for MouseInputs motion
	}
	
	public void changeXDelta(int value) { //method that changes the x value
		this.xDelta += value;
		repaint();
	}
	
	public void changeYDelta(int value) { //method that changes the y value
		this.yDelta += value;
		repaint();
	}
	
	public void setRectPos(int x, int y) { //when in a new position we apply the new values to x and y delta 
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}
	
	public void paintComponent(Graphics g) { //graphics allows us to draw
		
		super.paintComponent(g); //calling the super class JPanel paintComponent
		
		//g.drawRect(xDelta, yDelta, 200, 50); //x, y, wide, tall. Only draws it, not filled
		g.fillRect(xDelta, yDelta, 200, 50);
	}
	
}
