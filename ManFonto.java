import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;






public class ManFonto extends JPanel implements Runnable
{
	private JFileChooser chooser = null;
	private double amount=1.0D;
	private JFrame frame=null;
	private Thread thread=null;

	private double x_Coord = 0.0D;
	private double y_Coord = 0.0D;
	private double areaSize = 0.0D;
	private int megethos=0 ;
	private int numberOfIterations = 0;
	private Color[] colors=new Color[46];

//	private double amount=1.0D;
	
	BufferedImage image = null;

	void zoomIn()
	{   
		amount = amount+.10;
		repaint();   
	}

	void zoomOut()
	{
		if(amount > 1)
		{
			amount = amount-.10;
		}

		repaint();
	}

	public void setFrame(JFrame frame)
	{
		this.frame = frame;


	}




	public void run()
	{
		drawMandelBrot();
	}

	public void startDrawing()
	{
		thread.start();
		
	}

	public ManFonto(double x_Coord, double y_Coord, double areaSize, int megethos, int numberOfIterations)
	{

		this.x_Coord = x_Coord;
		this.y_Coord= y_Coord;
		this.areaSize = areaSize;
		this.megethos = megethos;
		this.numberOfIterations = numberOfIterations;

		thread = new Thread(this);


		image = new BufferedImage(megethos, megethos , BufferedImage.TYPE_INT_BGR);

		colors[0]  = new Color(127, 255, 212);
		colors[1]  = new Color(255, 228, 196);
		colors[2]  = new Color(0, 0, 255);
		colors[3]  = new Color(138, 43, 226);
		colors[4]  = new Color(95, 158, 160);
		colors[5]  = new Color(127, 255, 0);
		colors[6]  = new Color(255, 127, 80);
		colors[7]  = new Color(100, 149, 237);
		colors[8]  = new Color(0, 255, 255);
		colors[9]  = new Color(0, 100, 0);
		colors[10] = new Color(153, 50, 204);
		colors[11] = new Color(233, 150, 122);
		colors[12] = new Color(143, 188, 143);
		colors[13] = new Color(0, 206, 209);
		colors[14] = new Color(148, 0, 211);
		colors[15] = new Color(255, 20, 147);
		colors[16] = new Color(0, 191, 255);
		colors[17] = new Color(255, 215, 0);
		colors[18] = new Color(240, 230, 140);
		colors[19] = new Color(240, 128, 128);
		colors[20] = new Color(32, 178, 170);
		colors[20] = new Color(255, 0, 255);
		colors[21] = new Color(0, 0, 205);
		colors[22] = new Color(147, 112, 219);
		colors[23] = new Color(0, 250, 154);
		colors[24] = new Color(255, 228, 225);
		colors[25] = new Color(107, 142, 35);
		colors[26] = new Color(255, 165, 0);
		colors[27] = new Color(255, 69, 0);
		colors[28] = new Color(152, 251, 152);
		colors[29] = new Color(205, 133, 63);
		colors[30] = new Color(255, 192, 203);
		colors[31] = new Color(221, 160, 221);
		colors[32] = new Color(160, 32, 240);
		colors[33] = new Color(255, 0, 0);
		colors[34] = new Color(65, 105, 225);
		colors[35] = new Color(250, 128, 114);
		colors[36] = new Color(244, 164, 96);
		colors[37] = new Color(135, 206, 235);
		colors[38] = new Color(106, 90, 205);
		colors[39] = new Color(0, 255, 127);
		colors[40] = new Color(216, 191, 216);
		colors[41] = new Color(255, 99, 71);
		colors[42] = new Color(64, 224, 208);
		colors[43] = new Color(238, 130, 238);
		colors[44] = new Color(255, 255, 0);
		colors[45] = new Color(154, 205, 50);

		chooser = new JFileChooser(new File("."));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		chooser.setFileFilter(filter);




		Mouse pontiki = new Mouse(this);
		addMouseListener(pontiki);
	
/*
//		MouseListener mouseListener = new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{   
				switch(e.getModifiers())
				{   
					case	InputEvent.BUTTON1_MASK:
						zoomIn();
						break;
					case	InputEvent.BUTTON3_MASK:
						zoomOut();
						break;
				}
			}

			
		};

		addMouseListener(mouseListener);
	}

	void zoomIn()
	{   
		amount = amount+.10;
		repaint();   
	}

	void zoomOut()
	{
		if(amount > 1)
		{
			amount = amount-.10;
		}

		repaint();
	}*/
repaint();
}
	public void saveFile()
	{
		File saveFile = new File("MandelBrot.jpg");
		chooser.setSelectedFile(saveFile);

		int retVal = chooser.showSaveDialog(this);

		if (retVal == JFileChooser.APPROVE_OPTION)
		{
			saveFile = chooser.getSelectedFile();
			String fileName = saveFile.getName();

			int index = fileName.lastIndexOf('.');

			if(index == -1)
			{
				JOptionPane.showMessageDialog(this, "You have to provide a file extension!", "Message", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String extension = fileName.substring(index+1);

			if(!(extension.equals("jpg") || extension.equals("png")))
			{
				JOptionPane.showMessageDialog(this, "You gave incompatible file extension!", "Message", JOptionPane.ERROR_MESSAGE);
				return;
			}

	                try
			{
				ImageIO.write(image, "jpg", saveFile);
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void paintComponent(Graphics g)
	{
        	super.paintComponent(g);


		Graphics2D g2 = (Graphics2D)g;
    
		if(image == null)
		{
			return;
		}

		g2.scale(amount,amount);
		g2.drawImage(image, null, 0, 0);
	}

	private Color getColor(int iteration)
	{
		double hashCode = 0.0D;
		int colorIndex = 0;

		try
		{
			if(numberOfIterations < colors.length)
			{
				return colors[numberOfIterations];
			}

			hashCode = numberOfIterations / (float)colors.length;

			if (iteration<hashCode)
			{
				colorIndex = 0 ;
			}
			else
			{
				colorIndex = (int)(iteration / hashCode) -1;
			}

			return colors[colorIndex];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("problem " + colorIndex + " " + colors.length + " " + iteration);
		}

		return colors[0];
	}

	public void drawMandelBrot()
	{
		for (int i = 0; i< megethos; i++)
		{
			for (int j = 0; j < megethos; j++)
			{
				double x0 = x_Coord-areaSize / 2 + areaSize*i / megethos;
				double y0 = y_Coord-areaSize / 2 + areaSize*j / megethos;

				Complex z0 = new Complex(x0, y0);

				int iterations = mand(z0, numberOfIterations);

				Color color = getColor(iterations);

				image.setRGB(i, megethos - 1 - j, color.getRGB());
			}
		}

		if(frame == null)
		{
			return;
		}

		frame.setVisible(true);
		repaint();
	}

	public static int mand(Complex z0, int max)
	{
		Complex z = z0;

		for (int t = 0; t<max; t++)
		{
			if (z.abs()>2.0)
			{
				return t;
			}

			z = z.times(z).plus(z0);
        	}

		return max;
	}
}
