package views.BuiltWindow;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import model.abilities.Ability;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Condition;
import model.world.Cover;
import model.world.Damageable;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;
import views.AlertBox;
import views.ChampNames;
import views.GameMusic;
import views.Main;



public class GameWindow {
	
	public static BorderPane gameLayout;
	
	public static boolean ironmanSLA = false;
	public static boolean lokiSLA = false;

	static Game game, gameRound;
	static Game loadGameCAA;
	static Direction currentSelectedDirection;
	static Damageable currentSelectedTarget;
	static Champion currentChamp;
	static Player firstPlayer;
	static Player secondPlayer;
	static Champion champion1, champion2, champion3, champion4, champion5, champion6;
	
	static ArrayList<Champion> availableChampionsTest;
	static ArrayList<Ability> availableAbilitiesTest;
	
	
	public static Button firstChamp1;
	public static Button firstChamp2;
	public static Button firstChamp3;
	public static Button secondChamp1;
	public static Button secondChamp2;
	public static Button secondChamp3;
	
	public static ArrayList<Button> sideButtons1;
	public static ArrayList<Button> sideButtons2;
	
	
	
	//getters and setters
	public static Game getGame() {
		return game;
	}
	
	public static Game getGameRound() {
		return gameRound;
	}

	public static Direction getCurrentSelectedDirection() {
		return currentSelectedDirection;
	}
	
	public static Damageable getCurrentSelectedTarget() {
		return currentSelectedTarget;
	}

	public static Champion getCurrentChamp() {
		return currentChamp;
	}
	public static void setCurrentChamp(Champion currentChamp) {
		GameWindow.currentChamp = currentChamp;
	}



	static Label one, two, three, four, five, six;
	static Button b0_0, b0_1, b0_2, b0_3, b0_4, 
	b1_0, b1_1, b1_2, b1_3, b1_4,
	b2_0, b2_1, b2_2, b2_3, b2_4, 
	b3_0, b3_1, b3_2, b3_3, b3_4, 
	b4_0, b4_1, b4_2, b4_3, b4_4;
	
	public static Button allBoardButtons[][] = {  {b0_0, b0_1, b0_2, b0_3, b0_4},
			{b1_0, b1_1, b1_2, b1_3, b1_4},
			{b2_0, b2_1, b2_2, b2_3, b2_4},
			{b3_0, b3_1, b3_2, b3_3, b3_4},
			{b4_0, b4_1, b4_2, b4_3, b4_4}  };

	private final Scene currentGameScene;
	
	
	
	
	
