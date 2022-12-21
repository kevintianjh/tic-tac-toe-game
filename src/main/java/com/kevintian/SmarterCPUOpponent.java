package com.kevintian;

import java.util.ArrayList;

public class SmarterCPUOpponent extends CPUOpponent {
	
	private boolean testPutX(int row, int col) {
		getTicTacToe().getMap()[row][col] = 1;
		boolean outcome = getTicTacToe().checkResult(1);
		getTicTacToe().getMap()[row][col] = 0;
		
		return outcome;
	}
	
	private boolean testPutO(int row, int col) {
		getTicTacToe().getMap()[row][col] = 2;
		boolean outcome = getTicTacToe().checkResult(2);
		getTicTacToe().getMap()[row][col] = 0;
		
		return outcome;
	} 

	@Override
	public int nextMove() {   
		ArrayList<Integer> remainingMovesValues = getTicTacToe().getRemainingMoves();
		
		//Find a winning move for CPU
		for(Integer i : remainingMovesValues) {
			PosSet tPos = getTicTacToe().translatePosition(i);
			boolean winMove = this.testPutO(tPos.row, tPos.col);
			
			if(winMove) {
				getTicTacToe().getMap()[tPos.row][tPos.col] = 2; 
				remainingMovesValues.remove(i); 
				return i;
			}
		}
		
		//Find a winning move for player, and block it
		for(Integer i : remainingMovesValues) {
			PosSet tPos = getTicTacToe().translatePosition(i);
			boolean winMove = this.testPutX(tPos.row, tPos.col);
			
			if(winMove) {
				getTicTacToe().getMap()[tPos.row][tPos.col] = 2; 
				remainingMovesValues.remove(i); 
				return i;
			}
		}
		
		return super.nextMove();
	} 
}
