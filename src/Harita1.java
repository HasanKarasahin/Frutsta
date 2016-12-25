import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Harita1 extends Haritalar implements ActionListener {
	static boolean  kontrol1=false,map1_kontrol=false;
	static Timer timer1;
	public Harita1() {
		super();
		player=new Player(0, 427, 25, 25);
		bayrak=new Bayrak(0, 0, 0,0);
		hareketsizengel=new HareketsizEngeller[9];
		hareketsizengel[0]=new HareketsizEngeller(0, 0, 50, 420);
		hareketsizengel[1]=new HareketsizEngeller(0, 460, 500, 20);
		hareketsizengel[2]=new HareketsizEngeller(400, 380, 95, 100);
		hareketsizengel[3]=new HareketsizEngeller(0, 170, 350,250);
		hareketsizengel[4]=new HareketsizEngeller(485, 0, 10, 500);
		hareketsizengel[5]=new HareketsizEngeller(400, 230, 45, 100);
		hareketsizengel[6]=new HareketsizEngeller(400, 0, 100, 190);
		hareketsizengel[7]=new HareketsizEngeller(0, 70, 350,50);
		hareketsizengel[8]=new HareketsizEngeller(50, 0, 450,80);
		yem=new Yemler[4];
		yemsayisi=yem.length;
		yem[0]=new Yemler(370, 120, 10,20);
		yem[1]=new Yemler(370, 250, 10,20);
		yem[2]=new Yemler(450, 200, 10,20);
		yem[3]=new Yemler(450, 340, 10,20);
		timer1=new Timer(20, this);
		timer1.stop();
	}
	@Override
	protected void paintComponent(Graphics g) 
      {
		super.paintComponent(g);
		if(map1_kontrol)
		{
			 for (int i = 0; i < hareketsizengel.length; i++) 
				 hareketsizengel[i].HareketsizEngelciz(g);
			 for (int i = 0; i < yem.length; i++) 
				 yem[i].YemCiz(g);
			 player.PlayerCiz(g);
			 bayrak.BayrakCiz(g);
			 repaint();	
		}
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(map1_kontrol)
		{
			if(kontrol1)
			{
				pencere[1].setCursor(invisibleCursor);
				player.playerHareket();
				kontrol1=player.PlayerHareketsizEngelKontrol(hareketsizengel);
				yemkontrol=player.PlayerYemKontrol(yem,yemkontrol);
				map1_kontrol=player.PlayerBayrakKontrol(bayrak);
				if(yemkontrol==yemsayisi)
					bayrak=new Bayrak(70, 130, 10,20);
			}
			else 
			{
				pencere[1].setCursor(Cursor.CROSSHAIR_CURSOR);
				 yemkontrol=0;
				  if (0<FareDinleyici.x && FareDinleyici.x<50 && FareDinleyici.y<455 &&FareDinleyici.y>450) 
					  kontrol1=true;
				    player=new Player(0, 427, 25, 25);
					yem[0]=new Yemler(370, 120, 10,20);
					yem[1]=new Yemler(370, 250, 10,20);
					yem[2]=new Yemler(450, 200, 10,20);
					yem[3]=new Yemler(450, 340, 10,20);
					bayrak=new Bayrak(0, 0, 0,0);
			}
		}
		else
		{
			if(LevelGecis.levelgeciskontrol)
			{
				LevelGecis.timerlevelgecis.stop();
				yemkontrol=0;
				kontrol1=false;
				Harita2.map2_kontrol=true;
				Harita2.timer2.start();
				timer1.stop();
				LevelGecis.levelgeciskontrol=false;
			    pencere[2].setVisible(true);
			    pencere[1].dispose();	
			}
			else 
			{
				LevelGecis.timerlevelgecis.start();
				pencere[6].setVisible(true);
				pencere[1].setVisible(false);
				Levelgecislabel.setText("Level 2 ");}}}}
