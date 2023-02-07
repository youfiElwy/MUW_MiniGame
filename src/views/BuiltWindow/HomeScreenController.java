package views.BuiltWindow;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import views.Main;

public class HomeScreenController {

	
	
//	public static void homeScreenWindowStartGameButtonAction(Button playButton) {
//		
//		playButton.setOnAction(e -> {
//			Main.window.setScene(new PlayersNameWindow().getPlayersNameScene());
//			Main.window.setFullScreen(true);
//
//		});
//	}
	
	public static void homeScreenWindowStartGameButtonAction(MenuItem playButton) {
		
		playButton.setOnAction(e -> {
			Main.window.setScene(new PlayersNameWindow().getPlayersNameScene());
			Main.window.setFullScreen(true);
		});
	}
	
	
	
}
