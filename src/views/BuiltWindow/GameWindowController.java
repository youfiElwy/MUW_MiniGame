package views.BuiltWindow;

import java.nio.file.Paths;

import engine.Game;
import engine.Player;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import model.effects.Root;
import model.world.AntiHero;
import model.world.Condition;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;
import views.AbilityAlertBox;
import views.AlertBox;
import views.AttackDirectionAlertBox;
import views.BoardInfoAlertBox;
import views.GameMusic;
import views.GameOverAlertBox;
import views.MoveDirectionAlertBox;
import views.Main;

public class GameWindowController {

	
	static String s = "src/Resources/EndTurn.mp3";
	public static Media h = new Media(Paths.get(s).toUri().toString());
	//MediaPlayer soundEffect = new MediaPlayer(h);
	
	
	public static void endTurnClicked(Button pressed) {
		
		pressed.setOnAction(e -> {
			
			//backTransformation();
			
			GameWindow.gameRound.endTurn();
			MediaPlayer soundEffect = new MediaPlayer(h);
			soundEffect.play();
			GameWindow.currentChamp = GameWindow.gameRound.getCurrentChampion();
			
			//Tarnsformation();
			
			GameWindow.ironmanSLA = false;
			
			
			GameWindow.showTurnOrder();
			GameWindow.displayBoardChamps();
			gameOver();
			
			
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		});
	}
	
	public static void leaderAbilityClicked(Button pressed) {
		
		pressed.setOnAction(e -> {
			
			try {
				GameWindow.gameRound.useLeaderAbility();
				
				
			} catch (LeaderAbilityAlreadyUsedException e1) {

				AlertBox.display("LeaderAbilityAlreadyUsedException", "You can't use your Leader Ability twice");
			} catch (LeaderNotCurrentException e1) {

				AlertBox.display("LeaderNotCurrentException", e1.getMessage());
			}
			//GameWindow.displayBoardChamps();
			gameOver();
			
//			if (Game.flag5ara = false)
//				GameWindow.displayBoardChamps();
		});
	}
	
	public static void attackClicked(Button pressed, Direction d) {
		
		pressed.setOnAction(e -> {
			
			AttackDirectionAlertBox.display();
			//AttackDirectionAlertBox.waitOnDirectionBox("Enter a direction to attack in!");
			GameWindow.displayBoardChamps();
			gameOver();
			
//			try {
//				GameWindow.gameRound.attack(d);
//				
//				
//			} catch (ChampionDisarmedException e1) {
//
//				AlertBox.display("ChampionDisarmedException", e1.getMessage());
//			} catch (NotEnoughResourcesException e1) {
//
//				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
//			} catch (InvalidTargetException e1) {
//
//				AlertBox.display("InvalidTargetException", e1.getMessage());
//			}
		});
	}
	
	public static void moveClicked(Button pressed, Direction d) {
		
		pressed.setOnAction(e -> {
			
			MoveDirectionAlertBox.display("Enter a direction to move to: ");
			GameWindow.displayBoardChamps();
			gameOver();
			
//			try {
//				GameWindow.gameRound.move(d);
//				
//				
//			} catch (UnallowedMovementException e1) {
//
//				AlertBox.display("UnallowedMovementException", e1.getMessage());
//			} catch (NotEnoughResourcesException e1) {
//
//				AlertBox.display("NotEnoughResourcesException", e1.getMessage());
//			}
		});
	}
	
