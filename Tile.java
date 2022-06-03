package game;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
  private boolean canCollide; // if you can collide, and thus not able to move to it
  public static final int SIZE = 40; // the tile is 40 * 40 pixels wide
  private BufferedImage img; // the current image to be displayed of the tile
  private boolean isOpen; // used for doors and chests

  private int type;
  //floor = 0, wall = 1, water = 2, door = 3, switch = 4
  
  private boolean isOn; // used for switches
  

  public Tile(int t) {
    String fileName = "";
    this.type = t;
  
    if (this.type == 0) {
      this.canCollide = false;
	    fileName = "Floor.png";
	      
	  } else if (this.type == 1) {
	    this.canCollide = true;
      fileName = "Wall.png";
	      
	  } else if (this.type == 2) {
	    this.canCollide = true;
      fileName = "Water.png";
      
	  } else if (this.type == 3) {
	    this.canCollide = true;
      fileName = "Door.png";
      
	  } else if (this.type == 4) {
	    this.canCollide = false;
      this.isOn = false;
	    fileName = "Switch.png";
	      
	  } else if (this.type == 5) {
	  	this.canCollide = false;
	    	
    	fileName = "OpenDoor.png";
	    
    } else if (this.type == 7) {
	    this.canCollide = true;
	    	
	  	fileName = "Chest.png";
	  } else if (this.type == 8) {
    	this.canCollide = true;
	    	
      fileName = "OpenChest.png"; 
    } else {
	    this.canCollide = false;
      fileName = "Smile.png";
	      
	  }
	    
    try {
	    img = ImageIO.read(new File(fileName));
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
    
    this.type = t; 
    this.isOpen = false;
    this.isOn = false;
    //floor = 0, wall = 1, water = 2, door = 3, switch = 4
	  //SIZE = 40; // Same for all tiles.
  }
  
  public boolean getIsOn() {
    return isOn;
  }
  
  public void makeDoor() {
	  this.type = 5;
	  this.canCollide = false;
  	  
  	String fileName = "OpenDoor.png";
    try {
	    img = ImageIO.read(new File(fileName));
    } catch (IOException e) {
  	  e.printStackTrace();
    }
  }
  
  public int getSize(){
    return SIZE; 
  }
  
  public boolean getCollision(){
    return canCollide;
  }

  public void setImg(String fileName) {
	  try {
    	img = ImageIO.read(new File(fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public boolean getOpen() {
	  return isOpen;
  }
  
  public void setOpen(boolean o) {
	  isOpen = o;
	  
	  if (o) {
		  this.setCollision(false);
		  this.setImg("OpenDoor.png");
	  } else {
		  this.setCollision(true);
		  this.setImg("Door.png");
	  }
    
  }
  
  
  

  public BufferedImage getImg() {
	  return img;
  }
  
  public void setType(int t) {
    this.type = t;
  }

  public int getType() {
    return type;
  }
  
  public void setOn(boolean o) {
	  this.isOn = o;
    if (o) {
		  try {
	    	  img = ImageIO.read(new File("SwitchOn.png"));
	      } catch (IOException e) {
	      	e.printStackTrace();
	      }
	  } else {
		  try {
	    	  img = ImageIO.read(new File("Switch.png"));
	      } catch (IOException e) {
	      	e.printStackTrace();
	      }
	  }
  }
  
  public boolean getOn() {
	  return this.isOn;
  }

  public void setCollision(boolean a){
    this.canCollide = a;
  }
  
}
