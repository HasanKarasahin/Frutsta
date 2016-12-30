import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pencere extends JPanel {
	static JFrame[] pencere=new JFrame[7];
	static JLabel[] label=label=new JLabel[5];
	JLabel BASLIKlabel=new JLabel("Frutsta V7");
	static  JLabel Levelgecislabel;
		public static void main(String[] args) 
		{	
			Harita1 harita1 = new Harita1();
			Harita2 harita2 = new Harita2();
			Harita3 harita3 = new Harita3();
			Harita4 harita4 = new Harita4();
			Harita5 harita5 = new Harita5();
			LevelGecis lvlgecis = new LevelGecis();
			AcilisHaritasi acilisharitasi =new AcilisHaritasi();
			FareDinleyici fare = new FareDinleyici();
		    for (int i = 0; i < pencere.length; i++) 
		    {
		    	pencere[i] = new JFrame();
		    	pencere[i].setSize(500,500);
		    	pencere[i].setLocation(410, 50);
		    	pencere[i].addMouseMotionListener(fare);
		    	pencere[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	pencere[i].setResizable(false);
		        pencere[i].getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 10, 10, Color.BLACK));
			}
		    pencere[1].setUndecorated(true);
		    pencere[2].setUndecorated(true);
		    pencere[3].setUndecorated(true);
		    pencere[4].setUndecorated(true);
		    pencere[5].setUndecorated(true);
		    pencere[6].setUndecorated(true);
		    pencere[0].setVisible(true); 
		    pencere[0].add(acilisharitasi);
	    	pencere[1].add(harita1);
	    	pencere[2].add(harita2);
	    	pencere[3].add(harita3);
	    	pencere[4].add(harita4);
	    	pencere[5].add(harita5);
	    	acilisharitasi.setBackground(Color.DARK_GRAY);
	    	lvlgecis.setBackground(Color.BLACK);
	    	Font tip=new Font("Algerian", 50, 50);
	    	for (int i = 0; i < label.length; i++) 
	    	{
	    		 label[i]=new JLabel();
	    		 label[i].setFont(tip);
	    		 label[i].setForeground(Color.LIGHT_GRAY);	 
			}
	    	label[0].setText("Basla");
	    	label[1].setText("Bilgi");
	    	label[2].setText("Ayar");
	    	label[3].setText("Frutsta V7");
	    	label[3].setForeground(Color.RED);
	    	 acilisharitasi.add(label[0]);
	    	 acilisharitasi.add(label[1]);	
	    	 acilisharitasi.add(label[2]);	
	    	 acilisharitasi.add(label[3]);	
	    	 Levelgecislabel=new JLabel("LEVEL 1");
	    	 Levelgecislabel.setFont(tip);
	    	 Levelgecislabel.setBounds(150, 10, 400, 100);
	    	 Levelgecislabel.setForeground(Color.RED);
	    	 pencere[6].add(Levelgecislabel);
	    	 pencere[6].add(lvlgecis);}}