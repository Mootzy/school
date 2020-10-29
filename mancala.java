import java.util.Arrays;
import java.util.Scanner;


public class mancala

{

	static final int[ ] beadArray = new int[14];
	// fillArray(beadArray);
	static int[ ] firstHalf = Arrays.copyOfRange ( beadArray, 0, beadArray.length / 2 );
	static int[ ] secondHalf = Arrays.copyOfRange ( beadArray, beadArray.length / 2, beadArray.length );
	static int length = firstHalf.length + secondHalf.length;
	static int[ ] fullBoard = merge ( firstHalf, secondHalf );
	static final int BEAD = 4;
	static Scanner scanner = new Scanner ( System.in );

	public static void main( String[ ] args )

	{

		int game = -1;
		// game = gameOverCheck ( firstHalf, secondHalf );
		fillArray ( fullBoard );
		fillArray ( firstHalf );
		fillArray ( secondHalf );
		//firstHalf[6] = 0;
		//secondHalf[6] = 0;
		showBoard ( );

		do
		{

			game = gameOverCheck ( firstHalf, secondHalf );
			int playerNum = whosTurn ( game );
			int turn = playerNum - 1;
			int newLength = 7;
			// int update = dropBeads(fullBoard, validMove, playerNum);
			// fillArray(beadArray);
			// showBoard ( );

			//int[ ] fullBoard = merge ( firstHalf, secondHalf );
			int validMove = getStartingBin ( turn );
			System.out.println ( "Player " + turn + " selected Bin: " + validMove );
			System.out.println ( );

			// if ( turn == 1 )
			// {
			int[ ] updatePlayerOne = dropBeads ( fullBoard, validMove, playerNum );
			int[ ] topUpdate = Arrays.copyOf ( updatePlayerOne, newLength );
			int[ ] newTopBinBeads = updateTopBins ( topUpdate );
			showUpdatedBoardTop ( newTopBinBeads );

			// }
			// if ( turn == 2 )
			// {
			int[ ] updatePlayerTwo = dropBeads ( fullBoard, validMove, playerNum );
			int[ ] botUpdate = Arrays.copyOf ( updatePlayerTwo, newLength );
			int[ ] newBotBinBeads = updateTopBins ( botUpdate );
			showUpdatedBoardTop ( newBotBinBeads );

			// }
			turn++;
			System.out.println ( game );
		} while ( game == -1 );
		// gameOverCheck ( firstHalf, secondHalf );

		// showUpdatedBoardTop ( newTopBinBeads );
		// showUpdatedBoardBot ( newBotBinBeads );

	}

	private static void showUpdatedBoardTop( int[ ] newTopBinBeads )
	{

		System.out.printf ( "%44s", "TYLER'S MANACALA GAME   \n\n\n" );

		System.out.printf ( "%31s", "Player One" );
		System.out.println ( " " );
		makeSolidLine ( 57 );
		System.out.println ( );
		for ( int m = 1; m <= 5; m++ )
		{
			makeDottedLine ( );
			if ( m == 3 )
			{
				showTopRowNumbers ( );
				showTopBins ( newTopBinBeads );

			}
		}
		System.out.print ( "*  13  " );
		makeSolidLine ( 43 );
		System.out.print ( "  6   *" );
		System.out.println ( );

		for ( int i = 1; i <= 5; i++ )
		{
			makeDottedLine ( );
			if ( i == 3 )
			{
				showBottomRowNumbers ( );
				showBottomBins ( secondHalf );

			}

		}

		makeSolidLine ( 57 );
		System.out.println ( "" );
		System.out.printf ( "%31s", "Player Two \n" );
	}

	private static void showUpdatedBoardBot( int[ ] newBotBinBeads )
	{

		for ( int i = 1; i <= 5; i++ )
		{
			makeDottedLine ( );
			if ( i == 3 )
			{
				showBottomRowNumbers ( );
				showBottomBins ( newBotBinBeads );

			}

		}

		makeSolidLine ( 57 );
		System.out.println ( "" );
		System.out.printf ( "%31s", "Player Two \n" );
	}

