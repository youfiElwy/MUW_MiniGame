package views;

import java.nio.file.Paths;

import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.world.Direction;
import views.BuiltWindow.GameWindow;

public class MoveDirectionAlertBox {
	
	
	static String s1 = "src/Resources/Move.mp3";
	public static Media h1 = new Media(Paths.get(s1).toUri().toString());
	
	
	public static void display(String title) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(400);
		
		
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> window.close());
		
		
		
		
		BorderPane arrowButtons = new BorderPane();
		
		Button up = new Button("Up");
			//up.setAlignment(Pos.TOP_CENTER);
		Button down = new Button("down");
			//down.setAlignment(Pos.BOTTOM_CENTER);
		Button left = new Button("left");
			//left.setAlignment(Pos.CENTER_LEFT);
		Button right = new Button("right");
			//right.setAlignment(Pos.CENTER_RIGHT);
		Button select = new Button("       ");
			//select.setAlignment(Pos.CENTER);	
		
		
		
		arrowButtons.setTop(up);
		arrowButtons.setBottom(down);
		arrowButtons.setLeft(left);
		arrowButtons.setRight(right);
		arrowButtons.setCenter(select);
		
		
		
		up.setOnAction(e -> {
			
			window.close();
			
			try {
				GameWindow.getGameRound().move(Direction.UP);
				
				
			} catch (UnallowedMovementException e1) {
				
				AlertBox.display("UnallowedMovementException", e1.getMessage());
			} catch (NotEnoughResourcesException e1) {
				
				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
			}
			
		});
		
		down.setOnAction(e -> {
			
			window.close();
			
			try {
				GameWindow.getGameRound().move(Direction.DOWN);
				
				
			} catch (UnallowedMovementException e1) {
				
				AlertBox.display("UnallowedMovementException", e1.getMessage());
			} catch (NotEnoughResourcesException e1) {
				
				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
			}
			
		});
		
		left.setOnAction(e -> {
			
			window.close();
			
			try {
				GameWindow.getGameRound().move(Direction.LEFT);
				
				
			} catch (UnallowedMovementException e1) {
				
				AlertBox.display("UnallowedMovementException", e1.getMessage());
			} catch (NotEnoughResourcesException e1) {
				
				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
			}
			
		});
		
		right.setOnAction(e -> {
			
			window.close();
			
			try {
				GameWindow.getGameRound().move(Direction.RIGHT);
				
				
			} catch (UnallowedMovementException e1) {
				
				AlertBox.display("UnallowedMovementException", e1.getMessage());
			} catch (NotEnoughResourcesException e1) {
				
				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
			}
			
		});
		
		
		
		
		
		
		
		
		
		
		Scene scene = new Scene(arrowButtons, 500, 200);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
