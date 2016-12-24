import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bayrak {
	Rectangle bayrak;
	public Bayrak(int x,int y , int genislik,int yukseklik) 
	{
		bayrak=new Rectangle(x, y, genislik, yukseklik);	
	}
	public void BayrakCiz(Graphics g)
	{
		g.setColor(new Color(0, 148, 0));
		g.fillRect((int)bayrak.getX(),(int)bayrak.getY(),(int)bayrak.getWidth(),(int)bayrak.getHeight());
	}
	public Rectangle getRectangle() {
		return bayrak;
	}
}
