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
  
  public Panel(int w, int h) {
    this.setPreferredSize(new Dimension(w, h));
    this.setFocusable(true);
    this.setBackground(Color.white);
    this.c = new Character();
    this.level = 0;
    this.levels = new Level[4];
    
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
        if (keyCode == KeyEvent.VK_UP) {
          c.moveUp();
        } else if (keyCode == KeyEvent.VK_DOWN) {
          c.moveDown();
        } else if (keyCode == KeyEvent.VK_LEFT) {
          c.moveLeft();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
          c.moveRight();         
        }

        
      }

      public void keyTyped(KeyEvent e) {
			
			}

		  public void keyReleased(KeyEvent e) {
			
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
    
    for (int r = 0; r < height/40; r++) {
      for (int c = 0; c < width/40; c++) {

        g.drawImage(mainBoard.getTile(r, c).getImg(), c * 40, r * 40, this);
      }
    }

    
    g.drawImage(c.getImage(), c.getXPos(), c.getYPos(), this);
    
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
  
}
