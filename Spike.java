package game;

import javax.swing.*; //for Timer
import java.awt.event.*; //for ActionEvent

public class Spike extends Character implements ActionListener {

	/*
	 * 15 x 15 array that holds the path the spike will follow 
   *  - The path CANNOT loop back on itself, or it can, but it might behave a bit weird. 
   *  - The spike can only make 90 degree turns 
   *  - The path marked is 1 tile wide
	 * 
	 * Places marked true are where the spike moves.
	 */
	private boolean[][] path;
	private Timer stepTimer;

	private int direction; // 0 = up, 1 = right, 2 = down, 3 = left

	
	public Spike() {
		super("Spike.png", 280, 280);
		
		this.path = new boolean[15][15];
		
		this.direction = -1;
		direction = findNextDirection();
		
    // 1000 milliseconds from creation before it starts firing
    // this object will react to the timer firing
    this.stepTimer = new Timer(1000, this);
    stepTimer.setActionCommand("step");
		stepTimer.start();
    
	}
	
	
	/**
	 * 
	 * @param p
	 * @param startPos, the first index is the col #, the second is the row #
	 */
	public Spike(boolean[][] p, int[] startPos) {
		super("Spike.png", startPos[0] * 40, startPos[1] * 40);

		this.path = p;

		this.direction = -1;
		direction = findNextDirection();

    // 1000 milliseconds from creation before it starts firing
		// this object will react when the timer fires
		this.stepTimer = new Timer(1000, this);
    stepTimer.setActionCommand("step");
		stepTimer.start();
    
	}

	public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("step")) {
      direction = findNextDirection();
		  if (direction == 0) {
			  moveUp();
		  } else if (direction == 1) {
			  moveRight();
  		} else if (direction == 2) {
	  		moveDown();
		  } else if (direction == 3) {
			  moveLeft();
      }
    }

    if (e.getActionCommand().equals("death")) {
      //unused
			// this will be listening to a 
    }
    
    
	}

	public int findNextDirection() {
		int[] currPos = getBoardPos(); // [x,y]
		int d1 = direction; // checks clockwise
    int d2 = direction; // checks anticlockwise
    // 0 = up, 1 = right, 2 = down, 3 = left
    
		for (int i = 0; i < 4; i++) {
			
      if (d1 == -1) { // correcting the value so it checks all four directions
        d1++; 
      }
      if (d2 == -1) {
        d2 = 3;
      }
      d1 %= 4; // to limit this value to 0 - 3 inclusive
      
      
			if (d1 == 0) { // checking the clockwise way
				int[] nextPos = {currPos[0], currPos[1]-1}; // [x,y+1]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way up");
          return d1;
				}
			} else if (d1 == 1) {
				int[] nextPos = {currPos[0]+1, currPos[1]}; // [x+1,y]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way right");
          return d1;
				}
			} else if (d1 == 2) {
				int[] nextPos = {currPos[0], currPos[1]+1}; // [x,y-1]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way down");
          return d1;
				}
			} else if (d1 == 3) {
				int[] nextPos = {currPos[0]-1, currPos[1]}; // [x-1,y]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way left");
          return d1;
				}
			}


      if (d2 == 0) { // checking the anticlockwise way
				int[] nextPos = {currPos[0], currPos[1]-1}; // [x,y+1]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way up");
          return d2;
				}
			} else if (d2 == 1) {
				int[] nextPos = {currPos[0]+1, currPos[1]}; // [x+1,y]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way right");
          return d2;
				}
			} else if (d2 == 2) {
				int[] nextPos = {currPos[0], currPos[1]+1}; // [x,y-1]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way down");
          return d2;
				}
			} else if (d2 == 3) {
				int[] nextPos = {currPos[0]-1, currPos[1]}; // [x-1,y]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way left");
          return d2;
				}
			}

			d1++;
      d2--;
		}
		//System.out.println("failed to find path...");
		return -1;
	}
	
	

  /** 
  * @param pos The position to look at. pos[0] is col value (x), pos[1] is a row value (y)
  *
  * @return The path status (is part of a path or not) for that particlar position
  */
	public boolean getPathBoolean(int[] pos) {
		return path[pos[1]][pos[0]];
	}
  

	
	
	/**
	 * @return the stepTimer
	 */
	public Timer getStepTimer() {
		return stepTimer;
	}

	/**
	 * @param stepTimer the stepTimer to set
	 */
	public void setStepTimer(Timer stepTimer) {
		this.stepTimer = stepTimer;
	}

  /** An override for a super method to prevent the spike triggering switches
  */
  public void callMethods() {
		
	  checkDoor();
	  
	}

	
	//unused
  public void touched(Character c) {
    Timer wait = new Timer(1500, this);
    wait.setActionCommand("death");
    wait.setRepeats(false);
    wait.start();
  }
  
}
