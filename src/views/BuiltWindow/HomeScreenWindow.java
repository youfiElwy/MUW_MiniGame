package views.BuiltWindow;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import views.Main;

public class HomeScreenWindow {
	
	//private final Scene homeScreenScene;
	
	
	
	static StackPane layout;
	static String s = "src/Resources/Avengers8BitTheme.mp3";
	static Media h = new Media(Paths.get(s).toUri().toString());
	static MediaPlayer backGroundMusic = new MediaPlayer(h);
	
	//backGroundMusic.setCycleCount(AudioClip.INDEFINITE);
	
	static boolean playOrNot = true;
	
	
//	public HomeScreenWindow() {
//		
//		Button playButton = new Button("Play");
//		playButton.setFont(new Font(30));
//		playButton.setMaxWidth(150);
//		playButton.setStyle("-fx-background-color: #ffffff;");
//		//Load Game Button
//		Button loadGame = new Button("Load Game");
//		loadGame.setFont(new Font(30));
//		loadGame.setMaxWidth(250);
//		loadGame.setStyle("-fx-background-color: #ffffff;");
//		
//		//Bonus Button
//		Button bonus = new Button("Bonus");
//		bonus.setFont(new Font(30));
//		bonus.setMaxWidth(150);
//		bonus.setStyle("-fx-background-color: #ffffff;");
//		
//		//Home Screen Layout
//		VBox layout1 = new VBox(20);
//		layout1.getChildren().addAll(playButton, loadGame, bonus);
//		layout1.setAlignment(Pos.CENTER_LEFT);
//		layout1.setPadding(new Insets(10,10,10, 300));
//		
//		
//		BackgroundFill background = new BackgroundFill(Color.valueOf("#800000"), new CornerRadii(0), new Insets(0));
//		Background bg = new Background(background);
//		layout1.setBackground(bg);
//		
////		Image image = new Image("file:///D:/Workspaces/EclipseWorkspace/MarvelGame%20Milestone%202/src/Resources/Marvel-Wallpapers.jpg");
////		//ImageView image = new ImageView(new Image(new File("src/Resources/Marvel-Wallpapers.jpg").toURI().toString()));
////		
////		BackgroundImage bgImage = new BackgroundImage(
////				image,
////				BackgroundRepeat.NO_REPEAT,
////				BackgroundRepeat.NO_REPEAT,
////				BackgroundPosition.CENTER,
////				new BackgroundSize(50,50,true,true,true,false)
////		);
////		
////		Background bg = new Background(bgImage);
////		layout1.setBackground(bg);
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		//Home Screen Scene
//		
//		homeScreenScene = new Scene(layout1, 500, 500);
//		//homeScreenScene.setFill(Color.RED);
//		
//		HomeScreenController.homeScreenWindowStartGameButtonAction(playButton);
//	}
	
	
	public Parent createContent()  {
		
		
		Pane root = new Pane();
		root.setPrefSize(860, 600);
		
		
		
		BackgroundImage backgroundImage = new BackgroundImage(
                new Image(new File("src/Resources/AvengersWallpaper.jpg")
                        .toURI().toString()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(300, 300, true, true, true, true));
		root.setBackground(new Background(backgroundImage));

		
		
		
		
		
		Title title = new Title("MARVEL'S ULTIMATE WAR");
		title.setTranslateX(75);
		title.setTranslateY(200);
		
		MenuItem playButton = new MenuItem("Play");
			playButton.setOnMouseClicked(e -> {
				
				Main.window.setScene(new PlayersNameWindow().getPlayersNameScene());
				Main.window.setFullScreen(true);
			});
			
		MenuItem mPlay = new MenuItem("MPlay");
			mPlay.setOnMouseClicked(e ->{
				
//				String s = "src/Resources/Avengers8BitTheme.mp3";
//				Media h = new Media(Paths.get(s).toUri().toString());
//				backGroundMusic = new MediaPlayer(h);
//				backGroundMusic.play();
				
			});
		
		MenuBox menu = new MenuBox(
				playButton,
				new MenuItem("LOAD GAME"),
				new MenuItem("ONLINE"),
				new MenuItem("JOIN CO-OP"),
				new MenuItem("BONUS"),
				mPlay);
		menu.setTranslateX(100);
		menu.setTranslateY(300);
		
		root.getChildren().addAll(title, menu);
		
		music();
		
		return root;
	}
	
	
	
	
	
	
	
	
	
	public static class Title extends StackPane {
		
		public Title(String name) {
			
			Rectangle bg = new Rectangle(655, 90);
			bg.setStroke(Color.YELLOW);
			bg.setStrokeWidth(2);
			bg.setFill(null);
			
			Text text = new Text(name);
			text.setFill(Color.FIREBRICK);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 70));
			
			
//			text.setFont(new Font(32));
//			text.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-font-weight: bold;");
			

//			String fontString = "src/Resources/PressStart2P-Regular.ttf";
//			Font font = Font.loadFont(new File(fontString).toURI().toString(), 32);
//			text.setFont(font);
//			text.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-font-weight: bold;");

			
			
			
			
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
		}
	}
	
	
	public static class MenuBox extends VBox {
		
		public MenuBox(MenuItem...items ) {
			
			getChildren().add(createSeperator());
			
			for (MenuItem item : items) {
				
				getChildren().addAll(item, createSeperator());
			}
		}
		
		public Line createSeperator() {
			
			Line sep = new Line();
			sep.setEndX(200);
			sep.setStroke(Color.DARKGREY);
			return sep;
		}
		
	}
	
	
	
	
	public static class MenuItem extends StackPane {
		
		public MenuItem(String name) {
			
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] {
					
					new Stop(0, Color.DARKVIOLET),
					new Stop(0.1, Color.BLACK),
					new Stop(0.9, Color.BLACK),
					new Stop(1, Color.DARKVIOLET)
			});
			
			Rectangle bg = new Rectangle(400, 60);
			bg.setOpacity(0.4);		
			
			Text text = new Text(name);
			text.setFill(Color.DARKGREY);
			text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 30));
			
			
//			text.setFont(new Font(22));
//			text.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-font-weight: bold;");
			
//			String fontString = "src/Resources/PressStart2P-Regular.ttf";
//			Font font = Font.loadFont(new File(fontString).toURI().toString(), 32);
//			text.setFont(font);
			
			
			
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
			
			setOnMouseDragEntered(e -> {
				
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
			});
			
			setOnMouseExited(e -> {
				
				bg.setFill(Color.BLACK);
				text.setFill(Color.DARKGREY);
			});
			
			setOnMousePressed(e -> {
				
				bg.setFill(Color.DARKVIOLET);
			});
			
			setOnMouseReleased(e -> {
				
				bg.setFill(gradient);
			});
			
		}
		
	}
	
	
	
//	public Scene getHomeScreenScene() {
//
//		return homeScreenScene;
//	}
	
	
	public static void music() {
		
		backGroundMusic.setCycleCount(AudioClip.INDEFINITE);
		backGroundMusic.setVolume(0.05);
		
		if (playOrNot) {
			backGroundMusic.play();
			
		}
		else {
			backGroundMusic.stop();
		}
	}
	
	
//	HomeScreenWindow.playOrNot = true;
//	HomeScreenWindow.music();
	
//	playOrNot = false;
//	music();
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}
