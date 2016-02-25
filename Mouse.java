import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.InputEvent;

public class Mouse extends MouseAdapter //implements MouseListener
{
	private ManFonto mfonto=null;

	public Mouse(){}

	public Mouse(ManFonto mfonto)
	{
		this.mfonto=mfonto;
	}
	
	public void mouseClicked(MouseEvent e)
	{   
		switch(e.getModifiers())
		{   
			case	InputEvent.BUTTON1_MASK:
				mfonto.zoomIn();
				break;
			case	InputEvent.BUTTON3_MASK:
				mfonto.zoomOut();
				break;
		}
	}
}