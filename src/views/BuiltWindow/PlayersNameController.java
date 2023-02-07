package views.BuiltWindow;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import views.AlertBox;
import views.Main;

public class PlayersNameController {
	

	static String player1Name, player2Name;
	private static Scene homeScreenScene;
	
	
	public static void playerNameBackButton(Button backButton) {
		
		backButton.setOnAction(e -> {
			
//			Main.window.setScene(new HomeScreenWindow().getHomeScreenScene());
//			Main.window.setFullScreen(true);

			homeScreenScene = new Scene(new HomeScreenWindow().createContent(), 500, 500);
			Main.window.setScene(homeScreenScene);
			Main.window.setFullScreen(true);
		});
	}
	
	public static void enterNamesButton(Button enterNames, TextField name1Input, TextField name2Input) {
		
		enterNames.setOnAction(e -> {
			
			enterNames(name1Input, name2Input);
		});
	}
	
	public static void chooseChampions(Button chooseChamps, TextField name1Input, TextField name2Input) {
		
		chooseChamps.setOnAction(e -> {
			if (name1Input.getText().length() == 0 || name2Input.getText().length() == 0) {
				
				AlertBox.display("Player name error", "You have too obey the Player naming rules!");
			}
			else if (name1Input.getText().equals(name2Input.getText())) {
				
				AlertBox.display("Player name error", "Both Players cannot have the same Name");
			}
			
			else {
				Main.window.setScene(new ChampSelectionWindow().getChampSelectionScene());
				Main.window.setFullScreen(true);
			}
		});
	}
	
	
	
	public static void enterNames(TextField input1, TextField input2) {
		
		if (input1.getText().length() == 0 || input2.getText().length() == 0) {
			
			AlertBox.display("Player name error", "Your Player's name cannot be : *empty* ");
		}
		
		
		else if (input1.getText().equals(input2.getText())) {
			
			AlertBox.display("Player name error", "Both Players cannot have the same Name");
		}
		else if (input1.getText().length() > 0 && input2.getText().length() > 0) {
			player1Name = input1.getText();
			player2Name = input2.getText();
			
			// enter the third scene
			
			
		}
		else {
			AlertBox.display("Player name error", "Please fill in the names");
		}
		
	}
}
