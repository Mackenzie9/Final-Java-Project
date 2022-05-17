package game;

public class Tile {
	  private boolean collidable;
	  private boolean canInteract;
	  private static int SIZE; 

	  public Tile(){
	    collidable = true;
	    canInteract = true;
	    SIZE = 40; // Same for all tiles.
	  }

	  public static int getSize(){
	    return SIZE; 
	  }
	  public boolean getAvailability(){
	    return collidable;
	  }

	  public void setAvailability(boolean a){
	    collidable = a;
	  }
	  public boolean getInteraction(){
	    return canInteract;
	  }
	  public void setInteraction(boolean a){
	    canInteract = a;
	  }
}
