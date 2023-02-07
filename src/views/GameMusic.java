package views;

import java.nio.file.Paths;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import views.BuiltWindow.HomeScreenWindow;

public class GameMusic {
	
	public static boolean gameOver = false;

	static int songNumber = 1;
	
	public static String s = "src/Resources/Spiderman.mp3";
	public static Media h = new Media(Paths.get(s).toUri().toString());
	public static MediaPlayer backGroundMusic = new MediaPlayer(h);
	static String song = s;
	
	//backGroundMusic.setCycleCount(AudioClip.INDEFINITE);
	
	
	public static void allMusic() {
		
		backGroundMusic.setVolume(0.005);
		backGroundMusic.play();
		
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(5),
						new KeyValue(backGroundMusic.volumeProperty(), 0.05)));
		timeline.play();
		backGroundMusic.setOnEndOfMedia(new Runnable() {
			
			public void run() {
				
				if (gameOver == false) {
				
					if (song.equals("src/Resources/Spiderman.mp3"))
						song = "src/Resources/IronMan3.mp3";
					
					else if (song.equals("src/Resources/IronMan3.mp3"))
						song = "src/Resources/XMen.mp3";
					
					else if (song.equals("src/Resources/XMen.mp3"))
					song = "src/Resources/BlackSabbathIronman.mp3";
					
					else if (song.equals("src/Resources/BlackSabbathIronman.mp3"))
						song = "src/Resources/DoctorStrange.mp3";
					
					else if (song.equals("src/Resources/DoctorStrange.mp3"))
						song = "src/Resources/Deadpool.mp3";
	
					else if (song.equals("src/Resources/Deadpool.mp3"))
						song = "src/Resources/ThorRagnarok.mp3";
					
					else if (song.equals("src/Resources/ThorRagnarok.mp3"))
						song = "src/Resources/PortalsEndGame.mp3";
					
					else if (song.equals("src/Resources/PortalsEndGame.mp3"))
						song = "src/Resources/GhostRider.mp3";
					
					else if (song.equals("src/Resources/GhostRider.mp3"))
						song = "src/Resources/Ironman3.mp3";
					
					
					
					h = new Media(Paths.get(song).toUri().toString());
					backGroundMusic.setOnEndOfMedia(new Runnable() {
						
						public void run() {
							
							backGroundMusic.dispose();
						}
					});
					backGroundMusic = new MediaPlayer(h);
					allMusic();
				}
			}
		});
	}

	
	
//	public static void skip() {
//		
//		backGroundMusic.
//	}
	
	
	
	
	
	
	
	
	
	public static void nextSong() {
		
		if (songNumber == 10)
			songNumber = 1;
		
		switch (songNumber) {
		
			case 1: s = "src/Resources/IronMan3.mp3";
			case 2: s = "src/Resources/GhostRider.mp3";
			case 3: s = "src/Resources/BlackSabbathIronman.mp3";
			case 4: s = "src/Resources/Deadpool.mp3";
			case 5: s = "src/Resources/XMen.mp3";
			case 6: s = "src/Resources/DoctorStrange.mp3";
			case 7: s = "src/Resources/ThorRagnarok.mp3";
			case 8: s = "src/Resources/PortalsEndGame.mp3";
			case 9: s = "src/Resources/Spiderman.mp3";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
