import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Harita3 extends Haritalar implements ActionListener {
	static boolean  kontrol3=false,map3_kontrol=false;
	static Timer timer3;
	public Harita3() {
		 super();
		 player=new Player(0, 265, 25, 25);
		 bayrak=new Bayrak(0, 0, 0,0);
		 hareketsizengel=new HareketsizEngeller[11];
		 HareketsizEngelSayisi=hareketsizengel.length;
		 hareketsizengel[0]=new HareketsizEngeller(0, 0, 500, 150);
		 hareketsizengel[1]=new HareketsizEngeller(0,400,500,100);
		 hareketsizengel[2]=new HareketsizEngeller(0,100,50,150);
		 hareketsizengel[3]=new HareketsizEngeller(125,100,75,150);
		 hareketsizengel[4]=new HareketsizEngeller(275,100,75,150);
		 hareketsizengel[5]=new HareketsizEngeller(425,100,75,150);
		 hareketsizengel[6]=new HareketsizEngeller(0,300,50,150);
		 hareketsizengel[7]=new HareketsizEngeller(125,300,75,150);
		 hareketsizengel[8]=new HareketsizEngeller(425,300,75,150);
		 hareketsizengel[9]=new HareketsizEngeller(125,300,75,150);
		 hareketsizengel[10]=new HareketsizEngeller(275,300,75,150);
		 yem=new Yemler[4];
		 yemsayisi=yem.length;
		 yem[0]=new Yemler(85, 150, 10,20);
		 yem[1]=new Yemler(235, 150, 10,20);
		 yem[2]=new Yemler(85, 380, 10,20);
		 yem[3]=new Yemler(235, 380, 10,20);
		 canevar=new Canavarlar[3];
		 canevarsayisi=canevar.length;
		 canevar[0]=new Canavarlar(215,150,50,60,150,340,150,"yukariasagi");
		 canevar[1]=new Canavarlar(65,340,50,60,350,340,150,"asagiyukari");
		 canevar[2]=new Canavarlar(365,150,50,60,50,340,150,"yukariasagi");
		 timer3=new Timer(20, this);
		 timer3.stop();
	}
	@Override
	protected void paintComponent(Graphics g) 
      {
		super.paintComponent(g);
		if(map3_kontrol)
		{
			 for (int i = 0; i < hareketsizengel.length; i++) 
				 hareketsizengel[i].HareketsizEngelciz(g);
			 for (int i = 0; i < yem.length; i++) 
				 yem[i].YemCiz(g);
			for (int i = 0; i < canevar.length; i++) 
				canevar[i].CanavarCiz(g);
			 bayrak.BayrakCiz(g);
			 player.PlayerCiz(g);
			 repaint();	
		}
     }
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(map3_kontrol)
		{
			if(kontrol3)
			{
				Pencere.pencere[3].setCursor(Pencere.invisibleCursor);
				player.playerHareket();
				kontrol3=player.PlayerHareketsizEngelKontrol(hareketsizengel);
				map3_kontrol=player.PlayerBayrakKontrol(bayrak);
				if(kontrol3)
				{
					kontrol3=player.PlayerCanavarKontrol(canevar);
					yemkontrol=player.PlayerYemKontrol(yem,yemkontrol);
				}
				if(yemkontrol==yemsayisi)
					bayrak=new Bayrak(480, 265, 10,20);
			}
			else 
			{
				Pencere.pencere[3].setCursor(Cursor.CROSSHAIR_CURSOR);
				 player=new Player(0, 265, 25, 25);  
				  if (0<FareDinleyici.x && FareDinleyici.x<40 &&FareDinleyici.y>275 && FareDinleyici.y<295) 
						kontrol3=true;
				     yemkontrol=0;
				     yem[0]=new Yemler(85, 150, 10,20);
					 yem[1]=new Yemler(235, 150, 10,20);
					 yem[2]=new Yemler(85, 380, 10,20);
					 yem[3]=new Yemler(235, 380, 10,20);
					 bayrak=new Bayrak(0, 0, 0,0);
			}
		}
		else 
		{
			if(LevelGecis.levelgeciskontrol)
			{
				LevelGecis.timerlevelgecis.stop();
				yemkontrol=0;
				kontrol3=false;
				Harita4.map4_kontrol=true;
				Harita4.timer4.start();
				timer3.stop();
				LevelGecis.levelgeciskontrol=false;
				Pencere.pencere[4].setVisible(true);
				Pencere.pencere[3].dispose();
			}
			else 
			{
				LevelGecis.timerlevelgecis.start();
				Pencere.pencere[6].setVisible(true);
				Pencere.pencere[3].setVisible(false);
				Pencere.Levelgecislabel.setText("Level 4 ");
			}	
		}
	}
}
