package main;

import java.awt.Graphics; //new

import javax.swing.JPanel; //new

public class GamePanel extends JPanel{

	public GamePanel() {
		
		
		
	}
	
	public void paintComponent(Graphics g) { //graphics allows us to draw
		
		super.paintComponent(g); //calling the super class JPanel paintComponent
		
		//g.drawRect(100, 100, 200, 50); //x, y, wide, tall. Only draws it, not filled
		g.fillRect(100, 100, 200, 50);
	}
	
}