	public static void castAbilityClicked(Button pressed) {
		
		pressed.setOnAction(e -> {
			
			// display a choiceBox with all the available Abilities: (and then call another method that executes whatever the player selected)
			AbilityAlertBox.display(GameWindow.currentChamp.getName());
			GameWindow.displayBoardChamps();
			gameOver();
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void upClicked(Button pressed) {
		
		pressed.setOnAction(e -> {
			
			//System.out.println(GameWindow.currentSelectedDirection);
			GameWindow.currentSelectedDirection = Direction.UP;
			//System.out.println(GameWindow.currentSelectedDirection);
			
			GameWindow.getGameRound().getFirstPlayer().getTeam().clear();
			
//			GameWindow.getGameRound().getFirstPlayer().getTeam().get(0).getAppliedEffects().add(new Root(8));
//			GameWindow.getGameRound().getFirstPlayer().getTeam().get(1).getAppliedEffects().add(new Root(8));
//			GameWindow.getGameRound().getFirstPlayer().getTeam().get(2).getAppliedEffects().add(new Root(8));
			gameOver();
		});
	}
	public static void downClicked(Button pressed) {
		
		pressed.setOnAction(e -> {
			
			System.out.println(GameWindow.currentSelectedDirection);
			GameWindow.currentSelectedDirection = Direction.DOWN;
			System.out.println(GameWindow.currentSelectedDirection);
		});
	}
	public static void leftClicked(Button pressed) {
	
		pressed.setOnAction(e -> {
			
			
			
			System.out.println(GameWindow.currentSelectedDirection);
			GameWindow.currentSelectedDirection = Direction.LEFT;
			System.out.println(GameWindow.currentSelectedDirection);
		});
	}
	public static void rightClicked(Button pressed) {
	
		pressed.setOnAction(e -> {
			System.out.println(GameWindow.currentSelectedDirection);
			GameWindow.currentSelectedDirection = Direction.RIGHT;
			System.out.println(GameWindow.currentSelectedDirection);
		});
	}
	
	
	//									for example:: Button b0_1
	public static void boardButtonClicked(Button pressed, int x, int y) {
		
		pressed.setOnAction(e -> {
			
			// display board Info Alert Box WITH info about specific Button -> if its empty, champion info, cover info
			BoardInfoAlertBox.display("Selected Board Location: ", x, y);
			//pressed.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
		});
	}
	
	
	
	
	public static void gameOver() {
		
		Player player = GameWindow.getGameRound().checkGameOver();
		
		if (player != null) {
			
			//display winning Player -> alertBox and then the close Button closes the entire game!
			GameOverAlertBox.display(player);
		}

	}
	
	
	public static void showLAStatus1Clicked(Button pressed) {
		
		pressed.setOnAction(e -> {
			
			if (GameWindow.getGameRound().isFirstLeaderAbilityUsed() == true) {
				
				String status = "Leader Ability Already Used! --("
						+ GameWindow.getGameRound().getFirstPlayer().getLeader().getName();
				
				if (GameWindow.getGameRound().getFirstPlayer().getLeader() instanceof Hero)
					status = status + "/Hero)--";
				else if (GameWindow.getGameRound().getFirstPlayer().getLeader() instanceof Villain)
					status = status + "/Villain)--";
				else if (GameWindow.getGameRound().getFirstPlayer().getLeader() instanceof AntiHero)
					status = status + "/AntiHero)--";
				
				AlertBox.display("Player 1 Leader Ability Status: ", status);
			}
			else {
				
				String status = "Leader Ability not used! --("
						+ GameWindow.getGameRound().getFirstPlayer().getLeader().getName();
				
				if (GameWindow.getGameRound().getFirstPlayer().getLeader() instanceof Hero)
					status = status + "/Hero)--";
				else if (GameWindow.getGameRound().getFirstPlayer().getLeader() instanceof Villain)
					status = status + "/Villain)--";
				else if (GameWindow.getGameRound().getFirstPlayer().getLeader() instanceof AntiHero)
					status = status + "/AntiHero)--";
				
				AlertBox.display("Player 1 Leader Ability Status: ", status);
			}
		});
	}
	
	public static void showLAStatus2Clicked(Button pressed) {
		
		pressed.setOnAction(e -> {
			
			if (GameWindow.getGameRound().isSecondLeaderAbilityUsed() == true) {
				
					
				String status = "Leader Ability Already Used! --("
						+ GameWindow.getGameRound().getSecondPlayer().getLeader().getName();
					
				if (GameWindow.getGameRound().getSecondPlayer().getLeader() instanceof Hero)
					status = status + "/Hero)--";
				else if (GameWindow.getGameRound().getSecondPlayer().getLeader() instanceof Villain)
					status = status + "/Villain)--";
				else if (GameWindow.getGameRound().getSecondPlayer().getLeader() instanceof AntiHero)
					status = status + "/AntiHero)--";
				
				AlertBox.display("Player 2 Leader Ability Status: ", status);
			}
			else {
				
				String status = "Leader Ability not used! --("
						+ GameWindow.getGameRound().getSecondPlayer().getLeader().getName();
				
				if (GameWindow.getGameRound().getSecondPlayer().getLeader() instanceof Hero)
					status = status + "/Hero)--";
				else if (GameWindow.getGameRound().getSecondPlayer().getLeader() instanceof Villain)
					status = status + "/Villain)--";
				else if (GameWindow.getGameRound().getSecondPlayer().getLeader() instanceof AntiHero)
					status = status + "/AntiHero)--";
				
				AlertBox.display("Player 2 Leader Ability Status: ", status);
			}
		});
	}
	
	
	
	
	public static void backTransformation() {
		
		if (GameWindow.gameRound.getCurrentChampion().getName().equals("Hulk")) {
			
			
		}
	}
	
	public static void Tarnsformation() {
		
		
	}
	
	public static void specialLeader() {
		
		
	}
	
	
	
	
	
}
