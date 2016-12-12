import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class LevelGecis extends Haritalar implements ActionListener {
static Timer timerlevelgecis;
static boolean levelgeciskontrol=false;
int degerkontrol=0;
	public LevelGecis() 
	{
		timerlevelgecis=new Timer(500, this);
		timerlevelgecis.stop();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(degerkontrol==1)
		{
			degerkontrol=0;
			levelgeciskontrol=true;
			timerlevelgecis.stop();
		}
		else 
		{
			degerkontrol++;
		}
	}
}
