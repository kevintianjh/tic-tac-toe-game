# tic-tac-toe-game
 
A command line selectable grid (up to 9x9) tic tac toe game written in Java that demonstrated the benefit of object-oriented design

Enhancements made on top of original specifications
1) User can choose the gridsize from 3x3 to 9x9.

2) Objected-oriented design was applied that seperate the main flow and the related classes - TicTacToe, CPUOpponent, SmarterCPUOpponent. It enabled program to update to future GUI easily as the design is modular.

3) A simple demostation of polymorphism. CPUOpponent will determine the next move against player with its method nextMove() method. CPUOpponent implemented nextMove() method that selects random spot left on game grid. SmarterCPUOpponent extends CPUOpponent which overides nextMove() method that block any next winning move by player, or selects a next winning move available to CPU, if both not available, then selects random spot. Say in the future an even smarter CPUOpponent is created, the change is simply plug and play
