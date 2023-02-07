package views;

import java.nio.file.Paths;

import Resources.AbilityStatsBox;
import exceptions.AbilityUseException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import views.BuiltWindow.GameWindow;

public class AbilityAlertBox {

	static Stage window;
	
	static String s1 = "src/Resources/Damage.mp3";
	public static Media h1 = new Media(Paths.get(s1).toUri().toString());
	
	static String s2 = "src/Resources/Healing.mp3";
	public static Media h2 = new Media(Paths.get(s2).toUri().toString());
	
	static String s3 = "src/Resources/CrowdControl.mp3";
	public static Media h3 = new Media(Paths.get(s3).toUri().toString());
	
	
	public static void display(String title) {
		
		window = new Stage();
		window.initStyle(StageStyle.TRANSPARENT);
		
		window.setX(248);
		window.setY(300);
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(260);
		window.setMinHeight(600);
		
		
		
		//layout
		VBox the3Abilities = new VBox();
		
		
		//1
		Button closeButton = new Button("Close the window");
		closeButton.setStyle("-fx-background-color: navy; -fx-text-fill: darkslategrey; -fx-font-weight: bold; -fx-border-color: orangered ; -fx-border-width: 4px;");
		closeButton.setOnAction(e -> window.close());
		
		
		
		
		
		//2
		Button ability1 = new Button("Ability 1: " + GameWindow.getGameRound().getCurrentChampion().getAbilities().get(0).getName());
		Button ability2 = new Button("Ability 2: " + GameWindow.getGameRound().getCurrentChampion().getAbilities().get(1).getName());
		Button ability3 = new Button("Ability 3: " + GameWindow.getGameRound().getCurrentChampion().getAbilities().get(2).getName());
		
		ability1.setStyle("-fx-background-color: dimgrey; -fx-text-fill: snow; -fx-font-weight: bold; -fx-border-color: ghostwhite ; -fx-border-width: 2px;");
		ability2.setStyle("-fx-background-color: dimgrey; -fx-text-fill: snow; -fx-font-weight: bold; -fx-border-color: ghostwhite ; -fx-border-width: 2px;");
		ability3.setStyle("-fx-background-color: dimgrey; -fx-text-fill: snow; -fx-font-weight: bold; -fx-border-color: ghostwhite ; -fx-border-width: 2px;");
		
		ability1.setOnAction(e -> ability1Clicked(GameWindow.getGameRound().getCurrentChampion().getAbilities().get(0)));
		ability2.setOnAction(e -> ability2Clicked(GameWindow.getGameRound().getCurrentChampion().getAbilities().get(1)));
		ability3.setOnAction(e -> ability3Clicked(GameWindow.getGameRound().getCurrentChampion().getAbilities().get(2)));
		
		
		
		//3
		Button select1 = new Button("Select Ability 1");
		Button select2 = new Button("Select Ability 2");
		Button select3 = new Button("Select Ability 3");
		
		select1.setStyle("-fx-background-color: azure; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-border-color: cyan ; -fx-border-width: 2px;");
		select2.setStyle("-fx-background-color: azure; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-border-color: cyan ; -fx-border-width: 2px;");
		select3.setStyle("-fx-background-color: azure; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-border-color: cyan ; -fx-border-width: 2px;");
		
		select1.setOnAction(e -> abilitySelected(GameWindow.getGameRound().getCurrentChampion().getAbilities().get(0)));
		select2.setOnAction(e -> abilitySelected(GameWindow.getGameRound().getCurrentChampion().getAbilities().get(1)));
		select3.setOnAction(e -> abilitySelected(GameWindow.getGameRound().getCurrentChampion().getAbilities().get(2)));
		
		
		
		
		
		
		the3Abilities.getChildren().addAll(ability1, ability2, ability3, select1, select2, select3, closeButton);
		the3Abilities.setAlignment(Pos.CENTER);
		the3Abilities.setSpacing(50);
		
		
		BackgroundFill background = new BackgroundFill(Color.TRANSPARENT, new CornerRadii(5), new Insets(0));
		Background bg = new Background(background);
		the3Abilities.setBackground(bg);
		the3Abilities.setStyle("-fx-border-color: yellow ; -fx-border-width: 4px;");
		
		Scene scene = new Scene(the3Abilities, 260, 600);
		scene.setFill(Color.TRANSPARENT);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	public static void ability1Clicked(Ability ability) {
		
		//display AbilityStatsBox
		AbilityStatsBox.display("Ability: ", ability);
	}
	public static void ability2Clicked(Ability ability) {
		
		//display AbilityStatsBox
		AbilityStatsBox.display("Ability: ", ability);
	}
	public static void ability3Clicked(Ability ability) {
	
		//display AbilityStatsBox
		AbilityStatsBox.display("Ability: ", ability);
	}
	
	
	
	public static void abilitySelected(Ability ability) {
		
		if (ability.getCastArea() == AreaOfEffect.DIRECTIONAL) {
			
			CastAbilityDirectionAlertBox.display(ability);
		}
		
		
		
		else if (ability.getCastArea() == AreaOfEffect.SINGLETARGET) {
			
			SingleTargetAlertBox.display("ENTER A LOCATION!", ability);
			
//			try {
//				GameWindow.getGame().castAbility(ability, GameWindow.getCurrentSelectedTarget().getLocation().x, GameWindow.getCurrentSelectedTarget().getLocation().y);
//				
//				
//			} catch (AbilityUseException e) {
//
//				AlertBox.display("AbilityUseException", e.getMessage());
//			} catch (NotEnoughResourcesException e) {
//
//				AlertBox.display("NotEnoughResourcesException", e.getMessage());
//			} catch (InvalidTargetException e) {
//
//				AlertBox.display("InvalidTargetException", e.getMessage());
//			} catch (CloneNotSupportedException e) {
//
//				AlertBox.display("CloneNotSupportedException", e.getMessage());
//			}
			
			//window.close();
		}
		
		
		
		else {
			
			try {
				GameWindow.getGameRound().castAbility(ability);
			} catch (AbilityUseException e) {

				AlertBox.display("AbilityUseException", e.getMessage());
			} catch (NotEnoughResourcesException e) {

				AlertBox.display("NotEnoughResourcesException", e.getMessage());
			} catch (CloneNotSupportedException e) {

				AlertBox.display("CloneNotSupportedException", e.getMessage());
			}
			window.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
