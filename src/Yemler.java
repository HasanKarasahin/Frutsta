import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Yemler {
	Rectangle yem;
	public Yemler(int x,int y,int genislik,int yukseklik) 
	{
		yem=new Rectangle(x, y, genislik, yukseklik);
	}
	public void YemCiz(Graphics g)
	{
		g.setColor(new Color(199, 0, 6));	
		g.fillRect((int)yem.getX(),(int)yem.getY(),(int)yem.getWidth(),(int)yem.getHeight());
	}
	public Rectangle getRectangle() {
		return yem;
	}
}
