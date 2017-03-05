package TicTacToe;

import java.util.Scanner;

public class Player {
	String name;
	char chosenSymbol;
	int turnCount = 0;

	// Sets the name of the player
	public void setName(String playerName) {
		name = playerName;
	}
	
	// Returns the name of the player
	public String getName() {
		return name;
	}
	
	// Tries to place a symbol at the row and column the player specifies
	public void takeTurn(GameBoard board) {
		int row = -1, col = -1;
		try {
			while((row != 1 || row != 2 || row != 3) && (col != 1 || col != 2 || col != 3) 
				|| board.positionsArray[row][col] != ' ' || (row == -1 && col == -1)) 
			{
				board.printBoard();
				row = -1; col = -1;
				System.out.print(this.getName() + " enter the row you want to choose: ");
				Scanner scan = new Scanner(System.in); //Import java.util.Scanner for it
				row = scan.nextInt();
				System.out.print(this.getName() + " enter the column you want to choose: ");
				col = scan.nextInt();
				
				if(board.positionsArray[row-1][col-1] == ' ') {
					board.positionsArray[row-1][col-1] = chosenSymbol;
					turnCount++;			// Increment the turn count
					for(int i=0; i<3; i++) {
						for(int j=0; j<3; j++) {
							if(board.positionsArray[i][j] != ' ') turnCount++;
						}
					}
					if(turnCount == 9) {
						System.out.println("Game Over");
						System.exit(0);		// Exit the program
					}
					board.clearConsole();	// Clear the console
					break;					// Exit out of the loop
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Set the chosen symbol for the player
	public void setChosenSymbol(char symbol) {
		chosenSymbol = symbol;
	}

	// get the chosen symbol for the player
	public char getChosenSymbol() {
		return chosenSymbol;
	}

}