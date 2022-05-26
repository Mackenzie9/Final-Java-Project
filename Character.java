package game;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.Arrays;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.Arrays;


public class Character {

  int xPos;
  int yPos;
  
  BufferedImage img;
  BufferedImage left;
  BufferedImage right;

  
  public Character() {
    xPos = 280;
    yPos = 280;

  }

  

  
  public Character(String fileNameR, String fileNameL) {
    xPos = 280;
    yPos = 280;

    try {
  	  left = ImageIO.read(new File(fileNameL));
  	  right = ImageIO.read(new File(fileNameR));
    } catch (IOException e) {
    	e.printStackTrace();
    }
    
    img = right;
  }
  
  public Image getImage() {
	  return img;
  }

  public void moveLeft(){
    xPos -= 40;
    
    if(Panel.mainBoard.getTile(yPos/40, xPos/40).getCollision()) {
    	xPos += 40;
    }
    callMethods();
    img = left;
  }
  
  public void moveRight() {
    xPos += 40;
    
    if(Panel.mainBoard.getTile(yPos/40, xPos/40).getCollision()) {
    	xPos -= 40;
    }

    System.out.println(getBoardPos());
    callMethods();
    img = right;
  }
  
  public void moveDown() {
    yPos += 40;
    
    if(Panel.mainBoard.getTile(yPos/40, xPos/40).getCollision()) {
    	yPos -= 40;
    }
    callMethods();
  }
  
  public void moveUp(){
    yPos -= 40;
    
    if(Panel.mainBoard.getTile(yPos/40, xPos/40).getCollision()) {
    	yPos += 40;
    }
    callMethods();
  }

  /**
  * callMethods calls all the methods and checks that need to be called when the character moves.
* for example, checkDoor is called in this method.
  */
  public void callMethods() {
	 Panel.getLevel().checkOrder(xPos,yPos);
	 checkNextLevel();
	 checkDoor();
    if (Panel.getLevelNum() == Panel.getLastLevel() && (xPos / 40 == 7 && yPos / 40 == 7) && Panel.mainBoard.getTile(7, 7).getType() == 5) {
		 System.out.println("nice");
		 Panel.winner();
	  }
  }
  
  public void checkNextLevel() {
	  if (xPos/40 == 14 && yPos/40 == 7) {
		  Panel.setLevelNum(Panel.getLevelNum() + 1);
		  xPos = 40;
		  yPos = 280;
				  
	  }
    if (xPos/40 == 0 && yPos/40 == 7) {
		  Panel.setLevelNum(Panel.getLevelNum() - 1);
		  xPos = 520;
		  yPos = 280;
				  
	  }
  }

  /** checks the status of the doors. If a door SHOULD be open, but is closed, it opens that door.
  */
  public void checkDoor(){
      if (Panel.getLevel().checkSwitchesOn()) {
    	  Panel.mainBoard.getTile(7, 14).setImg("OpenDoor.png");

        //if on right side, level up. else go down a level. 
    	  Panel.mainBoard.getTile(7, 14).setOpen(true);
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

    public void openChest() {
	  if (Panel.getLevelNum() == Panel.getLastLevel() && (xPos / 40 == 12 && yPos / 40 == 7)) {
			 //System.out.println("It works");
		  Panel.mainBoard.getTile(7, 13).setImg("OpenChest.png");
      Panel.mainBoard.getTile(7, 7).makeDoor();

      }
	  //System.out.println("used space");
  }
  
}
