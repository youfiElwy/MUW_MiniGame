package views;


import java.io.File;
import java.util.ArrayList;
import engine.Game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import views.BuiltWindow.HomeScreenWindow;


public class Main  extends Application {
	
	
//	public static String fontString = "src/Resources/PressStart2P-Regular.ttf";
//	public static Font font = Font.loadFont(fontString, 45);

	
	public static Stage window;
	private Scene IntroWindow;
	
	
	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		window = primaryStage;
		
		Image image = new Image(new File("src/Resources/MarvelUltimate.png").toURI().toString());
		window.getIcons().add(image);
		
		//window.setTitle("Marvels Ultimate War");
		
		window.setTitle("GTA 6");
		

		//window.setScene(new HomeScreenWindow().getHomeScreenScene());
		window.setScene(new views.BuiltWindow.IntroWindow().getIntroWindow());
		window.setFullScreen(true);

		window.show();
		
		
		
	}
	
	
	public Scene getIntroWindow() {
		return IntroWindow;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
