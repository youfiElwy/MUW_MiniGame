package engine;

import java.awt.Point;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Disarm;
import model.effects.Dodge;
import model.effects.Effect;
import model.effects.EffectType;
import model.effects.Embrace;
import model.effects.PowerUp;
import model.effects.Root;
import model.effects.Shield;
import model.effects.Shock;
import model.effects.Silence;
import model.effects.SpeedUp;
import model.effects.Stun;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Condition;
import model.world.Cover;
import model.world.Damageable;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;
import views.AbilityAlertBox;
import views.AttackDirectionAlertBox;
import views.GameMusic;
import views.MoveDirectionAlertBox;
import views.BuiltWindow.GameWindow;

public class Game {
	
	public static boolean flag5ara = false;
	public static boolean thorsLA = false;
	public static boolean yellowFlag = false;

	
	static String s = "src/Resources/ChampDeath.mp3";
	public static Media h10 = new Media(Paths.get(s).toUri().toString());
	static String sLA = "src/Resources/LeaderAbility.mp3";
	public static Media hLA = new Media(Paths.get(sLA).toUri().toString());
	static String sHB = "src/Resources/LokiThemeCutFadeOut.mp3";
	public static Media hHB = new Media(Paths.get(sHB).toUri().toString());
	static String sHB1 = "src/Resources/HulkBusterEntrenceCutFadeOut.mp3";
	public static Media hHB1 = new Media(Paths.get(sHB1).toUri().toString());
	static String sThor = "src/Resources/ThorBringCutFadeOut.mp3";
	public static Media hThor = new Media(Paths.get(sThor).toUri().toString());
	static String sYellow = "src/Resources/TinyYellow.mp3";
	public static Media hYellow = new Media(Paths.get(sYellow).toUri().toString());
	static String sDead = "src/Resources/MaxEffort.mp3";
	public static Media hDead = new Media(Paths.get(sDead).toUri().toString());
	

	private Player firstPlayer;
	private Player secondPlayer;
	private boolean firstLeaderAbilityUsed;
	private boolean secondLeaderAbilityUsed;
	private Object[][] board;
	public PriorityQueue turnOrder;
	private static ArrayList<Champion> availableChampions;
	private static ArrayList<Ability> availableAbilities;
	private final static int BOARDWIDTH = 5;
	private final static int BOARDHEIGHT = 5;

	
	
//	public Game() throws IOException {
//		
//		loadAbilities("src\\Abilities.csv");
//		loadChampions("src\\Champions.csv");
//		
//		availableChampions = new ArrayList<Champion>();
//		availableAbilities = new ArrayList<Ability>();
//	}
	
	
	
	public Game(Player p1, Player p2) throws IOException {
		
		this.firstLeaderAbilityUsed = false;
		this.secondLeaderAbilityUsed = false;
		
		this.firstPlayer = p1;
		this.secondPlayer = p2;
		
		turnOrder = new PriorityQueue(6);
		
		board = new Object[BOARDHEIGHT][BOARDWIDTH];
		
			//System.out.println("shit");
		placeChampions();
			//System.out.println("after placing champs");
		placeCovers();
		
		
		availableChampions = new ArrayList<Champion>();
		availableAbilities = new ArrayList<Ability>();
		
		loadAbilities("src\\Abilities.csv");
		loadChampions("src\\Champions.csv");
		
		
		prepareChampionTurns();
		
	}

	public boolean isFirstLeaderAbilityUsed() {
		return firstLeaderAbilityUsed;
	}

