import java.util.Scanner;
import java.util.Random;

public class GuessingGamepart4
{

	public static void main( String[ ] args )
	{

		System.out.println ( "I'll pick a number between 10 to 20. Guess the number correctly to win, " );
		System.out.println ( "the computer will let you know if your guess is too high or too low. " );
		System.out.println ( "your score will be 5 at the beginning of the game," );
		System.out.println ( "each incorrect guess will subtract 1 from your possible score. " );

		Random rand = new Random ( );
		Scanner scanner = new Scanner ( System.in );

		int userNumber;
		int guesses = 0;
		int finalScore = 0;
		int averageScore;
		String answer; // initalize string variable 'answer' used for condition to repeat game
		char answerInital;
		int highValue;
		int lowValue;

		System.out.println (
				"First we'll initalize our range, we get this from taking (highValue - lowValue + 1) + lowValue" ); // explain
																																						// to
																																						// user
																																						// formula
																																						// for
																																						// range
		System.out.println ( "What do you want the largest possible number to be?" );
		highValue = scanner.nextInt ( ); // get largest possible number from user
		System.out.println ( "What do you want the lowest possible number to be?" );
		lowValue = scanner.nextInt ( ); // get lowest possible number from user

		do
		{

			int score = 5;
			int compNumber = rand.nextInt ( highValue - lowValue + 1 ) + lowValue; // (high - low + 1) + low
			// System.out.println ( "the random computer number is: " + compNumber ); used for debugging compNumber and
			// ensuring correct value

			do // nested loop with instructions for game and code for game
			{

				System.out.println ( "what is your guess? " );

				userNumber = scanner.nextInt ( );

				System.out.println ( compNumber + " compNumber" );

				System.out.println ( "your guess is " + userNumber );

				guesses++;

				if ( score > 0 && compNumber != userNumber ) // subtract one from score each time user guesses wrong, and
																			// only when they guess wrong.
				{
					score--;
				}

				if ( compNumber > userNumber )
				{
					System.out.println ( "Your guess is Too low" );
					System.out.println ( "Your score will now be " + score + " if you guess correct." );

				}
				else if ( compNumber < userNumber )
				{
					System.out.println ( "Your guess is too high" );
					System.out.println ( "Your score will now be " + score + " if you guess correct." );

				}
				else
				{
					System.out.println ( "Your guess is correct!" );
					finalScore += score;
					System.out.println ( "your total score is " + finalScore );
				}

				System.out.println ( "Total number of guessses: " + guesses );
				averageScore = finalScore / guesses;

			} while ( userNumber != compNumber ); // condition for loop to be met

			System.out.println ( "Want to play again? (Yes or no)" ); // ask user if they want to play again
			answer = scanner.next ( );
			answerInital = answer.charAt ( 0 ); // transfer value of string to 'answerInital' to the char at index 0 of
															// answer string

		} while ( answerInital == 'y' || answerInital == 'Y' ); // when the user says Yes yes y or Y the loop will
																					// endlessly

		System.out.println ( "Game over, final score = " + finalScore ); // user types no, final score, total games, and
																								// average score are printed to screen.
		System.out.println ( "total games played = " + guesses );
		System.out.println ( "Average points of each game = " + averageScore );

		scanner.close ( ); // close the scanner
	}
}

// Tyler Wallace 10/4/2020

// guessing game part 7; do while loop to continue game pt 7 extra credit