	/**
	 * This creates the solid lines for the board
	 * 
	 * @param numOfStar
	 *           int @
	 */
	public static void makeSolidLine( int numOfStar )
	{

		for ( int i = 1; i <= numOfStar; i++ )
		{
			System.out.print ( "*" );
		}

	}

	/**
	 * Creates dotted lines for board
	 * 
	 * @param none
	 */
	public static void makeDottedLine( )
	{
		/**
		 * 
		 */
		int numOfSpaces = 6;
		int j, k;

		for ( k = 0; k <= 8; k++ )
		{
			System.out.print ( "*" );

			for ( j = 1; j <= numOfSpaces; j++ )
			{

				System.out.print ( " " );
			}

		}
		System.out.println ( );
	}

	/**
	 * Create entire board calling all other methods to create
	 */

	public static void showBoard( )

	{
		startingArray ( fullBoard );
		System.out.printf ( "%44s", "TYLER'S MANACALA GAME   \n\n\n" );

		System.out.printf ( "%31s", "Player One" );
		System.out.println ( " " );
		makeSolidLine ( 57 );
		System.out.println ( );
		for ( int m = 1; m <= 5; m++ )
		{
			makeDottedLine ( );
			if ( m == 3 )
			{
				showTopRowNumbers ( );
				showTopBins ( firstHalf );

			}
		}

		System.out.print ( "*  13  " );
		makeSolidLine ( 43 );
		System.out.print ( "  6   *" );
		System.out.println ( );

		for ( int i = 1; i <= 5; i++ )
		{
			makeDottedLine ( );
			if ( i == 3 )
			{
				showBottomRowNumbers ( );
				showBottomBins ( secondHalf );

			}

		}

		makeSolidLine ( 57 );
		System.out.println ( "" );
		System.out.printf ( "%31s", "Player Two \n" );
	}

	/**
	 * method to generate top numbers 0-6
	 */

	static void showTopRowNumbers( )
	{

		System.out.print ( "*      " );
		for ( int a = 0; a < 6; a++ )
		{
			System.out.print ( "*" );
			for ( int b = 0; b <= 5; b++ )
			{
				if ( b == 3 )
				{
					System.out.print ( a );
				}

				else
				{
					System.out.print ( " " );
				}
			}
		}
		System.out.print ( "*      *" );
		System.out.println ( );
	}

	/**
	 * method to generate bottom row numbers 7-12
	 */
	static void showBottomRowNumbers( )
	{

		System.out.print ( "*      " );
		for ( int a = 12; a >= 10; a-- )
		{

			System.out.print ( "*" );
			for ( int b = 2; b <= 6; b++ )
			{
				if ( b == 3 )
				{
					System.out.print ( a );
				}

				else
				{
					System.out.print ( " " );
				}
			}
		}
		for ( int a = 9; a >= 7; a-- )
		{
			System.out.print ( "*" );
			for ( int b = 0; b <= 5; b++ )
			{
				if ( b == 3 )
				{
					System.out.print ( a );
				}
				else if ( b == 3 && a > 9 )
				{
					System.out.println ( a );
				}
				else
				{
					System.out.print ( " " );
				}
			}
		}

		System.out.print ( "*      *" );
		System.out.println ( );
	}

	/**
	 * Method to fill beadArray except bins with 4
	 * 
	 * @param beadArray
	 * @param i
	 * @param beads
	 * @param j
	 * @return
	 */
	public static void startingArray( int[ ] arr )
	{
		for ( int i = 0; i < firstHalf.length; i++ )
		{
			firstHalf[i] = BEAD;
		}

		for ( int i = 0; i < secondHalf.length; i++ )
		{
			secondHalf[i] = BEAD;
		}

	}

