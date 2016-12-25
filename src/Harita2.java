import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Harita2 extends Haritalar implements ActionListener  {
	static boolean  kontrol2=false,map2_kontrol=false;
	static Timer timer2;
	public Harita2() {
		 super();
		 player=new Player(0, 410, 25, 25);
		 bayrak=new Bayrak(0, 0, 0,0);
		 hareketsizengel=new HareketsizEngeller[10];
		 HareketsizEngelSayisi=hareketsizengel.length;
		 hareketsizengel[0]=new HareketsizEngeller(0, 0, 100, 400);
		 hareketsizengel[1]=new HareketsizEngeller(0, 445, 490, 30);
		 hareketsizengel[2]=new HareketsizEngeller(100,325,140,75);
		 hareketsizengel[3]=new HareketsizEngeller(410,0,80,450);
		 hareketsizengel[4]=new HareketsizEngeller(40,0,400,100);
		 hareketsizengel[5]=new HareketsizEngeller(140,275,100,50);
		 hareketsizengel[6]=new HareketsizEngeller(140,175,20,100);
		 hareketsizengel[7]=new HareketsizEngeller(205,240,35,35);
		 hareketsizengel[8]=new HareketsizEngeller(300,190,140,25);
		 hareketsizengel[9]=new HareketsizEngeller(295,190,75,215);
		 yem=new Yemler[4];
		 yemsayisi=yem.length;
	     yem[0]=new Yemler(380, 250, 10,20);
		 yem[1]=new Yemler(370, 150, 10,20);
		 yem[2]=new Yemler(250, 200, 10,20);
		 yem[3]=new Yemler(115, 300, 10,20);
		 hareketliengel=new HareketliEngeller(200,190,100,50);
		 actionkutusu=new Action(380, 220, 5, 5,"asagi");
		 timer2=new Timer(20, this);
		 timer2.stop();
	}
	@Override
	protected void paintComponent(Graphics g) 
      {
		super.paintComponent(g);
		if(map2_kontrol)
		{
			 for (int i = 0; i < hareketsizengel.length; i++) 
				 hareketsizengel[i].HareketsizEngelciz(g);
			 for (int i = 0; i < yem.length; i++) 
				 yem[i].YemCiz(g);
			 bayrak.BayrakCiz(g);
			 player.PlayerCiz(g);
			 hareketliengel.HareketliEngelCiz(g);
			 actionkutusu.actionkutusuCiz(g);
			 repaint();	
		}
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(map2_kontrol)
		{
			if(kontrol2)
			{
				Pencere.pencere[2].setCursor(Pencere.invisibleCursor);
				player.playerHareket();
				kontrol2=player.PlayerHareketsizEngelKontrol(hareketsizengel);
				yemkontrol=player.PlayerYemKontrol(yem,yemkontrol);
				map2_kontrol=player.PlayerBayrakKontrol(bayrak);	
				player.PlayerKutuEtkilesim(actionkutusu);
				if(yemkontrol==yemsayisi)
					bayrak=new Bayrak(180, 250, 10,20);
				if(kontrol2)
					kontrol2=player.PlayerHareketliEngelKontrol(hareketliengel);
			}
			else 
			{
				    Pencere.pencere[2].setCursor(Cursor.CROSSHAIR_CURSOR);
				    yemkontrol=0;
				    yem[0]=new Yemler(380, 250, 10,20);
					yem[1]=new Yemler(370, 150, 10,20);
					yem[2]=new Yemler(250, 200, 10,20);
					yem[3]=new Yemler(115, 300, 10,20);
				    bayrak=new Bayrak(0, 0, 0,0);
				    player=new Player(0, 410, 25, 25);  
				  if (0<FareDinleyici.x && FareDinleyici.x<40 &&FareDinleyici.y>430 && FareDinleyici.y<450) 
						kontrol2=true;
				  hareketliengel=new HareketliEngeller(200,190,100,50);
			}
		}
		else 
		{
			if(LevelGecis.levelgeciskontrol)
			{
				LevelGecis.timerlevelgecis.stop();
				yemkontrol=0;
				kontrol2=false;
				Harita3.map3_kontrol=true;
				Harita3.timer3.start();
				timer2.stop();
				LevelGecis.levelgeciskontrol=false;
				 Pencere.pencere[3].setVisible(true);
					Pencere.pencere[2].dispose();
			}
			else 
			{
				LevelGecis.timerlevelgecis.start();
				Pencere.pencere[6].setVisible(true);
				Pencere.pencere[2].setVisible(false);
				Pencere.Levelgecislabel.setText("Level 3 ");
			}
		}
	}
}
