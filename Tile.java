package game;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
  private boolean canCollide;
  private boolean canInteract;
  public static final int SIZE = 40; 
  private BufferedImage img;
  private int type;
  
  private boolean isOn;
  //floor = 0, wall = 1, water = 2, door = 3, switch = 4

  public Tile(int t) {
      String fileName = "";
      this.type = t;
	    if (this.type == 0) {
	      this.canCollide = false;
	      this.canInteract = false; 
	      fileName = "Floor.png";
	      
	    } else if (this.type == 1) {
	    	
	      this.canCollide = true;
	      this.canInteract = false;
	      fileName = "Wall.png";
	      
	    } else if (this.type == 2) {
	    	
	      this.canCollide = true;
	      this.canInteract = false;
	      fileName = "Water.png";
	      
	    } else if (this.type == 3) {
	    	
	      this.canCollide = true;
	      this.canInteract = true;
	      fileName = "Door.png";
	      
	    } else if (this.type == 4) {
	    	
	      this.canCollide = false;
	      this.canInteract = false;
	      this.isOn = false;
	      fileName = "Switch.png";
	      
	    } else if (this.type == 5) {
	    	this.canCollide = false;
	    	this.canInteract = false;
	    	fileName = "OpenDoor";
	    } else {
	      this.canCollide = false;
	      this.canInteract = false;
	      fileName = "Smile.png";
	      
	    }
	    try {
	    	  img = ImageIO.read(new File(fileName));
	      } catch (IOException e) {
	      	e.printStackTrace();
	      }
	    this.type = t; 
      this.isOn = false;
	    //floor = 0, wall = 1, water = 2, door = 3, switch = 4
	    //SIZE = 40; // Same for all tiles.
  }
  public boolean getIsOn() {
    return isOn;
  }
  public void turnOn() {
    this.isOn = true;
  }
  public void turnOff() {
    this.isOn = false;
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
  }
  
  public boolean getOn() {
	  return this.isOn;
  }

  public void setCollision(boolean a){
    this.canCollide = a;
  }
  
  public boolean getinteraction(){
    return canInteract;
  }
  public void setInteraction(boolean a){
    this.canInteract = a;
  }
}
