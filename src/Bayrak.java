import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bayrak extends Object  {
	public Bayrak(int x,int y , int genislik,int yukseklik) 
	{
		object=new Rectangle(x, y, genislik, yukseklik);	
	}
	public void BayrakCiz(Graphics g)
	{
		g.setColor(new Color(0, 148, 0));
		g.fillRect((int)object.getX(),(int)object.getY(),(int)object.getWidth(),(int)object.getHeight());}}