	public boolean isSecondLeaderAbilityUsed() {
		return secondLeaderAbilityUsed;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public Object[][] getBoard() {
		return board;
	}

	public PriorityQueue getTurnOrder() {
		return turnOrder;
	}

	public static ArrayList<Champion> getAvailableChampions() {
		return availableChampions;
	}

	public static ArrayList<Ability> getAvailableAbilities() {
		return availableAbilities;
	}

	public static int getBoardwidth() {
		return BOARDWIDTH;
	}

	public static int getBoardheight() {
		return BOARDHEIGHT;
	}
	
	
	
	
	
	
	
	

	public static void loadChampions(String filepath) throws IOException {
		
		availableChampions = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line = br.readLine();
		while (line != null) {
			String[] content = line.split(",");
			if (content[0].equals("H")) {
				Hero h = new Hero(content[1], Integer.parseInt(content[2]), Integer.parseInt(content[3]),
						Integer.parseInt(content[4]), Integer.parseInt(content[5]), Integer.parseInt(content[6]),
						Integer.parseInt(content[7]));
				h.getAbilities().add(getAbilityFromAvailable(content[8]));
				h.getAbilities().add(getAbilityFromAvailable(content[9]));
				h.getAbilities().add(getAbilityFromAvailable(content[10]));
				availableChampions.add(h);
			} else if (content[0].equals("V")) {
				Villain h = new Villain(content[1], Integer.parseInt(content[2]), Integer.parseInt(content[3]),
						Integer.parseInt(content[4]), Integer.parseInt(content[5]), Integer.parseInt(content[6]),
						Integer.parseInt(content[7]));
				h.getAbilities().add(getAbilityFromAvailable(content[8]));
				h.getAbilities().add(getAbilityFromAvailable(content[9]));
				h.getAbilities().add(getAbilityFromAvailable(content[10]));
				availableChampions.add(h);
			} else if (content[0].equals("A")) {
				AntiHero h = new AntiHero(content[1], Integer.parseInt(content[2]), Integer.parseInt(content[3]),
						Integer.parseInt(content[4]), Integer.parseInt(content[5]), Integer.parseInt(content[6]),
						Integer.parseInt(content[7]));
				h.getAbilities().add(getAbilityFromAvailable(content[8]));
				h.getAbilities().add(getAbilityFromAvailable(content[9]));
				h.getAbilities().add(getAbilityFromAvailable(content[10]));
				availableChampions.add(h);
			}
			line = br.readLine();
		}
		br.close();
	}

	
	
	
	
	
	
	private static Ability getAbilityFromAvailable(String string) {
		for (Ability ability : availableAbilities) {
			if (ability.getName().equals(string))
				return ability;
		}
		return null;
	}

	
	
	
	
	
	
	public static void loadAbilities(String filepath) throws IOException {
		availableAbilities = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line = br.readLine();
		while (line != null) {
			String[] content = line.split(",");
			if (content[0].equals("CC")) {
				availableAbilities.add(new CrowdControlAbility(content[1], Integer.parseInt(content[2]),
						Integer.parseInt(content[4]), Integer.parseInt(content[3]), AreaOfEffect.valueOf(content[5]),
						Integer.parseInt(content[6]), getEffect(content[7], Integer.parseInt(content[8]))));
			} else if (content[0].equals("DMG")) {
				availableAbilities.add(new DamagingAbility(content[1], Integer.parseInt(content[2]),
						Integer.parseInt(content[4]), Integer.parseInt(content[3]), AreaOfEffect.valueOf(content[5]),
						Integer.parseInt(content[6]), Integer.parseInt(content[7])));
			} else if (content[0].equals("HEL")) {
				availableAbilities.add(new HealingAbility(content[1], Integer.parseInt(content[2]),
						Integer.parseInt(content[4]), Integer.parseInt(content[3]), AreaOfEffect.valueOf(content[5]),
						Integer.parseInt(content[6]), Integer.parseInt(content[7])));
			}
			line = br.readLine();
		}
		br.close();
	}

	private static Effect getEffect(String name, int duration) {
		if (name.equals("Dodge"))
			return new Dodge(duration);
		if (name.equals("Disarm"))
			return new Disarm(duration);
		if (name.equals("Embrace"))
			return new Embrace(duration);
		if (name.equals("Stun"))
			return new Stun(duration);
		if (name.equals("Shield"))
			return new Shield(duration);
		if (name.equals("Shock"))
			return new Shock(duration);
		if (name.equals("PowerUp"))
			return new PowerUp(duration);
		if (name.equals("SpeedUp"))
			return new SpeedUp(duration);
		if (name.equals("Silence"))
			return new Silence(duration);
		if (name.equals("Root"))
			return new Root(duration);
		return null;
	}

	
	
	
	
	
	
	
	public void placeChampions() {
		for (int i = 0; i < firstPlayer.getTeam().size(); i++) {
			board[0][i + 1] = firstPlayer.getTeam().get(i);
			firstPlayer.getTeam().get(i).setLocation(new Point(0, i + 1));
			;
		}
		for (int i = 0; i < secondPlayer.getTeam().size(); i++) {
			board[4][i + 1] = secondPlayer.getTeam().get(i);
			secondPlayer.getTeam().get(i).setLocation(new Point(4, i + 1));
			;
		}
	}

	

	
	
	
	
	
	public void placeCovers() {
		int i = 0;
		while (i < 5) {
			int x = (int) (Math.random() * 3) + 1;
			int y = (int) (Math.random() * 5);
			if (board[x][y] == null) {
				board[x][y] = new Cover(x, y);
				i++;
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 1
	public Champion getCurrentChampion() {
		return (Champion) turnOrder.peekMin();
	}
	
	
	
	
	
	// 2
	public Player checkGameOver() {
		if (firstPlayer.getTeam().size() == 0)
			return secondPlayer;
		if (secondPlayer.getTeam().size() == 0)
			return firstPlayer;
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public void move(Direction d) throws UnallowedMovementException, NotEnoughResourcesException {
		Champion c = getCurrentChampion();
		int targetX;
		int targetY;
		
		if (d == Direction.UP) {
			targetX = c.getLocation().x + 1;
			targetY = c.getLocation().y;
		}
		
		else if (d == Direction.DOWN) {
			targetX = c.getLocation().x - 1;
			targetY = c.getLocation().y;
		}
		
		else if (d == Direction.LEFT) {
			targetX = c.getLocation().x;
			targetY = c.getLocation().y - 1;
		}
		
		else {
			targetX = c.getLocation().x;
			targetY = c.getLocation().y + 1;
		}
		
		
		if (c.getCurrentActionPoints() < 1)
			throw new NotEnoughResourcesException(
					"You need at least 1 action point in order to move in any direction.");
		
		if (targetX < 0 || targetX > 4 || targetY < 0 || targetY > 4)
			throw new UnallowedMovementException("You can only move inside the borders of the game.");
		
		if (c.getCondition() == Condition.ROOTED)
			throw new UnallowedMovementException("You cannot move while rooted.");
		
		if (board[targetX][targetY] != null)
			throw new UnallowedMovementException("You cannot move to an unempty cell.");
		
		c.setCurrentActionPoints(c.getCurrentActionPoints() - 1);
		
		board[c.getLocation().x][c.getLocation().y] = null;
		board[targetX][targetY] = c;
		
		//move
		MediaPlayer soundEffect = new MediaPlayer(MoveDirectionAlertBox.h1);
		soundEffect.play();
		soundEffect.setOnEndOfMedia(new Runnable() {
			
			public void run() {
				
				soundEffect.dispose();
			}
		});
		
		c.setLocation(new Point(targetX, targetY));
	}
	
	
	
	
	
	
	

	private boolean checkFriendly(Damageable d) {
		
		Champion c = getCurrentChampion();
		if ((firstPlayer.getTeam().contains(c) && firstPlayer.getTeam().contains(d))
				|| (secondPlayer.getTeam().contains(c) && secondPlayer.getTeam().contains(d)))
			return true;
		return false;
	}
	
	
	
	

	public void attack(Direction d)
			throws ChampionDisarmedException, NotEnoughResourcesException, InvalidTargetException {
		Champion c = getCurrentChampion();
		
		
		for (Effect e : c.getAppliedEffects()) {
			if (e instanceof Disarm)
				throw new ChampionDisarmedException();
		}
		
		
		if (c.getCurrentActionPoints() < 2)
			throw new NotEnoughResourcesException();
		
		int i = 1;
		boolean found = false;
		Damageable target = null;
		
		while (i <= c.getAttackRange() && !found) {
			
			if (d == Direction.DOWN && c.getLocation().x - i >= 0
					&& board[c.getLocation().x - i][c.getLocation().y] != null) {
				
				target = (Damageable) board[c.getLocation().x - i][c.getLocation().y];
				if (!checkFriendly(target)) // if checkFriendly == false
					found = true;
				
			} else if (d == Direction.UP && c.getLocation().x + i <= 4
					&& board[c.getLocation().x + i][c.getLocation().y] != null) {
				
				target = (Damageable) board[c.getLocation().x + i][c.getLocation().y];
				if (!checkFriendly(target))
					found = true;
				
			} else if (d == Direction.LEFT && c.getLocation().y - i >= 0
					&& board[c.getLocation().x][c.getLocation().y - i] != null) {
				
				target = (Damageable) board[c.getLocation().x][c.getLocation().y - i];
				if (!checkFriendly(target))
					found = true;
				
			} else if (d == Direction.RIGHT && c.getLocation().y + i <= 4
					&& board[c.getLocation().x][c.getLocation().y + i] != null) {
				
				target = (Damageable) board[c.getLocation().x][c.getLocation().y + i];
				if (!checkFriendly(target))
					found = true;
			}
			i++;
		}
		
		if (found) {
			c.setCurrentActionPoints(c.getCurrentActionPoints() - 2);
			if (target instanceof Champion) {
				
				for (Effect e : ((Champion) target).getAppliedEffects()) {
					if (e instanceof Shield) {
						e.remove((Champion) target);
						((Champion) target).getAppliedEffects().remove(e);
						return;
					}
				}
				for (Effect e : ((Champion) target).getAppliedEffects()) {
					if (e instanceof Dodge) {
						int rand = (int) (Math.random() * 10);
						if (rand < 5) {
							return;
						}
					}
				}
			}
			if (checkBonus(target)) {
				
				MediaPlayer soundEffect = new MediaPlayer(AttackDirectionAlertBox.h);
				soundEffect.play();
				soundEffect.setOnEndOfMedia(new Runnable() {
					
					public void run() {
						
						soundEffect.dispose();
					}
				});
				
				target.setCurrentHP(target.getCurrentHP() - (int) (c.getAttackDamage() * 1.5));
			} else {
				
				MediaPlayer soundEffect = new MediaPlayer(AttackDirectionAlertBox.h);
				soundEffect.play();
				soundEffect.setOnEndOfMedia(new Runnable() {
					
					public void run() {
						
						soundEffect.dispose();
					}
				});
				
				target.setCurrentHP(target.getCurrentHP() - c.getAttackDamage());
			}
			
			if (target.getCurrentHP() == 0) {
				
				if (target instanceof Champion) {
					
					for (int j = 0; j < GameWindow.getGameRound().getFirstPlayer().getTeam().size(); j++) {
						
						if (GameWindow.getGameRound().getFirstPlayer().getTeam().get(j).getName().equals( ((Champion) target).getName())   ) {
							
							GameWindow.removeFromSide(((Champion) target).getName(), getButton(((Champion) target).getName()));
						}
					}
					for (int j = 0; j < GameWindow.getGameRound().getSecondPlayer().getTeam().size(); j++) {
						
						if (GameWindow.getGameRound().getSecondPlayer().getTeam().get(j).getName().equals( ((Champion) target).getName())   ) {
							
							GameWindow.removeFromSide(((Champion) target).getName(), getButton(((Champion) target).getName()));
						}
					}
				}
				
				clear(target);
				
				MediaPlayer soundEffect = new MediaPlayer(h10);
				soundEffect.play();
				soundEffect.setOnEndOfMedia(new Runnable() {
					
					public void run() {
						
						soundEffect.dispose();
					}
				});
			}
			
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean checkBonus(Damageable d) {
		
		Champion c = getCurrentChampion();
		if ((c instanceof Hero && d instanceof Hero) || (c instanceof Villain && d instanceof Villain)
				|| (c instanceof AntiHero && d instanceof AntiHero) || d instanceof Cover)
			return false;
		return true;
	}

	
	
	
	
	public void clear(Damageable d) {
		
		Point location = d.getLocation();
		if (d instanceof Champion) {
			ArrayList<Champion> temp = new ArrayList<>();
			while (!turnOrder.isEmpty()) {
				temp.add((Champion) turnOrder.remove());
			}
			temp.remove(d);
			while (!temp.isEmpty()) {
				turnOrder.insert(temp.remove(0));
			}
			firstPlayer.getTeam().remove(d);
			secondPlayer.getTeam().remove(d);
		}
		board[location.x][location.y] = null;
	}
	

	
	
	
	private void prepareChampionTurns() {
		
		for (Champion c : firstPlayer.getTeam()) {
			turnOrder.insert(c);
		}
		for (Champion c : secondPlayer.getTeam()) {
			turnOrder.insert(c);
		}
	}

	
	
	
	
	
	public void useLeaderAbility() throws LeaderAbilityAlreadyUsedException, LeaderNotCurrentException {
		
		flag5ara = false;
		thorsLA = false;
		
		Champion c = getCurrentChampion();
		ArrayList<Champion> targets = new ArrayList<>();
		
		
		if (firstPlayer.getLeader() == c) {
			
			if (firstLeaderAbilityUsed)
				throw new LeaderAbilityAlreadyUsedException("You can only use your leader ability once per game.");
			firstLeaderAbilityUsed = true;
			
			if (c instanceof Hero) {
				targets.addAll(firstPlayer.getTeam());
				
				
				
			} else if (c instanceof Villain) {
				for (Champion champion : secondPlayer.getTeam()) {
					if (champion.getCurrentHP() <= (int) (champion.getMaxHP() * 0.3))
						targets.add(champion);
				}
			} 
			
			
			
			else {	// if AntiHero
				targets.addAll(firstPlayer.getTeam());
				targets.remove(firstPlayer.getLeader());
				targets.addAll(secondPlayer.getTeam());
				targets.remove(secondPlayer.getLeader());
			}
		} 
		
		
		else if (secondPlayer.getLeader() == c) {
			if (secondLeaderAbilityUsed)
				throw new LeaderAbilityAlreadyUsedException();
			secondLeaderAbilityUsed = true;
			
			
			if (c instanceof Hero) {
				targets.addAll(secondPlayer.getTeam());
				
			} 
			
			else if (c instanceof Villain) {
				for (Champion champion : firstPlayer.getTeam()) {
					if (champion.getCurrentHP() <= (int) (champion.getMaxHP() * 0.3))
						targets.add(champion);
				}
			}
			
			
			else {
				targets.addAll(firstPlayer.getTeam());
				targets.remove(firstPlayer.getLeader());
				targets.addAll(secondPlayer.getTeam());
				targets.remove(secondPlayer.getLeader());
			}
			
		}
		else {// currentChampion is not the Leader
			throw new LeaderNotCurrentException("You can only use your leader ability during your leader's turn.");
		}
		
		
		
		if (GameWindow.getGameRound().getCurrentChampion().getName().equals("Ironman")) {
			
			GameWindow.ironmanSLA = true;
			GameWindow.displayBoardChamps();
			
			
			GameMusic.backGroundMusic.pause();
			MediaPlayer soundEffect = new MediaPlayer(hHB1);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
			
			
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					GameWindow.displayBoardChamps();
					GameMusic.backGroundMusic.play();
				}
			});
		}
		else if (GameWindow.getGameRound().getCurrentChampion().getName().equals("Loki")) {
			
			flag5ara = true;
			//GameWindow.lokiSLA = true;
			GameWindow.displayBoardChamps();
			GameWindow.displayLokis();
			
			
			GameMusic.backGroundMusic.pause();
			MediaPlayer soundEffect = new MediaPlayer(hHB);
			soundEffect.play();
			
			BackgroundFill background = new BackgroundFill(Color.valueOf("#023020"), new CornerRadii(0), new Insets(0));
			Background bg = new Background(background);
			GameWindow.gameLayout.setBackground(bg);

			
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
					
					BackgroundFill background = new BackgroundFill(Color.valueOf("#800000"), new CornerRadii(0), new Insets(0));
					Background bg = new Background(background);
					GameWindow.gameLayout.setBackground(bg);
					
					flag5ara = false;
					GameWindow.displayBoardChamps();
					GameMusic.backGroundMusic.play();
				}
			});
		}
		
		else if (GameWindow.getGameRound().getCurrentChampion().getName().equals("Thor")) {
			
			thorsLA = true;
			
			GameMusic.backGroundMusic.pause();
			MediaPlayer soundEffect = new MediaPlayer(hThor);
			soundEffect.play();

			
			
//			BackgroundImage backgroundImage = new BackgroundImage(
//	                new Image(new File("src/Resources/ThorBringGif3.gif")
//	                        .toURI().toString()),
//	                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
//	                new BackgroundSize(100, 100, true, true, true, true));
//			GameWindow.gameLayout.setBackground(new Background(backgroundImage));
			
			
			BackgroundFill background = new BackgroundFill(Color.MIDNIGHTBLUE, new CornerRadii(0), new Insets(0));
			Background bg = new Background(background);
			GameWindow.gameLayout.setBackground(bg);
			
			
			GameWindow.displayBoardChamps();
			
			
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
					
					BackgroundFill background = new BackgroundFill(Color.valueOf("#800000"), new CornerRadii(0), new Insets(0));
					Background bg = new Background(background);
					GameWindow.gameLayout.setBackground(bg);
					
					//GameWindow.displayBoardChamps();
					GameMusic.backGroundMusic.play();
					thorsLA = false;
					GameWindow.displayBoardChamps();
				}
			});
		}
		else if (GameWindow.getGameRound().getCurrentChampion().getName().equals("Yellow Jacket")) {
			
			yellowFlag = true;
			//GameWindow.lokiSLA = true;
			GameWindow.displayBoardChamps();
			
			
			GameMusic.backGroundMusic.pause();
			MediaPlayer soundEffect = new MediaPlayer(hYellow);
			soundEffect.play();
			
			BackgroundFill background = new BackgroundFill(Color.GOLD, new CornerRadii(0), new Insets(0));
			Background bg = new Background(background);
			GameWindow.gameLayout.setBackground(bg);

			
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
					
					BackgroundFill background = new BackgroundFill(Color.valueOf("#800000"), new CornerRadii(0), new Insets(0));
					Background bg = new Background(background);
					GameWindow.gameLayout.setBackground(bg);
					
					yellowFlag = false;
					GameWindow.displayBoardChamps();
					GameMusic.backGroundMusic.play();
				}
			});
		}
		else if (GameWindow.getGameRound().getCurrentChampion().getName().equals("Deadpool")) {
			
			
			GameMusic.backGroundMusic.pause();
			MediaPlayer soundEffect = new MediaPlayer(hDead);
			soundEffect.play();

			
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
					GameMusic.backGroundMusic.play();
				}
			});
		}
		
		else {
			
			MediaPlayer soundEffect = new MediaPlayer(hLA);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
			GameWindow.displayBoardChamps();
		}
		
		//GameWindow.displayBoardChamps();
		
		c.useLeaderAbility(targets);
		
