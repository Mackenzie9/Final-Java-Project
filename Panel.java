import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener {

  static final int DELAY = 100;

  Timer timer;

  Character c;

  Board mainBoard;

  private int height;

  private int width;


  
  public Panel(int w, int h) {
    this.setPreferredSize(new Dimension(w, h));
    this.setFocusable(true);
    this.setBackground(Color.white);
    this.c = new Character();

    height = h;
    width = w;
    
    timer = new Timer(DELAY, this);
    timer.start();
    mainBoard = new Board();
    
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

    BufferedImage tempImg;
    
    for (int r = 0; r < height/40; r++) {
      for (int c = 0; c < width/40; c++) {

        String fileName;
        int tileType = mainBoard.getTile(r, c);
        if (tileType == 0) {
          fileName = "Floor.png";
        } else if (tileType == 1) {
          fileName = "Wall.png";
        } else if (tileType == 2) {
          fileName = "Water.png";
        } else if (tileType == 3) {
          fileName = "Door.png";
        } else if (tileType == 4) {
          fileName = "Switch.png";
        } else {
          fileName = "Smile.png";
        }

        try {
  	      tempImg = ImageIO.read(new File(filename));
        } catch (IOException e) {
    	    e.printStackTrace();
        }

        g.draw(tempImg, c * 40, r * 40, this);
      }
    }

    
    g.drawImage(c.getImage(), c.getXPos(), c.getYPos(), this);
    
  }


  public void actionPerformed(ActionEvent e) {
    //c.move();
    repaint();
  }

  
}
