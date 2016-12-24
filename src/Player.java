import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
	Rectangle Player;
	 public Player(int x,int y,int genislik,int yukseklik) 
		{
			Player=new Rectangle(x, y, genislik, yukseklik);
		}
	 public void PlayerCiz(Graphics g)
		{
		    g.setColor(new Color(51, 47, 46));
			g.fillRect((int)Player.getX(),(int)Player.getY(),(int)Player.getWidth(),(int)Player.getHeight());
		}
	 public boolean PlayerHareketsizEngelKontrol(int x,int y,HareketsizEngeller[] hareketsizEngeller,int hareketsizengelsayisi)
		{
			  Rectangle gecici=new Rectangle(Player);
			  gecici.setLocation((int)gecici.getX()+x,(int)gecici.getY()+y);
			  boolean cakisma=false;	  
			  //HareketsizEngelKontrolENGELE ÇARPTI MI ÇARPMADI MI?
			  for (int i = 0; i < hareketsizengelsayisi; i++) 
			  {
				if (gecici.intersects(hareketsizEngeller[i].getRectangle()))
					cakisma=true;
			  }
			  if(cakisma==false)
				  Player.setLocation((int)Player.getX()+x,(int)Player.getY()+y);
			  else 
			  {
				  return false;
			  } 
			  return true;
		}
	 public boolean PlayerHareketliEngelKontrol(int x,int y,HareketliEngeller engel,int hareketlizengelsayisi)
		{
			  Rectangle gecici=new Rectangle(Player);
			  gecici.setLocation((int)gecici.getX()+x,(int)gecici.getY()+y);
			  boolean cakisma=false;	  
			  // Hareketli ENGELE ÇARPTI MI ÇARPMADI MI?
				if (gecici.intersects(engel.getRectangle()))
				{
					 System.out.println("Hareketli Engele Carpma OLdu");
					 return false;
				}
				return true;
		}
	 public boolean PlayerBayrakKontrol(int x,int y,Bayrak bayrak,int bayraksayisi,int yemkontrol,int yemsayisi)
		{
			 Rectangle gecici=new Rectangle(Player);
			 gecici.setLocation((int)gecici.getX()+x,(int)gecici.getY()+y);
			 for (int i = 0; i < bayraksayisi; i++) 
			  {
				if (gecici.intersects(bayrak.getRectangle()))
			   {
						return false;
			   }
			  }
			 return true;
		}
	 public int PlayerYemKontrol(int x,int y,Yemler[] yem,int yemsayisi,int yemkontrol)
		{
			 Rectangle gecici= new Rectangle(Player);
			  gecici.setLocation((int)gecici.getX()+x,(int)gecici.getY()+y);
			  //YEM YEDÝ MÝ YEMEDÝ MÝ?//Yediyse Kaç Tane Yedi?
			  for (int i = 0; i < yemsayisi; i++) 
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
	 public void PlayerKutuEtkilesim(int x,int y,Action actiondeneme)
		{
			  Rectangle gecici= new Rectangle(Player);
			  gecici.setLocation((int)gecici.getX()+x,(int)gecici.getY()+y);
				if (gecici.intersects(actiondeneme.getRectangle()))
					Action.kutudurum=true;
				else
					Action.kutudurum=false;
		}
	 public boolean PlayerCanavarKontrol(int x,int y,Canavarlar[] canevar,int canavarsayisi)
		{
			  Rectangle gecici=new Rectangle(Player);
			  gecici.setLocation((int)gecici.getX()+x,(int)gecici.getY()+y);
			  boolean cakisma=false;	  
			  // Canevara ÇARPTI MI ÇARPMADI MI?
			  for (int i = 0; i < canevar.length; i++) 
			  {
				  if (gecici.intersects(canevar[i].getRectangle()))
					{
						 System.out.println("Cenavara Carpti");
						 return false;
					}
			  }
				return true;
		}
	 public void playerHareket()
		{
			Player.setLocation(FareDinleyici.x-10,FareDinleyici.y-23);
		}
}
