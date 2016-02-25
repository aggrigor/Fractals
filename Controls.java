import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JMenuItem;



class Controls implements ActionListener
{
	CustomFrame frame=null;

	public Controls(CustomFrame frame)
	{
		this.frame=frame;
	}

	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() instanceof JMenuItem)
		{
			String command = e.getActionCommand();
			Choises c = Choises.valueOf(command);
			switch(c)
			{
				case LoadImage:		frame.loadImage(); break;
				case SetBackground:	frame.setBackground(); break;	
				case CreateMandelbrot:	frame.CreateMandelbrot(); break;
		//		case CreateJulia:	frame.CreateJulia(); break;

   
				case About:		JOptionPane.showMessageDialog(null,"              Created by: \n Vaggelis Sotiropoulos 760 \n                    and  \n Aggeliki Grigoropoulou 699");	break;
				case Exit: 		System.exit(0); break;
			
			}

			
		}
	}
}