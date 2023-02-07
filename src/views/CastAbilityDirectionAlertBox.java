package views;

import java.io.File;

import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.abilities.Ability;
import model.world.Direction;
import views.BuiltWindow.GameWindow;

public class CastAbilityDirectionAlertBox {
	
	
	
	public static void display(Ability ability) {
		
		
		
		Stage window = new Stage();
		
		window.initStyle(StageStyle.TRANSPARENT);
		
		window.setX(1375);
		window.setY(680);
		
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMinWidth(400);
		
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> window.close());
		
		
		
		//BorderPane arrowButtons = new BorderPane();
		GridPane arrowButtons = new GridPane();
		
		Button up = new Button();
			ImageView upImage = new ImageView(new Image(new File("src/Resources/Up.png").toURI().toString(), 100, 0.0, true, true));
			up.setGraphic(upImage);
			up.setPrefSize(12,12);
			up.setBackground(null);
		Button down = new Button();
			ImageView downImage = new ImageView(new Image(new File("src/Resources/Down.png").toURI().toString(), 100, 0.0, true, true));
			down.setGraphic(downImage);
			down.setPrefSize(12,12);
			down.setBackground(null);
		Button left = new Button();
			ImageView leftImage = new ImageView(new Image(new File("src/Resources/Left.png").toURI().toString(), 100, 0.0, true, true));
			left.setGraphic(leftImage);
			left.setPrefSize(12,12);
			left.setBackground(null);
		Button right = new Button();
			ImageView rightImage = new ImageView(new Image(new File("src/Resources/Right.png").toURI().toString(), 100, 0.0, true, true));
			right.setGraphic(rightImage);
			right.setPrefSize(12,12);
			right.setBackground(null);
		Button select = new Button();
			ImageView selectImage = new ImageView(new Image(new File("src/Resources/Center.png").toURI().toString(), 100, 0.0, true, true));
			select.setGraphic(selectImage);
			select.setAlignment(Pos.CENTER);
			select.setPrefSize(12,12);
			select.setBackground(null);
		
			GridPane.setConstraints(up, 	1, 0);
			GridPane.setConstraints(down, 	1, 2);
			GridPane.setConstraints(left, 	0, 1);
			GridPane.setConstraints(right, 	2, 1);
			GridPane.setConstraints(select, 1, 1);
			arrowButtons.setAlignment(Pos.CENTER);
			arrowButtons.setPadding(new Insets(20,20,20,20));
			arrowButtons.getChildren().addAll(up,down,left,right,select);
			
			BackgroundFill background = new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0), new Insets(0));
			Background bg = new Background(background);
			arrowButtons.setBackground(bg);
			
//		arrowButtons.setTop(up);
//		arrowButtons.setBottom(down);
//		arrowButtons.setLeft(left);
//		arrowButtons.setRight(right);
//		arrowButtons.setCenter(select);
//		arrowButtons.setPadding(new Insets(30,30,30,30));
		
		
			up.setOnAction(e -> {
				
				window.close();
				AbilityAlertBox.window.close();
				try {
					GameWindow.getGameRound().castAbility(ability, Direction.UP);
				} catch (AbilityUseException e1) {
					AlertBox.display("AbilityUseException", e1.getMessage());
				} catch (NotEnoughResourcesException e1) {
					AlertBox.display("NotEnoughResourcesException", e1.getMessage());
				} catch (CloneNotSupportedException e1) {
					AlertBox.display("CloneNotSupportedException", e1.getMessage());
				}
			});
			
			down.setOnAction(e -> {
				
				window.close();
				AbilityAlertBox.window.close();
				try {
					GameWindow.getGameRound().castAbility(ability, Direction.DOWN);
				} catch (AbilityUseException e1) {
					AlertBox.display("AbilityUseException", e1.getMessage());
				} catch (NotEnoughResourcesException e1) {
					AlertBox.display("NotEnoughResourcesException", e1.getMessage());
				} catch (CloneNotSupportedException e1) {
					AlertBox.display("CloneNotSupportedException", e1.getMessage());
				}
			});
			
			left.setOnAction(e -> {
				
				window.close();
				AbilityAlertBox.window.close();
				try {
					GameWindow.getGameRound().castAbility(ability, Direction.LEFT);
				} catch (AbilityUseException e1) {
					AlertBox.display("AbilityUseException", e1.getMessage());
				} catch (NotEnoughResourcesException e1) {
					AlertBox.display("NotEnoughResourcesException", e1.getMessage());
				} catch (CloneNotSupportedException e1) {
					AlertBox.display("CloneNotSupportedException", e1.getMessage());
				}
			});
			
			right.setOnAction(e -> {
				
				window.close();
				AbilityAlertBox.window.close();
				try {
					GameWindow.getGameRound().castAbility(ability, Direction.RIGHT);
				} catch (AbilityUseException e1) {
					AlertBox.display("AbilityUseException", e1.getMessage());
				} catch (NotEnoughResourcesException e1) {
					AlertBox.display("NotEnoughResourcesException", e1.getMessage());
				} catch (CloneNotSupportedException e1) {
					AlertBox.display("CloneNotSupportedException", e1.getMessage());
				}
			});
		select.setOnAction(e -> {
			
			window.close();
		});
		
		
		
		
		
		
		
		
		
		
		Scene scene = new Scene(arrowButtons, 370, 370);
		scene.setFill(Color.TRANSPARENT);
		window.setScene(scene);
		window.showAndWait();
	}

	
