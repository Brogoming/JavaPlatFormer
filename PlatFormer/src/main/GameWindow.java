package main;

import javax.swing.JFrame; //new

public class GameWindow extends JFrame{
	private JFrame jFrame = new JFrame();
	
	public GameWindow(GamePanel gamePanel) { //constructor
		
		jFrame.setSize(400, 400); //400px wide and 400px tall
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the program when x is pressed
		jFrame.add(gamePanel); //adds the panel to the window
		jFrame.setLocationRelativeTo(null); //put the window in the center of the screen
		jFrame.setVisible(true); //shows the window, needs to be at the bottom
	}
	
}
