import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Action  implements ActionListener {
	Rectangle actionkutusu;
	public static String yon;
	Timer timer3;
	public static boolean kutudurum=false;
	public Action(int x,int y , int genislik,int yukseklik,String yon) {
		actionkutusu=new Rectangle(x,y,genislik,yukseklik);	
		this.yon=yon;
		timer3=new Timer(1000, this);
		timer3.start();
	}
	public void actionkutusuCiz(Graphics g)
	{
		//g.setColor(Color.GREEN);
		g.setColor(new Color(0, 0, 116));
		g.fillRect((int)actionkutusu.getX(),(int)actionkutusu.getY(),(int)actionkutusu.getWidth(),(int)actionkutusu.getHeight());
	}
	public Rectangle getRectangle() {
		return actionkutusu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(kutudurum)
		{
			if(Harita2.kontrol2)
			{
				if(yon=="yukari")
				{
					HareketliEngeller.hareketliy+=50;
				}
				else if(yon=="asagi")
				{
					HareketliEngeller.hareketliy-=50;
				}
			}
		}
	}
}