//	public static void display(String title, Ability ability) {
//		
//		Stage window = new Stage();
//		
//		window.initModality(Modality.APPLICATION_MODAL);
//		window.setTitle(title);
//		window.setMinWidth(400);
//		
//		
//		Button closeButton = new Button("Close the window");
//		closeButton.setOnAction(e -> window.close());
//		
//		
//		
//		
//		BorderPane arrowButtons = new BorderPane();
//		
//		Button up = new Button("Up");
//			//up.setAlignment(Pos.TOP_CENTER);
//		Button down = new Button("down");
//			//down.setAlignment(Pos.BOTTOM_CENTER);
//		Button left = new Button("left");
//			//left.setAlignment(Pos.CENTER_LEFT);
//		Button right = new Button("right");
//			//right.setAlignment(Pos.CENTER_RIGHT);
//		Button select = new Button("       ");
//			//select.setAlignment(Pos.CENTER);	
//		
//		
//		
//		arrowButtons.setTop(up);
//		arrowButtons.setBottom(down);
//		arrowButtons.setLeft(left);
//		arrowButtons.setRight(right);
//		arrowButtons.setCenter(select);
//		
//		
//		
//		up.setOnAction(e -> {
//			
//			window.close();
//			
//			try {
//				GameWindow.getGameRound().castAbility(ability, Direction.UP);
//				
//				
//			} catch (AbilityUseException e1) {
//
//				AlertBox.display("AbilityUseException", e1.getMessage());
//			} catch (NotEnoughResourcesException e1) {
//
//				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
//			} catch (CloneNotSupportedException e1) {
//
//				AlertBox.display("CloneNotSupportedException", e1.getMessage());
//			}
//			
//		});
//		
//		down.setOnAction(e -> {
//			
//			window.close();
//			
//			try {
//				GameWindow.getGameRound().castAbility(ability, Direction.DOWN);
//				
//				
//			} catch (AbilityUseException e1) {
//
//				AlertBox.display("AbilityUseException", e1.getMessage());
//			} catch (NotEnoughResourcesException e1) {
//
//				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
//			} catch (CloneNotSupportedException e1) {
//
//				AlertBox.display("CloneNotSupportedException", e1.getMessage());
//			}
//			
//		});
//		
//		left.setOnAction(e -> {
//			
//			window.close();
//			
//			try {
//				GameWindow.getGameRound().castAbility(ability, Direction.LEFT);
//				
//				
//			} catch (AbilityUseException e1) {
//
//				AlertBox.display("AbilityUseException", e1.getMessage());
//			} catch (NotEnoughResourcesException e1) {
//
//				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
//			} catch (CloneNotSupportedException e1) {
//
//				AlertBox.display("CloneNotSupportedException", e1.getMessage());
//			}
//			
//		});
//		
//		right.setOnAction(e -> {
//			
//			window.close();
//			
//			try {
//				GameWindow.getGameRound().castAbility(ability, Direction.RIGHT);
//				
//				
//			} catch (AbilityUseException e1) {
//
//				AlertBox.display("AbilityUseException", e1.getMessage());
//			} catch (NotEnoughResourcesException e1) {
//
//				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
//			} catch (CloneNotSupportedException e1) {
//
//				AlertBox.display("CloneNotSupportedException", e1.getMessage());
//			}
//			
//		});
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
//		Scene scene = new Scene(arrowButtons, 500, 200);
//		window.setScene(scene);
//		window.showAndWait();
//	}
}
