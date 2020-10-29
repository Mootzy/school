
		import java.util.Arrays;

		public class mancalaTest
		{
			static int[ ] beads = new int[ ] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
			static int[ ] beadArray = new int[ ] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			static int[ ] firstHalf = Arrays.copyOfRange ( beadArray, 0, beadArray.length / 2 );
			static int[ ] secondHalf = Arrays.copyOfRange ( beadArray, beadArray.length / 2, beadArray.length );
			static int bead = 4;
			static int low = 0;
			static int high = 6;
			static int bin = 0;

			public static void main( String[ ] args )
			{

				int[ ] beads = new int[ ] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
				int[ ] beadArray = new int[ ] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

				showBoard ( );
				startingArray ( beadArray, 0, 10, beads );
				printArray ( beadArray );
			}

			/**
			 * This creates the solid lines for the board
			 * 
			 * @param numOfStar
			 *           int @
			 */
			static void makeSolidLine( int numOfStar )
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
			static void makeDottedLine( )
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

						// System.out.print ( j ); used to debug and test total number of spaces is properly 6
						System.out.print ( " " );
					}

				}
				System.out.println ( );
			}

			/*
			 * static void middleLine( int num ) used to debug middle line spaces and numbers for bins { System.out.print (
			 * "*  13  " ); makeSolidLine ( 43 ); System.out.print ( "  6   *" ); System.out.println ( );
			 * 
			 * }
			 */

			/**
			 * Create entire board calling all other methods to create
			 */

			static void showBoard( )

			{
				int l, m;

				makeSolidLine ( 57 );
				System.out.println ( );
				for ( m = 1; m <= 5; m++ )
				{
					makeDottedLine ( );
					if ( m == 3 )
					{
						showTopRowNumbers (firstHalf );
					}
				}

				// middleLine ( 43 );
				System.out.print ( "*  13  " );
				makeSolidLine ( 43 );
				System.out.print ( "  6   *" );
				System.out.println ( );

				for ( m = 1; m <= 5; m++ )
				{
					makeDottedLine ( );
					if ( m == 3 )
					{
						//showBottomRowNumbers ( );
					}
				}

				makeSolidLine ( 57 );
			}

			/**
			 * method to generate top numbers 0-5
			 * @param firstHalf2 
			 */

			static void showTopRowNumbers(int[ ] firstHalf )
			{
				int b;
				int count = 6;
				System.out.print ( "*      " );
				for ( int a = 0; a < count; a++ )
				{
					System.out.print ( "*" );
					for ( b = 0; b <= 5; b++ )
					{
						if ( b == 3 )
						{
							System.out.print ( a );// + " " );
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

			public static int[ ] startingArray( int[ ] beadArray, int i, int beads, int[ ] j )
			{

				beadArray = new int[ ] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				/*
				 * int[ ] firstHalf = Arrays.copyOfRange ( beadArray, 0, beadArray.length / 2 ); int[ ] secondHalf =
				 * Arrays.copyOfRange ( beadArray, beadArray.length / 2, beadArray.length ); int bead = 4; int low = 0; int high =
				 * 6; int bin = 0;
				 */
				int low2 = 0;
				int high2 = 6; ///////// this is whats causing the issues

				Arrays.fill ( beadArray, low, high, bead );
				Arrays.fill ( beadArray, low, high, bead );

				Arrays.fill ( firstHalf, low, high, bead );
				Arrays.fill ( secondHalf, low, high, bead );
				return firstHalf;

			}
			/**
			 * Method to print your and your enemies array
			 * 
			 * @param beadArray2
			 * @return
			 */
			public static void printArray( int[ ] beadArray )
			{

				Arrays.fill ( beadArray, low, high, bead );
				Arrays.fill ( beadArray, low, high, bead );

				Arrays.fill ( firstHalf, low, high, bead );
				Arrays.fill ( secondHalf, low, high, bead );

				int[ ] beadsOnBoard = beadArray;

				// return beadArray;

				System.out.println ( "\n\n" + "This is my BeadArray\n" );

				System.out.print ( Arrays.toString ( firstHalf ).replace ( "[", "" ).replace ( "]", "" ).replace ( ",", "" ) );
				System.out.print ( " | " );
				System.out.print ( Arrays.toString ( secondHalf ).replace ( "[", "" ).replace ( "]", "" ).replace ( ",", "" ) );

			}
		}
		 
		


