import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class Sesler extends Object  {
	 public void YemSes()
	 {
		 AudioInputStream audioInputStream;
		 try {                                                                              
		        audioInputStream = AudioSystem.getAudioInputStream(new File("../Frutsta_Alfa_1/ses/yem/yemses.wav").getAbsoluteFile());
		        ses = AudioSystem.getClip();
		        ses.open(audioInputStream);
		        ses.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();}}
	 public void BayrakSes()
	 {
		 AudioInputStream audioInputStream;
		 try {                                                                              
		        audioInputStream = AudioSystem.getAudioInputStream(new File("../Frutsta_Alfa_1/ses/bayrak/bayrakses.wav").getAbsoluteFile());
		   	    ses = AudioSystem.getClip();
		        ses.open(audioInputStream);
		        ses.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	 }
	 
	 
	 public void KapiSes()
	 {
		 AudioInputStream audioInputStream;
		 try {                                                                              
		        audioInputStream = AudioSystem.getAudioInputStream(new File("../Frutsta_Alfa_1/ses/kapi/kapises.wav").getAbsoluteFile());
		   	    ses = AudioSystem.getClip();
		        ses.open(audioInputStream);
		        ses.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	 }
	 public void HareketSes()
	 {
		 AudioInputStream audioInputStream;
		 try {                                                                              
		        audioInputStream = AudioSystem.getAudioInputStream(new File("../Frutsta_Alfa_1/ses/hareket/hareketses.wav").getAbsoluteFile());
		   	    ses = AudioSystem.getClip();
		        ses.open(audioInputStream);
		        ses.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	 }
	 
	 
	 
	 public void OlumSes()
	 {
		 AudioInputStream audioInputStream;
		 try {                                                                              
		        audioInputStream = AudioSystem.getAudioInputStream(new File("../Frutsta_Alfa_1/ses/olum/olum1.wav").getAbsoluteFile());
		   	    ses = AudioSystem.getClip();
		        ses.open(audioInputStream);
		        ses.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	 }
	 
	 
	 public void MenuSes()
	 {
		 AudioInputStream audioInputStream;
		 try {                                                                              
		        audioInputStream = AudioSystem.getAudioInputStream(new File("../Frutsta_Alfa_1/ses/menu/menuses1.wav").getAbsoluteFile());
		   	    ses = AudioSystem.getClip();
		        ses.open(audioInputStream);
		        ses.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	 }
	 
	 
	 
	 
	 
}
