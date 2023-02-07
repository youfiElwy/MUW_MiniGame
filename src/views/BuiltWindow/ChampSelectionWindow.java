package views.BuiltWindow;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import engine.Game;
import engine.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Hero;
import model.world.Villain;
import views.AlertBox;
import views.ChampNames;
import views.Main;

public class ChampSelectionWindow {
	
	static String s = "src/Resources/ChampSelection.mp3";
	static Media h = new Media(Paths.get(s).toUri().toString());

	TextField nameInput1, nameInput2;
	TableView<ChampNames> player1Champs, player2Champs;
	Button submitChamps;
	
	static Player firstPlayer, secondPlayer;
	static Game game;
	static ObservableList<ChampNames> allNames;
	static ObservableList<ChampNames> allNames2;
	
	Label typeLabel, nameLabel, maxHPLabel ,manaLabel, actionsLabel,
	speedLabel, damageLabel, rangeLabel, ab1Label, ab2Label, ab3Label;
	
	static Label typeLabelAnswer, nameLabelAnswer, maxHPLabelAnswer, manaLabelAnswer, actionsLabelAnswer,
	speedLabelAnswer, damageLabelAnswer, rangeLabelAnswer, ab1LabelAnswer, ab2LabelAnswer, ab3LabelAnswer;
	 
