package game;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


public class Panel extends JPanel implements ActionListener {

  static final int DELAY = 1;

  Timer timer;

  private static int level;

  Character c;

  public static Board mainBoard;

  private int height;

  private int width;

  private static Level[] levels;

  public boolean[] switches;

  private BufferedImage mainBot;

  private boolean mainMenu;
  
  private static boolean endScreen;
  private static boolean read;
  
  private BufferedImage mainTop;
  
  private boolean running;

  private String characterNameR;
  private String characterNameL;

  private BufferedImage hatEnd;
  private BufferedImage noHatEnd;
  
  private BufferedImage instructionscreen;

  private BufferedImage pauseMenu;

  // TODO: MAKE A GAMEMODE INT TO REPLACE ALL THE GAMEMODE BOOLEANS, BECAUSE THIS IS GETTING OUT OF HAND
  
  private BufferedImage prevHat;
  private BufferedImage prevNoHat;
  
  public Panel(int w, int h) {
    this.endScreen = false;
    this.read = false;
    this.setPreferredSize(new Dimension(w, h));
    this.setFocusable(true);
    this.setBackground(Color.black);
    this.c = new Character();
    this.level = 0;
    this.levels = new Level[4];
    this.mainMenu = true;
    this.running = false;
    characterNameR = "SpriteRight.png";
    characterNameL = "SpriteLeft.png";
    this.mainBoard = new Board();
    
 
    try {
    	mainBot = ImageIO.read(new File("menuBottom.png"));
    } catch (IOException e) {
      	e.printStackTrace();
    }
      try {
    	instructionscreen = ImageIO.read(new File("instructionscreen.png"));
    } catch (IOException e) {
      	e.printStackTrace();
    }
    
    
    try {
    	mainTop = ImageIO.read(new File("menuTop.png"));
    } catch (IOException e) {
      	e.printStackTrace();
    }
    try {
    	prevHat = ImageIO.read(new File("SpriteRightHat.png"));
    } catch (IOException e) {
      	e.printStackTrace();
    }
    try {
    	prevNoHat = ImageIO.read(new File("SpriteRight.png"));
    } catch (IOException e) {
      	e.printStackTrace();
    }
    try {
    	pauseMenu = ImageIO.read(new File("PauseMenu.png"));
    } catch (IOException e) {
      	e.printStackTrace();
    } 
    try {
    	noHatEnd = ImageIO.read(new File("nohatwinscreen.png"));
    } catch (IOException e) {
      	e.printStackTrace();
    }
    try {
    	hatEnd = ImageIO.read(new File("hatwinscreen.png"));
    } catch (IOException e) {
      	e.printStackTrace();
    }

    levels[0] = new Level(0);
    levels[1] = new Level(1);
    levels[2] = new Level(2);
    levels[3] = new Level(3);
    
    height = h;
    width = w;
    
    timer = new Timer(DELAY, this);
    timer.start();
    
    this.addKeyListener(new KeyListener() { 
      //"listens" to key presses
      
      public void keyPressed(KeyEvent e) { 
        //method for when a key is pressed
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP && !mainMenu && running && !endScreen) {
          c.moveUp();
        } else if (!mainMenu && running && keyCode == KeyEvent.VK_DOWN && !endScreen) {
          c.moveDown();
        } else if (!mainMenu && running && keyCode == KeyEvent.VK_LEFT && !endScreen) {
          c.moveLeft();
        } else if (!mainMenu && running && keyCode == KeyEvent.VK_RIGHT && !endScreen) {
          c.moveRight();         
        } else if(!mainMenu && running && keyCode == KeyEvent.VK_SPACE && !endScreen) {
        	c.openChest();
        	
        } else if ((mainMenu || !running || read) && keyCode == KeyEvent.VK_ENTER) {
        	
        	running = true;
        	System.out.println("Start");
        	timer.start();
        	if (read) {
        		read = false;
        		
        		
        	}
        	
        	if(mainMenu) {
        		c = new Character(characterNameR, characterNameL);
        		read = true;
        		
        	}
        	
        	mainMenu = false;
        	
        } else if (endScreen && keyCode == KeyEvent.VK_ENTER) {
        	for (int i = levels.length - 1; i >= 0; i--) {
        		level = i;
        		resetLevel();
        	}
        	endScreen = false;
        	mainMenu = true;
        	running = false;
        
          } else if (!mainMenu && running && keyCode == KeyEvent.VK_ESCAPE) {
        	running = false;
  
        } else if (mainMenu && keyCode == KeyEvent.VK_1) {
        	characterNameR = "SpriteRight.png";
        	characterNameL = "SpriteLeft.png";
        } else if (mainMenu && keyCode == KeyEvent.VK_2) {
        	characterNameR = "SpriteRightHat.png";
        	characterNameL = "SpriteLeftHat.png";
        }

        
      }

      public void keyTyped(KeyEvent e) {
			  //unimplemented methods
      }

      public void keyReleased(KeyEvent e) {
			  
        //unimplemented methods
      }

     
    }); //do not alter this line

  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }

  public void draw(Graphics g) {
    /*g.setColor(Color.red);  // sets color
    g.fillRect(c.getXPos(), c.getYPos(), 25, 25); //draws a square*/
	
    if (!mainMenu && !endScreen) {
      if (!read) {
    	for (int r = 0; r < height/40; r++) {
    	  for (int c = 0; c < width/40; c++) {

    	    g.drawImage(mainBoard.getTile(r, c).getImg(), c * 40, r * 40, this);
    	  }
    	}

    	    
      g.drawImage(c.getImage(), c.getXPos(), c.getYPos(), this);

      for (int i = 0; i < getLevel().getSpikes().length ; i++) {
				Spike currSpike = getLevel().getSpikes()[i];
				g.drawImage(currSpike.getImage(), currSpike.getXPos(), currSpike.getYPos(), this);
			}
    }
      else{
        g.drawImage(instructionscreen, 0, 0, this);
      }
      }
    if (!running && !mainMenu && !endScreen && !read) {
    	g.setColor(new Color(0, 0, 0, 150));
    	g.fillRect(0, 0, 600, 600);
      g.drawImage(pauseMenu, 0, 0, this);
    	timer.stop();
      
    }
    if(mainMenu) {
    	g.drawImage(mainTop, 0, 0, this);
    	g.drawImage(mainBot, 0, 385, this);
    	g.drawImage(prevNoHat, 100, 300, 100, 100, this);
    	g.drawImage(prevHat, 400, 300, 100, 100, this);
    	g.setColor(Color.white);
    	if (characterNameR.equals("SpriteRight.png")) {
    		g.drawRect(85, 285, 130, 130);
    	} else {
    		g.drawRect(385, 285, 130, 130);
    	}
    }
    if(endScreen) {
    	if (characterNameR.equals("SpriteRight.png")) {
    		g.drawImage(noHatEnd, 0, 0, 600, 600, this);
    	} else {
    		g.drawImage(hatEnd, 0, 0, 600, 600, this);
    	}
    	
    	
    }
    
  }
  
  
  public static Level getLevel() {
    return levels[level]; 
  }
  
  public static void setLevelNum(int l) {
	  level = l;
  }
  
  public static int getLevelNum() {
	  return level;
  }

  public void actionPerformed(ActionEvent e) {
    mainBoard = levels[level].getBoard();
    repaint();
  }
  
  public static int getLastLevel() {
	  return levels.length - 1;
  }
  
  public static void winner() {
	  endScreen = true;
  }

  public void resetLevel() {
	  for (int i = 0; i < levels[level].getSwitchesCol().length; i++) {
		  levels[level].getBoard().getTile(levels[level].getSwitchesRow()[i], levels[level].getSwitchesCol()[i]).setOn(false);;
	  }
	 
		levels[level].getBoard().getTile(7, 14).setOpen(false);
	  
	  
	  c.setXPos(40);
	  c.setYPos(280);
  }
  public static Level getLevel(int l) {
	  return levels[l];
  }
  
}
