package views;

import java.io.File;

import Resources.AbilityStatsBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.effects.Root;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Hero;
import model.world.Villain;
import views.BuiltWindow.GameWindow;

public class BoardInfoAlertBox {

	
	static TableView<EffectNames> effectsLayout;
	
	public static void display(String title, int x, int y) {
		
		Stage window = new Stage();
		Image image = new Image(new File("src/Resources/InfoBox.png").toURI().toString());
		window.getIcons().add(image);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(400);
		
		
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> window.close());
		
		
		HBox entireLayout = new HBox();
		
		
		
		VBox infoLayout = new VBox();
		
		
		Label type = new Label();
			type.setFont(new Font(20));
			type.setStyle("-fx-font-weight: bold;");
		Label name = new Label();
			name.setFont(new Font(20));
			name.setStyle("-fx-font-weight: bold;");
		Label currentHP = new Label();
			currentHP.setFont(new Font(20));
			currentHP.setStyle("-fx-font-weight: bold;");
		Label maxHP = new Label();
			maxHP.setFont(new Font(20));
			maxHP.setStyle("-fx-font-weight: bold;");
		Label mana = new Label();
			mana.setFont(new Font(20));
			mana.setStyle("-fx-font-weight: bold;");
		Label currentActionPoints = new Label();
			currentActionPoints.setFont(new Font(20));
			currentActionPoints.setStyle("-fx-font-weight: bold;");
		Label maxActionsPerTurn = new Label();
			maxActionsPerTurn.setFont(new Font(20));
			maxActionsPerTurn.setStyle("-fx-font-weight: bold;");
		Label speed = new Label();
			speed.setFont(new Font(20));
			speed.setStyle("-fx-font-weight: bold;");
		Label attackRange = new Label();
			attackRange.setFont(new Font(20));
			attackRange.setStyle("-fx-font-weight: bold;");
		Label attackDamage = new Label();
			attackDamage.setFont(new Font(20));
			attackDamage.setStyle("-fx-font-weight: bold;");
		Label condition = new Label();
			condition.setFont(new Font(20));
			condition.setStyle("-fx-font-weight: bold;");
		
		
		if (GameWindow.getGameRound().getBoard()[x][y] == null) {
			
			type.setText("EMPTY CELL");
			name.setText("");
			currentHP.setText("");
			maxHP.setText("");
			mana.setText("");
			currentActionPoints.setText("");
			maxActionsPerTurn.setText("");
			speed.setText("");
			attackRange.setText("");
			attackDamage.setText("");
			condition.setText("");
		}
		else if (GameWindow.getGameRound().getBoard()[x][y] instanceof Champion) {
			
			Champion champion = (Champion) GameWindow.getGameRound().getBoard()[x][y];
			
			if (champion instanceof Hero)
				type.setText("Type: Hero");
			else if (champion instanceof Villain)
				type.setText("Type: Villain");
			else if (champion instanceof AntiHero)
				type.setText("Type: AntiHero");
			
			name.setText("Name: " + champion.getName());
			currentHP.setText("Current HP: " + champion.getCurrentHP());
			maxHP.setText("Max HP: " + champion.getMaxHP());
			mana.setText("Mana: " + champion.getMana());
			currentActionPoints.setText("Current Action Points: " + champion.getCurrentActionPoints());
			maxActionsPerTurn.setText("Max Actions Per Turn: " + champion.getMaxActionPointsPerTurn());
			speed.setText("Speed: " + champion.getSpeed());
			attackRange.setText("Attack Range: " + champion.getAttackRange());
			attackDamage.setText("Attack Damage: " + champion.getAttackDamage());
			condition.setText("Condition: " + champion.getCondition());
		}
		else if (GameWindow.getGameRound().getBoard()[x][y] instanceof Cover) {
			
			Cover cover = (Cover) GameWindow.getGameRound().getBoard()[x][y];
			
			type.setText("Type: Cover");
			name.setText("Current HP: " + cover.getCurrentHP());
			currentHP.setText("");
			maxHP.setText("");
			mana.setText("");
			currentActionPoints.setText("");
			maxActionsPerTurn.setText("");
			speed.setText("");
			attackRange.setText("");
			attackDamage.setText("");
			condition.setText("");
		}
		
		infoLayout.getChildren().addAll(type, name, currentHP, maxHP, mana, currentActionPoints, maxActionsPerTurn, speed, attackRange, attackDamage, condition);
		
		
		
		
		
		
		
		
		
		
		
		VBox abilitiesLayout = new VBox();
		
		Button ability1 = new Button();
		Button ability2 = new Button();
		Button ability3 = new Button();
		
