import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ZamanCubugu extends Object {
int zamancubuguyatay=0;
static int brenk=30;
static int grenk=7;
static int rrenk=0;
	public ZamanCubugu() {
		object=new Rectangle(0, 460, zamancubuguyatay, 150);
	}
	public void zamancubuguCiz(Graphics g)
	{
		    g.setColor(new Color(rrenk, grenk, brenk));
			g.fillRect((int)object.getX(),(int)object.getY(),(int)object.getWidth()+zamancubuguyatay,(int)object.getHeight());
			}}
