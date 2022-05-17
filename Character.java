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
    xPos = 0;
    yPos = 0;

    
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
  
  public void move() {
    xPos += 40;
    yPos += 40;
  }

  public void moveLeft(){
    xPos -= 40;
  }
  
  public void moveRight() {
    xPos += 40;
  }
  
  public void moveDown() {
    yPos += 40;
  }

  public void moveUp(){
    yPos -= 40;
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