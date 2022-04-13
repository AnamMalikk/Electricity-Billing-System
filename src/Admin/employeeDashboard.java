package Admin;
import Admin.customers.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import run.imgscale;

public class employeeDashboard extends JFrame   {    
	
	public employeeDashboard()
	{
         super("Electricity Billing System: Admin Interface");

 		
 		setExtendedState(JFrame.MAXIMIZED_BOTH); 
 		
 	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 		final BufferedImage img=new imgscale().scaleImage(screenSize.width,screenSize.height,"C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\dashscr2.jpg");
 		JLabel label=new JLabel(new ImageIcon((Image)img));
         add(label);
 		
		
		JMenuBar nb= new JMenuBar();
		
		
		//first column
		
				JMenu details= new JMenu("Customer Details");
				JMenuItem d1= new JMenuItem("View Details", KeyEvent.VK_V);
				d1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
				d1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new viewcustomer();
					}
				});
				d1.setToolTipText("View Customer Information");
				JMenuItem d2= new JMenuItem("Modify Customer Details", KeyEvent.VK_M);
				d2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
				d2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new modifycustomer();
					}
				});
				d2.setToolTipText("Modify Customer Information");
				JMenuItem d3= new JMenuItem("Add Customer",KeyEvent.VK_A);
				d3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
				d3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new addcustomer();
					}
				});
				d3.setToolTipText("Add New Customer Record");
				JMenuItem d4= new JMenuItem("Delete User", KeyEvent.VK_D);
				d4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
				d4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new deletecustomer();
					}
				});
				d4.setToolTipText("Delete Customer Record");
				
				details.setForeground(Color.blue);
		
				//d1
				d1.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icond1= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\u1.png");
				Image imaged1=icond1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				d1.setIcon(new ImageIcon (imaged1));
				
				d1.setBackground(Color.WHITE);
				
				
				//d2
				d2.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icond2= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\u1.png");
				Image imaged2=icond2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				d2.setIcon(new ImageIcon (imaged2));
				
				d2.setBackground(Color.WHITE);
				
				//d3
				d3.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icond3= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\u1.png");
				Image imaged3=icond3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				d3.setIcon(new ImageIcon (imaged3));
				
				d3.setBackground(Color.WHITE);
				
				//d4
				d4.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icond4= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\u1.png");
				Image imaged4=icond4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				d4.setIcon(new ImageIcon (imaged4));
				
				d4.setBackground(Color.WHITE);
			
				//second column
				JMenu bills=new JMenu("Customer Bills");
				JMenuItem b1=new JMenuItem("Edit Bill Information", KeyEvent.VK_E);
				b1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
				b1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new editbill();
					}
				});
				b1.setToolTipText("Modify Customer Bill Information");
				JMenuItem b2=new JMenuItem("Enter Bill", KeyEvent.VK_C);
				b2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						new createbill();
					}
				});
				b2.setToolTipText("Enter New Bill");
				
				bills.setForeground(Color.orange);
				
				bills.add(b1);
				bills.add(b2);
				
				
				//b1
				b1.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon iconb1= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\b1.png");
				Image imageb1=iconb1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				b1.setIcon(new ImageIcon (imageb1));
				
				b1.setBackground(Color.WHITE);
				
				//b2
				b2.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon iconb2= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\b1.png");
				Image imageb2=iconb2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				b2.setIcon(new ImageIcon (imageb2));
				
				b2.setBackground(Color.WHITE);
				
				//third column
				JMenu exit= new JMenu("Exit");
				JMenuItem ex= new JMenuItem("Logout", KeyEvent.VK_L);
				ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
				ex.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						System.exit(0);
					}
				});
				ex.setToolTipText("Log Out of Admin");
				exit.setForeground(Color.red);
				
				ex.setFont(new Font("monospaced", Font.PLAIN, 14));
				ImageIcon icon0= new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\ex.png");
				Image image0=icon0.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				ex.setIcon(new ImageIcon (image0));
				
				ex.setBackground(Color.WHITE);
								
				
				details.add(d1);
				details.add(d2);
				details.add(d3);
				details.add(d4);
				
				exit.add(ex);
				
				
				nb.add(details);
				nb.add(bills);
				nb.add(exit);
				
				
				setJMenuBar(nb);
				setFont(new Font("monospaced", Font.BOLD,16));
				setLayout(new FlowLayout());
				setVisible(true);}}