	/**
	 * Method to print your and your enemies array
	 * 
	 * @param beadArray2
	 * @return
	 */
	public static void printArray( int[ ] arr )
	{

		for ( int i = 0; i < arr.length; i++ )
		{

			System.out.print ( arr[i] );
		}
		System.out.println ( );
	}

	/**
	 * Method to show how many beads are in the top bin, filled with array beadArray
	 * 
	 * @param firstHalf
	 */
	public static void showTopBins( int[ ] firstHalf )
	{

		//firstHalf[6] = 0;

		System.out.print ( "*" );
		System.out.print ( "      " );
		for ( int a = 0; a < firstHalf.length; a++ )
		{
			System.out.print ( "*" );
			for ( int b = 0; b <= 5; b++ )
			{
				if ( b == 3 )
				{
					System.out.print ( firstHalf[a]  );
				}

				else
				{
					System.out.print ( " " );
				}
			}
		}
		System.out.print ( "*" );
		System.out.println ( );
	}

	/**
	 * Shows how many beads are in the bottom bin, reversed array of topBins
	 * 
	 * @param secondHalf
	 */
	public static void showBottomBins( int[ ] secondHalf )

	{

		//secondHalf[6] = 0;

		int[ ] reverseSecondHalf = new int[secondHalf.length]; // Reverse second half so that
																					// 0 falls into correct bin not 4
		for ( int i = 1; i < secondHalf.length; i++ )
		{
			reverseSecondHalf[i] = secondHalf[secondHalf.length - 1 - i];
		}

		int a;
		int b;

		System.out.print ( "" );

		for ( a = 0; a < secondHalf.length; a++ )
		{
			System.out.print ( "*" );

			for ( b = 0; b <= 5; b++ )

			{
				if ( b == 3 )
				{
					System.out.print ( reverseSecondHalf[a] );
				}

				else
				{
					System.out.print ( " " );
				}
			}
		}
		System.out.print ( "*      *" );
		System.out.println ( );
	}

	/**
	 * Method to fill top middle pits with 0's and check that gameOverCheck Works and prints!
	 * 
	 * @param firstHalf
	 */

	public static void testGameOverCheck( int[ ] firstHalf ) // fill topBin with 0's to test game over and score adding
	{
		int test = 0;

		for ( int i = 0; i < firstHalf.length; i++ )
		{
			firstHalf[i] = test;
		}
	}

	/**
	 * Method to fill bottom pits with 0's and check that gameOverCheck Works and prints!
	 * 
	 * @param secondHalf
	 */

	public static void testGameOverCheckSecond( int[ ] secondHalf ) // fill BottomBin with 0's to test game over and
																							// score adding
	{
		int test = 0;

		for ( int i = 0; i < firstHalf.length; i++ )
		{
			firstHalf[i] = test;
		}

	}

	/**
	 * Method that checks if middle of either pits are empty, calculates beads you'll receive based on opponents bins
	 * prints game over/who won
	 * 
	 * @param firstHalf
	 * @param secondHalf
	 * @return
	 */

	public static int gameOverCheck( int[ ] firstHalf, int[ ] secondHalf )

