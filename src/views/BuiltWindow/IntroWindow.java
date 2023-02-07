package views.BuiltWindow;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import views.Main;

public class IntroWindow {

	
	private final Scene IntroWindow;
	private Scene homeScreenScene;
	
	
	
	public IntroWindow() throws Exception {
		
		//private String Dir = System.getProperty("user.dir");
		
		
		Media media = new Media(new File("src/Resources/MarvelComicsIntro.mp4").toURI().toURL().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);  
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView (mediaPlayer);
		mediaView.setPreserveRatio(true);
		
		VBox root = new VBox();
		root.getChildren().add(mediaView);
		root.setAlignment(Pos.CENTER);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			
			public void run() {
				
				mediaPlayer.dispose();
				
				homeScreenScene = new Scene(new HomeScreenWindow().createContent(), 500, 500);
//				homeScreenScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");
				Main.window.setScene(homeScreenScene);
				Main.window.setFullScreen(true);
			}
		});
		
		
		
		
		
		IntroWindow = new Scene(root,600,400, Color.BLACK);
	}


	
	
	

	public Scene getIntroWindow() {
		return IntroWindow;
	}
	
	public Scene getHomeScreenScene() {

		return homeScreenScene;
	}
	
	
	
}