	public GameWindow() throws IOException {
		
		Main.window.setResizable(false);
		
		
		firstPlayer = new Player(PlayersNameController.player1Name);
		secondPlayer = new Player(PlayersNameController.player2Name);
		
		game = new Game(firstPlayer, secondPlayer);
		
		
		createChampsPart1();
		
		
		gameRound = new Game(firstPlayer, secondPlayer);
		
		currentChamp = gameRound.getCurrentChampion();
		
		
		
		
		
		
		//top layout that has 2 layouts inside it
		HBox topLayout = new HBox();
		
		//"-fx-border-color: blue; -fx-border-radius: 5;
		
		one = new Label();
			one.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, new CornerRadii(10, 0, 0, 10, true) , Insets.EMPTY)));
			one.setPrefSize(170,50);
			one.setFont(new Font(20));
			one.setStyle("-fx-font-weight: bold; -fx-text-fill: black; -fx-alignment:CENTER;");
		two = new Label();
			two.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			two.setPrefSize(170,50);
			two.setFont(new Font(20));
			two.setStyle("-fx-font-weight: bold; -fx-text-fill: black; -fx-alignment:CENTER;");
		three = new Label();
			three.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			three.setPrefSize(170,50);
			three.setFont(new Font(20));
			three.setStyle("-fx-font-weight: bold; -fx-text-fill: black; -fx-alignment:CENTER;");
		four = new Label();
			four.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			four.setPrefSize(170,50);
			four.setFont(new Font(20));
			four.setStyle("-fx-font-weight: bold; -fx-text-fill: black; -fx-alignment:CENTER;");
		five = new Label();
			five.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			five.setPrefSize(170,50);
			five.setFont(new Font(20));
			five.setStyle("-fx-font-weight: bold; -fx-text-fill: black; -fx-alignment:CENTER;");
		six = new Label();
			six.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, new CornerRadii(0, 10, 10, 0, true), Insets.EMPTY)));
			six.setPrefSize(170,50);
			six.setFont(new Font(20));
			six.setStyle("-fx-font-weight: bold; -fx-text-fill: black; -fx-alignment:CENTER;");
		
		showTurnOrder();
		
		
		topLayout.getChildren().addAll(one, two, three, four, five, six);
		topLayout.setAlignment(Pos.TOP_CENTER);
		//topLayout.setSpacing(10);
		
		
		
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
				//info about currentChamp Layout (ChoiceBox) or smth
		
		
		
		
		
		
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
				//turnorder layout (HBox) or smth
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//left Player 1 layout
		VBox leftLayout = new VBox();
		
		Label player1 = new Label("Player 1: " + gameRound.getFirstPlayer().getName());
			player1.setFont(new Font(40));
			player1.setStyle("-fx-font-weight: bold; -fx-text-fill: midnightblue; -fx-alignment:CENTER; -fx-background-color: navajowhite;");
			
			
		Label player1Leader = new Label("Leader: " + gameRound.getFirstPlayer().getLeader().getName());
			player1Leader.setFont(new Font(26));
			player1Leader.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-alignment:CENTER;");
		
		Button leaderAbility1Status = new Button("Show Leader Ability Status");
			leaderAbility1Status.setStyle("-fx-font-weight: bold; -fx-text-fill: deeppink; -fx-alignment:CENTER; -fx-background-color: lightslategrey;");
		
		firstChamp1 = new Button(gameRound.getFirstPlayer().getTeam().get(0).getName());
			firstChamp1.setBackground(null);
			firstChamp1.setPrefSize(150, 150);
			firstChamp1.setFont(new Font(0));
		firstChamp2 = new Button(gameRound.getFirstPlayer().getTeam().get(1).getName());
			firstChamp2.setBackground(null);
			firstChamp2.setPrefSize(150, 150);
			firstChamp2.setFont(new Font(0));
		firstChamp3 = new Button(gameRound.getFirstPlayer().getTeam().get(2).getName());
			firstChamp3.setBackground(null);
			firstChamp3.setPrefSize(150, 150);
			firstChamp3.setFont(new Font(0));
		
		displayChampImages(gameRound.getFirstPlayer().getTeam().get(0).getName(), firstChamp1);
		displayChampImages(gameRound.getFirstPlayer().getTeam().get(1).getName(), firstChamp2);
		displayChampImages(gameRound.getFirstPlayer().getTeam().get(2).getName(), firstChamp3);
		
		
		sideButtons1 = new ArrayList();
		sideButtons1.add(firstChamp1);
		sideButtons1.add(firstChamp2);
		sideButtons1.add(firstChamp3);
		
		
		
		
		
		
		leftLayout.getChildren().addAll(player1, player1Leader, leaderAbility1Status, firstChamp1, firstChamp2, firstChamp3);
		leftLayout.setSpacing(30);
		leftLayout.setPadding(new Insets(20,20,20,20));
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//right Player 2 layout
		VBox rightLayout = new VBox();
		
		Label player2 = new Label("Player 2: " + gameRound.getSecondPlayer().getName());
			player2.setFont(new Font(40));
			player2.setStyle("-fx-font-weight: bold; -fx-text-fill: crimson; -fx-alignment:CENTER; -fx-background-color: navajowhite;");
		
		Label player2Leader = new Label("Leader: " + gameRound.getSecondPlayer().getLeader().getName());
			player2Leader.setFont(new Font(26));
			player2Leader.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-alignment:CENTER;");
		
		Button leaderAbility2Status = new Button("Show Leader Ability Status");
			leaderAbility2Status.setStyle("-fx-font-weight: bold; -fx-text-fill: deeppink; -fx-alignment:CENTER; -fx-background-color: lightslategrey;");
		
		secondChamp1 = new Button(gameRound.getSecondPlayer().getTeam().get(0).getName());
			secondChamp1.setBackground(null);
			secondChamp1.setPrefSize(150, 150);
			secondChamp1.setFont(new Font(0));
		secondChamp2 = new Button(gameRound.getSecondPlayer().getTeam().get(1).getName());
			secondChamp2.setBackground(null);
			secondChamp2.setPrefSize(150, 150);
			secondChamp2.setFont(new Font(0));
		secondChamp3 = new Button(gameRound.getSecondPlayer().getTeam().get(2).getName());
			secondChamp3.setBackground(null);
			secondChamp3.setPrefSize(150, 150);
			secondChamp3.setFont(new Font(0));
		
		displayChampImages(gameRound.getSecondPlayer().getTeam().get(0).getName(), secondChamp1);
		displayChampImages(gameRound.getSecondPlayer().getTeam().get(1).getName(), secondChamp2);
		displayChampImages(gameRound.getSecondPlayer().getTeam().get(2).getName(), secondChamp3);
		

		sideButtons2 = new ArrayList();
		sideButtons2.add(secondChamp1);
		sideButtons2.add(secondChamp2);
		sideButtons2.add(secondChamp3);
		
		
		rightLayout.getChildren().addAll(player2, player2Leader, leaderAbility2Status, secondChamp1, secondChamp2, secondChamp3);
		rightLayout.setSpacing(30);
		rightLayout.setPadding(new Insets(20,20,20,20));
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//bottom control Buttons layout
		HBox bottomLayout = new HBox();
		
		
		Button endTurnButton = new Button("End Turn");
			endTurnButton.setStyle("-fx-background-color: peachpuff; -fx-text-fill: red; -fx-font-weight: bold; -fx-border-color: violet ; -fx-border-width: 4px;");
		Button leaderAbilityButton = new Button("Leader Ability");
			leaderAbilityButton.setStyle("-fx-background-color: khaki; -fx-text-fill: deeppink; -fx-font-weight: bold; -fx-border-color: violet ; -fx-border-width: 4px;");
		
		Button attackButton = new Button("Attack");
			attackButton.setStyle("-fx-background-color: khaki; -fx-text-fill: deeppink; -fx-font-weight: bold; -fx-border-color: violet ; -fx-border-width: 4px;");
		
		Button moveButton = new Button("Move");
			moveButton.setStyle("-fx-background-color: khaki; -fx-text-fill: coral; -fx-font-weight: bold; -fx-border-color: violet ; -fx-border-width: 4px;");
		
		Button castAbilityButton = new Button("Cast Ability");
			castAbilityButton.setStyle("-fx-background-color: khaki; -fx-text-fill: deeppink; -fx-font-weight: bold; -fx-border-color: violet ; -fx-border-width: 4px;");
		
		
		
			
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
		
