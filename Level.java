package game;

public class Level{
	  private int name;
	  private boolean[] switches;
	  //private int[][] map;
	  private Board board;
	  
	  public Level(int n) {
	    int[][] map = new int[15][15];
	    for (int r = 0; r < map.length; r++) {
	      for (int c = 0; c < map[r].length; c++) {
	        if (r == 0 || c == 0 || c == 14 || r == 14) {
	          map[r][c] = 1;
	        } else {
	          map[r][c] = 0;
	        }
	      }
	    }
	    if (n == 1) {
	      map[6][14] = 3;
	      
	    }
	    this.name = n;
	    this.switches = new boolean[2];
	    this.switches[0] = true;
	    this.switches[1]= true;
	    this.board = new Board(map);
	  }
	  
	  public Board getBoard() {
	    return board;
	  }

	}
