package com.kevintian;
 
import java.util.ArrayList; 

class PosSet {
	int row;
	int col;
} 
 
public class TicTacToe {  
	private int gridSize;
	private byte[][] map;
	private ArrayList<Integer> remainingMoves = new ArrayList<>();
	
	public TicTacToe(int gridSize) { 
		this.gridSize = gridSize;
		this.map = new byte[gridSize][gridSize];
		
		int count = 1;
		for(int row=0; row < this.gridSize; row++) {
			for(int col=0; col < this.gridSize; col++) { 
				this.remainingMoves.add(count);
				count++;
			}
		}
	}  
	   
	public byte[][] getMap() {
		return map; 
	}
 
	public ArrayList<Integer> getRemainingMoves() {
		return this.remainingMoves;
	}
			 
	public void printBoard() { 
		String rowSeperator = generateRowSeperator();
		
		for(int row = 0; row < this.gridSize; row++) {
			for(int col = 0; col < this.gridSize; col++) {
				
				if(map[row][col] == 0) {
					System.out.print(" ");
				}
				else if(map[row][col] == 1) {
					System.out.print("X");
				}
				else if(map[row][col] == 2) {
					System.out.print("O");
				}
				
				if(col != (this.gridSize-1)) {
					System.out.print("|");
				}
			} 

			System.out.println();
			
			if(row != (this.gridSize-1)) {
				System.out.println(rowSeperator);
			}
		}
	}
	
	private String generateRowSeperator() {
		StringBuilder ret = new StringBuilder();
		
		for(int count = 0; count < this.gridSize; count++) {
			ret.append("-");
			
			if(count != (this.gridSize-1)) {
				ret.append("+");
			}
		}
		
		return ret.toString();
	}
	
	public boolean putX(int pos) {
		PosSet posSet = translatePosition(pos); 
		
		if(this.map[posSet.row][posSet.col] == 0) {
			this.map[posSet.row][posSet.col] = 1;
			
			this.remainingMoves.remove(Integer.valueOf(pos));
			 
			return true;
		}
		else { 
			return false;
		}
	} 
	
	//Player 1 denotes X, Player 2 denotes O
	public boolean checkResult(int player) {
		
		int strikeCount = 0;
		
		//Horizontal match
		for(int row = 0; row < this.gridSize; row++) { 
			strikeCount = 0;
			
			for(int col = 0; col < this.gridSize; col++) {
				if(player == 1 && this.map[row][col] == 1) {
					strikeCount++;
				}
				
				if(player == 2 && this.map[row][col] == 2) {
					strikeCount++;
				} 
			}
			
			if(strikeCount==this.gridSize) {
				return true;
			}
		}
		
		//Vertical match
		for(int col = 0; col < this.gridSize; col++) {
			strikeCount = 0;
			
			for(int row = 0; row < this.gridSize; row++) {
				if(player == 1 && this.map[row][col] == 1) {
					strikeCount++;
				}
				
				if(player == 2 && this.map[row][col] == 2) {
					strikeCount++;
				} 
			}
			
			if(strikeCount == this.gridSize) {
				return true;
			}
		}
		
		//Cross match 
		strikeCount = 0;
		for(int count = 0; count < this.gridSize; count++) { 
			
			if(player == 1 && this.map[count][count] == 1) {
				strikeCount++;
			}
			
			if(player == 2 && this.map[count][count] == 2) {
				strikeCount++;
			}
			
			if(strikeCount == this.gridSize) {
				return true;
			}
		}
		
		//Back cross match
		int row = 0;
		int col = this.gridSize-1;
		strikeCount = 0;
		
		for(int count = 0; count < this.gridSize; count++) { 
			
			if(player == 1 && this.map[row][col] == 1) {
				strikeCount++;
			}
			
			if(player == 2 && this.map[row][col] == 2) {
				strikeCount++;
			}
			
			row++;
			col--;
			
			if(strikeCount == this.gridSize) {
				return true;
			}
		}
		
		return false;
	}
	
	public PosSet translatePosition(int pos) {
		PosSet ret = new PosSet();
		
		int leftComparator = 1;
		int rightComparator = this.gridSize;
		int colAdjuster = 1;
		
		for(int count = 0; count < this.gridSize; count++) {
			
			if(pos >= leftComparator && pos <= rightComparator) {
				ret.row = count;
				ret.col = pos - colAdjuster;
				break;
			} 
			
			leftComparator += this.gridSize;
			rightComparator += this.gridSize;
			colAdjuster += this.gridSize;
		} 
		
		return ret;
	}
}
