package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

	public static void main(String args[]) {
		GameBoard game = new GameBoard();
		game.drawOpeningScreens();
	}

	public void victoryMessage(Player player) {
		System.out.println(player.getName() + " wins!");
	}

	// Ask the player to choose a symbol if they want to be an X or a O
	public void chooseSymbol(Player human) {
		char symbol = ' ';
		while(symbol == ' ') {
			System.out.print(human.getName() + ", choose a symbol: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				symbol = br.readLine().charAt(0);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		human.setChosenSymbol(symbol);
	}
	
	// Prompts the player for their name
	public void inputName(Player human) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			human.setName(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Check columns for a TicTacToe - The 2d array is stored in the format [row][column]
	public boolean checkVertical(GameBoard board, Player human) {
		if((board.positionsArray[0][0] == board.positionsArray[1][0]  		// Vertical TicTacToe in column 1
			 && board.positionsArray[1][0] == board.positionsArray[2][0] 
			 && board.positionsArray[2][0] == human.getChosenSymbol())   
		  	 || (board.positionsArray[1][0] == board.positionsArray[1][1]	// Vertical TicTacToe in column 2
		  	 && board.positionsArray[1][1] == board.positionsArray[1][2] 
		  	 && board.positionsArray[1][2] == human.getChosenSymbol())
			 || (board.positionsArray[2][0] == board.positionsArray[2][1] 	// Vertical TicTacToe in column 3
			 && board.positionsArray[2][1] == board.positionsArray[2][2] 
			 && board.positionsArray[2][2] == human.getChosenSymbol())) {	
				return true;	// The move resulted in a win from a vertical TicTacToe
		}
		return false;			// The move didn't result in a win from a vertical TicTacToe
	}

	// Check rows for a TicTacToe - The 2d array is stored in the format [row][column] 
	public boolean checkHorizontal(GameBoard board, Player player) {
		if ((board.positionsArray[0][0] == board.positionsArray[0][1]	 // Horizontal TicTacToe in row 1
		    && board.positionsArray[0][1] == board.positionsArray[0][2] 
		    && board.positionsArray[0][2] == player.getChosenSymbol())
		    || (board.positionsArray[0][1] == board.positionsArray[1][1] // Horizontal TicTacToe in row 2
		    && board.positionsArray[1][1] == board.positionsArray[2][1] 
		    && board.positionsArray[2][1] == player.getChosenSymbol())
		    || (board.positionsArray[0][2] == board.positionsArray[1][2] // Horizontal TicTacToe in row 3
		    && board.positionsArray[1][2] == board.positionsArray[2][2] 
		    && board.positionsArray[2][2] == player.getChosenSymbol())) {
				return true;	// The move resulted in a horizontal TicTacToe
		}
		return false;			// The move didn't result in a horizontal TicTacToe
	}

	// Check for Diagonal TicTacToe - The 2d array is stored in the format [row][column] 
	public boolean checkDiagonal(GameBoard board, Player player) {
		if ((board.positionsArray[0][0] == board.positionsArray[1][1]	 // Diagonal TicTacToe - top left to bottom right
			&& board.positionsArray[1][1] == board.positionsArray[2][2] 
			&& board.positionsArray[2][2] == player.getChosenSymbol())
			|| (board.positionsArray[2][0] == board.positionsArray[1][1] // Diagonal TicTacToe - bottom left to top right
			&& board.positionsArray[1][1] == board.positionsArray[0][2] 
			&& board.positionsArray[0][2] == player.getChosenSymbol())) {
				return true;
		}
		return false;
	}

	public void playGame(GameBoard board, Player player1, Player player2) {
		while (!this.checkDiagonal(board,player1) && !this.checkHorizontal(board,player1) && !this.checkVertical(board,player1)
		    && !this.checkDiagonal(board,player2) && !this.checkHorizontal(board,player2) && !this.checkVertical(board,player2)) 
		{
			player1.takeTurn(board);
			if(this.checkDiagonal(board,player1) || this.checkHorizontal(board,player1) || this.checkVertical(board,player1)) {
				board.printBoard();				// Print board after checking for diagonal, horizontal and vertical wins
				this.victoryMessage(player1);	// Player 1 wins, print victory message
				System.exit(0);					// Exits the program with a 0, which means the execution went fine
			}
			player2.takeTurn(board);
			if(this.checkDiagonal(board,player2) || this.checkHorizontal(board,player2) || this.checkVertical(board,player2)) {
			    board.printBoard();				// Print board after checking for diagonal, horizontal and vertical wins
			    this.victoryMessage(player2);	// Player 2 wins, print victory message
			    System.exit(0);					// Exits the program with a 0, which means the execution went fine
			}
		}
	}
}