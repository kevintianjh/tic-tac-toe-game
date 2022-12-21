package com.kevintian;

import java.util.Scanner;

public class LaunchApplication {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Hello, please specify grid size (3-9) for your game: ");
		int gridSize = Integer.parseInt(scanner.nextLine());
		
		if(gridSize < 3 || gridSize > 9) {
			System.out.println("Invalid value");
			scanner.close();
			return;
		}
		
		System.out.print("Use smarter CPU opponent? (y/n): ");
		String input = scanner.nextLine();
		CPUOpponent cpuOpponent = null;
		
		if(input.equals("y")) {
			System.out.println("Using smarter CPU opponent");
			cpuOpponent = new SmarterCPUOpponent();
		}
		else {
			cpuOpponent = new CPUOpponent();
		} 
		
		TicTacToe ttt = new TicTacToe(gridSize);  
		cpuOpponent.setTicTacToe(ttt);
		int choiceRange = gridSize * gridSize;
		
		while(true) {
			ttt.printBoard();
			System.out.print("Player, kindly enter your position (1-" + choiceRange + "): "); 
			int choice = Integer.parseInt(scanner.nextLine());
			
			if(choice < 1 || choice > choiceRange) {
				System.out.println("Invalid value");
				continue;
			}
			
			if(!ttt.putX(choice)) {
				System.out.println("Position is already occupied. Please re-enter the position");
				continue;
			}
			
			if(ttt.checkResult(1)) {
				ttt.printBoard();
				System.out.println("Great, you won!");
				break;
			} 
			else if(ttt.getRemainingMoves().size() == 0) {
				ttt.printBoard();
				System.out.println("Draw...");
				break;
			}
			
			int cpuMove = cpuOpponent.nextMove();
			System.out.println("CPU has selected: " + cpuMove);
			
			if(ttt.checkResult(2)) {
				ttt.printBoard();
				System.out.println("You lost...");
				break;
			}
			else if(ttt.getRemainingMoves().size() == 0) {
				ttt.printBoard();
				System.out.println("Draw...");
				break;
			}
		}
		
		scanner.close();
	}
}
