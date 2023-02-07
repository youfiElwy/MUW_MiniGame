package model.world;

import java.util.ArrayList;

import engine.Game;
import views.BuiltWindow.GameWindow;


public class Villain extends Champion {

	public Villain(String name, int maxHP, int mana, int maxActionsPerTurn, int speed, int attackRange,
			int attackDamage) {
		super(name, maxHP, mana, maxActionsPerTurn, speed, attackRange, attackDamage);
	}

	@Override
	public void useLeaderAbility(ArrayList<Champion> targets) {
		for (Champion champion : targets) {
			champion.setCurrentHP(0);
			
			ArrayList<Damageable> targs = new ArrayList<Damageable>();
			targs.addAll(targets);
			
			GameWindow.getGameRound().clean(targs);
			
			
			if (Game.flag5ara == false) {
				GameWindow.displayBoardChamps();
				//GameWindow.allBoardButtons[champion.getLocation().x][champion.getLocation().y].setGraphic(null);
			}
		}
	}

}
