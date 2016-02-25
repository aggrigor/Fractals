import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.lang.Exception;
import java.awt.Container;



class MDialog extends JDialog implements ActionListener
{

	private JFrame frame = null;
	private JPanel panel = null;
	
	double x_Coord = 0.0D;
	double y_Coord = 0.0D;
	double areaSize = 0.0D;
	int numberOfIterations = 0;	 
	int megethos = 0;


	private String Titlos()
	{
		String title = megethos + "x" + megethos + ":" + x_Coord + " " + y_Coord + " " + areaSize + " " + numberOfIterations;
		return title;
	}




	JTextField tf1 = null;
	JTextField tf2 = null;
	JTextField tf3 = null;
	JTextField tf4 = null;
	JTextField tf5 = null;


	JLabel lb1=new JLabel("x-Coord of center");
	JLabel lb2=new JLabel("y-Coord of center");
	JLabel lb3=new JLabel("Area size");
	JLabel lb4=new JLabel("Image size");
	JLabel lb5=new JLabel("Number of Iterations");

	private boolean elegxos()
	{
		try
		{
			x_Coord = Double.parseDouble(tf1.getText());
			y_Coord = Double.parseDouble(tf2.getText());
			areaSize = Double.parseDouble(tf3.getText());
			megethos = Integer.parseInt(tf4.getText());
			numberOfIterations = Integer.parseInt(tf5.getText());
		}
		catch(Exception e)
		{
			String message = "Input type mismatch in one (or more) input fields\n";
			JOptionPane.showMessageDialog(this, message+e.getLocalizedMessage(), "Message", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}
	
	

	
	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		Choises c = Choises.valueOf(command);
		switch(c)
		{
			case Accept:	if(elegxos() == true)
					{

						ManFonto mfonto = new ManFonto(x_Coord, y_Coord, areaSize, megethos, numberOfIterations);
 						ManFrame frame = new ManFrame(Titlos(), mfonto, megethos);
					}
			case Cancel:	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
		dispose();

	}

	public MDialog(JFrame frame, String title, boolean modal, JFrame parent)
	{
		super(frame, title, modal);
		this.frame = parent;
		panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		Container cont = this.getContentPane();
		cont.add(panel);

		
		tf1 = new JTextField("0.5");
		tf1.setHorizontalAlignment(JTextField.CENTER);
	
		tf2 = new JTextField("0.5");
		tf2.setHorizontalAlignment(JTextField.CENTER);

		tf3 = new JTextField("1.0");
		tf3.setHorizontalAlignment(JTextField.CENTER);

		tf4 = new JTextField("768");
		tf4.setHorizontalAlignment(JTextField.CENTER);

		tf5 = new JTextField("100");
		tf5.setHorizontalAlignment(JTextField.CENTER);



		JButton button1 = new JButton("Accept");
		button1.setMnemonic('A');
		button1.setActionCommand("Accept");
		button1.addActionListener(this);


		JButton button2 = new JButton("Cancel");
		button2.setMnemonic('C');
		button2.setActionCommand("Cancel");
		button2.addActionListener(this);


		GridBagConstraints constaints = new GridBagConstraints();
		constaints.fill=GridBagConstraints.BOTH;
		constaints.weightx=0.0;
		constaints.weighty=0.0;
		constaints.ipady=30;
		constaints.gridx=0;
		constaints.gridy=0;
		constaints.ipadx=60;
		layout.setConstraints(lb1,constaints);
		panel.add(lb1);

		constaints.gridx=1;
		constaints.gridy=0;
		constaints.ipadx=0;
		layout.setConstraints(tf1,constaints);
		panel.add(tf1);

		constaints.gridx=0;
		constaints.gridy=1;
		layout.setConstraints(lb2,constaints);
		panel.add(lb2);

		constaints.gridx=1;
		constaints.gridy=1;
		layout.setConstraints(tf2,constaints);
		panel.add(tf2);

		constaints.gridx=0;
		constaints.gridy=2;
		layout.setConstraints(lb3,constaints);
		panel.add(lb3);

		constaints.gridx=1;
		constaints.gridy=2;
		layout.setConstraints(tf3,constaints);
		panel.add(tf3);

		constaints.gridx=0;
		constaints.gridy=3;
		layout.setConstraints(lb4,constaints);
		panel.add(lb4);

		constaints.gridx=1;
		constaints.gridy=3;
		layout.setConstraints(tf4,constaints);
		panel.add(tf4);

		constaints.gridx=0;
		constaints.gridy=4;
		layout.setConstraints(lb5,constaints);
		panel.add(lb5);

		constaints.gridx=1;
		constaints.gridy=4;
		layout.setConstraints(tf5,constaints);
		panel.add(tf5);

		constaints.gridx=0;
		constaints.gridy=5;
		constaints.ipady=10;
		layout.setConstraints(button1,constaints);
		panel.add(button1);

		constaints.gridx=1;
		constaints.gridy=5;
		layout.setConstraints(button2,constaints);
		panel.add(button2);

		// set frame parameters and display it
		this.pack();
		this.setSize(350,350);
		this.setResizable(false);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}
}		




















