import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Canavarlar extends Object  implements ActionListener {
private Timer canavartimer;
private int kontrol=0,max,min,baslangisx,baslangisy;
private String hareketyonu;
	public Canavarlar(int x,int y ,int genislik,int yukseklik,int interval,int max,int min,String hareketyonu) 
	{
		object=new Rectangle(x,y,genislik,yukseklik);
		canavartimer=new Timer(interval, this);
		canavartimer.start();
		this.max=max;
		baslangisx=x;
		baslangisy=y;
		this.min=min;
		this.hareketyonu=hareketyonu;
	}
	public void CanavarCiz(Graphics g)
	{
		g.setColor(Color.BLACK);
		object.setLocation(baslangisx,baslangisy);
		g.fillRect((int)object.getX(),(int)object.getY(),(int)object.getWidth(),(int)object.getHeight());
	}
	public Rectangle getRectangle() {
		return object;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(hareketyonu=="sagsol")
		{
			if(kontrol==0)
			{
				baslangisx-=10;
				if(baslangisx==min)
					kontrol=1;
			}
			else if(kontrol==1)
			{
				baslangisx+=10;
				if(baslangisx==max)
					kontrol=0;
			}
		}
		else if(hareketyonu=="solsag")
		{
			if(kontrol==0)
			{
				baslangisx-=10;
				if(baslangisx==min)
					kontrol=1;
			}
			else if(kontrol==1)
			{
				baslangisx+=10;
				if(baslangisx==max)
					kontrol=0;
			}
		}
		else if(hareketyonu=="asagiyukari")
		{
			if(kontrol==0)
			{
				baslangisy-=10;
				if(baslangisy==min)
					kontrol=1;
			}
			else if(kontrol==1)
			{
				baslangisy+=10;
				if(baslangisy==max)
					kontrol=0;
			}
		}
		else if(hareketyonu=="yukariasagi")
		{
			if(kontrol==0)
			{
				baslangisy+=10;
				if(baslangisy==max)
					kontrol=1;
			}
			else if(kontrol==1)
			{
				baslangisy-=10;
				if(baslangisy==min)
					kontrol=0;
			}
		}
		else if(hareketyonu=="dur")
		{
		}
	}
}
