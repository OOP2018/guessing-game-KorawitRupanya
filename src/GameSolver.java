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
		int i = 1 ;
		for (i=1;;i++) {
			if(game.guess(i)) return i;
		}
	}
}
