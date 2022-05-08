package main;

public class Game implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread; //a separate thread that is ran
	private final int FPS_SET = 120; //max frames per second
	
	public Game() { //constructor - head method of the class
		gamePanel = new GamePanel(); //needs to create the game panel before the window
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus(); //gets input focus
		startGameLoop();
		
	}
	
	private void startGameLoop() { //starts the separate thread
		gameThread = new Thread(this);
		gameThread.start(); //starts the thread
	}

	@Override
	public void run() { //runs a separate thread
		
		double timePFrame = 1000000000.0/FPS_SET; //how long each frame will last in nano-seconds
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		int frames = 0;
		long lastCheck = System.currentTimeMillis();
		
		while(true) { //an infinite loop that always runs
			
			now = System.nanoTime();
			if(now - lastFrame >= timePFrame) { //if the last  time we had a frame if it is more or equal to the duration we want to display
				gamePanel.repaint(); //repaint the surface again
				lastFrame = now;
				frames++; //adds the number of frames per second (when this repaints)
			}
			
			if(System.currentTimeMillis() - lastCheck >= 1000) { //fps counter
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS " + frames);
				frames = 0; //resets the frames
			}
		}
		
	}
	
}
