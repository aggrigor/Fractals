import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Container;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

class CustomFrame extends JFrame 
{
	private final int x_coordinates = 500;
	private final int y_coordinates = 500;
	private JFileChooser Chooser = null;
	private BufferedImage image = null;
	private Fonto fonto = null;


	public void loadImage()
	{
		int retval = Chooser.showOpenDialog(this);
		if (retval == JFileChooser.APPROVE_OPTION)
		{
			File file = Chooser.getSelectedFile();
			image = null;
			try
			{
				image = ImageIO.read(file);
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			

			String message ="	Load Completed!!!";
			JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);

		}
	}


	public void setBackground()
	{



		int retval = Chooser.showOpenDialog(this);
		if (retval == JFileChooser.APPROVE_OPTION)
		{
			File file=Chooser.getSelectedFile();
			BufferedImage background=null;

			try
			{
				background = ImageIO.read(file);
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String message="	Done...";
			JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);

			int Width = background.getWidth();
			int Height = background.getHeight();

			if(x_coordinates > Width && Height < y_coordinates)
			{
		
				int distance = ((x_coordinates - Width) / 2);


				fonto.setFonto(background, distance, 0);
				repaint();
				return;
			}

			float x_scale = Width / x_coordinates;
			float y_scale = Height / y_coordinates;
		
			if(x_scale > y_scale)
			{	
				Width = (int) (Width / x_scale);
				Height = (int) (Height / x_scale);
			}

			else
			{
				Width = (int) (Width / y_scale);
				Height = (int) (Height / y_scale);					
			}
			Image image = background.getScaledInstance(Width, Height, Image.SCALE_SMOOTH);
			fonto.setFonto(image, Width, Height);
			repaint();	
		}
	}
		
	public void CreateMandelbrot()
	{
		JFrame frame = new JFrame();
		MDialog dialog = new MDialog(frame, "Specify complex area position & size...", true, this);
	}
						
        


	
	public CustomFrame (String title)
	{
		super(title);

		Chooser = new JFileChooser(new File("."));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		Chooser.setFileFilter(filter);


		fonto = new Fonto();
		Container container = this.getContentPane();
		container.add(fonto);

		Controls control = new Controls(this);

		JMenuItem iload = new JMenuItem("Load Image...");
		iload.setMnemonic('L');
		iload.setActionCommand("LoadImage");
		iload.addActionListener(control);


		JMenuItem ibackground = new JMenuItem("Set Background...");
		ibackground.setMnemonic('B');
		ibackground.setActionCommand("SetBackground");
		ibackground.addActionListener(control);


		JMenuItem iexit = new JMenuItem("Exit...");
		iexit.setMnemonic('E');
		iexit.setActionCommand("Exit");
		iexit.addActionListener(control);
	


		JMenu mprogram = new JMenu("Program");
		mprogram.setMnemonic('P');
		mprogram.add(iload);
		mprogram.addSeparator();
		mprogram.add(ibackground);
		mprogram.addSeparator();
		mprogram.add(iexit);


		JMenuItem imandelbrot = new JMenuItem("Create Mandelbrot...");
		imandelbrot.setMnemonic('M');
		imandelbrot.setActionCommand("CreateMandelbrot");
		imandelbrot.addActionListener(control);

		
		JMenuItem ijulia = new JMenuItem("Create Julia...");
		ijulia.setMnemonic('J');
		ijulia.setActionCommand("CreateJulia");
		ijulia.addActionListener(control);


		JMenu mfractals = new JMenu("Fractals");
		mfractals.setMnemonic('F');
		mfractals.add(imandelbrot);
		mfractals.addSeparator();
		mfractals.add(ijulia);




		JMenuItem iabout = new JMenuItem("About...");
		iabout.setMnemonic('A');
		iabout.setActionCommand("About");
		iabout.addActionListener(control);

		
		JMenu mhelp = new JMenu("Help");
		mhelp.setMnemonic('H');
		mhelp.add(iabout);


		JMenuBar bar = new JMenuBar();
		bar.add(mprogram);
		bar.add(mfractals);
		bar.add(mhelp);

		this.setJMenuBar(bar);


		



		this.pack();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(x_coordinates,y_coordinates);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}