	private final Scene ChampSelectionScene;
	
	
	public ChampSelectionWindow() {
		
		// do this later
		//AlertBox.display("Tip", "Each Player will take turns choosing their Champion by starting with their Leader." + "\n" +  "Player 1 starts!");
		

		// main layout that has the buttons and the champ pic and stats
		
					AnchorPane anchorpane = new AnchorPane();
					
					// Bottom left layout with buttons
					TilePane championTilePane = new TilePane();
					
						Button cap = new Button();
							cap.setMinSize(180, 180);
							ImageView pictureView1 = new ImageView(new Image(new File("src/Resources/CaptainAmerica.png").toURI().toString(), 150, 0.0, true, true));
							cap.setGraphic(pictureView1);
							cap.setBackground(null);
						Button Electro = new Button();
							Electro.setMinSize(180, 180);
							ImageView pictureView2 = new ImageView(new Image(new File("src/Resources/Electro.png").toURI().toString(), 150, 0.0, true, true));
							Electro.setGraphic(pictureView2);
							Electro.setBackground(null);
						Button Hulk = new Button();
							Hulk.setMinSize(180, 180);
							ImageView pictureView3 = new ImageView(new Image(new File("src/Resources/Hulk.png").toURI().toString(), 150, 0.0, true, true));
							Hulk.setGraphic(pictureView3);
							Hulk.setBackground(null);
						Button Loki = new Button();
							Loki.setMinSize(180, 180);
							ImageView pictureView4 = new ImageView(new Image(new File("src/Resources/Loki.png").toURI().toString(), 150, 0.0, true, true));
							Loki.setGraphic(pictureView4);
							Loki.setBackground(null);
						Button Thor = new Button();
							Thor.setMinSize(180, 180);
							ImageView pictureView5 = new ImageView(new Image(new File("src/Resources/Thor.png").toURI().toString(), 150, 0.0, true, true));
							Thor.setGraphic(pictureView5);
							Thor.setBackground(null);
							
				
						Button Deadpool = new Button();
							Deadpool.setMinSize(180, 180);
							ImageView pictureView6 = new ImageView(new Image(new File("src/Resources/Deadpool.png").toURI().toString(), 150, 0.0, true, true));
							Deadpool.setGraphic(pictureView6);
							Deadpool.setBackground(null);
						Button GhostRider = new Button();
							GhostRider.setMinSize(180, 180);
							ImageView pictureView7 = new ImageView(new Image(new File("src/Resources/GhostRider.png").toURI().toString(), 150, 0.0, true, true));
							GhostRider.setGraphic(pictureView7);
							GhostRider.setBackground(null);
						Button Iceman = new Button();
							Iceman.setMinSize(180, 180);
							ImageView pictureView8 = new ImageView(new Image(new File("src/Resources/Iceman.png").toURI().toString(), 150, 0.0, true, true));
							Iceman.setGraphic(pictureView8);
							Iceman.setBackground(null);
						Button Quicksilver = new Button();
							Quicksilver.setMinSize(180, 180);
							ImageView pictureView9 = new ImageView(new Image(new File("src/Resources/Quicksilver.png").toURI().toString(), 150, 0.0, true, true));
							Quicksilver.setGraphic(pictureView9);
							Quicksilver.setBackground(null);
						Button Venom = new Button();
							Venom.setMinSize(180, 180);
							ImageView pictureView10 = new ImageView(new Image(new File("src/Resources/Venom.png").toURI().toString(), 150, 0.0, true, true));
							Venom.setGraphic(pictureView10);
							Venom.setBackground(null);
							
				
						Button Strange = new Button();
							Strange.setMinSize(180, 180);
							ImageView pictureView11 = new ImageView(new Image(new File("src/Resources/DrStrange.png").toURI().toString(), 150, 0.0, true, true));
							Strange.setGraphic(pictureView11);
							Strange.setBackground(null);
						Button Hela = new Button();
							Hela.setMinSize(180, 180);
							ImageView pictureView12 = new ImageView(new Image(new File("src/Resources/Hela.png").toURI().toString(), 150, 0.0, true, true));
							Hela.setGraphic(pictureView12);
							Hela.setBackground(null);
						Button Ironman = new Button();
							Ironman.setMinSize(180, 180);
							ImageView pictureView13 = new ImageView(new Image(new File("src/Resources/Ironman.png").toURI().toString(), 150, 0.0, true, true));
							Ironman.setGraphic(pictureView13);
							Ironman.setBackground(null);
						Button Spiderman = new Button();
							Spiderman.setMinSize(180, 180);
							ImageView pictureView14 = new ImageView(new Image(new File("src/Resources/Spiderman.png").toURI().toString(), 150, 0.0, true, true));
							Spiderman.setGraphic(pictureView14);
							Spiderman.setBackground(null);
						Button YellowJacket = new Button();
							YellowJacket.setMinSize(180, 180);
							ImageView pictureView15 = new ImageView(new Image(new File("src/Resources/YellowJacket.png").toURI().toString(), 150, 0.0, true, true));
							YellowJacket.setGraphic(pictureView15);
							YellowJacket.setBackground(null);
						
						championTilePane.setPadding(new Insets(10,10,10,10));
						championTilePane.setHgap(10);
						championTilePane.setVgap(10);
						championTilePane.getChildren().addAll(cap, Electro, Hulk, Loki, Thor,
								Deadpool, GhostRider, Iceman, Quicksilver, Venom,
								Strange, Hela, Ironman, Spiderman, YellowJacket);
						
						
						
						   
						
					// top layout for the champions of 1 Player
					player1Champs = new TableView();
					player1Champs.setMaxHeight(200);
					
					//Player 1 column
					TableColumn<ChampNames, String> player1Column = new TableColumn("Player 1: ");
					player1Column.setStyle("-fx-background-color: burlywood");
					player1Column.setMinWidth(250);
					player1Column.setCellValueFactory(new PropertyValueFactory<>("name"));
					
					player1Champs.setItems(getChampNames());
					
					player1Champs.getColumns().add(player1Column);
					
					
					nameInput1 = new TextField();
					nameInput1.setPromptText("Champion Name");
					nameInput1.setMinWidth(125);
					nameInput1.setStyle("-fx-background-color: navy; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: yellow ; -fx-border-width: 4px;");
					
					//Button
					Button addButton1 = new Button("Add");
						addButton1.setOnAction(e -> add1ButtonClicked());
						addButton1.setStyle("-fx-background-color: lightslategrey; -fx-text-fill: ivory; -fx-font-weight: bold;");
					Button deleteButton1 = new Button("Delete");
						deleteButton1.setOnAction(e -> delete1ButtonClicked());
						deleteButton1.setStyle("-fx-background-color: lightslategrey; -fx-text-fill: ivory; -fx-font-weight: bold;");

					HBox hBox1 = new HBox();
					hBox1.setPadding(new Insets(10,10,10,10));
					hBox1.setSpacing(10);
					hBox1.getChildren().addAll(nameInput1, addButton1, deleteButton1);
					
					
					VBox table1VBox = new VBox();
					table1VBox.getChildren().addAll(player1Champs, hBox1);
					table1VBox.setPadding(new Insets(20,10,10,10));
					
					player1Champs.setStyle("-fx-background-color: orangered; -fx-selection-bar: blue; -fx-selection-bar-non-focused: lightskyblue;");
					
					
					
					// top layout for the champions of 2 Player
					player2Champs = new TableView();
					player2Champs.setMaxHeight(200);
					
					//Player 2 column
					TableColumn<ChampNames, String> player2Column = new TableColumn("Player 2: ");
					player2Column.setStyle("-fx-background-color: burlywood");
					player2Column.setMinWidth(250);
					player2Column.setCellValueFactory(new PropertyValueFactory<>("name"));
					
					player2Champs.setItems(getChampNames2());
					
					player2Champs.getColumns().add(player2Column);
					
					nameInput2 = new TextField();
					nameInput2.setPromptText("Champion Name");
					nameInput2.setMinWidth(125);
					nameInput2.setStyle("-fx-background-color: darkred; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: yellow ; -fx-border-width: 4px;");
					
					
					
					
					
					
					//Button
					Button addButton2 = new Button("Add");
						addButton2.setOnAction(e -> add2ButtonClicked());
						addButton2.setStyle("-fx-background-color: lightslategrey; -fx-text-fill: ivory; -fx-font-weight: bold;");
					Button deleteButton2 = new Button("Delete");
						deleteButton2.setOnAction(e -> delete2ButtonClicked());
						deleteButton2.setStyle("-fx-background-color: lightslategrey; -fx-text-fill: ivory; -fx-font-weight: bold;");
					
					HBox hBox2 = new HBox();
					hBox2.setPadding(new Insets(10,10,10,10));
					hBox2.setSpacing(10);
					hBox2.getChildren().addAll(nameInput2, addButton2, deleteButton2);
					
					
					
					VBox table2VBox = new VBox();
					table2VBox.getChildren().addAll(player2Champs, hBox2);
					table2VBox.setPadding(new Insets(20,10,10,10));			
					
					player2Champs.setStyle("-fx-background-color: orangered; -fx-selection-bar: red; -fx-selection-bar-non-focused: tomato;");
					
					
					
					
					
					// submit champs Button
					submitChamps = new Button("Generate the Champions");
						submitChamps.setStyle("-fx-background-color: teal; -fx-text-fill: white; -fx-font-weight: bold;");
						submitChamps.setFont(new Font(20));
						submitChamps.setOnAction(e -> submitButtonClicked());
						
					Button backButton = new Button("Back");
						backButton.setStyle("-fx-background-color: darkslategrey; -fx-text-fill: red; -fx-font-weight: bold; -fx-border-color: orangered ; -fx-border-width: 4px;");
						backButton.setFont(new Font(20));
						backButton.setOnAction(e -> {
							
							Main.window.setScene(new PlayersNameWindow().getPlayersNameScene());
							Main.window.setFullScreen(true);
						});
						
						
					Button startGameButton = new Button("StartGame");
						startGameButton.setFont(new Font(25));
						startGameButton.setStyle("-fx-background-color: mediumseagreen; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: lime ; -fx-border-width: 4px;");
						
						
						
					 typeLabel = new Label		("Type:");
						typeLabel.setMinSize(50, 50);
						typeLabel.setFont(new Font(40));
						
						//typeLabel.setTextFill(Color.web("#D2AC47",1.0));
						
						typeLabel.setTextFill(Color.GOLD);
					 nameLabel = new Label		("Name:");
						nameLabel.setMinSize(50, 50);
						nameLabel.setFont(new Font(40));
						nameLabel.setTextFill(Color.GOLD);
					 maxHPLabel = new Label	("Maximum HP:");
						maxHPLabel.setMinSize(50, 50);
						maxHPLabel.setFont(new Font(40));
						maxHPLabel.setTextFill(Color.GOLD);
					 manaLabel = new Label		("Mana:");
						manaLabel.setMinSize(50, 50);
						manaLabel.setFont(new Font(40));
						manaLabel.setTextFill(Color.GOLD);
					 actionsLabel = new Label	("Actions:");
						actionsLabel.setMinSize(50, 50);
						actionsLabel.setFont(new Font(40));
						actionsLabel.setTextFill(Color.GOLD);
					 speedLabel = new Label	("Speed:");
						speedLabel.setMinSize(50, 50);
						speedLabel.setFont(new Font(40));
						speedLabel.setTextFill(Color.GOLD);
					 damageLabel = new Label	("Attack Damage:");
						damageLabel.setMinSize(50, 50);
						damageLabel.setFont(new Font(40));
						damageLabel.setTextFill(Color.GOLD);
					 rangeLabel = new Label	("Attack Range:");
						rangeLabel.setMinSize(50, 50);
						rangeLabel.setFont(new Font(40));
						rangeLabel.setTextFill(Color.GOLD);
					 ab1Label = new Label		("Abiliyty 1:");
						ab1Label.setMinSize(50, 50);
						ab1Label.setFont(new Font(40));
						ab1Label.setTextFill(Color.GOLD);
					 ab2Label = new Label		("Ability 2:");
						ab2Label.setMinSize(50, 50);
						ab2Label.setFont(new Font(40));
						ab2Label.setTextFill(Color.GOLD);
					 ab3Label = new Label		("Ability 3:");
						ab3Label.setMinSize(50, 50);
						ab3Label.setFont(new Font(40));
						ab3Label.setTextFill(Color.GOLD);

					VBox stats = new VBox();
					stats.setPadding(new Insets(10,10,10,10));
					stats.setSpacing(8);
					stats.getChildren().addAll(typeLabel, nameLabel, maxHPLabel ,manaLabel, actionsLabel,
							speedLabel, damageLabel, rangeLabel, ab1Label, ab2Label, ab3Label);
						
					
					
				 typeLabelAnswer = new Label();
					typeLabelAnswer.setMinSize(50, 50);
					typeLabelAnswer.setFont(new Font(40));
					typeLabelAnswer.setTextFill(Color.GOLDENROD);
				 nameLabelAnswer = new Label();
					nameLabelAnswer.setMinSize(50, 50);
					nameLabelAnswer.setFont(new Font(40));
					nameLabelAnswer.setTextFill(Color.GOLDENROD);
				 maxHPLabelAnswer = new Label();
					maxHPLabelAnswer.setMinSize(50, 50);
					maxHPLabelAnswer.setFont(new Font(40));
					maxHPLabelAnswer.setTextFill(Color.GOLDENROD);
				 manaLabelAnswer = new Label();
					manaLabelAnswer.setMinSize(50, 50);
					manaLabelAnswer.setFont(new Font(40));
					manaLabelAnswer.setTextFill(Color.GOLDENROD);
				 actionsLabelAnswer = new Label();
					actionsLabelAnswer.setMinSize(50, 50);
					actionsLabelAnswer.setFont(new Font(40));
					actionsLabelAnswer.setTextFill(Color.GOLDENROD);
				 speedLabelAnswer = new Label();
					speedLabelAnswer.setMinSize(50, 50);
					speedLabelAnswer.setFont(new Font(40));
					speedLabelAnswer.setTextFill(Color.GOLDENROD);
				 damageLabelAnswer = new Label();
					damageLabelAnswer.setMinSize(50, 50);
					damageLabelAnswer.setFont(new Font(40));
					damageLabelAnswer.setTextFill(Color.GOLDENROD);
				 rangeLabelAnswer = new Label();
				 	rangeLabelAnswer.setMinSize(50, 50);
					rangeLabelAnswer.setFont(new Font(40));
					rangeLabelAnswer.setTextFill(Color.GOLDENROD);
				 ab1LabelAnswer = new Label();
					ab1LabelAnswer.setMinSize(50, 50);
					ab1LabelAnswer.setFont(new Font(40));
					ab1LabelAnswer.setTextFill(Color.GOLDENROD);
				 ab2LabelAnswer = new Label();
					ab2LabelAnswer.setMinSize(50, 50);
					ab2LabelAnswer.setFont(new Font(40));
					ab2LabelAnswer.setTextFill(Color.GOLDENROD);
				 ab3LabelAnswer = new Label();
					ab3LabelAnswer.setMinSize(50, 50);
					ab3LabelAnswer.setFont(new Font(40));
					ab3LabelAnswer.setTextFill(Color.GOLDENROD);
						
				VBox statsAnswer = new VBox();
				statsAnswer.setPadding(new Insets(10,10,10,10));
				statsAnswer.setSpacing(8);
				statsAnswer.getChildren().addAll(typeLabelAnswer, nameLabelAnswer, maxHPLabelAnswer, manaLabelAnswer, actionsLabelAnswer,
						speedLabelAnswer, damageLabelAnswer, rangeLabelAnswer, ab1LabelAnswer, ab2LabelAnswer, ab3LabelAnswer);
						
				
				BackgroundFill background = new BackgroundFill(Color.valueOf("#800000"), new CornerRadii(0), new Insets(0));
				Background bg = new Background(background);
				anchorpane.setBackground(bg);
						
						
					anchorpane.getChildren().addAll(championTilePane, table1VBox, table2VBox,submitChamps, backButton, stats, statsAnswer, startGameButton);
					AnchorPane.setBottomAnchor(championTilePane, 25.0);
					AnchorPane.setTopAnchor(table1VBox, 0.0);
					AnchorPane.setLeftAnchor(table2VBox, 400.0);
					AnchorPane.setLeftAnchor(submitChamps, 800.0);
					AnchorPane.setTopAnchor(submitChamps, 30.0);
					AnchorPane.setLeftAnchor(backButton, 800.0);
					AnchorPane.setTopAnchor(backButton, 80.0);
					AnchorPane.setRightAnchor(stats, 580.0);
					AnchorPane.setBottomAnchor(stats, 70.0);
					AnchorPane.setLeftAnchor(statsAnswer, 1400.0);
					AnchorPane.setBottomAnchor(statsAnswer, 70.0);
					AnchorPane.setLeftAnchor(startGameButton, 800.0);
					AnchorPane.setTopAnchor(startGameButton, 140.0);
					
					
					ChampSelectionScene = new Scene(anchorpane);
					
					
					ChampSelectionController.capPressed(cap, nameInput1, nameInput2);
					ChampSelectionController.electroPressed(Electro, nameInput1, nameInput2);
					ChampSelectionController.hulkPressed(Hulk, nameInput1, nameInput2);
					ChampSelectionController.lokiPressed(Loki, nameInput1, nameInput2);
					ChampSelectionController.thorPressed(Thor, nameInput1, nameInput2);
					
					ChampSelectionController.deadPoolPressed(Deadpool, nameInput1, nameInput2);
					ChampSelectionController.ghostRiderPressed(GhostRider, nameInput1, nameInput2);
					ChampSelectionController.icemanPressed(Iceman, nameInput1, nameInput2);
					ChampSelectionController.quicksilverPressed(Quicksilver, nameInput1, nameInput2);
					ChampSelectionController.venomPressed(Venom, nameInput1, nameInput2);
					
					ChampSelectionController.strangePressed(Strange, nameInput1, nameInput2);
					ChampSelectionController.helaPressed(Hela, nameInput1, nameInput2);
					ChampSelectionController.ironmanPressed(Ironman, nameInput1, nameInput2);
					ChampSelectionController.spidermanPressed(Spiderman, nameInput1, nameInput2);
					ChampSelectionController.yellowJacketPressed(YellowJacket, nameInput1, nameInput2);

				
					
					cap.setOnMousePressed(e -> {
						cap.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					cap.setOnMouseReleased(e -> {
						cap.setBackground(null);
					});
					
					Electro.setOnMousePressed(e -> {
						Electro.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Electro.setOnMouseReleased(e -> {
						Electro.setBackground(null);
					});
					
					Hulk.setOnMousePressed(e -> {
						Hulk.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Hulk.setOnMouseReleased(e -> {
						Hulk.setBackground(null);
					});
					
					Loki.setOnMousePressed(e -> {
						Loki.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Loki.setOnMouseReleased(e -> {
						Loki.setBackground(null);
					});
					
					Deadpool.setOnMousePressed(e -> {
						Deadpool.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Deadpool.setOnMouseReleased(e -> {
						Deadpool.setBackground(null);
					});
					

					
					
					GhostRider.setOnMousePressed(e -> {
						GhostRider.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					GhostRider.setOnMouseReleased(e -> {
						GhostRider.setBackground(null);
					});
					
					Iceman.setOnMousePressed(e -> {
						Iceman.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Iceman.setOnMouseReleased(e -> {
						Iceman.setBackground(null);
					});
					
					Quicksilver.setOnMousePressed(e -> {
						Quicksilver.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Quicksilver.setOnMouseReleased(e -> {
						Quicksilver.setBackground(null);
					});
					
					Venom.setOnMousePressed(e -> {
						Venom.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Venom.setOnMouseReleased(e -> {
						Venom.setBackground(null);
					});
					
					Strange.setOnMousePressed(e -> {
						Strange.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Strange.setOnMouseReleased(e -> {
						Strange.setBackground(null);
					});
					
//					cap, Electro, Hulk, Loki, Thor, Deadpool, GhostRider, Iceman, Quicksilver, Venom, Strange, Hela, Ironman, Spiderman, YellowJacket

					
					Hela.setOnMousePressed(e -> {
						Hela.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Hela.setOnMouseReleased(e -> {
						Hela.setBackground(null);
					});
					
					Ironman.setOnMousePressed(e -> {
						Ironman.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Ironman.setOnMouseReleased(e -> {
						Ironman.setBackground(null);
					});
					
					Spiderman.setOnMousePressed(e -> {
						Spiderman.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Spiderman.setOnMouseReleased(e -> {
						Spiderman.setBackground(null);
					});
					
					YellowJacket.setOnMousePressed(e -> {
						YellowJacket.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					YellowJacket.setOnMouseReleased(e -> {
						YellowJacket.setBackground(null);
					});
					
					Thor.setOnMousePressed(e -> {
						Thor.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(50, 50, 50, 50, true) , Insets.EMPTY)));
						championSelected();
					});
					Thor.setOnMouseReleased(e -> {
						Thor.setBackground(null);
					});
					
					
					
					ChampSelectionController.startGameClicked(startGameButton);
	}


	
	
	public Scene getChampSelectionScene() {
		return ChampSelectionScene;
	}
	
	
	public ObservableList<ChampNames> getChampNames(){
		
		ObservableList<ChampNames> champNames = FXCollections.observableArrayList();
		
		champNames.add(new ChampNames("Ironman"));
		champNames.add(new ChampNames("Thor"));
		champNames.add(new ChampNames("Captain America"));
		
		return champNames;
	}
	public ObservableList<ChampNames> getChampNames2(){
		
		ObservableList<ChampNames> champNames = FXCollections.observableArrayList();
		
		champNames.add(new ChampNames("Loki"));
		champNames.add(new ChampNames("Hulk"));
		champNames.add(new ChampNames("Venom"));
		
		return champNames;
	}
	
	
	public void add1ButtonClicked() {
		
		boolean alreadySelected = false;
		
		ChampNames name = new ChampNames();
		name.setName(nameInput1.getText());
		
		ObservableList<ChampNames> allNames;
		allNames = player1Champs.getItems();
		ObservableList<ChampNames> allNames2;
		allNames2 = player2Champs.getItems();
		
		for (int i = 0; i < allNames.size(); i++) {
			
			if (allNames.get(i).getName().equals(name.getName())) {
				
				alreadySelected = true;
				break;
			}
		}
		for (int i = 0; i < allNames2.size(); i++) {
			
			if (allNames2.get(i).getName().equals(name.getName())) {
				
				alreadySelected = true;
				break;
			}
		}
		
		
		if (alreadySelected == true)
			AlertBox.display("Champion already selected", "You have to select another champion");
		
		else if (player1Champs.getItems().size() >= 3) {
			AlertBox.display("Champion Selection Error", "You have already selected 3 champions");
		}
		else {
			player1Champs.getItems().add(name);
			nameInput1.clear();
		}
			
	}
	public void delete1ButtonClicked() {
		
		ObservableList<ChampNames> nameSelected, allNames;
		allNames = player1Champs.getItems();
		// gets items that user has selected
		nameSelected = player1Champs.getSelectionModel().getSelectedItems();
		nameSelected.forEach(allNames:: remove);
	}
	
	public void add2ButtonClicked() {
		
		boolean alreadySelected = false;
		
		ChampNames name = new ChampNames();
		name.setName(nameInput2.getText());
		
		ObservableList<ChampNames> allNames;
		allNames = player1Champs.getItems();
		ObservableList<ChampNames> allNames2;
		allNames2 = player2Champs.getItems();
		
		
		
		for (int i = 0; i < allNames2.size(); i++) {
			
			if (allNames2.get(i).getName().equals(name.getName())) {
				
				alreadySelected = true;
				break;
			}
		}
		for (int i = 0; i < allNames.size(); i++) {
			
			if (allNames.get(i).getName().equals(name.getName())) {
				
				alreadySelected = true;
				break;
			}
		}
		
		
		if (alreadySelected == true)
			AlertBox.display("Champion already selected", "You have to select another champion");
		
		else if (player2Champs.getItems().size() >= 3) {
			AlertBox.display("Champion Selection Error", "You have already selected 3 champions");
		}
		else {
			player2Champs.getItems().add(name);
			nameInput2.clear();
		}
		
		
		
		
	}
	public void delete2ButtonClicked() {
		
		ObservableList<ChampNames> nameSelected, allNames;
		allNames = player2Champs.getItems();
		// gets items that user has selected
		nameSelected = player2Champs.getSelectionModel().getSelectedItems();
		nameSelected.forEach(allNames:: remove);
	}
	
	
	public void submitButtonClicked() {
		
		String player1 = PlayersNameController.player1Name;
		String player2 = PlayersNameController.player2Name;
		//ObservableList<ChampNames> allNames;
		allNames = player1Champs.getItems();
		
//		champion1 = createChampions(champion1, allNames.get(0));
//		champion2 = createChampions(champion2, allNames.get(1));
//		champion3 = createChampions(champion3, allNames.get(2));
		
		
		//ObservableList<ChampNames> allNames2;
		allNames2 = player2Champs.getItems();
		
//		champion4 = createChampions(champion4, allNames2.get(0));
//		champion5 = createChampions(champion5, allNames2.get(1));
//		champion6 = createChampions(champion6, allNames2.get(2));
		
		
		
		
		
		
		
//		// creating actual Players
//		firstPlayer = new Player(player1);
//		firstPlayer.getTeam().add(champion1);
//		firstPlayer.getTeam().add(champion2);
//		firstPlayer.getTeam().add(champion3);
//		firstPlayer.setLeader(champion1);
//		
//		secondPlayer = new Player(player2);
//		secondPlayer.getTeam().add(champion4);
//		secondPlayer.getTeam().add(champion5);
//		secondPlayer.getTeam().add(champion6);
//		secondPlayer.setLeader(champion4);
		
		
//		
//		System.out.println(champion1.getName());
//		System.out.println(champion2.getName());
//		System.out.println(champion3.getName());
//		System.out.println(champion4.getName());
//		System.out.println(champion5.getName());
//		System.out.println(champion6.getName());
//		
//		System.out.println(champion1.getAttackDamage());
//		System.out.println(champion2.getAttackDamage());
//		System.out.println(champion3.getAttackDamage());
//		System.out.println(champion4.getAttackDamage());
//		System.out.println(champion5.getAttackDamage());
//		System.out.println(champion6.getAttackDamage());
		
		//System.out.println(secondPlayer.getTeam().get(0).getName());
		
		//System.out.println(player1 + player2);

	}
	
	
	public void championSelected() {
		
		MediaPlayer backGroundMusic = new MediaPlayer(h);
		backGroundMusic.play();
		backGroundMusic.setOnEndOfMedia(new Runnable() {
			
			public void run() {
				
				backGroundMusic.dispose();
			}
		});
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
