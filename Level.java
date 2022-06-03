package game;
import java.util.Arrays;

public class Level{
  
  private int[] switchesRow;
  private int[] switchesCol;
  //private int[][] map;
  private Board board;
    private int number;

  private Spike[] spikes;
  
  
  public Level(int n) {
    number = n;
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
				path[7][c] = true;
			}
      

      
			//for (int i = 0; i < 15; i++) {
			//	System.out.println(Arrays.toString(path[i]));
			//}
			
			int[] startPos = {1,7};
			Spike sp = new Spike(path, startPos);
			spikes = new Spike[1];
			spikes[0] = sp;
      
      
      this.switchesRow = new int[1]; // stores the locations of four switches
	    this.switchesCol = new int[1];
      
	  } else if (n==1) { 
		  //creates a path for the spike
		  	boolean[][] pathA = new boolean[15][15];
			for (int c = 1; c < 14; c++) {
				pathA[5][c] = true;
			}
			boolean[][] pathB = new boolean[15][15];
			for (int c = 3; c < 12; c++) {
				pathB[3][c] = true;
				
			}
			for (int r = 3; r < 14; r++) {
				pathB[r][3] = true;
				pathB[r][11] = true;
			}
			
			//for (int i = 0; i < 15; i++) {
			//	System.out.println(Arrays.toString(pathB[i]));
			//}
			//creates the spike
			int[] startPosA = {1,5};
			Spike spA = new Spike(pathA, startPosA);
			spikes = new Spike[2];
			spikes[0] = spA;
			int[] startPosB = {3,13};
			Spike spB = new Spike(pathB, startPosB);
			spikes[1] = spB;
      //creates the layout of the second level
	    for (int c = 0; c < map[0].length; c++) {    
		    map[14][c] = 2;
  	  }
	    
      for (int r = 6; r < map.length-1; r++) {
	    		map [r][7] = 1; 
	    	}
	  this.switchesRow = new int[4];
	  this.switchesCol = new int[4];
	  } else if (n==2) {
		  boolean[][] pathA = new boolean[15][15];
		  for (int r = 1; r < 14; r++) {
				for (int c = 1; c < 14; c++) {
					if (r== 6 && (c > 3 && c < 11)) {
						pathA[r][c] = true;
					}
					if ((r > 6  && r < 10) && (c == 4 || c == 10)) {
						pathA[r][c] = true;
					}
					if (r == 9 && c > 2 && c < 13 && (c < 5 || c > 9) ) {
						pathA[r][c] = true;
					}
					if ((c == 2 || c == 12) && (r >= 9 && r < 13)) {
						pathA[r][c] = true;
					}
					if (r == 12 && (c > 2 && c < 13)) {
						pathA[r][c] = true;
					}
				
				}
			}
			boolean[][] pathB = new boolean[15][15];
			for (int c = 2; c < 7; c++) {
				pathB[3][c] = true;
				pathB[5][c] = true;
			}
			pathB[4][2] = true;
			pathB[4][6] = true;
			for (int r = 3; r < 14; r++) {
				pathB[r][3] = true;
				pathB[r][11] = true;
			}
			boolean[][] pathC = new boolean[15][15];
			for (int r = 1; r < 14; r++) {
				for (int c = 1; c < 14; c++) {
					if ((r == 1 || r == 13) && (c < 4 || c > 9)) {
						pathC[r][c] = true;
					}
					
					if ((c == 3 || c == 10) && (r > 1 && r < 4)) {
						pathC[r][c] = true;
					}
					if ((c == 3 || c == 10) && (r > 11 && r < 14)) {
						pathC[r][c] = true;
					}
					if (c >= 3 && c <= 10 && (r == 3 || r == 11)) {
						pathC[r][c] = true;
					}
					if (c == 1 || c == 13) {
						pathC[r][c] = true;
					}
				
				}
			}
			
			
			/*for (int i = 0; i < 15; i++) {
				System.out.println(Arrays.toString(pathA[i]));
			}
			*/
			//creates the spike
			int[] startPosA = {4,6};
			Spike spA = new Spike(pathA, startPosA);
			spikes = new Spike[3];
			spikes[0] = spA;
			int[] startPosB = {2,3};
			Spike spB = new Spike(pathB, startPosB);
			spikes[1] = spB;
			int[] startPosC = {1,1};
			Spike spC = new Spike(pathC, startPosC);
			spikes[2] = spC;

      //creates the layout of the third level
	    for (int r = 0; r < map.length; r++) {
	  		for (int c = 0; c < map[r].length; c++) {
	  			if ((r==4 || r==10) && ((c >2 && c<6)||(c>8 && c<12))||(r==7 && (c>4 && c<10))){
    				map[r][c] = 1;
	    		}
	    	}
	  	}
	    this.switchesRow = new int[3];
		  this.switchesCol = new int[3];
	  } else if(n == 3) {
		  boolean[][] path = new boolean[15][15];
		  int add1 = 2;
		  int add2 = 3;
		  int add3 = 0;
		  int add4 = 5;
		  for (int row = 1; row < 14; row++) {
		    	for (int c = 1; c < 14; c++) {
		    		map[row][c] = 2;
		    		if (row == 7) {
		    			map[row][c] = 0;
		    		}
		    		if (row > 7 && c < 7 && c +  add1 == row) {
		    			path[row][c] = true;//makes a diagonal line
		    			add1 +=2;
		    			map[row][c] = 0;
		    		}
		    		if (row > 7 && c < 7 && c +  add2 == row) {
		    			path[row][c] = true;//makes a diagonal line right next to the other one.
		    			add2 +=2;
		    			map[row][c] = 0;
		    		}
		    		if (row == 13 && c < 10) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		if (row < 13 && row > 10 && c < 10 && c > 6) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		if (row == 11 && c > 9 && c < 13) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		if (c == 12 && row < 11 && row > 7) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		if ((c == 5) && row < 7 && row > 3) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		if (row ==4 && (c < 5 && c > 1)) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		if (row < 4 && row > 2 && c == 2) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		if (row > 0 && row < 4 && c < 3 && c > 0 && add3 + c ==row) {
		    			add3 +=2;
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		if (row > 0 && row < 3 && c == 1) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		
		    		if (row == 1 && c >= 1 && c < 8) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    		}
		    		
		    		if (c >= 7 && row > 0 && c - 5 == row && row < 7 ) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    			
		    		}
		    		if (c >= 7 && row > 0 && c - 4 == row && row < 7 ) {
		    			path[row][c] = true;
		    			map[row][c] = 0;
		    			
		    		}
		    		
		    		

		    	}
		  }
        map[2][8] = 0;
		    path[12][1] = false;
  		  path[13][1] = false;
		    int[] startPos = {1,1};
		    Spike sp = new Spike(path, startPos);
		    spikes = new Spike[2];
		    spikes[0] = sp;
		    int[] startPos2 = {1,12};
		    Spike sp2 = new Spike(path, startPos2);
		    spikes[1] = sp2;
		    this.switchesRow = new int[3];
		    this.switchesCol = new int[3];
	  } else {
      map[7][14] = 1;
      map[7][13] = 7;
	    this.switchesRow = new int[0];
	    this.switchesCol = new int[0];
	  }
    
    for (int i = 0; i < switchesRow.length; i++) {
	    int rowR = (int)(Math.random() * 13 + 1);
	    int colR = (int)(Math.random() * 13 + 1);
	    boolean worksForOtherSwitches = true;
      
      while(((rowR == switchesRow[i] && colR == switchesCol[i]) || 
             map[rowR][colR] != 0) || 
            !worksForOtherSwitches) {
        
	      worksForOtherSwitches = true;
	      rowR = (int)(Math.random() * 13 + 1);
	      colR = (int)(Math.random() * 13 + 1);
	    }
      
	    for (int j = 0; j < i; j++) {
	      while (((rowR == switchesRow[j] && colR == switchesCol[j]) ||
                map[rowR][colR] != 0) || 
               !worksForOtherSwitches) {
          
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
    
	  
    this.board = new Board(map);
    
    if(n != 0) {
    	board.getTile(7, 0).setOpen(true);
    }
  }


  /**
  * @param x of the switch/player
  * @param y of the switch/player
  * @param isPlayer if the character on the switch is a player. If not, it wont trigger the switch
  * @return true if previous switches are all on
  */
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


  /**
  * @return true if switches exist in the level AND they are ALL ON
  */
  public boolean checkSwitchesOn() {
		for (int i = 0; i < switchesRow.length; i++) {
			if (!board.getTile(switchesRow[i], switchesCol[i]).getIsOn()) {
				return false;
			}
		}
		if (this.switchesCol.length > 0) {
			return true;
		}
		return false;
	}

  /** 
  * @return the column positions of the switches in the current level
  */
  public int[] getSwitchesCol() {
    return switchesCol;
  }
  /**
  * @return the row positions of the switches in the current level
  */
  public int[] getSwitchesRow() {
    return switchesRow;
  }

  /**
  * @return the current board
  */
  public Board getBoard() {
    return board;
  }

  /**
  * @return the spikes of the current level
  */
  public Spike[] getSpikes() {
		return spikes;
	}

  public int getNumber() {
	  return number;
  }

}
