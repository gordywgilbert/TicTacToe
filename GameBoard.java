package TicTacToe;

public class GameBoard {
	protected int ROWS = 3;	// Constant value for the number of rows
	protected int COLS = 3;	// Constant value for the number of columns
	protected char[][] positionsArray = new char[ROWS][COLS];	// Initialize the 2d array used to store the boards game state
	public int turnCount = 0;
	
	// Construct the board and clear it.
	public GameBoard() {
		clearBoard();	// Calls the method that clears the board
	}

	// Print the game board to the console
	public void printBoard() {
		System.out.println("");
		System.out.println("Col       1   2   3");
		System.out.println("");
		System.out.println("Row 1     " + positionsArray[0][0] + " | " + positionsArray[0][1] + " | " + positionsArray[0][2] );
		System.out.println("         ---|---|---" );
		System.out.println("Row 2     " + positionsArray[1][0] + " | " + positionsArray[1][1] + " | " + positionsArray[1][2] );
		System.out.println("         ---|---|---" );
		System.out.println("Row 3     " + positionsArray[2][0] + " | " + positionsArray[2][1] + " | " + positionsArray[2][2] );
		System.out.println("");
	}
	
	// Initialize the game board and set all choices to a " "
	public void clearBoard() {
		for(int i=0; i < ROWS; i++) {
			for(int j=0; j < COLS; j++) {
				positionsArray[i][j] = ' ';
			}
		}
	}
	
	public void drawOpeningScreens() {
		TicTacToe game = new TicTacToe();	// Initialize game
		GameBoard board = new GameBoard();	// Initialize game board
	
		Player player1 = new Player();		// Create player 1 object
		Player player2 = new Player();		// Create player 2 object
		System.out.println("Welcome to TicTacToe!");	// Print the welcome message to the console
		
		System.out.print("Player 1 enter your name: ");
		game.inputName(player1);						// Get player 1's name from input
		game.chooseSymbol(player1);						// Get player 1's symbol from input
		
		System.out.print("Player 2 enter your name: ");		
		game.inputName(player2);						// Get player 2's name from input
		game.chooseSymbol(player2);						// Get player 2's symbol from input
		
		game.playGame(board, player1, player2);			// Call the driver function for the game

	}

	// Clear the console by sending 30 empty lines.
	public void clearConsole() {
		for(int i=0; i<30; i++)
			System.out.println("");
	}
}