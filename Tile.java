package game;

public class Tile {
	private boolean isAvailable;
	  private boolean caninteract;
	  private static int SIZE; 

	  public Tile(){
	    isAvailable = true;
	    caninteract = true;
	    SIZE = 40; // Same for all tiles.
	  }

	  public int getSize(){
	    return SIZE; 
	  }
	  public boolean getAvailability(){
	    return isAvailable;
	  }

	  public void setAvailability(boolean a){
	    isAvailable = a;
	  }
	  public boolean getinteraction(){
	    return caninteract;
	  }
	  public void setInteraction(boolean a){
	    caninteract = a;
	  }
}
