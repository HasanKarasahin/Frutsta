import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Canavarlar  implements ActionListener {
Rectangle canavar;
static Timer canavartimer;
int kontrol=0;
int max;
int min;
int baslangisx;
int baslangisy;
String hareketyonu;
	public Canavarlar(int x,int y ,int genislik,int yukseklik,int interval,int max,int min,String hareketyonu) 
	{
		canavar=new Rectangle(x,y,genislik,yukseklik);
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
		canavar.setLocation(baslangisx,baslangisy);
		g.fillRect((int)canavar.getX(),(int)canavar.getY(),(int)canavar.getWidth(),(int)canavar.getHeight());
	}
	public Rectangle getRectangle() {
		return canavar;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(hareketyonu=="sagsol")
		{
			if(kontrol==0)
			{
				baslangisx+=10;
				if(baslangisx==max)
					kontrol=1;
			}
			else if(kontrol==1)
			{
				baslangisx-=10;
				if(baslangisx==min)
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
		else if(hareketyonu=="dur")
		{
			
		}
	}
}
