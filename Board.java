package game;

public class Board {
	private Tile[][] tiles;
	  public Board() {
	    this.tiles = new Tile[2][2];
	  }
	  public int numberOpen() {
	    int count = 0; 
	    for (int r = 0; r < tiles.length; r++) {
	      for (int c = 0; c < tiles[r].length; c++) {
	        if (tiles[r][c].getAvailability()) {
	          count++;
	        }
	      }
	    }
	    return count;
	  }
}
