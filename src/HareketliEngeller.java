import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HareketliEngeller extends Engeller {
	public static int hareketlix , hareketliy;
	 Rectangle hareketliengel;
	public HareketliEngeller(int x,int y , int genislik,int yukseklik) 
	{
		hareketliengel=new Rectangle(x, y, genislik, yukseklik);
		hareketlix=(int)hareketliengel.getX();
		hareketliy=(int)hareketliengel.getY();
	}
	public void HareketliEngelCiz(Graphics g)
	{
		 g.setColor(Color.BLACK);
		 hareketliengel.setLocation((int)hareketliengel.getX(),hareketliy);
	     g.fillRect((int)hareketliengel.getX(),(int)hareketliengel.getY(),(int)hareketliengel.getWidth(),(int)hareketliengel.getHeight());	
	}
	public Rectangle getRectangle() 
	{
		return hareketliengel;
	}
}
