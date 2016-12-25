import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Object {
	Rectangle gecici;
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
	 public boolean PlayerHareketsizEngelKontrol(HareketsizEngeller[] hareketsizEngeller)
		{ 
		      geciciplayer();
			  boolean cakisma=false;	  
			  for (int i = 0; i < hareketsizEngeller.length; i++) 
			  {
				if (gecici.intersects(hareketsizEngeller[i].getRectangle()))
					return false;
			  }
			  if(cakisma==false)
				  object.setLocation((int)object.getX(),(int)object.getY()-1);
			  else 
				  return false;
			  return true;
		}
	 public boolean PlayerHareketliEngelKontrol(HareketliEngeller engel)
		{	  
		        geciciplayer();
				if (gecici.intersects(engel.getRectangle()))
					 return false;
				return true;
		}
	 public boolean PlayerBayrakKontrol(Bayrak bayrak)
		{
		      geciciplayer();
				if (gecici.intersects(bayrak.getRectangle()))
						return false;
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
					yemkontrol++;
					return yemkontrol;
			   }
			  }
			  return yemkontrol;
		}
	 public void PlayerKutuEtkilesim(Action actiondeneme)
		{
		        geciciplayer();
				if (gecici.intersects(actiondeneme.getRectangle()))
					Action.kutudurum=true;
				else
					Action.kutudurum=false;
		}
	 public boolean PlayerCanavarKontrol(Canavarlar[] canevar)
		{	  
		      geciciplayer();
			  for (int i = 0; i < canevar.length; i++) 
			  {
				  if (gecici.intersects(canevar[i].getRectangle()))
						 return false;
			  }
				return true;
		}
	 public void playerHareket()
		{
		 object.setLocation(FareDinleyici.x-10,FareDinleyici.y-23);
		}}
