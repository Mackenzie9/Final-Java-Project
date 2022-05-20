package game;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;


public class Character {

  int xPos;
  int yPos;
  
  BufferedImage img;

  
  public Character() {
    xPos = 280;
    yPos = 280;

    
    try {
  	  img = ImageIO.read(new File("Smile.png"));
    } catch (IOException e) {
    	e.printStackTrace();
    }

    
  }

  
  public Character(String fileName) {
    xPos = 0;
    yPos = 0;

    try {
  	  img = ImageIO.read(new File(fileName));
    } catch (IOException e) {
    	e.printStackTrace();
    }
  }

  
  public Image getImage() {
	  return img;
  }

    public void moveLeft(){
    xPos -= 40;
    checkDoor();
    if(Panel.mainBoard.getTile(yPos/40, xPos/40).getCollision()) {
    	xPos += 40;
    }
    Panel.getLevel().checkOrder(xPos,yPos);
    
  }
  
  public void moveRight() {
    xPos += 40;
    checkDoor();
    if(Panel.mainBoard.getTile(yPos/40, xPos/40).getCollision()) {
    	xPos -= 40;
    }
    Panel.getLevel().checkOrder(xPos,yPos);
    
  }
  
  public void moveDown() {
    yPos += 40;
    checkDoor();
    if(Panel.mainBoard.getTile(yPos/40, xPos/40).getCollision()) {
    	yPos -= 40;
    }
    Panel.getLevel().checkOrder(xPos,yPos);
    
    
  }

  public void moveUp(){
    yPos -= 40;
    checkDoor();
    if(Panel.mainBoard.getTile(yPos/40, xPos/40).getCollision()) {
    	yPos += 40;
    }

    Panel.getLevel().checkOrder(xPos,yPos);
    
  }

  public void checkSwitch() {
    if (Panel.mainBoard.getTile(yPos/40, xPos/40).getType() == 4 && !Panel.mainBoard.getTile(yPos/40, xPos/40).getOn()) {
      Panel.mainBoard.getTile(yPos/40, xPos/40).turnOn();
      System.out.println(true);
      Panel.mainBoard.getTile(yPos/40, xPos/40).setImg("SwitchOn.png");
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

  /** returns an array with values for accesing a 2d array:
    index 0: the row #
    index 1: the col #
  */
  public int[] getBoardPos() {
    int[] result = new int[2];
    
    result[0] = this.yPos /40;
    result[1] = this.xPos /40;
    
    return result;
  }

  
  
}
