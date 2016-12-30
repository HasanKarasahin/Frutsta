import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Object {
	Rectangle gecici;
	Sesler seskontrol = new Sesler();
	int kapisesikontrol=0;
	 public Player(int x,int y,int genislik,int yukseklik) 
		{
		 object=new Rectangle(x, y, genislik, yukseklik);
		}
	 public void PlayerCiz(Graphics g)
		{
		    g.setColor(new Color(51, 47, 46));
			g.fillRect((int)object.getX(),(int)object.getY(),(int)object.getWidth(),(int)object.getHeight());
		}
	 public void geciciplayer()
	 {
		 gecici=new Rectangle(object);
		 gecici.setLocation((int)gecici.getX(),(int)gecici.getY()-1);
	 }
	 public void OlumSes()
	 {
		 seskontrol.OlumSes();
	 }
	 public boolean PlayerHareketsizEngelKontrol(HareketsizEngeller[] hareketsizEngeller)
		{ 
		      geciciplayer();	  
			  for (int i = 0; i < hareketsizEngeller.length; i++) 
			  {
				if (gecici.intersects(hareketsizEngeller[i].getRectangle()))
				{
					OlumSes();
					return false;
				}
			  }
				  object.setLocation((int)object.getX(),(int)object.getY()-1);
			  return true;
		}
	 public boolean PlayerHareketliEngelKontrol(HareketliEngeller engel)
		{	  
		        geciciplayer();
				if (gecici.intersects(engel.getRectangle()))
				{
					 OlumSes();
					 return false;
				}
				return true;
		}
	 public boolean PlayerBayrakKontrol(Bayrak bayrak)
		{
		      geciciplayer();
				if (gecici.intersects(bayrak.getRectangle()))
				{
					seskontrol.BayrakSes();
					return false;
				}	
			 return true;
		}
	 public int PlayerYemKontrol(Yemler[] yem,int yemkontrol)
		{
		      geciciplayer();
			  for (int i = 0; i < yem.length; i++) 
			  {
				if (gecici.intersects(yem[i].getRectangle()))
			   {
					yem[i]=new Yemler(0, 0, 0, 0);
					seskontrol.YemSes();
					yemkontrol++;
					kapisesikontrol=0;//biyerde sifirlamam gerekiyordu..simdilik en uygun yer bura..saat 06.03 :(
					return yemkontrol;
			   }
			  }
			  return yemkontrol;
		}
	 public void PlayerKutuEtkilesim(Action actiondeneme)
		{
		        geciciplayer();
				if (gecici.intersects(actiondeneme.getRectangle()))
				{
					Action.kutudurum=true;
					if(kapisesikontrol==0)
					{
						seskontrol.KapiSes();
						kapisesikontrol=1;
					}
				}
				else
					Action.kutudurum=false;
		}
	 public boolean PlayerCanavarKontrol(Canavarlar[] canevar)
		{	  
		      geciciplayer();
			  for (int i = 0; i < canevar.length; i++) 
			  {
				  if (gecici.intersects(canevar[i].getRectangle()))
				  {
					  OlumSes();
					  return false;
				  } 
			  }
				return true;
		}
	 public void playerHareket(int x,int y)
		{
		 object.setLocation(FareDinleyici.x-12-x,FareDinleyici.y-10-y);
		}}
