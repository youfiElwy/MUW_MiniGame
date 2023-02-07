package Resources;

import java.io.File;

import org.omg.CORBA.DATA_CONVERSION;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import views.BuiltWindow.GameWindow;

public class AbilityStatsBox {

	
	
	public static void display(String title, Ability clickedAbility) {// , Ability clickedAbility
		
		Stage window = new Stage();
		Image image = new Image(new File("src/Resources/InfoBox.png").toURI().toString());
		window.getIcons().add(image);
		
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		window.setMinHeight(500);
		
		
		
		//layout
		VBox layout = new VBox();
		
		
		//1
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(e -> window.close());
		
		
		Label type;
		if (clickedAbility instanceof DamagingAbility)
			type = new Label("Type: Damaging Ability");
		else if (clickedAbility instanceof HealingAbility)
			type = new Label("Type: Healing Ability");
		else
			type = new Label("Type: Crowd Control Ability");
		
		type.setFont(new Font(20));
		type.setStyle("-fx-font-weight: bold;");
		
		
		Label name = new Label("Name: " + clickedAbility.getName());
			name.setFont(new Font(20));
			name.setStyle("-fx-font-weight: bold;");
		Label manaCost = new Label("Mana Cost: " + clickedAbility.getManaCost());
			manaCost.setFont(new Font(20));
			manaCost.setStyle("-fx-font-weight: bold;");
		Label castRange = new Label("Cast Range: " + clickedAbility.getCastRange());
			castRange.setFont(new Font(20));
			castRange.setStyle("-fx-font-weight: bold;");
		Label baseCooldown = new Label("Base Cooldown: " + clickedAbility.getBaseCooldown());
			baseCooldown.setFont(new Font(20));
			baseCooldown.setStyle("-fx-font-weight: bold;");
		Label currentCooldown = new Label("Current Cooldown: " + clickedAbility.getCurrentCooldown());
			currentCooldown.setFont(new Font(20));
			currentCooldown.setStyle("-fx-font-weight: bold;");
		Label AreaOfEffect = new Label("Area Of Effect: " + clickedAbility.getCastArea());
			AreaOfEffect.setFont(new Font(20));
			AreaOfEffect.setStyle("-fx-font-weight: bold;");
		Label requiredActionsPerTurn = new Label("Required Actions Per Turn: " + clickedAbility.getRequiredActionPoints());
			requiredActionsPerTurn.setFont(new Font(20));
			requiredActionsPerTurn.setStyle("-fx-font-weight: bold;");
		
		
		Label dhe, effectDuration;
		
		if (clickedAbility instanceof DamagingAbility) {
			dhe = new Label("Damage Amount: " + ((DamagingAbility) clickedAbility).getDamageAmount());
			effectDuration = new Label("Effect Duration: NO EFFECT");
			
			BackgroundFill background = new BackgroundFill(Color.RED, new CornerRadii(0), new Insets(0));
			Background bg = new Background(background);
			layout.setBackground(bg);
			layout.setStyle("-fx-border-color: saddlebrown ; -fx-border-width: 12px;");
			
			Image image1 = new Image(new File("src/Resources/DamagePic.png").toURI().toString());
			window.getIcons().add(image1);
		}
		else if (clickedAbility instanceof HealingAbility) {
			dhe = new Label("Heal Amount: " + ((HealingAbility) clickedAbility).getHealAmount());
			effectDuration = new Label("Effect Duration: NO EFFECT");
			
			BackgroundFill background = new BackgroundFill(Color.DARKTURQUOISE, new CornerRadii(0), new Insets(0));
			Background bg = new Background(background);
			layout.setBackground(bg);
			layout.setStyle("-fx-border-color: saddlebrown ; -fx-border-width: 12px;");
			
			Image image1 = new Image(new File("src/Resources/HealPic.png").toURI().toString());
			window.getIcons().add(image1);
		}
		else {
			dhe = new Label("Effect Name: " + ((CrowdControlAbility) clickedAbility).getName());
			effectDuration = new Label("Effect Duration: " + ((CrowdControlAbility) clickedAbility).getEffect().getDuration());
			
			BackgroundFill background = new BackgroundFill(Color.SPRINGGREEN, new CornerRadii(0), new Insets(0));
			Background bg = new Background(background);
			layout.setBackground(bg);
			layout.setStyle("-fx-border-color: saddlebrown ; -fx-border-width: 12px;");
			
			Image image1 = new Image(new File("src/Resources/CCPic.png").toURI().toString());
			window.getIcons().add(image1);
		}
		dhe.setFont(new Font(20));
		dhe.setStyle("-fx-font-weight: bold;");
		
		effectDuration.setFont(new Font(20));
		effectDuration.setStyle("-fx-font-weight: bold;");
		
		
		
		
		layout.getChildren().addAll(type, name, manaCost, castRange, baseCooldown, currentCooldown, AreaOfEffect, requiredActionsPerTurn, dhe, effectDuration);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10,10,10));
		layout.setSpacing(4);
		
		Scene scene = new Scene(layout, 400, 500);
		window.setScene(scene);
		window.showAndWait();
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
