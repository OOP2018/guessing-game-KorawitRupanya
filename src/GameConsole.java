import java.util.Scanner;

/** 
 *  The console of guessing game on the console.
 *  @param guess receive the number form the user.
 *  @return message to inform the user whether their guess number is too big or too small or correct.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		boolean correct;
		int guess;
		System.out.println( game.toString() );
		do{
			Scanner console = new Scanner(System.in);
			System.out.println( game.getMessage() );
			System.out.print("Your answer? ");
			guess = console.nextInt();
			correct = game.guess(guess);
			
		} while(!correct);
		
		return guess;
	}
}
