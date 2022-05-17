package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener {

  static final int DELAY = 100;

  Timer timer;

  Character c;


  
  public Panel(int w, int h) {
    this.setPreferredSize(new Dimension(w, h));
    this.setFocusable(true);
    this.setBackground(Color.white);
    this.c = new Character();
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
    g.drawImage(c.getImage(), c.getXPos(), c.getYPos(), this);
    
  }


  public void actionPerformed(ActionEvent e) {
    //c.move();
    repaint();
  }

  
}