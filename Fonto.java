import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Image;
import java.awt.image.BufferedImage;



class Fonto extends JPanel
{
	private Insets insets = null;
	private BufferedImage image = null;
	private int Width = 0;
	private int Height = 0;

	public void setFonto(BufferedImage image, int Width, int Height)
	{
		this.image = image;
		this.Width = Width;
		this.Height = Height;
	}

	public void setFonto(Image image, int Width, int Height)
	{
 		this.image = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_BGR);
		this.image.createGraphics().drawImage(image, 0, 0, null);
		this.Width = 0;
		this.Height = 0;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if(insets==null)
		{
			insets=getInsets();
		}

		g.drawImage(image, insets.left+Width, insets.top, null);

	}
}
