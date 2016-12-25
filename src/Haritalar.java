import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Haritalar extends Pencere {
	public Haritalar()
	{
		setBackground(Color.WHITE);
	}
	 Toolkit toolkit = Toolkit.getDefaultToolkit();
	 Point hotSpot = new Point(0, 0);
	 BufferedImage cursorImage = new BufferedImage(10, 10,BufferedImage.TRANSLUCENT);
	 Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage,hotSpot, "InvisibleCursor");
	 
	HareketsizEngeller[] hareketsizengel;
	HareketliEngeller hareketliengel;
	Canavarlar[] canevar;
	Yemler[] yem;
	Player player;
	Bayrak bayrak;
	Action actionkutusu;
	int yemkontrol=0,yemsayisi;
}
