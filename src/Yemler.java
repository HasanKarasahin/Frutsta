import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Yemler extends Object {
	public Yemler(int x,int y,int genislik,int yukseklik) 
	{
		object = new Rectangle(x, y, genislik, yukseklik);  
	}
	public void YemCiz(Graphics g)
	{
		g.setColor(new Color(199, 0, 6));	
		g.fillRect((int)object.getX(),(int)object.getY(),(int)object.getWidth(),(int)object.getHeight());}}




