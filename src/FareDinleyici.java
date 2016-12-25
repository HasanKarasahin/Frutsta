import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
	public class FareDinleyici implements MouseMotionListener {
		static int x,y; 
		@Override
		public void mouseDragged(MouseEvent arg0) {}
		@Override
		public void mouseMoved(MouseEvent e) 
		{
			x=e.getX();
			y=e.getY();}}

