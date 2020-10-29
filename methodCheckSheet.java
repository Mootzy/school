import java.util.Random;
import java.util.Scanner;

public class methodCheckSheet
{
	static Scanner scanner = new Scanner ( System.in );
	static Random ran = new Random ( );

	public static void main( String[ ] args )
	{
		int tableNumTotal = 0;
		int randNum = 1;

		System.out.println (
				"How many numbers do you want to be in the table?" + " It must be greater then 10 & less then 500 " );

		tableNumTotal = scanner.nextInt ( );

		validInput ( tableNumTotal );
		// int tableNumTotalReturn = validInput ( tableNumTotal );

		System.out.println ( "What do you want your highest range to be? " );
		int high = scanner.nextInt ( );
		System.out.println ( "What do you want your lowest range to be? " );
		int low = scanner.nextInt ( );
		//checkRange ( high, low );
		int[ ] range = checkRange ( high, low );
		//for ( int i = 0; i < 2; i++ )
		//{
			//System.out.print ( range[i] );
		//}

		high = range[1];
		low = range[0];

		//do
		//{
			makeTable ( high, low, tableNumTotal, randNum );

		//} while ( tableNumTotal > 10 && tableNumTotal < 500 );
	//}
	}
	public static void makeTable( int high, int low, int tableNumTotal, int randNum )
	{

		String title = "Random Number Table \n";
		System.out.printf ( " %36s", title );
		for ( int i = 1; i <= tableNumTotal; i++ )
		{
			randNum = ran.nextInt ( ( high + 1 ) - low ) + low;
			System.out.printf ( "%5d", randNum );
			if ( i % 7 == 0 )
			{
				System.out.println ( "" );

			}
		}
	}

	public static int validInput( int tableNumTotal )
	{
		do
		{

			if ( tableNumTotal < 10 | tableNumTotal > 500 )
			{

				System.out.println ( "Your total number doesn't meet the accepted values" );

				System.out.println (
						"How many numbers do you want to be in the table? It must be greater then 10 & less then 500 " );

				tableNumTotal = scanner.nextInt ( );
			}

		} while ( tableNumTotal < 10 | tableNumTotal > 500 );

		return tableNumTotal;

	}

	// Function code
	

	public static int[ ] checkRange( int high, int low )
	{
		if ( low > high )
		{
			do
			{

				{
					System.out.print ( "Your low is larger then your high. " );
				}

				System.out.println ( "What do you want the highest possible number to be?" );
				high = scanner.nextInt ( );

				System.out.println ( "What do you want the lowest possible number to be?" );
				low = scanner.nextInt ( );

			} while ( low > high );

		}
		return new int[ ] { low, high };
	}

}
