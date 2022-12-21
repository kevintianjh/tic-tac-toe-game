package com.kevintian;

import java.util.ArrayList;
import java.util.Random;

public class CPUOpponent {
	
	private TicTacToe ticTacToe;
	private Random random = new Random();
	  
	public TicTacToe getTicTacToe() {
		return ticTacToe;
	} 
	
	public void setTicTacToe(TicTacToe ticTacToe) {
		this.ticTacToe = ticTacToe;
	}
 
	public int nextMove() {
		ArrayList<Integer> remainingMoves = getTicTacToe().getRemainingMoves();
		int randSelection = random.nextInt(remainingMoves.size());
		int pos = remainingMoves.get(randSelection);
		PosSet posSet = getTicTacToe().translatePosition(pos);
		
		getTicTacToe().getMap()[posSet.row][posSet.col] = 2; 
		remainingMoves.remove(Integer.valueOf(pos)); 
		return pos;
	}
}
