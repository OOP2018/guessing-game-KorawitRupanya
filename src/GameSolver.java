/**
 * Find the secret to any NumberGame.
 * 
 * @author Korawit Rupanya
 *
 */
public class GameSolver {
	/**
	 * Play a NumberGame and return the solution. The NumberGame object must provide
	 * message (getMessage) containing the phrase "too small" if a guess is too
	 * small and "too large" if a guess is too large, for efficient solution.
	 * 
	 * @param game
	 *            is the NumberGame to solve
	 * @return solution of NumberGame
	 */
	public int play(NumberGame game) {
		int upper = game.getUpperBound()+1;
		int lower = 0;
		while (true) {
			int find = (upper + lower) / 2;
			if (game.guess(find)) {
				return find;
			}
			if(game.getMessage().contains("too small")) {
				lower = find;
			}
			if(game.getMessage().contains("too big")) {
				upper = find;
			}
		}
	}
}