//		select.setOnAction(e ->{
//			
//			firstPlayer.getTeam().get(0).setCondition(Condition.INACTIVE);
//		});

		arrowButtons.setTop(up);
		arrowButtons.setBottom(down);
		arrowButtons.setLeft(left);
		arrowButtons.setRight(right);
		arrowButtons.setCenter(select);
		
		
		
		
		bottomLayout.setSpacing(10);
		bottomLayout.setPadding(new Insets(10,10,10,10));
		bottomLayout.setAlignment(Pos.CENTER);
		bottomLayout.getChildren().addAll(endTurnButton, leaderAbilityButton, attackButton, castAbilityButton);	//moveButton
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Center board Layout
		
		GridPane boardLayout = new GridPane();
		
		boardLayout.setPadding(new Insets(10,10,10,10));
		boardLayout.setAlignment(Pos.CENTER);
		
			b0_0 = new Button("00");
				b0_0.setMinSize(175,175);
			b0_1 = new Button("01");
				b0_1.setMinSize(175,175);
			b0_2 = new Button("02");
				b0_2.setMinSize(175,175);
			b0_3 = new Button("03");
				b0_3.setMinSize(175,175);
			b0_4 = new Button("04");
				b0_4.setMinSize(175,175);
			
			b1_0 = new Button("10");
				b1_0.setMinSize(175,175);
			b1_1 = new Button("11");
				b1_1.setMinSize(175,175);
			b1_2 = new Button("12");
				b1_2.setMinSize(175,175);
			b1_3 = new Button("13");
				b1_3.setMinSize(175,175);
			b1_4 = new Button("14");
				b1_4.setMinSize(175,175);
			
			b2_0 = new Button("20");
				b2_0.setMinSize(175,175);
			b2_1 = new Button("21");
				b2_1.setMinSize(175,175);
			b2_2 = new Button("22");
				b2_2.setMinSize(175,175);
			b2_3 = new Button("23");
				b2_3.setMinSize(175,175);
			b2_4 = new Button("24");
				b2_4.setMinSize(175,175);
			
			b3_0 = new Button("30");
				b3_0.setMinSize(175,175);
			b3_1 = new Button("31");
				b3_1.setMinSize(175,175);
			b3_2 = new Button("32");
				b3_2.setMinSize(175,175);
			b3_3 = new Button("33");
				b3_3.setMinSize(175,175);
			b3_4 = new Button("34");
				b3_4.setMinSize(175,175);
			
			b4_0 = new Button("40");
				b4_0.setMinSize(175,175);
			b4_1 = new Button("41");
				b4_1.setMinSize(175,175);
			b4_2 = new Button("42");
				b4_2.setMinSize(175,175);
			b4_3 = new Button("43");
				b4_3.setMinSize(175,175);
			b4_4 = new Button("44");
				b4_4.setMinSize(175,175);
		
			
			GridPane.setConstraints(b4_4, 4,0);
			GridPane.setConstraints(b3_4, 4,1);
			GridPane.setConstraints(b2_4, 4,2);
			GridPane.setConstraints(b1_4, 4,3);
			GridPane.setConstraints(b0_4, 4,4);
			
			GridPane.setConstraints(b4_3, 3,0);
			GridPane.setConstraints(b3_3, 3,1);
			GridPane.setConstraints(b2_3, 3,2);
			GridPane.setConstraints(b1_3, 3,3);
			GridPane.setConstraints(b0_3, 3,4);
			
			GridPane.setConstraints(b4_2, 2,0);
			GridPane.setConstraints(b3_2, 2,1);
			GridPane.setConstraints(b2_2, 2,2);
			GridPane.setConstraints(b1_2, 2,3);
			GridPane.setConstraints(b0_2, 2,4);
		
			GridPane.setConstraints(b4_1, 1,0);
			GridPane.setConstraints(b3_1, 1,1);
			GridPane.setConstraints(b2_1, 1,2);
			GridPane.setConstraints(b1_1, 1,3);
			GridPane.setConstraints(b0_1, 1,4);
			
			GridPane.setConstraints(b4_0, 0,0);
			GridPane.setConstraints(b3_0, 0,1);
			GridPane.setConstraints(b2_0, 0,2);
			GridPane.setConstraints(b1_0, 0,3);
			GridPane.setConstraints(b0_0, 0,4);
		
		
		boardLayout.getChildren().addAll(b0_0, b0_1, b0_2, b0_3, b0_4, 
										b1_0, b1_1, b1_2, b1_3, b1_4,
										b2_0, b2_1, b2_2, b2_3, b2_4, 
										b3_0, b3_1, b3_2, b3_3, b3_4, 
										b4_0, b4_1, b4_2, b4_3, b4_4);
		
		
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// entire Game layout like in photo
		gameLayout = new BorderPane();
		gameLayout.setTop(topLayout);
		//topLayout.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		gameLayout.setLeft(leftLayout);
		//leftLayout.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		gameLayout.setRight(rightLayout);
		//rightLayout.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		gameLayout.setBottom(bottomLayout);
		//bottomLayout.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		gameLayout.setCenter(boardLayout);
		//boardLayout.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		BackgroundFill background = new BackgroundFill(Color.valueOf("#800000"), new CornerRadii(0), new Insets(0));
		Background bg = new Background(background);
		gameLayout.setBackground(bg);
		gameLayout.setPadding(new Insets(20,20,20,20));
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		currentGameScene = new Scene(gameLayout);
		
		currentGameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				switch(event.getCode()) {
					case UP:
						try {
							GameWindow.getGameRound().move(Direction.UP);
						} catch (UnallowedMovementException e1) {
							AlertBox.display("UnallowedMovementException", e1.getMessage());
						} catch (NotEnoughResourcesException e1) {
							AlertBox.display("NotEnoughResourcesException", e1.getMessage());
						}
						break;
					case DOWN:
						try {
							GameWindow.getGameRound().move(Direction.DOWN);
						} catch (UnallowedMovementException e1) {
							AlertBox.display("UnallowedMovementException", e1.getMessage());
						} catch (NotEnoughResourcesException e1) {
							AlertBox.display("NotEnoughResourcesException", e1.getMessage());
						}
						break;
					case LEFT:
						try {
							GameWindow.getGameRound().move(Direction.LEFT);
						} catch (UnallowedMovementException e1) {
							AlertBox.display("UnallowedMovementException", e1.getMessage());
						} catch (NotEnoughResourcesException e1) {
							AlertBox.display("NotEnoughResourcesException", e1.getMessage());
						}
						break;
					case RIGHT:
						try {
							GameWindow.getGameRound().move(Direction.RIGHT);
						} catch (UnallowedMovementException e1) {
							AlertBox.display("UnallowedMovementException", e1.getMessage());
						} catch (NotEnoughResourcesException e1) {
							AlertBox.display("NotEnoughResourcesException", e1.getMessage());
						}
						break;
					default: break;
				}
				
				GameWindow.displayBoardChamps();
				GameWindowController.gameOver();
			}
		});
		
		
		// call method that displays champions on board
		displayBoardChamps();
				
				
				
				
				
		
		//Button methods
		
		GameWindowController.endTurnClicked(endTurnButton);
		GameWindowController.leaderAbilityClicked(leaderAbilityButton);
		GameWindowController.attackClicked(attackButton, currentSelectedDirection);
		GameWindowController.moveClicked(moveButton, currentSelectedDirection);
		
		GameWindowController.castAbilityClicked(castAbilityButton);
		
		GameWindowController.upClicked(up);
		GameWindowController.downClicked(down);
		GameWindowController.leftClicked(left);
		GameWindowController.rightClicked(right);
		
		GameWindowController.boardButtonClicked(b4_4, 4,4);
		GameWindowController.boardButtonClicked(b3_4, 3,4);
		GameWindowController.boardButtonClicked(b2_4, 2,4);
		GameWindowController.boardButtonClicked(b1_4, 1,4);
		GameWindowController.boardButtonClicked(b0_4, 0,4);
		
		GameWindowController.boardButtonClicked(b4_3, 4,3);
		GameWindowController.boardButtonClicked(b3_3, 3,3);
		GameWindowController.boardButtonClicked(b2_3, 2,3);
		GameWindowController.boardButtonClicked(b1_3, 1,3);
		GameWindowController.boardButtonClicked(b0_3, 0,3);
		
		GameWindowController.boardButtonClicked(b4_2, 4,2);
		GameWindowController.boardButtonClicked(b3_2, 3,2);
		GameWindowController.boardButtonClicked(b2_2, 2,2);
		GameWindowController.boardButtonClicked(b1_2, 1,2);
		GameWindowController.boardButtonClicked(b0_2, 0,2);
	
		GameWindowController.boardButtonClicked(b4_1, 4,1);
		GameWindowController.boardButtonClicked(b3_1, 3,1);
		GameWindowController.boardButtonClicked(b2_1, 2,1);
		GameWindowController.boardButtonClicked(b1_1, 1,1);
		GameWindowController.boardButtonClicked(b0_1, 0,1);
		
		GameWindowController.boardButtonClicked(b4_0, 4,0);
		GameWindowController.boardButtonClicked(b3_0, 3,0);
		GameWindowController.boardButtonClicked(b2_0, 2,0);
		GameWindowController.boardButtonClicked(b1_0, 1,0);
		GameWindowController.boardButtonClicked(b0_0, 0,0);
		
		GameWindowController.showLAStatus1Clicked(leaderAbility1Status);
		GameWindowController.showLAStatus2Clicked(leaderAbility2Status);
		
		GameMusic.allMusic();
	}
	
	
	

	public Scene getCurrentGameScene() {
		return currentGameScene;
	}
	
	
	public void createChampsPart1() {
		
		champion1 = createChampionsPart2(ChampSelectionWindow.allNames.get(0));
		champion2 = createChampionsPart2(ChampSelectionWindow.allNames.get(1));
		champion3 = createChampionsPart2(ChampSelectionWindow.allNames.get(2));
		
		champion4 = createChampionsPart2(ChampSelectionWindow.allNames2.get(0));
		champion5 = createChampionsPart2(ChampSelectionWindow.allNames2.get(1));
		champion6 = createChampionsPart2(ChampSelectionWindow.allNames2.get(2));
		
		
		//firstPlayer = new Player(PlayersNameController.player1Name);
		firstPlayer.getTeam().add(champion1);
		firstPlayer.getTeam().add(champion2);
		firstPlayer.getTeam().add(champion3);
		firstPlayer.setLeader(champion1);
		
		//secondPlayer = new Player(PlayersNameController.player2Name);
		secondPlayer.getTeam().add(champion4);
		secondPlayer.getTeam().add(champion5);
		secondPlayer.getTeam().add(champion6);
		secondPlayer.setLeader(champion4);
	}
	
	
