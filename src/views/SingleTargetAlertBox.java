package views;

import java.awt.Point;
import java.io.File;

import exceptions.AbilityUseException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.abilities.Ability;
import model.world.Direction;
import views.BuiltWindow.GameWindow;

public class SingleTargetAlertBox {
	
	static TextField inputLocation;

	public static void display(String title, Ability ability) {
		
		Stage window = new Stage();
		
		Image image = new Image(new File("src/Resources/Target.png").toURI().toString());
		window.getIcons().add(image);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(400);
		
		
		
		
		VBox layout = new VBox();
		
		Button closeButton = new Button("Close the window");
			closeButton.setOnAction(e -> window.close());
			closeButton.setAlignment(Pos.CENTER);
			closeButton.setStyle("-fx-background-color: darkslategrey; -fx-text-fill: red; -fx-border-color: orangered ; -fx-border-width: 2px;");
		
		inputLocation = new TextField();
		inputLocation.setPrefWidth(10);
		
		inputLocation.setPromptText("0-2");
		
		Button castButton = new Button("Cast Ability on ex: 1" + '-' + "3 (location)");
			castButton.setAlignment(Pos.CENTER);
			castButton.setStyle("-fx-background-color: lightgray; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-border-color: cyan ; -fx-border-width: 2px;");
		
		
		layout.getChildren().addAll(inputLocation, castButton, closeButton);
		layout.setAlignment(Pos.CENTER);
		BackgroundFill background = new BackgroundFill(Color.BROWN, new CornerRadii(0), new Insets(0));
		Background bg = new Background(background);
		layout.setBackground(bg);
		
		
		
		
		
		
		castButton.setOnAction(e -> {
			//Point target = takeInput();
			
			String input = inputLocation.getText();
			
			if (inputLocation.getText().length() < 3 || inputLocation.getText().length() > 3) {
				
				AlertBox.display("You have to use the correct format", "for example: 0-1");
			}
			else if (Integer.parseInt(input.substring(0,1)) < 0 || Integer.parseInt(input.substring(0,1)) > 4 ||
					Integer.parseInt(input.substring(2,3)) < 0 || Integer.parseInt(input.substring(2,3)) > 4) {
				
				AlertBox.display("You have to input a location inside the board!", "for example: 0-1");
			}
			else {
			
				int x = Integer.parseInt(input.substring(0,1));
				int y = Integer.parseInt(input.substring(2,3));
				
				
				
				
				window.close();
				
				
				try {
					GameWindow.getGameRound().castAbility(ability, x, y);
					
					
				} catch (AbilityUseException e1) {
	
					AlertBox.display("AbilityUseException", e1.getMessage());
				} catch (NotEnoughResourcesException e1) {
	
					AlertBox.display("NotEnoughResourcesException!", "You do not have enough Resources");
				} catch (InvalidTargetException e1) {
	
					AlertBox.display("InvalidTargetException", e1.getMessage());
				} catch (CloneNotSupportedException e1) {
	
					AlertBox.display("CloneNotSupportedException", e1.getMessage());
				}
			}
			
			AbilityAlertBox.window.close();
		});
		
		
	
		
		
		
		
		
		
		Scene scene = new Scene(layout, 500, 200);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	
	
	public Point takeInput() {
		
		String input = inputLocation.getText();
		
		int y = Integer.parseInt(input.substring(0,1));
		int x = Integer.parseInt(input.substring(2,3));
		
		return new Point(x,y);
	}
	
	
	
//	public static void main(String[] args) {
//		
//		
//		String test = "2_1";
//		
//		System.out.println(Integer.parseInt(test.substring(0,1)) + Integer.parseInt(test.substring(2,3)));
//		
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
