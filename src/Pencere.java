import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pencere {
	static JFrame[] pencere=new JFrame[6];
	static JLabel[] label=new JLabel[4];
	
	static  JLabel Levelgecislabel;
	
	
	static Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	static Point hotSpot = new Point(0, 0);
	
	static BufferedImage cursorImage = new BufferedImage(10, 10,BufferedImage.TRANSLUCENT);
	
	static Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage,hotSpot, "InvisibleCursor");
	
	public static void main(String[] args) 
	{
		Harita1 harita1 = new Harita1();
		Harita2 harita2 = new Harita2();
		Harita3 harita3 = new Harita3();
		Harita4 harita4 = new Harita4();
		LevelGecis lvlgecis = new LevelGecis();
		
		AcilisHaritasi acilisharitasi =new AcilisHaritasi();
		FareDinleyici fare = new FareDinleyici();
		
	    for (int i = 0; i < pencere.length; i++) 
	    {
	    	pencere[i] = new JFrame("Harita");
	    	pencere[i].setSize(500,500);
	    	pencere[i].setVisible(false);
	    	pencere[i].setLocation(410, 0);
	    	pencere[i].addMouseMotionListener(fare);
	    	pencere[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	pencere[i].setResizable(false);
	    	pencere[i].setCursor(invisibleCursor);
		}
	    pencere[0].setVisible(true); 
	    pencere[0].add(acilisharitasi);
    	pencere[1].add(harita1);
    	pencere[2].add(harita2);
    	pencere[3].add(harita3);
    	pencere[4].add(harita4);
    	
    	
    	acilisharitasi.setBackground(Color.DARK_GRAY);
    	harita1.setBackground(Color.WHITE);
    	harita2.setBackground(Color.WHITE);
    	harita3.setBackground(Color.WHITE);
    	harita4.setBackground(Color.WHITE);
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
    	label[0].setBounds(new Rectangle(new Point(150, 100), label[0].getPreferredSize()));
    	label[1].setBounds(new Rectangle(new Point(150, 170), label[1].getPreferredSize()));
    	label[2].setBounds(new Rectangle(new Point(150, 260), label[2].getPreferredSize()));
    	 acilisharitasi.add(label[0]);
    	 acilisharitasi.add(label[1]);	
    	 acilisharitasi.add(label[2]);	
    	 JLabel BASLIKlabel=new JLabel("Frutsta V5");
    	 BASLIKlabel.setFont(tip);
    	 BASLIKlabel.setForeground(Color.RED);
    	 BASLIKlabel.setBounds(new Rectangle(new Point(100, 20), BASLIKlabel.getPreferredSize()));
    	 acilisharitasi.add(BASLIKlabel);
    	 
    	 
    	 
    	 
    	 Levelgecislabel=new JLabel("LEVEL 1 ");
    	 Levelgecislabel.setFont(tip);
    	 Levelgecislabel.setForeground(Color.RED);
    	 Levelgecislabel.setBounds(new Rectangle(new Point(150, 80), Levelgecislabel.getPreferredSize()));
    	 pencere[5].add(Levelgecislabel);
    	 pencere[5].add(lvlgecis);
	}
}
