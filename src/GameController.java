import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The game controller class that play the guessing game.
 * @author Korawit Rupnaya
 *
 */
public class GameController {

	private KorawitGame game;
	private CounterView view;
	@FXML
	Label statusMessage;
	@FXML
	TextField inputField;
	@FXML
	Button button1;
	@FXML
	Button button2;

	public GameController() {
		game = new KorawitGame();
		view = new CounterView(game);
		game.addObserver(view);
	}

	/**
	 * initialize the game.
	 */
	@FXML
	public void initialize() {
		System.out.println("GameController initializing");
		System.out.println("message = " + game.getMessage());
		statusMessage.setText(game.getMessage());
		view.run();
	}

	/**
	 * The button to guess the number.
	 * @param event
	 */
	public void pressButton1(ActionEvent event) {
		inputField.setStyle("-fx-text-inner-color: black;");
		System.out.println("Button 1 pressed");
		statusMessage.setText("");
		try {
			String input = inputField.getText().trim();
			int number = Integer.parseInt(input);
			inputField.setText("");
			boolean check = game.guess(number);
			statusMessage.setText(game.getMessage());
			if (!check) {
				inputField.clear();
				inputField.requestFocus();
				return;
			}
			view.displayCount();
		} catch (Exception e) {
			inputField.clear();
			inputField.requestFocus();
			statusMessage.setText("Invalid input");
			inputField.setStyle("-fx-text-inner-color: red;");
		}
	}
	/**
	 * The button to give up (exit the program).
	 * @param event
	 */
	public void pressButton2(ActionEvent event) {
		System.exit(0);
	}
}