	{

		int score = -1;
		int playerOneScore = 0;
		int playerTwoScore = 0;
		int sumFirstHalf = 0;

		for ( int i = 0; i < firstHalf.length - 1; i++ )
		{
			sumFirstHalf += firstHalf[i];

		}

		if ( sumFirstHalf == 0 )

		{

			score = 1;

		}

		for ( int l = 0; l < secondHalf.length; l++ )

		{
			playerOneScore += secondHalf[l];

		}

		if ( playerOneScore > playerTwoScore && sumFirstHalf == 0 )

		{
			System.out.println ( "" );
			System.out.println ( "" );
			System.out.println ( "" );
			System.out.printf ( "%32s", "GAMEOVER \n" );
			System.out.println ( "" );
			System.out.printf ( "%36s", "Player One Wins! \n" );
			System.out.println ( "" );
			System.out.printf ( "%50s", "They now recieve Player Twos Remaining: " + playerOneScore + " beads" );
		}

		int sumSecondHalf = 0;

		for ( int i = 0; i < secondHalf.length - 1; i++ )

		{

			sumSecondHalf += secondHalf[i];
		}

		if ( sumSecondHalf == 0 )

		{

			score = 2;
		}

		for ( int l = 0; l < firstHalf.length; l++ )

		{
			playerTwoScore += firstHalf[l];
		}

		if ( playerTwoScore > playerOneScore && sumSecondHalf == 0 )

		{

			System.out.println ( "" );
			System.out.println ( "" );
			System.out.println ( "" );
			System.out.printf ( "%32s", "GAMEOVER \n" );
			System.out.println ( "" );
			System.out.printf ( "%36s", "Player Two Wins! \n" );
			System.out.println ( "" );
			System.out.printf ( "%50s", "They now recieve Player Ones Remaining: " + playerTwoScore + " beads" );

		}

		return score;
	}

	/**
	 * Swapping elements in an array
	 * 
	 * @param fistHalf
	 *           - integer array with values
	 * @param index1
	 *           - integer first index to be swapped
	 * @param index2
	 *           - integer second index to be swapped
	 */
	public static void swapArray( int[ ] fistHalf, int index1, int index2 )

	{
		int hold = -1;
		hold = firstHalf[index1];
		firstHalf[index1] = firstHalf[index2];
		firstHalf[index2] = hold;
	}

	public static int getStartingBin( int playerNum )

	{
		boolean valid = false;
		int turn = playerNum;
		int playersChoice = 0;

		int startingBin[] = fullBoard;
		int bin = -1;
		int[ ] fullBoard = merge ( firstHalf, secondHalf );
		startingBin = fullBoard;

		do
		{

			try
			{
				// while ( valid != true ) // ( playersChoice != 1 || playersChoice != 2)

				System.out.println ( "\n Player " + turn + ", Which bin do you want to start in? \n " );

				playersChoice = scanner.nextInt ( );
				bin = playersChoice;
				startingBin[bin] = fullBoard[bin];

				if ( playerNum == 1 && playersChoice >= 0 && playersChoice < 6 && startingBin[bin] > 0 )
				{

					System.out.println ( "\n This is a valid bin for Player " + playerNum + ", containing: " + fullBoard[bin]
							+ " Beads \n" );
					valid = true;

				}

				else if ( playerNum == 2 && playersChoice >= 7 && playersChoice < 13 && startingBin[bin] > 0 )

				{

					System.out.println (

							"This is a valid bin for Player " + playerNum + ", containing: " + fullBoard[bin] + " Beads \n" );

					valid = true;
				}

				else

				{
					System.out.println ( "\n INVALID BIN! Please choose a bin from your side that contains atleast 1 bead" );
					valid = false;

				}
			}

			catch ( ArrayIndexOutOfBoundsException e )

			{
				System.out.println ( "This is not a pit you are allowed to choose" );
				System.out.println ( "Please pick a pit from your side of the board excluding the ending pits. " );
			}
		} while ( valid != true ); // && game != 1 && game != 2 );

		playersChoice = bin;

		return playersChoice;

	}

	public static int[ ] merge( int[ ] a, int[ ] b )

	{
		int[ ] c = new int[a.length + b.length];

		int i;

		for ( i = 0; i < a.length; i++ )
		{
			c[i] = a[i];
		}

		for ( int j = 0; j < b.length; j++ )
		{
			c[i++] = b[j];
		}

		return c;
	}

