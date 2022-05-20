package game;
public class Level{
  private int name;
  private int[] switchesRow;
  private int[] switchesCol;
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
    
    if (n == 0) {
      map[7][14] = 3;
      //map[7][10] = 4;
      //map[4][3] = 4;

      this.switchesRow = new int[2];
      this.switchesCol = new int[2];
      
    } else if (n == 1){
      map[0][7] = 3;
      this.switchesRow = new int[2];
      this.switchesCol = new int[2];
    } else {
      this.switchesRow = new int[1];
      this.switchesCol = new int[1];
    }
    for (int i = 0; i < switchesRow.length; i++) {
        int rowR = (int)(Math.random() * 13 + 1);
        int colR = (int)(Math.random() * 13 + 1);
        for (int j = 0; j < i; j++) {
          while(rowR == switchesRow[j] && colR == switchesCol[j]) {
            rowR = (int)(Math.random() * 13 + 1);
            colR = (int)(Math.random() * 13 + 1);
          }
        }
        this.switchesRow[i] = rowR;
        map[rowR][colR] = 4;
        this.switchesCol[i] = colR;
      }
    this.name = n;
    
	  
    this.board = new Board(map);
  }

  public void checkOrder(int x, int y) {
	    //System.out.println("First is: " + switchesRow[0] + " " + switchesCol[0]);
	    int c = x / 40;
	    int r = y / 40;
	    int place = -1;
	    for (int pos = 0; pos < switchesRow.length; pos++) {
	      if (switchesRow[pos] == r && switchesCol[pos] == c) {
	        place = pos;
	      }
	    }
	    System.out.println("Place = " + place);
	    for (int i = 0; i <= place; i++) {
	      if (i != place && !board.getTile(switchesRow[i],switchesCol[i]).getIsOn()) {
	        for (int j = 0; j < place; j++) {
	          board.getTile(switchesRow[j],switchesCol[j]).setOn(false);
	          //System.out.println("Tile is on if true (shouldn't be on) " + board.getTile(switchesRow[j],switchesCol[j]).getIsOn());
	        }
	        i = place + 1;
	      } else {
	        board.getTile(r,c).setOn(true);
	       // System.out.println("Should print true: " + board.getTile(r,c).getIsOn());
	      }
	    }
	  }
	  
	  public Board getBoard() {
	    return board;
	  }

	}