		ability1.setStyle("-fx-background-color: lightslategrey; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: cyan ; -fx-border-width: 2px;");
		ability2.setStyle("-fx-background-color: lightslategrey; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: cyan ; -fx-border-width: 2px;");
		ability3.setStyle("-fx-background-color: lightslategrey; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: cyan ; -fx-border-width: 2px;");
		
		abilitiesLayout.setSpacing(5);
		
		
		if (GameWindow.getGameRound().getBoard()[x][y] == null) {
			
			ability1.setText("Ability1: ----");
			ability2.setText("Ability2: ----");
			ability3.setText("Ability3: ----");
			
			ability1.setDisable(true);
			ability2.setDisable(true);
			ability3.setDisable(true);
		}
		else if (GameWindow.getGameRound().getBoard()[x][y] instanceof Champion) {
			
			Champion champion = (Champion) GameWindow.getGameRound().getBoard()[x][y];
			
			ability1.setText("Ability1: " + champion.getAbilities().get(0).getName());
			ability2.setText("Ability2: " + champion.getAbilities().get(1).getName());
			ability3.setText("Ability3: " + champion.getAbilities().get(2).getName());
		}
		else if (GameWindow.getGameRound().getBoard()[x][y] instanceof Cover) {
			
			Cover cover = (Cover) GameWindow.getGameRound().getBoard()[x][y];
			
			ability1.setText("Ability1: ----");
			ability2.setText("Ability2: ----");
			ability3.setText("Ability3: ----");
			
			ability1.setDisable(true);
			ability2.setDisable(true);
			ability3.setDisable(true);
		}
		
		
		ability1.setOnAction(e -> {
			
			AbilityStatsBox.display("Ability: ", ((Champion) GameWindow.getGameRound().getBoard()[x][y]).getAbilities().get(0));
		});
		ability2.setOnAction(e -> {
			
			AbilityStatsBox.display("Ability: ", ((Champion) GameWindow.getGameRound().getBoard()[x][y]).getAbilities().get(1));
		});
		ability3.setOnAction(e -> {
	
			AbilityStatsBox.display("Ability: ", ((Champion) GameWindow.getGameRound().getBoard()[x][y]).getAbilities().get(2));
		});
		
		
		
		abilitiesLayout.getChildren().addAll(ability1, ability2 ,ability3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		effectsLayout = new TableView();
		
		// name column
		TableColumn<EffectNames, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameColumn.setStyle("-fx-background-color: orchid");
		
		// duration column
		TableColumn<EffectNames, Integer> durationColumn = new TableColumn<>("Duration");
		durationColumn.setMinWidth(100);
		durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
		durationColumn.setStyle("-fx-background-color: plum");
		
		
		effectsLayout.setItems(getChampsEffect());
		effectsLayout.getColumns().addAll(nameColumn, durationColumn);
		
		effectsLayout.setStyle("-fx-background-color: darkviolet; -fx-selection-bar: magenta; -fx-selection-bar-non-focused: violet;");
		
		
		//clearTable();
		
		
		
		if (GameWindow.getGameRound().getBoard()[x][y] instanceof Champion) {
			
			Champion champion = (Champion) GameWindow.getGameRound().getBoard()[x][y];
		
			for (int i = 0; i < champion.getAppliedEffects().size(); i++) {
				
				EffectNames effectName = new EffectNames();
				effectName.setName(champion.getAppliedEffects().get(i).getName());
				effectName.setDuration(champion.getAppliedEffects().get(i).getDuration());
				effectsLayout.getItems().add(effectName);
				
			}
		
		}
		
		
		
		
		
		entireLayout.getChildren().addAll(infoLayout, abilitiesLayout, effectsLayout);
		entireLayout.setPadding(new Insets(20,20,20,20));
		entireLayout.setSpacing(30);
		BackgroundFill background = new BackgroundFill(Color.SANDYBROWN, new CornerRadii(0), new Insets(0));
		Background bg = new Background(background);
		entireLayout.setBackground(bg);
		entireLayout.setStyle("-fx-border-color: lightsalmon ; -fx-border-width: 12px;");
		
		
		
		
		
		
		
		
		
		
		
		
		
		Scene scene = new Scene(entireLayout, 1000, 400);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	
	public static ObservableList<EffectNames> getChampsEffect(){
		
		ObservableList<EffectNames> effectNames = FXCollections.observableArrayList();
		
		return effectNames;
	}
	
	
	
	
	
	
	
	
	public static void clearTable() {
		
		//ObservableList<EffectNames> allEffects;
		//allEffects = effectsLayout.getItems();
		
		// gets items that user has selected
		//allEffects.forEach(allEffects:: remove);
		
		effectsLayout.getItems().clear();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
