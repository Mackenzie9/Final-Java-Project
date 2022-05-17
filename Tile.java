package game;

public class Tile {
  private boolean canCollide;
  private boolean canInteract;
  public static final int SIZE = 40; 
  private BufferedImage img;
  private int type;
  //floor = 0, wall = 1, water = 2, door = 3, switch = 4

  public Tile(int t) {
      String fileName = "Smile.java";
	    if (t == 0) {
	      this.canCollide = false;
	      this.canInteract = false; 
	      
	    } else if (this.type == 1) {
	      this.canCollide = true;
	      this.canInteract = false;
	    } else if (this.type == 2) {
	      this.canCollide = true;
	      this.canInteract = false;
	    } else if (this.type == 3) {
	      this.canCollide = true;
	      this.canInteract = true;
	    } else if (this.type == 4) {
	      this.canCollide = true;
	      this.canInteract = false;
	    } else {
	      this.canCollide = false;
	      this.canInteract = false;
	    }
	    try {
	    	  img = ImageIO.read(new File(fileName));
	      } catch (IOException e) {
	      	e.printStackTrace();
	      }
	    this.type = t; 
	    //floor = 0, wall = 1, water = 2, door = 3, switch = 4
	    //SIZE = 40; // Same for all tiles.
  }
  
  public int getSize(){
    return SIZE; 
  }
  public boolean getCollision(){
    return canCollide;
  }

  public void setType(int t) {
    this.type = t;
  }

  public int getType() {
    return type;
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
