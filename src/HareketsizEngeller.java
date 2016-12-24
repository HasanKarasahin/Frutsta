import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HareketsizEngeller extends Engeller {
	Rectangle hareketsizengel;
	public HareketsizEngeller(int x,int y , int genislik,int yukseklik) 
	{
		hareketsizengel=new Rectangle(x, y, genislik, yukseklik);	
	}
	public void HareketsizEngelciz(Graphics g)
	{
		g.setColor(new Color(0, 0, 0));
	    g.fillRect((int)hareketsizengel.getX(),(int)hareketsizengel.getY(),(int)hareketsizengel.getWidth(),(int)hareketsizengel.getHeight());	
	}
	public Rectangle getRectangle() 
	{
		return hareketsizengel;
	}
}
