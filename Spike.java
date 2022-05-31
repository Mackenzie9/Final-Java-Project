package game;

import javax.swing.*; //for Timer
import java.awt.event.*; //for ActionEvent

public class Spike extends Character implements ActionListener {

	/*
	 * 15 x 15 array that holds the path the spike will follow 
      - The path CANNOT loop back on itself, or it can, but it might behave a bit weird. 
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
		this.stepTimer = new Timer(1000, this);
		stepTimer.start();
    
    //this.path = p;
		/*for (int i = 0; i < 15; i++) {
			System.out.println("In Spike in the constructor" + Arrays.toString(this.path[i]));
		}*/

		// 1000 milliseconds from creation before it starts firing
		//
    /*
		int[] currPos = getBoardPos();
		this.direction = -1;
		int[] nextPos = {currPos[0], currPos[1]-1}; // [x,y+1]
		if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("go right");
			this.direction = 0;
		}
		int[] nextPos2 = {currPos[0]+1, currPos[1]}; // [x+1,y]
		if (!isOutOfBounds(nextPos2) && getPathBoolean(nextPos2)) {
			 this.direction = 1;
		}
		int[] nextPos3 = {currPos[0], currPos[1]+1}; // [x,y-1]
		if (!isOutOfBounds(nextPos3) && getPathBoolean(nextPos3)) {
					this.direction = 2;
		}
			
		int[] nextPos4 = {currPos[0]-1, currPos[1]}; // [x-1,y]
				if (!isOutOfBounds(nextPos4) && getPathBoolean(nextPos4)) {
					this.direction = 3;
		}
		System.out.println(this.direction);
		this.stepTimer = new Timer(1000, this);
		stepTimer.start();
    */
	}
	
	
	/**
	 * 
	 * @param p
	 * @param startPos, the first index is the col #, the second is the row #
	 */
	public Spike(boolean[][] p, int[] startPos) {
		super("Spike.png", startPos[0] * 40, startPos[1] * 40);

		this.path = p;

		// 1000 milliseconds from creation before it starts firing
		//
		
		this.direction = -1;
		direction = findNextDirection();
		this.stepTimer = new Timer(1000, this);
		stepTimer.start();
	}

	public void actionPerformed(ActionEvent e) {
		
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

	public int findNextDirection() {
		int[] currPos = getBoardPos(); // [x,y]
		int d = direction;
		for (int i = 0; i < 4; i++) {
			
      if (d == -1) { // correcting the value so it checks all four directions
        d++; 
      }
      
      d %= 4; // to limit this value to 0 - 3
			
			if (d == 0) {
				int[] nextPos = {currPos[0], currPos[1]-1}; // [x,y+1]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way up");
          return d;
				}
			} else if (d == 1) {
				int[] nextPos = {currPos[0]+1, currPos[1]}; // [x+1,y]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way right");
          return d;
				}
			} else if (d == 2) {
				int[] nextPos = {currPos[0], currPos[1]+1}; // [x,y-1]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way down");
          return d;
				}
			} else if (d == 3) {
				int[] nextPos = {currPos[0]-1, currPos[1]}; // [x-1,y]
				if (!isOutOfBounds(nextPos) && getPathBoolean(nextPos)) {
					//System.out.println("found a way left");
          return d;
				}
			}

			d++;
		}
		//System.out.println("failed to find path...");
		return -1;
	}
	
	

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

}
