package views;

import java.io.File;
import java.nio.file.Paths;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	
	static String s = "src/Resources/Error.mp3";
	public static Media h = new Media(Paths.get(s).toUri().toString());
	
	
	public static void display(String title, String message) {
		
		MediaPlayer soundEffect = new MediaPlayer(h);
		soundEffect.play();
		soundEffect.setOnEndOfMedia(new Runnable() {
			
			public void run() {
				
				soundEffect.dispose();
			}
		});
		
		Stage window = new Stage();
		Image image = new Image(new File("src/Resources/AlertBox.png").toURI().toString());
		window.getIcons().add(image);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(800);
		
		Label label = new Label();
		label.setText(message);
		label.setFont(new Font(24));
		label.setStyle("-fx-background-color: darkgoldenrod; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: snow ; -fx-border-width: 2px;");
		
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> window.close());
		closeButton.setAlignment(Pos.CENTER);
		closeButton.setStyle("-fx-background-color: darkslategrey; -fx-text-fill: red; -fx-font-weight: bold; -fx-border-color: orangered ; -fx-border-width: 4px;");
		closeButton.setFont(new Font(20));
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		BackgroundFill background = new BackgroundFill(Color.ORANGERED, new CornerRadii(0), new Insets(0));
		Background bg = new Background(background);
		layout.setBackground(bg);
		layout.setStyle("-fx-border-color: yellow ; -fx-border-width: 8px;");
		
		
		Scene scene = new Scene(layout, 800, 300);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
