import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;

public class ManFrame extends JFrame implements ActionListener
{
	ManFonto mfonto = null;

		

	public ManFrame(String title, ManFonto mfonto, int megethos)
	{

		super(title);
		this.mfonto = mfonto;
		mfonto.setFrame(this);
		Container con = getContentPane();
		con.add(mfonto);
		mfonto.startDrawing();


		JMenuItem isave = new JMenuItem ("Save...");
		isave.setMnemonic('S');
		isave.setActionCommand("Save");
		isave.addActionListener(this);

		JMenu mfile = new JMenu("File");
		mfile.setMnemonic('F');
		mfile.add(isave);
	
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		mbar.add(mfile);

		this.pack();
		
		this.setSize(megethos, megethos);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		

	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		Choises c = Choises.valueOf(command);
		switch(c)
		{
			case Save:	mfonto.saveFile();
 		}
		
		
	}
}


	