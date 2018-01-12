import java.util.ArrayList;
import java.util.Random;
/**
 * Game of guessing a secret number.
 * @author Korawit Rupanya
 *
 */
public class KorawitGame extends NumberGame {

	private int secertnumber;
	private int upperBound;
	private String message = "";
	private ArrayList<Integer> guessingNum; 

public KorawitGame (int upperbound) {
	guessingNum = new ArrayList<Integer>();
	this.upperBound=upperbound;
	long seed = System.nanoTime();
	Random rand = new Random(seed);
	this.secertnumber = rand.nextInt(this.upperBound)+1;
}

public boolean guess(int number) {
	if(number == this.secertnumber) {
		this.setMessage ("Right you win!");
		return true;
	}
	if(guessingNum.contains(number)) {
		this.setMessage("You have tried this before");
		return false;
	}
	guessingNum.add(number);
	if(number < this.secertnumber) {
		this.setMessage(number + "is too small.");
}
	else if(number > this.secertnumber) {
		this.setMessage(number + "is too big.");
}
	return false;
}

public int getUpperBound() {
	return upperBound;
}

public String toString() {
	return String.format("Guess a secret number between 1 and %d",upperBound);
}
}
