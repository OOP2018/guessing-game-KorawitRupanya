import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 */
public class Main extends Application {
	public static final String UI_FORM = "game/GameUI.fxml";
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
//		int upperBound = 1000;
//		KorawitGame game = new KorawitGame(upperBound);
//		GameConsole ui = new GameConsole();
//
//		GameSolver solver = new GameSolver();
//		int onw = solver.play(game);
//		System.out.println(onw);
//
//		int solution = ui.play(game);
//		System.out.println("play() returned " + solution);
	launch(args);
	}
	
	/**
	 * Start the game by creating the scene to view the game.
	 */
	public void start(Stage stage) {
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("GameUI.fxml"));
			Scene scene = new Scene(root);
			if (root == null) {
				System.out.println("Couldn't find file: GameUI.fxml");
				Platform.exit();
			}

			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("Guessing Game");
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}