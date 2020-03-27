package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**

 */
public class Main extends Application implements Commons {

	
	 //Function will setup media variables.
	 
	private void addMedia() {
		// ~ Sounds created by Kenney Vleugels (www.kenney.nl)
		Sound.addSound(DEALER_DRAW_SOUND, new AudioClip(this.getClass().getResource("/sounds/cardPlace1.wav").toExternalForm()));
		Sound.addSound(PLAYER_DRAW_SOUND, new AudioClip(this.getClass().getResource("/sounds/cardPlace1.wav").toExternalForm()));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// === Create Sound Library ===
		addMedia();

		// === Load FXML ===
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
		Pane root = loader.load();

		// === Create Scene and start the show! ===
		Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);
		scene.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Black Jack");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}