import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sesler {
	 
	
	static Clip clip;
	 public static void YemSes()
	 {
		 AudioInputStream audioInputStream;
		 try {                                                                              
		        audioInputStream = AudioSystem.getAudioInputStream(new File("../Frutsta_Alfa_1/ses/yem/yemses.wav").getAbsoluteFile());
		   	    clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();}}}
