package views;

import java.io.File;
import java.nio.file.Paths;

import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.world.Direction;
import views.BuiltWindow.GameWindow;
import views.BuiltWindow.GameWindowController;

public class AttackDirectionAlertBox {

	static String s = "src/Resources/RetroImpactHit.mp3";
	public static Media h = new Media(Paths.get(s).toUri().toString());
	
	
	
	public static void display() {
		
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
			
			
			try {
				GameWindow.getGameRound().attack(Direction.UP);
				
				MediaPlayer soundEffect = new MediaPlayer(h);
				soundEffect.play();
				soundEffect.setOnEndOfMedia(new Runnable() {
					
					public void run() {
						
						soundEffect.dispose();
					}
				});
				
			} catch (ChampionDisarmedException e1) {

				AlertBox.display("ChampionDisarmedException", e1.getMessage());
			} catch (NotEnoughResourcesException e1) {

				AlertBox.display("NotEnoughResourcesException", "You do not have enough resources!");
			} catch (InvalidTargetException e1) {

				AlertBox.display("InvalidTargetException", e1.getMessage());
			}
			
		});
		
		down.setOnAction(e -> {
			
			window.close();
			
			
			try {
				GameWindow.getGameRound().attack(Direction.DOWN);
				MediaPlayer soundEffect = new MediaPlayer(h);
				soundEffect.play();
				soundEffect.setOnEndOfMedia(new Runnable() {
					
					public void run() {
						
						soundEffect.dispose();
					}
				});
				
			} catch (ChampionDisarmedException e1) {

				AlertBox.display("ChampionDisarmedException", e1.getMessage());
			} catch (NotEnoughResourcesException e1) {

				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
			} catch (InvalidTargetException e1) {

				AlertBox.display("InvalidTargetException", e1.getMessage());
			}
			
		});
		
		left.setOnAction(e -> {
			
			window.close();
			
			
			try {
				GameWindow.getGameRound().attack(Direction.LEFT);
				MediaPlayer soundEffect = new MediaPlayer(h);
				soundEffect.play();
				soundEffect.setOnEndOfMedia(new Runnable() {
					
					public void run() {
						
						soundEffect.dispose();
					}
				});
				
			} catch (ChampionDisarmedException e1) {

				AlertBox.display("ChampionDisarmedException", e1.getMessage());
			} catch (NotEnoughResourcesException e1) {

				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
			} catch (InvalidTargetException e1) {

				AlertBox.display("InvalidTargetException", e1.getMessage());
			}
			
		});
		
		right.setOnAction(e -> {
			
			window.close();
			
			
			try {
				GameWindow.getGameRound().attack(Direction.RIGHT);
				MediaPlayer soundEffect = new MediaPlayer(h);
				soundEffect.play();
				soundEffect.setOnEndOfMedia(new Runnable() {
					
					public void run() {
						
						soundEffect.dispose();
					}
				});
				
			} catch (ChampionDisarmedException e1) {

				AlertBox.display("ChampionDisarmedException", e1.getMessage());
			} catch (NotEnoughResourcesException e1) {

				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
			} catch (InvalidTargetException e1) {

				AlertBox.display("InvalidTargetException", e1.getMessage());
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
	
	public static void waitOnDirectionBox(String title) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(400);
		
		
		VBox layout = new VBox();
		
		layout.setPadding(new Insets(20,20,20,20));
		layout.setSpacing(10);
		
		
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> window.close());
		
		layout.getChildren().addAll(closeButton);
		
		
		
		Scene scene = new Scene(layout, 500, 200);
		window.setScene(scene);
		window.showAndWait();
		
	
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		
				@Override
				public void handle(KeyEvent event) {
					
					switch(event.getCode()) {
						case UP:
							try {
								GameWindow.getGameRound().attack(Direction.UP);
								MediaPlayer soundEffect = new MediaPlayer(h);
								soundEffect.play();
								soundEffect.setOnEndOfMedia(new Runnable() {
									
									public void run() {
										
										soundEffect.dispose();
									}
								});
								window.close();
							} catch (ChampionDisarmedException e1) {
								AlertBox.display("ChampionDisarmedException", e1.getMessage());
							} catch (NotEnoughResourcesException e1) {
								AlertBox.display("NotEnoughResourcesException", e1.getMessage());
							} catch (InvalidTargetException e1) {
								AlertBox.display("InvalidTargetException", e1.getMessage());
							}
							break;
						case DOWN:
							try {
								GameWindow.getGameRound().attack(Direction.DOWN);
								MediaPlayer soundEffect = new MediaPlayer(h);
								soundEffect.play();
								soundEffect.setOnEndOfMedia(new Runnable() {
									
									public void run() {
										
										soundEffect.dispose();
									}
								});
								window.close();
							} catch (ChampionDisarmedException e1) {
								AlertBox.display("ChampionDisarmedException", e1.getMessage());
							} catch (NotEnoughResourcesException e1) {
								AlertBox.display("NotEnoughResourcesException", e1.getMessage());
							} catch (InvalidTargetException e1) {
								AlertBox.display("InvalidTargetException", e1.getMessage());
							}
							break;
						case LEFT:
							try {
								GameWindow.getGameRound().attack(Direction.LEFT);
								MediaPlayer soundEffect = new MediaPlayer(h);
								soundEffect.play();
								soundEffect.setOnEndOfMedia(new Runnable() {
									
									public void run() {
										
										soundEffect.dispose();
									}
								});
								window.close();
							} catch (ChampionDisarmedException e1) {
								AlertBox.display("ChampionDisarmedException", e1.getMessage());
							} catch (NotEnoughResourcesException e1) {
								AlertBox.display("NotEnoughResourcesException", e1.getMessage());
							} catch (InvalidTargetException e1) {
								AlertBox.display("InvalidTargetException", e1.getMessage());
							}
							break;
						case RIGHT:
							try {
								GameWindow.getGameRound().attack(Direction.RIGHT);
								MediaPlayer soundEffect = new MediaPlayer(h);
								soundEffect.play();
								soundEffect.setOnEndOfMedia(new Runnable() {
									
									public void run() {
										
										soundEffect.dispose();
									}
								});
								window.close();
							} catch (ChampionDisarmedException e1) {
								AlertBox.display("ChampionDisarmedException", e1.getMessage());
							} catch (NotEnoughResourcesException e1) {
								AlertBox.display("NotEnoughResourcesException", e1.getMessage());
							} catch (InvalidTargetException e1) {
								AlertBox.display("InvalidTargetException", e1.getMessage());
							}
							break;
						default: break;
					}
				}
			});
	}
	
	
	
	

	
	
	
}
