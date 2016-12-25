import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HareketliEngeller extends Object {
   static int hareketlix , hareketliy;
	public HareketliEngeller(int x,int y , int genislik,int yukseklik) 
	{
		object=new Rectangle(x, y, genislik, yukseklik);
		hareketlix=(int)object.getX();
		hareketliy=(int)object.getY();
	}
	public void HareketliEngelCiz(Graphics g)
	{
		 g.setColor(Color.BLACK);
		 object.setLocation((int)object.getX(),hareketliy);
	     g.fillRect((int)object.getX(),(int)object.getY(),(int)object.getWidth(),(int)object.getHeight());	}}
