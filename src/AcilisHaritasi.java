import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class AcilisHaritasi extends Haritalar implements ActionListener {
	static Timer acilistimer;
    static Timer acilistimer2;
	int kontrol=0;
	ZamanCubugu zamancubugu;
	 boolean  AcilisKontrol1=false;
	static boolean AcilisMap_kontrol=true;
	Sesler seskontrol = new Sesler();
	int menukontrol=0;
	public AcilisHaritasi() {
		super();
		zamancubugu=new ZamanCubugu();
		hareketsizengel=new HareketsizEngeller[7];
		hareketsizengel[0]=new HareketsizEngeller(0, 0, 500, 100);
		hareketsizengel[1]=new HareketsizEngeller(0,400,500,75);
		hareketsizengel[2]=new HareketsizEngeller(0,80,80,260);
		hareketsizengel[3]=new HareketsizEngeller(420,0,75,450);
		hareketsizengel[4]=new HareketsizEngeller(150,160,270,20);
		hareketsizengel[5]=new HareketsizEngeller(150,240,270,20);
		hareketsizengel[6]=new HareketsizEngeller(150,320,270,20);
		player=new Player(0, 360, 25, 25);
		acilistimer=new Timer(20, this);
		acilistimer2=new Timer(100, this);
		acilistimer.start();
		acilistimer2.stop();
	}
	@Override
	protected void paintComponent(Graphics g) 
      {
		super.paintComponent(g);
		if(AcilisMap_kontrol)
		{
			    for (int i = 0; i < hareketsizengel.length; i++) 
			    hareketsizengel[i].HareketsizEngelciz(g);	 
			    zamancubugu.zamancubuguCiz(g);
			    player.PlayerCiz(g);
			    label[0].setBounds(new Rectangle(new Point(150, 100), label[0].getPreferredSize()));
		    	label[1].setBounds(new Rectangle(new Point(150, 170), label[1].getPreferredSize()));
		    	label[2].setBounds(new Rectangle(new Point(150, 260), label[2].getPreferredSize()));
		    	label[3].setBounds(new Rectangle(new Point(100, 20),  label[3].getPreferredSize()));
			    repaint();	
		}
     }
	
	
	public void MenuSes()
	{
		 if(menukontrol==0)
			 seskontrol.MenuSes();
			 menukontrol=1;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
			if(AcilisKontrol1)
			{
				  pencere[0].setCursor(Cursor.CROSSHAIR_CURSOR);
				player.playerHareket(5,20);
				AcilisKontrol1=player.PlayerHareketsizEngelKontrol(hareketsizengel);
				 if(FareDinleyici.x>150 &&FareDinleyici.x<300)
				 {		
					 if(FareDinleyici.y>100 && FareDinleyici.y<200)
					 {
						 label[0].setForeground(Color.WHITE);
						 AcilisKontrol1=false;
						 kontrol=1;
						 MenuSes();
					 }
					 else if(FareDinleyici.y>150 && FareDinleyici.y<250)
					 {
						 label[1].setForeground(Color.WHITE);
						 MenuSes();
					 }
					 else if(FareDinleyici.y>250 && FareDinleyici.y<350)
					 {
						 label[2].setForeground(Color.WHITE);
						 MenuSes();
					 }
				 }
				 else
				 {
					 menukontrol=0;
					 label[0].setForeground(Color.LIGHT_GRAY);
					 label[1].setForeground(Color.LIGHT_GRAY);
					 label[2].setForeground(Color.LIGHT_GRAY);
				   
				 }
			}
			else
			{
				if(kontrol==0)
				{
					     if (0<FareDinleyici.x && FareDinleyici.x<50 && FareDinleyici.y<400 &&FareDinleyici.y>365) 
						 AcilisKontrol1=true;	 
				         player=new Player(0, 360, 25, 25);
				}
				else if(kontrol==1)
				{
					 acilistimer.stop();
					 player=new Player(0, 0, 0, 0);
					 acilistimer2.start();
					 kontrol=2;
				}
				else if(kontrol==2)
				{
					ZamanCubugu.brenk+=4;
					ZamanCubugu.grenk+=5;
					ZamanCubugu.rrenk+=2;
					zamancubugu.zamancubuguyatay+=10;
					if(zamancubugu.zamancubuguyatay==500)
					{
						zamancubugu.zamancubuguyatay-=10;
						if(LevelGecis.levelgeciskontrol)
						{
							label[0].setForeground(Color.LIGHT_GRAY);
							label[1].setForeground(Color.LIGHT_GRAY);
							label[2].setForeground(Color.LIGHT_GRAY);	
							LevelGecis.timerlevelgecis.stop();
							LevelGecis.levelgeciskontrol=false;
							kontrol=0;
							pencere[1].setVisible(true);
							Harita1.map1_kontrol=true;
							Harita1.timer1.start();
							zamancubugu.zamancubuguyatay=0;
						}
						else 
						{
							AcilisMap_kontrol=false;
							LevelGecis.timerlevelgecis.start();
							pencere[6].setVisible(true);
							Levelgecislabel.setText("Level1");
							pencere[0].setVisible(false);}}}}}}

