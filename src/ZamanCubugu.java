import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ZamanCubugu {
Rectangle zamancubugu;
static int zamancubuguyatay=0;
static int brenk=30;
static int grenk=7;
static int rrenk=0;
	public ZamanCubugu() {
		zamancubugu=new Rectangle(0, 460, zamancubuguyatay, 150);
	}
	public void zamancubuguCiz(Graphics g)
	{
			//g.setColor(Color.BLUE);
		    g.setColor(new Color(rrenk, grenk, brenk));
			g.fillRect((int)zamancubugu.getX(),(int)zamancubugu.getY(),(int)zamancubugu.getWidth()+zamancubuguyatay,(int)zamancubugu.getHeight());
	}
}
