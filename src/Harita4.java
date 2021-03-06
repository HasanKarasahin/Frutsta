import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Harita4 extends Haritalar implements ActionListener {
	static boolean  kontrol4=false,map4_kontrol=false;
	static Timer timer4;
	public Harita4() {
		 super();
		 player=new Player(17, 20, 25, 25);
		 bayrak=new Bayrak(0, 0, 0,0);
		 hareketsizengel=new HareketsizEngeller[8];
		 hareketsizengel[0]=new HareketsizEngeller(50, 0, 500, 50);//en �st
		 hareketsizengel[1]=new HareketsizEngeller(0,100,440,50);//bir alt
		 hareketsizengel[2]=new HareketsizEngeller(50,200,450,50);//bir alt
		 hareketsizengel[3]=new HareketsizEngeller(0,300,440,50);//bir alt
		 hareketsizengel[4]=new HareketsizEngeller(50,400,450,90);//en alt
		 hareketsizengel[5]=new HareketsizEngeller(0,0,10,500);
		 hareketsizengel[6]=new HareketsizEngeller(485,0,10,500);
		 hareketsizengel[7]=new HareketsizEngeller(0,0,500,10);
		 yem=new Yemler[2];
		 yemsayisi=yem.length;     
		 yem[0]=new Yemler(25,435,10,20);   
		 yem[1]=new Yemler(0,0,0,0);  
		 canevar=new Canavarlar[5];
		 canevar[0]=new Canavarlar(100,50,50,50,170,510,50,"solsag");
		 canevar[1]=new Canavarlar(510,150,50,50,180,510,50,"sagsol");
		 canevar[2]=new Canavarlar(100,250,50,50,190,510,50,"solsag");
		 canevar[3]=new Canavarlar(510,350,50,50,200,510,50,"sagsol");
		 canevar[4]=new Canavarlar(365,150,50,60,50,340,150,"yukariasagi");
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
	public void actionPerformed(ActionEvent e) {
		System.out.println("X :" +FareDinleyici.x);
		System.out.println("Y :" +FareDinleyici.y);
		if(map4_kontrol)
		{
			if(kontrol4)
			{
			    pencere[4].setCursor(invisibleCursor);
				player.playerHareket(0,0);
			     kontrol4=player.PlayerHareketsizEngelKontrol(hareketsizengel);
				map4_kontrol=player.PlayerBayrakKontrol(bayrak);
				if(kontrol4)
				{
			        kontrol4=player.PlayerCanavarKontrol(canevar);
					yemkontrol=player.PlayerYemKontrol(yem,yemkontrol);
				}
				if(yemkontrol==0)
					 yem[0]=new Yemler(25,435,10,20);  
				else if(yemkontrol==1) 
					yem[1]=new Yemler(25,10,10,20);
				else if(yemkontrol==yemsayisi) 
					bayrak=new Bayrak(25,435,10,20);
			}
			else 
			{
				yemkontrol=0;
				pencere[4].setCursor(Cursor.CROSSHAIR_CURSOR);
				 player=new Player(17, 20, 25, 25);  
				  if (23<=FareDinleyici.x && FareDinleyici.x<=36 &&FareDinleyici.y<=49 && FareDinleyici.y>=23) 
						kontrol4=true;
				  yem[0]=new Yemler(25,435,10,20);  
				  yem[1]=new Yemler(0,0,0,0);
				  bayrak=new Bayrak(0, 0, 0,0);
			}
		}
		else
		{
			if(LevelGecis.levelgeciskontrol)
			{
				LevelGecis.timerlevelgecis.stop();
				yemkontrol=0;
				kontrol4=false;
				Harita5.map5_kontrol=true;
				Harita5.timer5.start();
				timer4.stop();
				LevelGecis.levelgeciskontrol=false;
				pencere[5].setVisible(true);
				pencere[4].dispose();
			}
			else 
			{
				LevelGecis.timerlevelgecis.start();
				pencere[6].setVisible(true);
				pencere[4].setVisible(false);
				Levelgecislabel.setText("Level 5");}	}}
}
