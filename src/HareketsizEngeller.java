import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HareketsizEngeller extends Object {
	public HareketsizEngeller(int x,int y , int genislik,int yukseklik) 
	{
		object=new Rectangle(x, y, genislik, yukseklik);	
	}
	public void HareketsizEngelciz(Graphics g)
	{
		g.setColor(new Color(0, 0, 0));
	    g.fillRect((int)object.getX(),(int)object.getY(),(int)object.getWidth(),(int)object.getHeight());	
	}
	public Rectangle getRectangle() 
	{
		return object;}}
