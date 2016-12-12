import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Harita4 extends Haritalar implements ActionListener {
	static boolean  kontrol4=false,map4_kontrol=false;
	static Timer timer4;
	public Harita4() {
		 player=new Player(0, 265, 25, 25);
		 bayrak=new Bayrak(0, 0, 0,0);
		 hareketsizengel=new HareketsizEngeller[9];
		 HareketsizEngelSayisi=hareketsizengel.length;
		 hareketsizengel[0]=new HareketsizEngeller(0, 0, 225, 125);
		 hareketsizengel[1]=new HareketsizEngeller(260,0,235,125);
		 hareketsizengel[2]=new HareketsizEngeller(0,155,75,100);
		 hareketsizengel[3]=new HareketsizEngeller(110,155,75,100);
		 hareketsizengel[4]=new HareketsizEngeller(310,155,75,100);
		 hareketsizengel[5]=new HareketsizEngeller(420,155,75,100);
		 hareketsizengel[6]=new HareketsizEngeller(0,290,250,100);
		 hareketsizengel[7]=new HareketsizEngeller(290,290,200,190);
		 hareketsizengel[8]=new HareketsizEngeller(0,450,290,50);
		 yem=new Yemler[4];
		 yemsayisi=yem.length;
		 yem[0]=new Yemler(85, 150, 10,20);
		 yem[1]=new Yemler(235, 150, 10,20);
		 yem[2]=new Yemler(85, 380, 10,20);
		 yem[3]=new Yemler(235, 380, 10,20);
		 timer4=new Timer(20, this);
		 timer4.stop();
	}
	@Override
	protected void paintComponent(Graphics g) 
      {
		super.paintComponent(g);
		if(map4_kontrol)
		{
			 for (int i = 0; i < hareketsizengel.length; i++) 
			 {
				 hareketsizengel[i].HareketsizEngelciz(g);
			 }	 
			 for (int i = 0; i < yem.length; i++) 
			 {
				 yem[i].YemCiz(g);
			 } 
			 bayrak.BayrakCiz(g);
			 player.PlayerCiz(g);
			 repaint();	
		}
      }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(map4_kontrol)
		{
			if(kontrol4)
			{
				Pencere.pencere[4].setCursor(Pencere.invisibleCursor);
				player.playerHareket();
				kontrol4=player.PlayerHareketsizEngelKontrol(0, -adim,hareketsizengel,HareketsizEngelSayisi);
				map4_kontrol=player.PlayerBayrakKontrol(0, -adim, bayrak, bayraksayisi,yemkontrol,yemsayisi);
				if(kontrol4)
				{
					yemkontrol=player.PlayerYemKontrol(0, -adim, yem, yemsayisi,yemkontrol);
				}
				if(yemkontrol==yemsayisi)
				{
					bayrak=new Bayrak(480, 265, 10,20);
				}
			}
			else 
			{
				Pencere.pencere[4].setCursor(Cursor.CROSSHAIR_CURSOR);
				  player=new Player(0, 265, 25, 25);  
				  if (0<FareDinleyici.x && FareDinleyici.x<40 &&FareDinleyici.y>275 && FareDinleyici.y<295) 
					 {
						kontrol4=true;
					 }	
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
			System.out.println("Oyun Bitti");
		}
	}
}
