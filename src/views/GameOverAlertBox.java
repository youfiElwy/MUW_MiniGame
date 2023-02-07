package views;

import java.io.File;
import java.nio.file.Paths;

import engine.Player;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameOverAlertBox {
	
	
	static String s = "src/Resources/CapGameOver.mp3";
	public static Media cap = new Media(Paths.get(s).toUri().toString());
	
	
	public static void display(Player player) {
		
		GameMusic.gameOver = true;
		
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(3),
						new KeyValue(GameMusic.backGroundMusic.volumeProperty(), 0)));
		timeline.play();
		
		
		MediaPlayer soundEffect = new MediaPlayer(cap);
		soundEffect.setVolume(0.001);
		soundEffect.play();
		soundEffect.setOnEndOfMedia(new Runnable() {
			
			public void run() {
				
				soundEffect.dispose();
			}
		});
		
		Timeline timeline2 = new Timeline(
				new KeyFrame(Duration.seconds(10),
						new KeyValue(soundEffect.volumeProperty(), 0.05)));
		timeline2.play();
		
		
		
		
		
		
		Stage window = new Stage();
		Image image = new Image(new File("src/Resources/MarvelUltimate.png").toURI().toString());
		window.getIcons().add(image);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("GAME OVER");
		window.setMinWidth(600);
		
		
		VBox layout = new VBox();
		
		
		
		Button closeButton = new Button("---Close the window---");
		closeButton.setAlignment(Pos.CENTER);
		closeButton.setStyle("-fx-background-color: darkslategrey; -fx-text-fill: red; -fx-font-weight: bold; -fx-border-color: orangered ; -fx-border-width: 3px;");
		closeButton.setFont(new Font(20));
		closeButton.setOnAction(e -> {
			
			window.close();
			Main.window.close();
		});
		window.setOnCloseRequest(e -> {
			
			window.close();
			Main.window.close();
		});
		
		
		Label label = new Label("The Winner is: " + player.getName() + '!' + " You were inevita-...*turns into dust*");
		label.setAlignment(Pos.CENTER);
		label.setFont(new Font(30));
		label.setStyle("-fx-background-color: bisque; -fx-text-fill: orangered; -fx-font-weight: bold; -fx-border-color: yellow ; -fx-border-width: 6px;");
		
		
		
		BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/Resources/GameOver.gif")
                        .toURI().toString()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(550, 300, true, true, true, true));
		//layout.setBackground(new Background(backgroundImage));
		
		Button gif = new Button();
		gif.setBackground(new Background(backgroundImage));
		gif.setPrefSize(550, 300);
		gif.setStyle("-fx-border-color: yellow ; -fx-border-width: 10px;");
		
		layout.getChildren().addAll(label, closeButton, gif);
		layout.setAlignment(Pos.CENTER);
		BackgroundFill background = new BackgroundFill(Color.LIGHTCORAL, new CornerRadii(0), new Insets(0));
		Background bg = new Background(background);
		layout.setBackground(bg);
		layout.setStyle("-fx-border-color: brown ; -fx-border-width: 15px;");
		
		
		Scene scene = new Scene(layout, 1100, 600);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
