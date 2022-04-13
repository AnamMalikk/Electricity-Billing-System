package Customer;

import Customer.user.*;
import run.imgscale;
import Customer.bills.*;
import Customer.calculate.*;
import Customer.feedbck.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MainDashboard extends JFrame {
	
	
	public MainDashboard(String id)
	{
		super("Electricity Billing System");
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final BufferedImage img=new imgscale().scaleImage(screenSize.width,screenSize.height,"C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\dashscr.jpg");
		JLabel label=new JLabel(new ImageIcon((Image)img));
        add(label);
		
	
		JMenuBar nb= new JMenuBar();
		
		
		//****************************************
		//first column
		
		JMenu user= new JMenu("User");		
		user.setForeground(Color.blue);
		
		//u1
		
		JMenuItem u1= new JMenuItem("View", KeyEvent.VK_V);
		u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		u1.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent ae)
			{
				new view(id);
			}
				});
		u1.setToolTipText("View Account Details");
		JMenuItem u2=new JMenuItem("Modify", KeyEvent.VK_M);
		u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		u2.setToolTipText("Modify Account Details");
		u2.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent ae)
	{
		new confirm(1,id);
	}
		});
		JMenuItem u3=new JMenuItem("Change User ID",KeyEvent.VK_U);
		u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		u3.setToolTipText("Change Account User ID");
		u3.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent ae)
	{
		new confirm(2,id);
	}
		});
		JMenuItem u4=new JMenuItem("Change Password",KeyEvent.VK_P);
		u4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		u4.setToolTipText("Change Account Password");
		u4.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent ae)
	{
		new confirm(3,id);
	}
		});
		
		u1.setFont(new Font("monospaced", Font.PLAIN, 14));
		ImageIcon icon4= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\u1.jpg");
		Image image4=icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		u1.setIcon(new ImageIcon (image4));
		
		u1.setBackground(Color.WHITE);
		
		
		//u2
		
		u2.setFont(new Font("monospaced", Font.PLAIN, 14));
		ImageIcon icon5= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\u2.jpg");
		Image image5=icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		u2.setIcon(new ImageIcon (image5));
		
		u2.setBackground(Color.WHITE);
		
		
		//u3
		
		u3.setFont(new Font("monospaced", Font.PLAIN, 14));
		ImageIcon icon6= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\u3.jpg");
		Image image6=icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		u3.setIcon(new ImageIcon (image6));
		
		u3.setBackground(Color.WHITE);
		
		//u4
		
		u4.setFont(new Font("monospaced", Font.PLAIN, 14));
		ImageIcon u4img= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\u3.jpg");
		Image img7=u4img.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		u4.setIcon(new ImageIcon (img7));
		
		u4.setBackground(Color.WHITE);
		
		//
		
	
		
		//**************************************
		//second column
		
				JMenu bill= new JMenu("Bill");
				JMenuItem b1= new JMenuItem("Pay Bill", KeyEvent.VK_B);
				b1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
				b1.setToolTipText("Go to Payment Window");
				b1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae)
						{
							new Pay(id);
						}
				});
				JMenuItem b2= new JMenuItem("View Bill", KeyEvent.VK_G);
				b2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
				b2.setToolTipText("Generate Electricity Bill");
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new Generate_Bill(id);
					}
			});
				
				
				bill.setForeground(Color.blue);
				
				//b1
				
				b1.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icon1= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\b1.jpg");
				Image image1=icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				b1.setIcon(new ImageIcon (image1));
				
				b1.setBackground(Color.WHITE);
				
				
				//b2
				
				b2.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icon2= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\b2.jpg");
				Image image2=icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				b2.setIcon(new ImageIcon (image2));
				
				b2.setBackground(Color.WHITE);


				
				//***************************************
				//third column
				
				JMenu calculate= new JMenu("Calculate");
				JMenuItem c1= new JMenuItem("Calculate",KeyEvent.VK_C);
				c1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
				c1.setToolTipText("Go to Calculator");
				c1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new Calculator();
					}
				});
				JMenuItem c2= new JMenuItem("Notepad",KeyEvent.VK_N);
				c2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				c2.setToolTipText("Go to Notepad");
				c2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new Notepad();
					}
				});
				
				calculate.setForeground(Color.blue);
				
				//c1
				
				c1.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icon7= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\c1.jpg");
				Image image7=icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				c1.setIcon(new ImageIcon (image7));
				
				c1.setBackground(Color.WHITE);
				
				
				//c2
				
				c2.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icon8= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\c2.jpg");
				Image image8=icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				c2.setIcon(new ImageIcon (image8));
				
				c2.setBackground(Color.WHITE);
				
				//
				
			
				
				
				
				//***************************************
				//fourth column
				
				JMenu feedback= new JMenu("Feedback");
				JMenuItem fd= new JMenuItem("Feedback",KeyEvent.VK_F);
				fd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
				fd.setToolTipText("Give Feedback");
				feedback.setForeground(Color.magenta);
				
				fd.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icon9= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\fd.jpg");
				Image image9=icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				fd.setIcon(new ImageIcon (image9));
				
				fd.setBackground(Color.WHITE);
				
				fd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new button(id);
					}
				});
				
		        //***************************************
				//fifth column
		
		JMenu exit= new JMenu("Exit");
		JMenuItem ex= new JMenuItem("Exit",KeyEvent.VK_E);
		ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		ex.setToolTipText("Exit Application");
		exit.setForeground(Color.red);
		
		ex.setFont(new Font("monospaced", Font.PLAIN, 14));
		ImageIcon icon0= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\ex.jpg");
		Image image0=icon0.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ex.setIcon(new ImageIcon (image0));
		
		ex.setBackground(Color.WHITE);
		
		ex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
				new Tips();
			}
		});
		
		
		//*****************************************
		
		
	     user.add(u1);
		user.add(u2);
		user.add(u3);
		user.add(u4);
		
		bill.add(b1);
		bill.add(b2);

		calculate.add(c1);
		calculate.add(c2);

		feedback.add(fd);
		
		exit.add(ex);
		
		
		nb.add(user);
		nb.add(bill);
		nb.add(calculate);
		nb.add(feedback);
		nb.add(exit);
		
		setJMenuBar(nb);
		setFont(new Font("monospaced", Font.BOLD,16));
		setLayout(new FlowLayout());
		setVisible(true);
		
	}
	

}
