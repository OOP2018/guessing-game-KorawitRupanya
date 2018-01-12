/**
 * Find the secret to any NumberGame.
 * @author Korawit Rupanya
 *
 */
public class GameSolver {
	/**
	 * Play a NumberGame and return the solution.
	 * The NumberGame object must provide message (getMessage)
	 * containing the phrase "too small" if a guess is too small
	 * and "too large" if a guess is too large, for efficient
	 * solution.
	 * 
	 * @param game is the NumberGame to solve
	 * @return solution of NumberGame
	 */
	public int play(NumberGame game) {
	int guess;
	
	while(true) {
		System.out.println( game.getMessage() );
		System.out.println("The number is ");
		guess = game.getUpperBound();
		boolean correct = game.guess(guess);
		if(correct==true) {
			break;
		}
		else if (correct==false) {
			if(game.getMessage().contains("too small")) {
				guess += 3;
			}
			if(game.getMessage().contains("too big")) {
				guess -= 2;
			}
		}
	}
	return guess;
	}
}
