import java.util.ArrayList;
import java.util.Random;

/**
 * Game of guessing a secret number.
 * 
 * @author Korawit Rupanya
 *
 */
public class KorawitGame extends NumberGame {
	/* properties of guessing game */
	private int secretnumber;
	private int upperBound;
	private String message = "";
	private ArrayList<Integer> guessingNum;
	private int count;

	public KorawitGame(int upperbound) {
		guessingNum = new ArrayList<Integer>();
		this.upperBound = upperbound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secretnumber = rand.nextInt(this.upperBound) + 1;
	}

	/**
	 * Evaluate a user's guess.Return true and the message if it is correct,false
	 * otherwise. Also send some message if the user is trying to guess the same
	 * number.
	 */
	public boolean guess(int number) {
		count++;
		if (number == this.secretnumber) {
			this.setMessage("Right you win!");
			return true;
		}
		if (guessingNum.contains(number)) {
			this.setMessage("You have tried this before");
			return false;
		}
		guessingNum.add(number);
		if (number < this.secretnumber) {
			this.setMessage(number + " is too small.");
		} else if (number > this.secretnumber) {
			this.setMessage(number + " is too big.");
		}
		return false;
	}

	/**
	 * method to get the upperbound
	 * 
	 * @return upperbound of the game
	 */
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * get the count number
	 * 
	 * @return count of how many times the user have been guessing.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * toString describes the game or problem.
	 * 
	 * @return description of this game or the problem to be solved.
	 */
	@Override
	public String toString() {
		return String.format("Guess a secret number between 1 and %d", upperBound);
	}
}
