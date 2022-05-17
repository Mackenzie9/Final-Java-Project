
package game;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;


public class Character {

  int xPos;
  int yPos;
  
  int width;
  int height;
  
  BufferedImage img;

  public Character(int w, int h) {
    xPos = 0;
    yPos = 0;
    
    width = w;
    height = h;
    
    
    
    try {
  	  img = ImageIO.read(new File("Smile2.png"));
    } catch (IOException e) {
    	e.printStackTrace();
    }

    
  }
  
  public Image getImage() {
	  return img;
  }
  
  

  /*public void move() {
    xPos += 40;
    yPos += 40;
  }*/

  public void moveLeft(){
    xPos -= 40;
    if (xPos < 0) {
    	xPos = 0;
    }
    
  }
  public void moveRight() {
    xPos += 40;
    if (xPos >= width) {
    	xPos = width - img.getWidth();
    }
  }
  public void moveDown() {
    yPos += 40;
    if (yPos >= height) {
    	yPos = height - img.getHeight();
    }
  }

  public void moveUp(){
    yPos -= 40;
    if (yPos < 0) {
    	yPos = 0;
    }
  }
  
  public int getXPos(){
    return xPos;
  }

  public int getYPos() {
    return yPos;
  }
  
  public void setYPos(int y) {
	    yPos = y;
  }

  public void setXPos(int x) {
	    xPos = x;
  }
  
  
  
  
}
