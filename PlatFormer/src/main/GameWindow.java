package main;

import javax.swing.JFrame; //new

public class GameWindow extends JFrame{
	private JFrame jFrame = new JFrame();
	
	public GameWindow(GamePanel gamePanel) { //constructor
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the program when x is pressed
		jFrame.add(gamePanel); //adds the panel to the window
		jFrame.setLocationRelativeTo(null); //put the window in the center of the screen
		jFrame.setResizable(false); //we don't want to resize the window
		jFrame.pack(); //tells jFrame to fit the size of the window to the panel
		jFrame.setVisible(true); //shows the window, needs to be at the bottom
	}
	
}