	/**
	 * for use in part 9, added unintentionally as part of pt 7
	 */
	public static int whosTurn( int game )
	{
		boolean valid = false;
		int turn = 0;
		int playersChoice = 0;
		int playerNum;
		int startingBin[] = fullBoard;
		int bin = -1;
		String playersTurn;
		int[ ] fullBoard = merge ( firstHalf, secondHalf );
		startingBin = fullBoard;
		
		
		while ( valid != true )
			
		{

		
		if ( turn % 2 == 0 )
		{

			playersTurn = "\n Player 2's turn \n";

			playerNum = 2;
			turn++;
			valid = true;

		}
		if (turn %2 == 1 || turn == 0)

		{
			playersTurn = "\n Player 1's turn \n";
			
			playerNum = 1;
			turn++;
			valid = true;
		}
		System.out.println(turn);
	}

	return turn;

	}

	public static int[ ] dropBeads( int[ ] startingBin, int validMove, int playerNum )

	{

		int turn = playerNum;
		int playersRowSelection = validMove;
		startingBin = merge ( firstHalf, secondHalf );
		int beadsToPickUp = startingBin[validMove];
		int binToDropBeadsIn = validMove + 1;

		startingBin[validMove] = 0;

		for ( int i = 0; i < beadsToPickUp; i++ )
		{
			if ( binToDropBeadsIn == 6 && turn == 2 )
			{
				// binToDropBeadsIn = 7;
				// binToDropBeadsIn += 1;
			}
			else if ( binToDropBeadsIn == 13 && turn == 1 )
			{

			}
			else
			{
				startingBin[binToDropBeadsIn] += 1;
				printArray ( startingBin );
			}
			if ( binToDropBeadsIn == 13 )

			{
				binToDropBeadsIn = 0;
				System.out.println ( "IN LAST IF STATMENT ATM" );
			}

			// else
			if ( turn == 2 )
			{
				binToDropBeadsIn += 1;
				// updateBottomBins(startingBin);
			}
			if ( turn == 1 )
			{
				binToDropBeadsIn += 1;
				// updateTopBins(startingBin);
			}

		}
		return startingBin;

	}

	public static int[ ] updateTopBins( int[ ] startingBin )
	{
		for ( int a = 0; a < firstHalf.length; a++ )
		{
			System.out.print ( "*" );
			for ( int b = 0; b <= 5; b++ )
			{
				if ( b == 3 )
				{
					System.out.print ( startingBin[a] );
				}

				else
				{
					System.out.print ( " " );
				}
			}
		}
		System.out.print ( "*      *" );
		System.out.println ( );
		int[ ] hold = startingBin;
		return startingBin;

	}

	public static int[ ] updateBottomBins( int[ ] startingBin )

	{
		int[ ] reverseSecondHalf = new int[secondHalf.length]; // Reverse second half so that
		// 0 falls into correct bin not 4
		for ( int i = 0; i < secondHalf.length; i++ )
		{
			//reverseSecondHalf[i] = secondHalf[secondHalf.length - 1 - i];
			reverseSecondHalf[i] = startingBin[startingBin.length - 1 - i];
		}

		int a;
		int b;

		System.out.print ( "" );

		for ( a = 0; a < secondHalf.length; a++ )
		{
			System.out.print ( "*" );

			for ( b = 0; b <= 5; b++ )

			{
				if ( b == 3 )
				{
					System.out.print ( reverseSecondHalf[a] );// + " " );
				}

				else
				{
					System.out.print ( " " );
				}
			}
		}
		System.out.print ( "*      *" );
		System.out.println ( );
		return startingBin;
	}

	public static void fillArray( int[ ] arr )
	{
		for ( int i = 0; i < arr.length -1; i++ )
		{
			arr[i] = BEAD;
		}
	}
	

}

/*
 *
 * Tyler Wallace 10/23/2020 Mancala Project part 8.
 * 
 * 
 * Created method to check if users selected bin is within their range and have beads it it. Will ask the player in what
 * bin they want to start. Return the players bin choice to a variable in main called validMove Using test variable to
 * set who's turn it is. I.E test = 1 == player 1; test = 2 == player 2;
 * 
 * 
 */