//	public static void createChampionsPart2(Champion champion, ChampNames name) {
//		
//		int size = GameWindow.getGame().getAvailableChampions().size();
//		
//		for (int i = 0; i < size; i++) {
//			
//			if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Hero cap = new Hero ("Captain America", 1500,	1000,	6,	80,	1,100);
////				champion = cap;
//				champion = GameWindow.getGame().getAvailableChampions().get(i);
//			}
//		}
//		
//	}
	
	public Champion createChampionsPart2(ChampNames name) {
		
		int size = GameWindow.getGame().getAvailableChampions().size();
		
		for (int i = 0; i < size; i++) {
			
			if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
				
//				Hero cap = new Hero ("Captain America", 1500,	1000,	6,	80,	1,100);
//				champion = cap;
				return GameWindow.getGame().getAvailableChampions().get(i);
			}
		}
		return null;
		
	}
	
	
	
	
//	public Champion createChampionsPart2(Champion champion, ChampNames name) {
//		
//		int size = GameWindow.getGame().getAvailableChampions().size();
//		
//		System.out.println(size);
//		
//		for (int i = 0; i < size; i++) {
//			
//			
//			
//			if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Hero cap = new Hero ("Captain America", 1500,	1000,	6,	80,	1,100);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Villain cap = new Villain ("Electro",	1200	,1200,	5,	75,	3	,110);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Hero cap = new Hero ("Hulk",	2250,	550	,5	,55	,1	,200);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Villain cap = new Villain ("Loki",	1150,	900,	5,	70	,1,	150);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Hero cap = new Hero ("Thor",	1800,	800	,7	,90	,1,	130);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			
//			
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				AntiHero cap = new AntiHero ("Deadpool",	1350,	700,	6,	80,	3,	90);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				AntiHero cap = new AntiHero ("Ghost Rider",	1800,	600	,6,	85,	1	,140);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Hero cap = new Hero ("Iceman",	1000	,900	,5	,65	,2,	120);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Villain cap = new Villain ("Quicksilver",	1200,	650,	8	,99,	1	,70);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				AntiHero cap = new AntiHero ("Venom",	1650,	700,	5,	70,	1,	140);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			
//			
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Hero cap = new Hero ("Dr Strange"	,1100	,1500,	6	,60	,2,	60);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Villain cap = new Villain ("Hela",	1500,	750,	5	,75	,1,	150);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Hero cap = new Hero ("Ironman",	1200,	800	,7	,85,	3,	90);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Hero cap = new Hero ("Spiderman",	1400	,750,	7,	85	,1,	120);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			else if (name.getName().equals(GameWindow.getGame().getAvailableChampions().get(i).getName())) {
//				
////				Villain cap = new Villain ("Yellow Jacket",	1050,	800,	6,	60,	2,	80);
////				champion = cap;
//				return GameWindow.getGame().getAvailableChampions().get(i);
//			}
//			return null;
//		}
//		return null;
//	}
	
	
	
	public static void showTurnOrder() {
		
		ArrayList<Champion> turnOrder = new ArrayList<>();
		ArrayList<Label> labels = new ArrayList<>();
		labels.add(one);
		labels.add(two);
		labels.add(three);
		labels.add(four);
		labels.add(five);
		labels.add(six);
		
		
		for (int i = 0; i < 6; i++) {
			
			labels.get(i).setText("----");
		}
		
		
		while (getGameRound().turnOrder.isEmpty() == false) {
			
			turnOrder.add((Champion) getGameRound().turnOrder.peekMin());
			
			getGameRound().turnOrder.remove();
		}
		
		
		for (int i = 0; i < turnOrder.size(); i++) {
			
			labels.get(i).setText(turnOrder.get(i).getName());
		}
		
		for (int i = 0; i < turnOrder.size(); i++) {
			
			getGameRound().turnOrder.insert(turnOrder.get(i));
			//System.out.println(turnOrder.get(i).getCondition());
		}
		//System.out.println();
		//System.out.println();
	}
	
	
	public static void displayBoardChamps() {
		
		//ArrayList<Button> buttons = new ArrayList<>();
		
//		buttons.add(b0_0);
//		buttons.add(b0_1);
//		buttons.add(b0_2);
//		buttons.add(b0_3);
//		buttons.add(b0_4);
//		
//		buttons.add(b1_0);
//		buttons.add(b1_1);
//		buttons.add(b1_2);
//		buttons.add(b1_3);
//		buttons.add(b1_4);
//		
//		buttons.add(b2_0);
//		buttons.add(b2_1);
//		buttons.add(b2_2);
//		buttons.add(b2_3);
//		buttons.add(b2_4);
//		
//		buttons.add(b3_0);
//		buttons.add(b3_1);
//		buttons.add(b3_2);
//		buttons.add(b3_3);
//		buttons.add(b3_4);
//		
//		buttons.add(b4_0);
//		buttons.add(b4_1);
//		buttons.add(b4_2);
//		buttons.add(b4_3);
//		buttons.add(b4_4);
		
		Button buttons[][] = {  {b0_0, b0_1, b0_2, b0_3, b0_4},
							{b1_0, b1_1, b1_2, b1_3, b1_4},
							{b2_0, b2_1, b2_2, b2_3, b2_4},
							{b3_0, b3_1, b3_2, b3_3, b3_4},
							{b4_0, b4_1, b4_2, b4_3, b4_4}  };
		
		
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < 5; j++) {
				
				
				// make chess board
				if ((i + j) % 2 == 0) {
					
					if (Game.thorsLA == true) {
						buttons[i][j].setBackground(new Background(new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
						buttons[i][j].setGraphic(null);
					}
					else if (Game.flag5ara == true) {
						buttons[i][j].setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
						buttons[i][j].setGraphic(null);
					}
					else if (Game.yellowFlag == true) {
						buttons[i][j].setBackground(new Background(new BackgroundFill(Color.valueOf("#C29200"), CornerRadii.EMPTY, Insets.EMPTY)));
						buttons[i][j].setGraphic(null);
					}
					else {
						buttons[i][j].setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
						buttons[i][j].setGraphic(null);
					}
				}
				else {
					
					if (Game.thorsLA == true) {
						buttons[i][j].setBackground(new Background(new BackgroundFill(Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
						buttons[i][j].setGraphic(null);
					}
					else if (Game.flag5ara == true) {
						buttons[i][j].setBackground(new Background(new BackgroundFill(Color.LIGHTSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
						buttons[i][j].setGraphic(null);
					}
					else if (Game.yellowFlag == true) {
						buttons[i][j].setBackground(new Background(new BackgroundFill(Color.valueOf("#EFFD5F"), CornerRadii.EMPTY, Insets.EMPTY)));
						buttons[i][j].setGraphic(null);
					}
					else {
						buttons[i][j].setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
						buttons[i][j].setGraphic(null);
					}
				}
				
				
				if (GameWindow.getGameRound().getBoard()[i][j] == null) {
					
					buttons[i][j].setGraphic(null);
					buttons[i][j].setStyle(null);
				}
				if (GameWindow.getGameRound().getBoard()[i][j] instanceof Cover) {
					
					//buttons[i][j].setBackground(new Background(new BackgroundFill(Color.GOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
					
					ImageView pictureView = new ImageView(new Image(new File("src/Resources/Cover.png").toURI().toString(), 120, 0.0, true, true));
					buttons[i][j].setGraphic(pictureView);

				}
				if (GameWindow.getGameRound().getBoard()[i][j] instanceof Champion) {
					
					if (GameWindow.getGameRound().getFirstPlayer().getTeam().contains(((Champion) GameWindow.getGameRound().getBoard()[i][j]))) {
						
						//buttons[i][j].setBackground(new Background(new BackgroundFill(Color.PLUM, CornerRadii.EMPTY, Insets.EMPTY)));
						//buttons[i][j].setBorder(new Border());
						buttons[i][j].setStyle( "-fx-border-color: blue; -fx-border-radius: 5;");
					}
					
					else {
						
						//buttons[i][j].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
						buttons[i][j].setStyle( "-fx-border-color: red; -fx-border-radius: 5;");
					}
					
					displayChampImages(( (Champion) GameWindow.getGameRound().getBoard()[i][j]).getName(), buttons[i][j]);
				}
				
			}
		}
		
		
		
	}
	
	public static void displayLokis() {
		
		Button buttons[][] = {  {b0_0, b0_1, b0_2, b0_3, b0_4},
				{b1_0, b1_1, b1_2, b1_3, b1_4},
				{b2_0, b2_1, b2_2, b2_3, b2_4},
				{b3_0, b3_1, b3_2, b3_3, b3_4},
				{b4_0, b4_1, b4_2, b4_3, b4_4}  };
		
		int clones = 0;
		while (clones < 3) {
			
			int lokiX = (int) (Math.random() * 5);
			int lokiY = (int) (Math.random() * 5);
			
			if (GameWindow.getGameRound().getBoard()[lokiX][lokiY] == null) {
				
				ImageView pictureView = new ImageView(new Image(new File("src/Resources/Loki.png").toURI().toString(), 120, 0.0, true, true));
				buttons[lokiX][lokiY].setGraphic(pictureView);
				clones++;
			}
		}
	}
	
	
	
	
	public static void displayChampImages(String name, Button button) {
		
		
		if (name.equals("Captain America")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/CaptainAmerica.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Electro")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/Electro.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Hulk")) {
			
			if (GameWindow.gameRound.getCurrentChampion().getName().equals("Hulk")) {
				
				ImageView pictureView = new ImageView(new Image(new File("src/Resources/Hulk.png").toURI().toString(), 120, 0.0, true, true));
				button.setGraphic(pictureView);
			}
			else {
				ImageView pictureView = new ImageView(new Image(new File("src/Resources/BruceBanner.png").toURI().toString(), 120, 0.0, true, true));
				button.setGraphic(pictureView);
			}
		}
		else if (name.equals("Loki")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/Loki.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Thor")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/Thor.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
			
			if (Game.thorsLA == true) {
				
				BackgroundImage backgroundImage = new BackgroundImage(
		                new Image(new File("src/Resources/lightning.jpg")	//	lightning.jpg	lghtningPNG.png
		                        .toURI().toString()),
		                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
		                new BackgroundSize(100, 100, true, true, true, true));
				button.setBackground(new Background(backgroundImage));
			}
		}
		
		
		else if (name.equals("Deadpool")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/Deadpool.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Ghost Rider")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/GhostRider.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Iceman")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/Iceman.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Quicksilver")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/Quicksilver.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Venom")) {
			
			if (GameWindow.gameRound.getCurrentChampion().getName().equals("Venom")) {
				
				ImageView pictureView = new ImageView(new Image(new File("src/Resources/Venom.png").toURI().toString(), 120, 0.0, true, true));
				button.setGraphic(pictureView);
			}
			else {
				ImageView pictureView = new ImageView(new Image(new File("src/Resources/EddieBrock.png").toURI().toString(), 120, 0.0, true, true));
				button.setGraphic(pictureView);
			}
		}
		
		
		else if (name.equals("Dr Strange")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/DrStrange.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Hela")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/Hela.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Ironman")) {
			
			if (ironmanSLA == true) {
				ImageView pictureView = new ImageView(new Image(new File("src/Resources/HulkBuster.png").toURI().toString(), 120, 0.0, true, true));
				button.setGraphic(pictureView);
			}
			else {
				ImageView pictureView = new ImageView(new Image(new File("src/Resources/Ironman.png").toURI().toString(), 120, 0.0, true, true));
				button.setGraphic(pictureView);
			}
		}
		else if (name.equals("Spiderman")) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/Spiderman.png").toURI().toString(), 120, 0.0, true, true));
			button.setGraphic(pictureView);
		}
		else if (name.equals("Yellow Jacket")) {
			
			if (Game.yellowFlag == true) {
				ImageView pictureView = new ImageView(new Image(new File("src/Resources/YellowJacket.png").toURI().toString(), 30, 0.0, true, true));
				button.setGraphic(pictureView);
			}
			else {
				ImageView pictureView = new ImageView(new Image(new File("src/Resources/YellowJacket.png").toURI().toString(), 120, 0.0, true, true));
				button.setGraphic(pictureView);
			}
		}

		
	}
	
	
	
	public static boolean checkIfAlive(String name) {
		
		boolean isAlive = false;
		
		for (int i = 0; i < gameRound.getFirstPlayer().getTeam().size(); i++) {
			
			if (gameRound.getFirstPlayer().getTeam().get(i).getName().equals(name)) {
				
				if (gameRound.getFirstPlayer().getTeam().get(i).getCurrentHP() > 0) {
					isAlive = true;
					break;
				}
			}
		}
		for (int i = 0; i < gameRound.getSecondPlayer().getTeam().size(); i++) {
			
			if (gameRound.getSecondPlayer().getTeam().get(i).getName().equals(name)) {
				
				if (gameRound.getSecondPlayer().getTeam().get(i).getCurrentHP() > 0) {
					isAlive = true;
					break;
				}
			}
		}
		return isAlive;
	}
	

	
	public static void removeFromSide(String name, Button button) {
		
		if (checkIfAlive(name) == false) {
			
			ImageView pictureView = new ImageView(new Image(new File("src/Resources/Ghost.png").toURI().toString(), 170, 0.0, true, true));
			button.setGraphic(pictureView);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