//		if (flag5ara = false)
//			GameWindow.displayBoardChamps();
		
		
//		MediaPlayer soundEffect = new MediaPlayer(hLA);
//		soundEffect.play();

	}

	
	
	
	
	
	
	
	
	public void endTurn() {
		
		turnOrder.remove();
		if (turnOrder.isEmpty())
			prepareChampionTurns();
		
		
		updateChampionTimersAndActions();
		
		
		if (getCurrentChampion().getCondition() == Condition.INACTIVE)
			endTurn();
	}

	
	
	
	
	
	
	
	private void updateChampionTimersAndActions() {
		Champion c = getCurrentChampion();
		
		
		for (Ability ability : c.getAbilities()) {
			if (ability.getCurrentCooldown() > 0)
				ability.setCurrentCooldown(ability.getCurrentCooldown() - 1);
		}
		
		
		for (int i = 0; i < c.getAppliedEffects().size(); i++) {
			
			Effect e = c.getAppliedEffects().get(i);
			e.setDuration(e.getDuration() - 1);
			if (e.getDuration() == 0) {
				e.remove(c);
				c.getAppliedEffects().remove(i);
				i--;
			}
		}
		c.setCurrentActionPoints(c.getMaxActionPointsPerTurn());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void validateCastAbility(Ability a) throws AbilityUseException, NotEnoughResourcesException {
		Champion c = getCurrentChampion();
		
		if (!c.getAbilities().contains(a))
			throw new AbilityUseException("You can only use abilities your current champion has.");
		boolean sil = false;
		
		for (Effect e : c.getAppliedEffects()) {
			if (e instanceof Silence)
				sil = true;
		}
		
		if (sil)
			throw new AbilityUseException("You cannot use abilities while your champion is silenced.");
		if (c.getMana() < a.getManaCost())
			throw new NotEnoughResourcesException("You cannot use abilities you do not have enough mana for.");
		if (c.getCurrentActionPoints() < a.getRequiredActionPoints())
			throw new NotEnoughResourcesException("You cannot use abilities you do not have enough action points for.");
		if (a.getCurrentCooldown() > 0)
			throw new AbilityUseException("You cannot use abilities that are still in cooldown.");
	}

	
	
	
	
	
	
	
	
	// teamtarget, selftarget, surround
	public void castAbility(Ability a)
			throws AbilityUseException, NotEnoughResourcesException, CloneNotSupportedException {
		Champion c = getCurrentChampion();
		
		
		validateCastAbility(a);
		
		
		ArrayList<Damageable> temp = getTargets(a);
		ArrayList<Damageable> targets;
		
		if (a.getCastArea() == AreaOfEffect.SELFTARGET)
			targets = temp;
		else
			targets = filterTargets(temp, a);

		a.execute(targets);
		
		
		if (a instanceof DamagingAbility) {
			
			MediaPlayer soundEffect = new MediaPlayer(AbilityAlertBox.h1);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		}
		else if (a instanceof HealingAbility) {
			
			MediaPlayer soundEffect = new MediaPlayer(AbilityAlertBox.h2);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		}
		else if (a instanceof CrowdControlAbility) {
			
			MediaPlayer soundEffect = new MediaPlayer(AbilityAlertBox.h3);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		}
		
		c.setCurrentActionPoints(c.getCurrentActionPoints() - a.getRequiredActionPoints());
		c.setMana(c.getMana() - a.getManaCost());
		a.setCurrentCooldown(a.getBaseCooldown());
		clean(targets);
		
		
	}
	

	
	
	
	
	
	
	// directional
	public void castAbility(Ability a, Direction d)
			throws AbilityUseException, NotEnoughResourcesException, CloneNotSupportedException {
		Champion c = getCurrentChampion();
		validateCastAbility(a);
		
		ArrayList<Damageable> temp = getTargetsDirectional(a, d);
		ArrayList<Damageable> targets = filterTargets(temp, a);

		a.execute(targets);
		
		if (a instanceof DamagingAbility) {
			
			MediaPlayer soundEffect = new MediaPlayer(AbilityAlertBox.h1);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		}
		else if (a instanceof HealingAbility) {
			
			MediaPlayer soundEffect = new MediaPlayer(AbilityAlertBox.h2);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		}
		else if (a instanceof CrowdControlAbility) {
			
			MediaPlayer soundEffect = new MediaPlayer(AbilityAlertBox.h3);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		}
		
		c.setCurrentActionPoints(c.getCurrentActionPoints() - a.getRequiredActionPoints());
		c.setMana(c.getMana() - a.getManaCost());
		a.setCurrentCooldown(a.getBaseCooldown());
		clean(targets);
		
		
	}

	
	
	
	
	
	
	
	
	// singletarget
	public void castAbility(Ability a, int x, int y) throws AbilityUseException, NotEnoughResourcesException,
			InvalidTargetException, CloneNotSupportedException {
		
		Champion c = getCurrentChampion();
		validateCastAbility(a);
		
		ArrayList<Damageable> targets = getTargetsSingle(a, x, y);

		a.execute(targets);
		
		
		if (a instanceof DamagingAbility) {
			
			MediaPlayer soundEffect = new MediaPlayer(AbilityAlertBox.h1);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		}
		else if (a instanceof HealingAbility) {
			
			MediaPlayer soundEffect = new MediaPlayer(AbilityAlertBox.h2);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		}
		else if (a instanceof CrowdControlAbility) {
			
			MediaPlayer soundEffect = new MediaPlayer(AbilityAlertBox.h3);
			soundEffect.play();
			soundEffect.setOnEndOfMedia(new Runnable() {
				
				public void run() {
					
					soundEffect.dispose();
				}
			});
		}
		
		c.setCurrentActionPoints(c.getCurrentActionPoints() - a.getRequiredActionPoints());
		c.setMana(c.getMana() - a.getManaCost());
		a.setCurrentCooldown(a.getBaseCooldown());
		clean(targets);
		
		
	}
	
	
	
	
	
	
	

	private ArrayList<Damageable> getTargets(Ability a) {
		
		
		ArrayList<Damageable> targets = new ArrayList<Damageable>();
		Point center = getCurrentChampion().getLocation();
		
		
		if (a.getCastArea() == AreaOfEffect.SURROUND) {
			
			for (int i = -1; i <= 1; i++) {
				
				for (int j = -1; j <= 1; j++) {
					
					if (center.x + i >= 0 && center.x + i <= 4 && center.y + j >= 0 && center.y + j <= 4
							&& !(i == 0 && j == 0) && board[center.x + i][center.y + j] != null) {
						
						targets.add((Damageable) board[center.x + i][center.y + j]);
					}
				}
			}
			
		}
		
		else if (a.getCastArea() == AreaOfEffect.SELFTARGET) {
			targets.add(getCurrentChampion());
		}
		
		else if (a.getCastArea() == AreaOfEffect.TEAMTARGET) {
			
			for (Champion c2 : secondPlayer.getTeam()) {
				
				if (checkRange(a.getCastRange(), c2))
					targets.add(c2);
			}
			for (Champion c2 : firstPlayer.getTeam()) {
				
				if (checkRange(a.getCastRange(), c2))
					targets.add(c2);
			}
		}
		return targets;
	}

	
	
	
	
	
	
	
	private ArrayList<Damageable> getTargetsDirectional(Ability a, Direction d) {
		
		Point center = getCurrentChampion().getLocation();
		
		ArrayList<Damageable> targets = new ArrayList<Damageable>();
		
		for (int i = 1; i <= a.getCastRange(); i++) {
			
			if (d == Direction.UP && center.x + i < 5 && board[center.x + i][center.y] != null) {
				targets.add((Damageable) board[center.x + i][center.y]);
			}
			
			else if (d == Direction.DOWN && center.x - i >= 0 && board[center.x - i][center.y] != null) {
				targets.add((Damageable) board[center.x - i][center.y]);
			}
			
			else if (d == Direction.RIGHT && center.y + i < 5 && board[center.x][center.y + i] != null) {
				targets.add((Damageable) board[center.x][center.y + i]);
			}
			
			else if (d == Direction.LEFT && center.y - i >= 0 && board[center.x][center.y - i] != null) {
				targets.add((Damageable) board[center.x][center.y - i]);
			}
		}
		return targets;
	}
	
	
	
	
	
	
	

	private ArrayList<Damageable> getTargetsSingle(Ability a, int x, int y)
			throws AbilityUseException, InvalidTargetException {
		
		if (board[x][y] == null)
			throw new InvalidTargetException("You cannot cast a single target ability on an empty cell.");
		
		Damageable target = (Damageable) board[x][y];
		
		if (target instanceof Cover && !(a instanceof DamagingAbility))
			throw new InvalidTargetException("You cannot use this ability on a cover.");
		
		if (checkFriendly(target) && (a instanceof DamagingAbility || (a instanceof CrowdControlAbility
				&& ((CrowdControlAbility) a).getEffect().getType() == EffectType.DEBUFF)))
			throw new InvalidTargetException("You cannot use this ability on a friendly champion.");
		
		if (!checkFriendly(target) && (a instanceof HealingAbility || (a instanceof CrowdControlAbility
				&& ((CrowdControlAbility) a).getEffect().getType() == EffectType.BUFF)))
			throw new InvalidTargetException("You cannot use this ability on an enemy champion.");
		
		if (!checkRange(a.getCastRange(), ((Damageable) board[x][y])))
			throw new AbilityUseException(
					"You can only use single target abilities on targets that are within ability range.");
		
		ArrayList<Damageable> targets = new ArrayList<>();
		targets.add(target);
		
		if (a instanceof DamagingAbility && target instanceof Champion) {
			
			for (Effect eff : ((Champion) target).getAppliedEffects()) {
				
				if (eff instanceof Shield) {
					eff.remove(((Champion) target));
					targets.remove(target);
					((Champion) target).getAppliedEffects().remove(eff);
					break;
				}
			}
		}
		return targets;
	}
	
	
	
	
	
	
	
	
	private ArrayList<Damageable> filterTargets(ArrayList<Damageable> t, Ability a) {
		
		ArrayList<Damageable> targets = new ArrayList<Damageable>();
		
		for (Damageable d : t) {
			
			if (a instanceof DamagingAbility && !checkFriendly(d)) {
				targets.add(d);
			}
			
			else if (a instanceof HealingAbility && checkFriendly(d)) {
				targets.add(d);
			}
			
			else if (a instanceof CrowdControlAbility
					&& ((CrowdControlAbility) a).getEffect().getType() == EffectType.BUFF && d instanceof Champion
					&& checkFriendly(d)) {
				targets.add(d);
			}
			
			else if (a instanceof CrowdControlAbility
					&& ((CrowdControlAbility) a).getEffect().getType() == EffectType.DEBUFF && d instanceof Champion
					&& !checkFriendly(d)) {
				targets.add(d);
			}
		}
		
		
		if (a instanceof DamagingAbility) {
			
			for (int i = 0; i < targets.size(); i++) {
				
				if (targets.get(i) instanceof Champion) {
					
					for (Effect eff : ((Champion) targets.get(i)).getAppliedEffects()) {
						
						if (eff instanceof Shield) {
							((Champion) targets.get(i)).getAppliedEffects().remove(eff);
							eff.remove(((Champion) targets.get(i)));
							targets.remove(i);
							i--;
							break;
						}
					}
				}
			}
		}
		return targets;
	}
	
	
	
	

	
	
	
	
	private int manDistance(Point l1, Point l2) {
		
		return Math.abs(l1.x - l2.x) + Math.abs(l1.y - l2.y);
	}
	
	
	
	
	
	

	private boolean checkRange(int range, Damageable d) {
		
		int dis = manDistance(d.getLocation(), getCurrentChampion().getLocation());
		
		if (dis <= range)
			return true;
		return false;
	}
	
	
	
	
	
	

	public void clean(ArrayList<Damageable> targets) {
		
		for (Damageable d : targets) {
			
			if (d.getCurrentHP() <= 0) {
				
				
				if (d instanceof Champion) {
					
					for (int i = 0; i < GameWindow.getGameRound().getFirstPlayer().getTeam().size(); i++) {
						
						if (GameWindow.getGameRound().getFirstPlayer().getTeam().get(i).getName().equals( ((Champion) d).getName())   ) {
							
							GameWindow.removeFromSide(((Champion) d).getName(), getButton(((Champion) d).getName()));
						}
					}
					for (int i = 0; i < GameWindow.getGameRound().getSecondPlayer().getTeam().size(); i++) {
						
						if (GameWindow.getGameRound().getSecondPlayer().getTeam().get(i).getName().equals( ((Champion) d).getName())   ) {
							
							GameWindow.removeFromSide(((Champion) d).getName(), getButton(((Champion) d).getName()));
						}
					}
				}
					
				
				
				clear(d);
				MediaPlayer soundEffect = new MediaPlayer(h10);
				soundEffect.play();
				soundEffect.setOnEndOfMedia(new Runnable() {
					
					public void run() {
						
						soundEffect.dispose();
					}
				});
			}
		}
	}
	
	
	
	
	public Button getButton(String name) {
		
		for (int i = 0; i < GameWindow.sideButtons1.size(); i++) {
			
			if (name.equals(GameWindow.sideButtons1.get(i).getText()))
				return GameWindow.sideButtons1.get(i);
		}
		for (int i = 0; i < GameWindow.sideButtons2.size(); i++) {
			
			if (name.equals(GameWindow.sideButtons2.get(i).getText()))
				return GameWindow.sideButtons2.get(i);
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
