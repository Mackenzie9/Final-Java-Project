package game;
public class Board {
	  private Tile[][] tiles;
	  
	  
	  public Board() {
	    this.tiles = new Tile[15][15];
	    for (int r = 0; r < tiles.length; r++) {
	      for (int c = 0; c < tiles[r].length; c++) {
	        if (r == 0 || c == 0 || c == 14 || r == 14) {
	          tiles[r][c] = new Tile(1);
	        } else {
	          tiles[r][c] = new Tile(0);
	        }
	      }
	    }
	    tiles[6][14] = new Tile(3);
	  }

	  public Board(int[][] arr) {    // for custom board
		  this.tiles = new Tile[15][15];
		  for (int r = 0; r < tiles.length; r++) {
			  for (int c = 0; c < tiles[0].length; c++) {
				  tiles[r][c] = new Tile(arr[r][c]);
			  }
		  }
	  }


	  public int numberOpen() {
		  int count = 0; 
		  for (int r = 0; r < tiles.length; r++) {
		    for (int c = 0; c < tiles[r].length; c++) {
		      if (tiles[r][c].getCollision()) {
		        count++;
	        }
	      }
	    }
	    return count;
	  }

	  public Tile getTile(int r, int c) {
	    return this.tiles[r][c];
	  }
	    
	}
