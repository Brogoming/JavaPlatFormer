package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Inputs.KeyBoardInputs; //allows the panel to access KeyBoardInputs
import Inputs.MouseInputs; //allows the panel to access MouseInputs

import static utilz.Constants.PlayerConstants.*; //imports all the player animations
import static utilz.Constants.Directions.*; //imports the directions of movement

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100; //changes the x and y value
	private BufferedImage image; //used to create an image
	private BufferedImage[][] animations; //animation array
	private int aniTick, aniIndex, aniSpeed = 15; //the ticks per animation, the index of the animation, the speed of each animation image
	private int playerAction = IDLE; //the default animation
	private int playerDir = -1; //not moving
	private boolean moving = false;
	
	public GamePanel() {
		mouseInputs = new MouseInputs(this);
		
		importImg();
		loadAnimations();
		
		setPanelSize();
		addKeyListener(new KeyBoardInputs(this)); //looks(listens) for KeyBoardInputs	
		addMouseListener(mouseInputs); //looks(listens) for MouseInputs	
		addMouseMotionListener(mouseInputs); //looks(listens) for MouseInputs motion
	}
	
	private void loadAnimations() { //loads our animations
		animations = new BufferedImage[9][6]; //9 rows and 6 columns of animation
		
		for(int j = 0; j < animations.length; j++) { //row
			for(int i = 0; i < animations[j].length; i++) {
				animations[j][i] = image.getSubimage(i*64, j*40, 64, 40); //gets the image from each column on row 0
				
			}
		}
		
	}

	private void importImg() { //imports the image to use
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		
		try {
			image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void setPanelSize() { //sets the size of the panel we play in
		Dimension size = new Dimension(1200, 800); //the images are 32 px big so its 40 images by 25 images
		setPreferredSize(size); //sets the size of the panel
		
	}
	
	public void setDirection(int direction) {
		this.playerDir = direction;
		moving = true;
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public void paintComponent(Graphics g) { //graphics allows us to draw
		super.paintComponent(g);
		updateAnimationTick();
		
		setAnimation();
		updatePos();
		
		g.drawImage(animations[playerAction][aniIndex], (int)xDelta, (int)yDelta, 256, 160, null); //image, x, y, image width, image height, image observer
		
	}

	private void updatePos() { //allows us to change position
		
		if(moving) {
			switch(playerDir) {
			case LEFT:
				xDelta -= 5;
				break;
			case UP:
				yDelta -= 5;
				break;
			case RIGHT:
				xDelta += 5;
				break;
			case DOWN:
				yDelta += 5;
				break;
			}
		}
		
	}

	private void setAnimation() { //determines what animation we will have for the frame
		if(moving) {
			playerAction = RUNNING;
		} else {
			playerAction = IDLE;
		}
		
	}

	private void updateAnimationTick() { //cycles through the animation
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0; //resets the tick
			aniIndex++; 
			if (aniIndex >= GetSpriteAmount(playerAction)) { //if the index is greater than or equal to 6
				aniIndex = 0; //resets the index
			}
		}
	}
}
