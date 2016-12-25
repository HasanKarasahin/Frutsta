import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Harita5 extends Haritalar implements ActionListener {
	static boolean  kontrol5=false,map5_kontrol=false;
	int kontroldeger=0;
	static Timer timer5;
	public Harita5() {
		 player=new Player(0, 260, 25, 25);
		 bayrak=new Bayrak(0, 0, 0,0);
		 hareketsizengel=new HareketsizEngeller[8];
		 HareketsizEngelSayisi=hareketsizengel.length;
		 hareketsizengel[0]=new HareketsizEngeller(0, 0, 225, 125);//ustsol
		 hareketsizengel[1]=new HareketsizEngeller(260,0,235,125);//ustsag
		 hareketsizengel[2]=new HareketsizEngeller(0,155,75,100);//ustsolalt1
		 hareketsizengel[3]=new HareketsizEngeller(420,155,75,100);//ustsagalt2
         hareketsizengel[4]=new HareketsizEngeller(0,290,250,100);//playeralt
		 hareketsizengel[5]=new HareketsizEngeller(290,290,210,190);//altsag
		 hareketsizengel[6]=new HareketsizEngeller(0,450,290,50);//alt c�zg�
         hareketsizengel[7]=new HareketsizEngeller(175,200,150,10);
		 canevar=new Canavarlar[2];
		 canevarsayisi=canevar.length;
		 canevar[0]=new Canavarlar(110,155,75,100,170,150,70,"solsag");
		 canevar[1]=new Canavarlar(310,155,75,100,170,350,270,"sagsol");
         yem=new Yemler[4];
         yemsayisi=yem.length;       
         yem[0]=new Yemler(238,0,10,20);       
         yem[1]=new Yemler(0,0,0,0);       
         yem[2]=new Yemler(0,0,0,0);       
         yem[3]=new Yemler(0,0,0,0);
		 timer5=new Timer(20, this);
		 timer5.stop();
	}
	@Override
	protected void paintComponent(Graphics g) 
      {
		super.paintComponent(g);
		if(map5_kontrol)
		{
			 for (int i = 0; i < hareketsizengel.length; i++) 
				 hareketsizengel[i].HareketsizEngelciz(g);
			 player.PlayerCiz(g);
			 for (int i = 0; i < canevar.length; i++) 
				 canevar[i].CanavarCiz(g);
			 for (int i = 0; i < yem.length; i++) 
				yem[i].YemCiz(g);
			 bayrak.BayrakCiz(g);
			 repaint();	
		}
      }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(map5_kontrol)
		{
			if(kontrol5)
			{
				player.playerHareket();
				kontrol5=player.PlayerHareketsizEngelKontrol(hareketsizengel);
				if(kontrol5)
				{
					kontrol5=player.PlayerCanavarKontrol(canevar);
					yemkontrol=player.PlayerYemKontrol(yem,yemkontrol);
				}
				if(yemkontrol==0)
					yem[0]=new Yemler(238,0,10,20);
				else if(yemkontrol==1) 
					 yem[1]=new Yemler(0,410,10,20);
				else if(yemkontrol==2) 
					yem[2]=new Yemler(0,130,10,20);
				else if(yemkontrol==3) 
					 yem[3]=new Yemler(480,262,10,20);
				else if(yemkontrol==yemsayisi) 
					System.out.println("YemlerBitti");
			}
			else 
			{
				 yemkontrol=0;
				  player=new Player(0, 260, 25, 25);  
				  if (0<FareDinleyici.x && FareDinleyici.x<40 &&FareDinleyici.y<285 && FareDinleyici.y>280) 
						kontrol5=true;
					    yem[0]=new Yemler(238,0,10,20);
		                yem[1]=new Yemler(0,0,10,0);
		                yem[2]=new Yemler(0,0,10,0);
		                yem[3]=new Yemler(0,2,0,0);
		}
		}
		else
		{
			System.out.println("Oyun Bitti");
		}
	}
}
