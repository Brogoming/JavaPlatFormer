package main;

import java.awt.Color;
import java.awt.Graphics; //new
import java.awt.event.KeyEvent; //new
import java.awt.event.KeyListener; //new
import java.util.Random;

import javax.swing.JPanel; //new

import Inputs.KeyBoardInputs; //allows the panel to access KeyBoardInputs
import Inputs.MouseInputs; //allows the panel to access MouseInputs

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100; //changes the x and y value
	private float xDir = 1f, yDir = 1f; //the directions of the x and y coordinates
	private int frames = 0; //number of frames
	private long lastCheck = 0; //every 1000 milsec, the last time we were in the if statement
	private Color color = new Color(150, 20, 90); //changes the color of the rectangle with red, green, blue (0-255)
	private Random random;
	
	public GamePanel() {
		random = new Random();
		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyBoardInputs(this)); //looks(listens) for KeyBoardInputs	
		addMouseListener(mouseInputs); //looks(listens) for MouseInputs	
		addMouseMotionListener(mouseInputs); //looks(listens) for MouseInputs motion
	}
	
	public void changeXDelta(int value) { //method that changes the x value
		this.xDelta += value;
	}
	
	public void changeYDelta(int value) { //method that changes the y value
		this.yDelta += value;
		repaint();
	}
	
	public void setRectPos(int x, int y) { //when in a new position we apply the new values to x and y delta 
		this.xDelta = x;
		this.yDelta = y;
	}
	
	public void paintComponent(Graphics g) { //graphics allows us to draw
		
		super.paintComponent(g); //calling the super class JPanel paintComponent
		
		updateRectangle();
		
		g.setColor(color); //changes the color of the rectangle with red, green, blue
		g.fillRect((int)xDelta, (int)yDelta, 200, 50); //x, y, wide, tall.
		
	}

	private void updateRectangle() { //allows the rectangle to move by itself and change color
		xDelta += xDir;
		if(xDelta > 400 || xDelta < 0) { //reverses the direction if the x delta of the rectangle x > 400 or <0
			xDir*=-1;
			color = getRandomColor();
		}
		yDelta += yDir;
		if(yDelta > 400 || yDelta < 0) { //reverses the direction if the x delta of the rectangle x > 400 or <0
			yDir*=-1;
			color = getRandomColor();
		}
	}

	private Color getRandomColor() { //change color method
		int r = random.nextInt(255); //red
		int g = random.nextInt(255); //green
		int b = random.nextInt(255); //blue
		
		return new Color (r, g, b);
	}
	
}
