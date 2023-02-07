package views.BuiltWindow;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Paths;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import views.Main;

public class PlayersNameWindow {

	private final Scene PlayersNameScene;
	
	static String s1 = "src/Resources/Player1.mp3";
	public static Media h1 = new Media(Paths.get(s1).toUri().toString());
	
	static String s2 = "src/Resources/Player2.mp3";
	public static Media h2 = new Media(Paths.get(s2).toUri().toString());
	
	
	
	public PlayersNameWindow() {
		
		
		
		HBox mainLayout = new HBox();
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////	
		
		VBox layout1 = new VBox();
		
		//Name label
		Label namesLabel = new Label("Player Name Entry");
		namesLabel.setBackground(new Background(new BackgroundFill(Color.ORANGERED, new CornerRadii(10, 10, 10, 10, false), new Insets(10,10,10,10))));
		namesLabel.setPrefSize(500,100);
		namesLabel.setTextAlignment(TextAlignment.CENTER);
		
		namesLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-alignment:CENTER;");
		namesLabel.setFont(new Font(50));
		
		
		// name textfield
		TextField name1Input = new TextField();
		name1Input.setPromptText("Player 1");
		name1Input.setPrefSize(15, 150);
		name1Input.setFont(new Font(60));
		name1Input.setStyle("-fx-text-fill: royalblue; -fx-alignment:CENTER;");
		name1Input.setOnMouseClicked(e -> {
			
			MediaPlayer soundEffect = new MediaPlayer(h1);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		});
		
		// name textfield
		TextField name2Input = new TextField();
		name2Input.setPromptText("Player 2");
		name2Input.setPrefSize(15, 150);
		name2Input.setFont(new Font(60));
		name2Input.setStyle("-fx-text-fill: crimson; -fx-alignment:CENTER;");
		name2Input.setOnMouseClicked(e -> {
			
			MediaPlayer soundEffect = new MediaPlayer(h2);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		});
		
		
		layout1.getChildren().addAll(namesLabel, name1Input, name2Input);
		layout1.setPadding(new Insets(20,20,20,20));
		layout1.setSpacing(20);
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		VBox layout2 = new VBox();
		
		
		//Back to home screen scene Button
		Button backToHomeScreenButton = new Button("Back");
		//backToHomeScreenButton.setAlignment(Pos.CENTER_RIGHT);
		backToHomeScreenButton.setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold;");
		backToHomeScreenButton.setPrefSize(120, 50);
		
		// button to set the names and validate them
		Button enterNamesButton = new Button("Enter Names");
		enterNamesButton.setStyle("-fx-background-color: honeydew; -fx-text-fill: black; -fx-font-weight: bold;");
		enterNamesButton.setPrefSize(150, 50);
		enterNamesButton.setFont(new Font(20));
		
		// button to go to champion selection scene
		Button chooseChampionsButton = new Button("Go to Champion Selection");
		chooseChampionsButton.setStyle("-fx-background-color: honeydew; -fx-text-fill: black; -fx-font-weight: bold;");
		chooseChampionsButton.setPrefSize(300, 50);
		chooseChampionsButton.setFont(new Font(20));
		
		
		layout2.getChildren().addAll(backToHomeScreenButton, enterNamesButton, chooseChampionsButton);
		layout2.setPadding(new Insets(20,20,20,20));
		layout2.setSpacing(20);
		
		
		
		
		
		
		
		Button loadingButton = new Button();
		BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/Resources/Loading.gif")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(70, 70, true, true, true, true));
		//layout.setBackground(new Background(backgroundImage));
		
		loadingButton.setBackground(new Background(backgroundImage));
		loadingButton.setAlignment(Pos.BOTTOM_RIGHT);
		loadingButton.setPrefSize(70, 70);
		loadingButton.setShape(new Circle(1.5));
		
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		// setting the layout:: adding all buttons n stuff
		BackgroundFill background = new BackgroundFill(Color.valueOf("#800000"), new CornerRadii(0), new Insets(0));
		Background bg = new Background(background);
		mainLayout.setBackground(bg);
		mainLayout.getChildren().addAll(layout1, layout2, loadingButton);
		mainLayout.setPadding(new Insets(50, 50, 50, 50));
		mainLayout.setSpacing(30);
		mainLayout.setAlignment(Pos.BOTTOM_CENTER);
		
		
		
		
		
		
//		BackgroundImage backgroundImage = new BackgroundImage(
//                new Image(new File("src/Resources/GameOver.gif")
//                        .toURI().toString()),
//                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
//                new BackgroundSize(550, 300, true, true, true, true));
//		//layout.setBackground(new Background(backgroundImage));
//		
//		mainLayout.setBackground(new Background(backgroundImage));
		
		
		
		
		
		
		
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//PlayersNameScene = new Scene(mainLayout, 1000, 1000);
		PlayersNameScene = new Scene(mainLayout, 1000, 1000);
		
		PlayersNameController.playerNameBackButton(backToHomeScreenButton);
		PlayersNameController.enterNamesButton(enterNamesButton, name1Input, name2Input);
		PlayersNameController.chooseChampions(chooseChampionsButton, name1Input, name2Input);
		
		
		
		
		
		
		
		
		
		
		
//		//Setting Player's Name's Scene Layout
//		GridPane grid = new GridPane();
//		grid.setPadding(new Insets(20, 20, 20, 20));
//		grid.setVgap(10);
//		grid.setHgap(10);
//		
//		//Back to home screen scene Button
//		Button backToHomeScreenButton = new Button("Back");
//		GridPane.setConstraints(backToHomeScreenButton, 6, 0);
//		//backToHomeScreenButton.setAlignment(Pos.CENTER_RIGHT);
//		
//		//Name label
//		Label namesLabel = new Label("Please enter the two player's names:");
//		GridPane.setConstraints(namesLabel, 0, 0);
//		namesLabel.setBackground(new Background(new BackgroundFill(Color.TOMATO, CornerRadii.EMPTY, Insets.EMPTY)));
//		namesLabel.setPrefSize(370,50);
//		namesLabel.setFont(new Font(20));
//		
//		
//		// name textfield
//		TextField name1Input = new TextField();
//		GridPane.setConstraints(name1Input, 0, 1);
//		name1Input.setPromptText("Player 1");
//		
////		// binded Player 1 label
////		Label player1Label = new Label("Player 1: ");
////		GridPane.setConstraints(player1Label, 2, 1);
////		player1Label.textProperty().bind(name1Input.textProperty());
//		
//		
//		
//		// name textfield
//		TextField name2Input = new TextField();
//		GridPane.setConstraints(name2Input, 0, 2);
//		name2Input.setPromptText("Player 2");
//		
////		// binded Player 1 label
////		Label player2Label = new Label("Player 2: ");
////		GridPane.setConstraints(player2Label, 2, 2);
////		player2Label.textProperty().bind(name2Input.textProperty());
//	
//		
//		
//		// button to set the names and validate them
//		Button enterNamesButton = new Button("Enter Names");
//		GridPane.setConstraints(enterNamesButton, 8, 5); // 6, 3
//		
//		
//		// button to go to champion selection scene
//		Button chooseChampionsButton = new Button("Go to Champion Selection");
//		GridPane.setConstraints(chooseChampionsButton, 8, 6);
//		
//		
//		// setting the layout:: adding all buttons n stuff
//		BackgroundFill background = new BackgroundFill(Color.valueOf("#800000"), new CornerRadii(0), new Insets(0));
//		Background bg = new Background(background);
//		grid.setBackground(bg);
//		grid.getChildren().addAll(backToHomeScreenButton, namesLabel, name1Input, name2Input, enterNamesButton, chooseChampionsButton);
//		
//		//Setting Player's Name's Scene
//		PlayersNameScene = new Scene(grid, 1000, 1000);
//
//		
//		
//		PlayersNameController.playerNameBackButton(backToHomeScreenButton);
//		PlayersNameController.enterNamesButton(enterNamesButton, name1Input, name2Input);
//		PlayersNameController.chooseChampions(chooseChampionsButton, name1Input, name2Input);
	}
	
	public Scene getPlayersNameScene() {
		
		return PlayersNameScene;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
