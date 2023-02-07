package views.BuiltWindow;

import java.io.File;
import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.world.AntiHero;
import model.world.Hero;
import model.world.Villain;
import views.ChampNames;
import views.Main;

public class ChampSelectionController {

	
	
	
	
	//1
	public static void capPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Hero");
			ChampSelectionWindow.nameLabelAnswer.setText("Captain America");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1500");
			ChampSelectionWindow.manaLabelAnswer.setText("1000");
			ChampSelectionWindow.actionsLabelAnswer.setText("6");
			ChampSelectionWindow.speedLabelAnswer.setText("80");
			ChampSelectionWindow.damageLabelAnswer.setText("100");
			ChampSelectionWindow.rangeLabelAnswer.setText("1");
			ChampSelectionWindow.ab1LabelAnswer.setText("Shield throw");
			ChampSelectionWindow.ab2LabelAnswer.setText("I can do this all day");
			ChampSelectionWindow.ab3LabelAnswer.setText("Shield Up");
			
			addTextField(textInput1, textInput2, "Captain America");
		});
	}
	//2
	public static void electroPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Villain");
			ChampSelectionWindow.nameLabelAnswer.setText("Electro");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1200");
			ChampSelectionWindow.manaLabelAnswer.setText("1200");
			ChampSelectionWindow.actionsLabelAnswer.setText("5");
			ChampSelectionWindow.speedLabelAnswer.setText("75");
			ChampSelectionWindow.damageLabelAnswer.setText("110");
			ChampSelectionWindow.rangeLabelAnswer.setText("3");
			ChampSelectionWindow.ab1LabelAnswer.setText("Fully Charged");
			ChampSelectionWindow.ab2LabelAnswer.setText("EMP");
			ChampSelectionWindow.ab3LabelAnswer.setText("Lightning Strike");
			
			addTextField(textInput1, textInput2, "Electro");
		});
	}
	//3
	public static void hulkPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Hero");
			ChampSelectionWindow.nameLabelAnswer.setText("Hulk");
			ChampSelectionWindow.maxHPLabelAnswer.setText("2250");
			ChampSelectionWindow.manaLabelAnswer.setText("550");
			ChampSelectionWindow.actionsLabelAnswer.setText("5");
			ChampSelectionWindow.speedLabelAnswer.setText("55");
			ChampSelectionWindow.damageLabelAnswer.setText("200");
			ChampSelectionWindow.rangeLabelAnswer.setText("1");
			ChampSelectionWindow.ab1LabelAnswer.setText("Rage");
			ChampSelectionWindow.ab2LabelAnswer.setText("Hulk Smash");
			ChampSelectionWindow.ab3LabelAnswer.setText("Sun is getting real low");
			
			addTextField(textInput1, textInput2, "Hulk");
		});
	}
	//4
	public static void lokiPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Villain");
			ChampSelectionWindow.nameLabelAnswer.setText("Loki");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1150");
			ChampSelectionWindow.manaLabelAnswer.setText("900");
			ChampSelectionWindow.actionsLabelAnswer.setText("5");
			ChampSelectionWindow.speedLabelAnswer.setText("70");
			ChampSelectionWindow.damageLabelAnswer.setText("150");
			ChampSelectionWindow.rangeLabelAnswer.setText("1");
			ChampSelectionWindow.ab1LabelAnswer.setText("God of Mischief");
			ChampSelectionWindow.ab2LabelAnswer.setText("The Hidden Dagger");
			ChampSelectionWindow.ab3LabelAnswer.setText("Fake Death");
			
			addTextField(textInput1, textInput2, "Loki");
		});
	}
	//5
	public static void thorPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Hero");
			ChampSelectionWindow.nameLabelAnswer.setText("Thor");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1800");
			ChampSelectionWindow.manaLabelAnswer.setText("800");
			ChampSelectionWindow.actionsLabelAnswer.setText("7");
			ChampSelectionWindow.speedLabelAnswer.setText("90");
			ChampSelectionWindow.damageLabelAnswer.setText("130");
			ChampSelectionWindow.rangeLabelAnswer.setText("1");
			ChampSelectionWindow.ab1LabelAnswer.setText("God of Thunder");
			ChampSelectionWindow.ab2LabelAnswer.setText("Mjollnir Throw");
			ChampSelectionWindow.ab3LabelAnswer.setText("Bring Me Thanos");
			
			addTextField(textInput1, textInput2, "Thor");
		});
	}
	//6
	public static void deadPoolPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("AntiHero");
			ChampSelectionWindow.nameLabelAnswer.setText("Deadpool");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1350");
			ChampSelectionWindow.manaLabelAnswer.setText("700");
			ChampSelectionWindow.actionsLabelAnswer.setText("6");
			ChampSelectionWindow.speedLabelAnswer.setText("80");
			ChampSelectionWindow.damageLabelAnswer.setText("90");
			ChampSelectionWindow.rangeLabelAnswer.setText("3");
			ChampSelectionWindow.ab1LabelAnswer.setText("Try Harder");
			ChampSelectionWindow.ab2LabelAnswer.setText("8 bullets left");
			ChampSelectionWindow.ab3LabelAnswer.setText("Can't Catch Me");
			
			addTextField(textInput1, textInput2, "Deadpool");
		});
	}
	//7
	public static void ghostRiderPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("AntiHero");
			ChampSelectionWindow.nameLabelAnswer.setText("Ghost Rider");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1800");
			ChampSelectionWindow.manaLabelAnswer.setText("600");
			ChampSelectionWindow.actionsLabelAnswer.setText("6");
			ChampSelectionWindow.speedLabelAnswer.setText("85");
			ChampSelectionWindow.damageLabelAnswer.setText("140");
			ChampSelectionWindow.rangeLabelAnswer.setText("1");
			ChampSelectionWindow.ab1LabelAnswer.setText("Death stare");
			ChampSelectionWindow.ab2LabelAnswer.setText("Fire Breath");
			ChampSelectionWindow.ab3LabelAnswer.setText("Chain Whip");
			
			addTextField(textInput1, textInput2, "Ghost Rider");
		});
	}
	//8
	public static void icemanPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Hero");
			ChampSelectionWindow.nameLabelAnswer.setText("Iceman");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1000");
			ChampSelectionWindow.manaLabelAnswer.setText("900");
			ChampSelectionWindow.actionsLabelAnswer.setText("5");
			ChampSelectionWindow.speedLabelAnswer.setText("65");
			ChampSelectionWindow.damageLabelAnswer.setText("120");
			ChampSelectionWindow.rangeLabelAnswer.setText("2");
			ChampSelectionWindow.ab1LabelAnswer.setText("Frost bite");
			ChampSelectionWindow.ab2LabelAnswer.setText("SubZero");
			ChampSelectionWindow.ab3LabelAnswer.setText("Hail Storm");
			
			addTextField(textInput1, textInput2, "Iceman");
		});
	}
	//9
	public static void quicksilverPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Villain");
			ChampSelectionWindow.nameLabelAnswer.setText("Quicksilver");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1200");
			ChampSelectionWindow.manaLabelAnswer.setText("650");
			ChampSelectionWindow.actionsLabelAnswer.setText("8");
			ChampSelectionWindow.speedLabelAnswer.setText("99");
			ChampSelectionWindow.rangeLabelAnswer.setText("1");
			ChampSelectionWindow.damageLabelAnswer.setText("70");
			ChampSelectionWindow.ab1LabelAnswer.setText("Time in a bottle");
			ChampSelectionWindow.ab2LabelAnswer.setText("Good as new");
			ChampSelectionWindow.ab3LabelAnswer.setText("1 sec 100 punch");
			
			addTextField(textInput1, textInput2, "Quicksilver");
		});
	}
	//10
	public static void venomPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("AntiHero");
			ChampSelectionWindow.nameLabelAnswer.setText("Venom");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1650");
			ChampSelectionWindow.manaLabelAnswer.setText("700");
			ChampSelectionWindow.actionsLabelAnswer.setText("5");
			ChampSelectionWindow.speedLabelAnswer.setText("70");
			ChampSelectionWindow.rangeLabelAnswer.setText("1");
			ChampSelectionWindow.damageLabelAnswer.setText("140");
			ChampSelectionWindow.ab1LabelAnswer.setText("Head Bite");
			ChampSelectionWindow.ab2LabelAnswer.setText("We are venom");
			ChampSelectionWindow.ab3LabelAnswer.setText("Symbiosis");
			
			addTextField(textInput1, textInput2, "Venom");
		});
	}
	//11
	public static void strangePressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Hero");
			ChampSelectionWindow.nameLabelAnswer.setText("Dr Strange");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1100");
			ChampSelectionWindow.manaLabelAnswer.setText("1500");
			ChampSelectionWindow.actionsLabelAnswer.setText("6");
			ChampSelectionWindow.speedLabelAnswer.setText("60");
			ChampSelectionWindow.rangeLabelAnswer.setText("2");
			ChampSelectionWindow.damageLabelAnswer.setText("60");
			ChampSelectionWindow.ab1LabelAnswer.setText("The eye of agamotto");
			ChampSelectionWindow.ab2LabelAnswer.setText("Thousand Hand");
			ChampSelectionWindow.ab3LabelAnswer.setText("Mirror Dimension");
			
			addTextField(textInput1, textInput2, "Dr Strange");
		});
	}
	//12
	public static void helaPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Villain");
			ChampSelectionWindow.nameLabelAnswer.setText("Hela");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1500");
			ChampSelectionWindow.manaLabelAnswer.setText("750");
			ChampSelectionWindow.actionsLabelAnswer.setText("5");
			ChampSelectionWindow.speedLabelAnswer.setText("75");
			ChampSelectionWindow.rangeLabelAnswer.setText("1");
			ChampSelectionWindow.damageLabelAnswer.setText("150");
			ChampSelectionWindow.ab1LabelAnswer.setText("Godess of Death");
			ChampSelectionWindow.ab2LabelAnswer.setText("Thorn Shield");
			ChampSelectionWindow.ab3LabelAnswer.setText("Thorn Shower");
			
			addTextField(textInput1, textInput2, "Hela");
		});
	}
	//13
	public static void ironmanPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Hero");
			ChampSelectionWindow.nameLabelAnswer.setText("Ironman");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1200");
			ChampSelectionWindow.manaLabelAnswer.setText("800");
			ChampSelectionWindow.actionsLabelAnswer.setText("7");
			ChampSelectionWindow.speedLabelAnswer.setText("85");
			ChampSelectionWindow.rangeLabelAnswer.setText("3");
			ChampSelectionWindow.damageLabelAnswer.setText("90");
			ChampSelectionWindow.ab1LabelAnswer.setText("I am Ironman");
			ChampSelectionWindow.ab2LabelAnswer.setText("Unibeam");
			ChampSelectionWindow.ab3LabelAnswer.setText("3000");
			
			addTextField(textInput1, textInput2, "Ironman");
		});
	}
	//14
	public static void spidermanPressed(Button pressed, TextField textInput1, TextField textInput2) {
		
		pressed.setOnAction(e -> {
			
			ChampSelectionWindow.typeLabelAnswer.setText("Hero");
			ChampSelectionWindow.nameLabelAnswer.setText("Spiderman");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1400");
			ChampSelectionWindow.manaLabelAnswer.setText("750");
			ChampSelectionWindow.actionsLabelAnswer.setText("7");
			ChampSelectionWindow.speedLabelAnswer.setText("85");
			ChampSelectionWindow.rangeLabelAnswer.setText("1");
			ChampSelectionWindow.damageLabelAnswer.setText("120");
			ChampSelectionWindow.ab1LabelAnswer.setText("give me that");
			ChampSelectionWindow.ab2LabelAnswer.setText("web trap");
			ChampSelectionWindow.ab3LabelAnswer.setText("Spiderverse");
			
			addTextField(textInput1, textInput2, "Spiderman");
		});
	}
	//15
	public static void yellowJacketPressed(Button pressed, TextField textInput1, TextField textInput2) {
			
		pressed.setOnAction(e -> {
				
			ChampSelectionWindow.typeLabelAnswer.setText("Villain");
			ChampSelectionWindow.nameLabelAnswer.setText("Yellow Jacket");
			ChampSelectionWindow.maxHPLabelAnswer.setText("1050");
			ChampSelectionWindow.manaLabelAnswer.setText("800");
			ChampSelectionWindow.actionsLabelAnswer.setText("6");
			ChampSelectionWindow.speedLabelAnswer.setText("60");
			ChampSelectionWindow.rangeLabelAnswer.setText("2");
			ChampSelectionWindow.damageLabelAnswer.setText("80");
			ChampSelectionWindow.ab1LabelAnswer.setText("Laser Sting");
			ChampSelectionWindow.ab2LabelAnswer.setText("QuANTaMANia");
			ChampSelectionWindow.ab3LabelAnswer.setText("Pym Particle Upsize");
			
			addTextField(textInput1, textInput2, "Yellow Jacket");
		});
	}
	
	public static void startGameClicked(Button pressed) {
		
		pressed.setOnAction(e -> {
			
			try {
				Main.window.setScene(new GameWindow().getCurrentGameScene());
			} catch (IOException e1) {

				System.out.println("ChampSelectionController start game button ta7t 5ales didnt work");
			}
			Main.window.setFullScreen(true);
			
			HomeScreenWindow.playOrNot = false;
			HomeScreenWindow.music();
		});
	}
	
	
	
	public static void addTextField(TextField textInput1, TextField textInput2, String name) {
		
		textInput1.setText(name);
		textInput2.setText(name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
