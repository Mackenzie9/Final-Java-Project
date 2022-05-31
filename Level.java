package game;
import java.util.Arrays;

public class Level{
  private int name;
  private int[] switchesRow;
  private int[] switchesCol;
  //private int[][] map;
  private Board board;

  private Spike[] spikes;
  
  
  public Level(int n) {
    int[][] map = new int[15][15];
    this.spikes = new Spike[0];
    
	  for (int r = 0; r < map.length; r++) { // default layout
      for (int c = 0; c < map[r].length; c++) {
	      if (r == 0 || c == 0 || c == 14 || r == 14) {
	        map[r][c] = 1;
        } else {
	        map[r][c] = 0;
        }
	    }
	  }
    map [7][0] = 3;
    map [7][14] = 3;
	    
    
    if (n == 0) {  // create the layout for the first level
      map[7][0] = 1; // location of the door
      
      boolean[][] path = new boolean[15][15];
			for (int c = 1; c < 14; c++) {
				path[1][c] = true;
			}

      
			//for (int i = 0; i < 15; i++) {
			//	System.out.println(Arrays.toString(path[i]));
			//}
			
			int[] startPos = {1,1};
			Spike sp = new Spike(path, startPos);
			spikes = new Spike[1];
			spikes[0] = sp;
      
      
		this.switchesRow = new int[2]; // stores the locations of four switches
	    this.switchesCol = new int[2];
      
	  } else if (n==1) { 
      //creates the layout of the second level
	    for (int c = 0; c < map[0].length; c++) {    
		    map[14][c] = 2;
  	  }  
      for (int r = 6; r < map.length-1; r++) {
	    		map [r][7] = 1; 
	    	}
	    	this.switchesRow = new int[2];
		    this.switchesCol = new int[2];
	  } else if (n==2) {
      //creates the layout of the third level
	    for (int r = 0; r < map.length; r++) {
	  		for (int c = 0; c < map[r].length; c++) {
	  			if ((r==4 || r==10) && ((c >2 && c<6)||(c>8 && c<12))||(r==7 && (c>4 && c<10))){
    				map[r][c] = 1;
	    		}
	    	}
	  	}
	    this.switchesRow = new int[2];
		  this.switchesCol = new int[2];
	  }else {
      map[7][14] = 1;
      map[7][13] = 7;
	    this.switchesRow = new int[0];
	    this.switchesCol = new int[0];
	  }
     for (int i = 0; i < switchesRow.length; i++) {
	        int rowR = (int)(Math.random() * 13 + 1);
	        int colR = (int)(Math.random() * 13 + 1);
	        boolean worksForOtherSwitches = true;
          while(((rowR == switchesRow[i] && colR == switchesCol[i]) || map[rowR][colR] != 0) || !worksForOtherSwitches) {
	            worksForOtherSwitches = true;
	        	rowR = (int)(Math.random() * 13 + 1);
	            colR = (int)(Math.random() * 13 + 1);
	            
	          }
	        for (int j = 0; j < i; j++) {
	          while(((rowR == switchesRow[j] && colR == switchesCol[j]) || map[rowR][colR] != 0) || !worksForOtherSwitches) {
	            worksForOtherSwitches = true;
	        	rowR = (int)(Math.random() * 13 + 1);
	            colR = (int)(Math.random() * 13 + 1);
	            for (int num = 0; num < j; num ++) {
	            	if (rowR == switchesRow[num] && colR == switchesCol[num]) {
	            		worksForOtherSwitches = false;
	            	}
	            }
	          }
	        }
	        this.switchesRow[i] = rowR;
	        map[rowR][colR] = 4;
	        this.switchesCol[i] = colR;
	      }
    this.name = n;
    
	  
    this.board = new Board(map);
    
    if(n != 0) {
    	board.getTile(7, 0).setOpen(true);
    }
  }

  public boolean checkOrder(int x, int y) {
	  //System.out.println("First is: " + switchesRow[0] + " " + switchesCol[0]);
	  int c = x / 40;
    int r = y / 40;
	  int place = -1;
	  for (int pos = 0; pos < switchesRow.length; pos++) {
	    if (switchesRow[pos] == r && switchesCol[pos] == c) {
	      place = pos;
	    }
    }
	  //
    //System.out.println("Place = " + place);
	  for (int i = 0; i <= place; i++) {
	    if (i != place && !board.getTile(switchesRow[i],switchesCol[i]).getIsOn()) {
	      for (int j = 0; j < place; j++) {
	        board.getTile(switchesRow[j],switchesCol[j]).setOn(false);
	        //System.out.println("Tile is on if true (shouldn't be on) " + board.getTile(switchesRow[j],switchesCol[j]).getIsOn());
	      }
        board.getTile(switchesRow[place],switchesCol[place]).setOn(false);
	      i = place + 1;
      } else {
	      board.getTile(r,c).setOn(true);
	      // System.out.println("Should print true: " + board.getTile(r,c).getIsOn());
	    }
	  }
    for (int p = 0; p < switchesRow.length; p++) {
	  	if (!board.getTile(switchesRow[p],switchesCol[p]).getIsOn()) {
    		//System.out.print("returned false ");
        return false;
	    }
	  }
	  //System.out.print("returned true ");
	return true;
  }


  public boolean checkSwitchesOn() {
		for (int i = 0; i < switchesRow.length; i++) {
			if (!board.getTile(switchesRow[i], switchesCol[i]).getIsOn()) {
				return false;
			}
		}
		if(this.switchesCol.length > 0) {
			return true;
		}
		return false;
	}

  public int[] getSwitchesCol() {
    return switchesCol;
  }
  public int[] getSwitchesRow() {
    return switchesRow;
  }
	  
  public Board getBoard() {
    return board;
  }

  public Spike[] getSpikes() {
		return spikes;
	}
}
