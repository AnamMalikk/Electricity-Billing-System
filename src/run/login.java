package run;
import Customer.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

import Admin.employeeDashboard;

class myPanel extends JPanel {

	  private Image img;
	  public myPanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }
	  public myPanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }
	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);

	}
}

public class login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3, l4,l5,l6;
    JTextField tf1, tf2;
    JPasswordField pf2, pf3;
    JButton b1,b2, b3, b4, b5;
    myPanel p2,p1,p3,mainpane;
    CardLayout cl=new CardLayout();

    login()
    {
        super("Login Page");
        setLayout(null);
        setLocationRelativeTo(null);
        
        mainpane=new myPanel(new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\blue.jpg").getImage());
        mainpane.repaint();
        
        p3=new myPanel(new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\imagesblue.jpg").getImage());
        p3.repaint();

        p1=new myPanel(new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\blue.jpg").getImage());
        p1.repaint();
        
        p2=new myPanel(new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\blue.jpg").getImage());
        p2.repaint();
   
    setLayout(new FlowLayout());
        getContentPane().setBackground(Color.cyan);
        l1 = new JLabel("Username");
        l1.setBounds(300, 30, 100, 20);
        l1.setForeground(Color.white);
        p2.add(l1);
        l2 = new JLabel("Password");
        l2.setBounds(300, 70, 100, 20);
        l2.setForeground(Color.white);
        p2.add(l2);
       
        tf1 = new JTextField(15);
        tf1.setBounds(400, 30, 150, 20);
        p2.add(tf1);
        pf2 = new JPasswordField(15);
        pf2.setBounds(400, 70, 150, 20);
        p2.add(pf2);
       
        b1 = new JButton(" Login ");
        b1.setBounds(340, 140, 110, 30);
        p2.add(b1);
       
        b2 = new JButton(" Signup ");
        b2.setBounds(470, 140, 110, 30);
        p2.add(b2);
        
        b3 = new JButton("Admin Login");
        b3.setBounds(130, 120, 150, 30);
        b3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		cl.show(mainpane, "panel3");
        	}
        });
		b3.setFont(new Font("Sanserif", Font.PLAIN, 14));
        b3.revalidate();

        b4 = new JButton("Customer Login");
        b4.setBounds(300, 120,150,30);
        b4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		cl.show(mainpane, "panel2");
        	}
        });
		b4.setFont(new Font("Sanserif", Font.PLAIN, 14));
        b4.revalidate();

        b1.addActionListener(this);
        b2.addActionListener(this);


        ImageIcon ic3 = new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\loginicon.png");
        Image i3 = ic3.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        l3.setBounds(0, 0, 250, 250);
        p2.add(l3);
        p2.setLayout(new BorderLayout());
        
       
        l4 = new JLabel("Username");
        l4.setBounds(300, 30, 100, 20);
        l4.setForeground(Color.white);
        p3.add(l4);
        l5 = new JLabel("Password");
        l5.setBounds(300, 70, 100, 20);
        l5.setForeground(Color.white);
        p3.add(l5);
       
        tf2 = new JTextField(15);
        tf2.setBounds(400, 30, 150, 20);
        p3.add(tf2);
        pf3 = new JPasswordField(15);
        pf3.setBounds(400, 70, 150, 20);
        p3.add(pf3);
       
        b5 = new JButton(" Login ");
        b5.setBounds(340, 140, 110, 30);
        p3.add(b5);
        
        b5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		String pf_3=new String(pf3.getPassword());
        	     if(tf2.getText().equals("Admin123")&& pf_3.equals("123@dmin")) {
                     setVisible(false);
                     new employeeDashboard().setVisible(true);

                 }else{
                     JOptionPane.showMessageDialog(null, "Invalid login");
                     tf1.setText("");
                     pf3.setText("");
                 }
        	}
        });
        
        


        ImageIcon ic6 = new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\loginicon.png");
        Image i6= ic6.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon icc6 = new ImageIcon(i6);
        l6 = new JLabel(icc6);
        l6.setBounds(0, 0, 250, 250);
        p3.add(l6);
        p3.setLayout(new BorderLayout());
        
        
        p1.setBackground(Color.black);


        p1.add(b3);
        p1.add(b4);
        
        p1.setLayout(new BorderLayout());
        
  mainpane.setLayout(cl);
        
        mainpane.add(p1, "panel1");
        mainpane.add(p2, "panel2");
        mainpane.add(p3, "panel3");;

        this.setContentPane(mainpane);
        cl.show(mainpane, "panel1");
        
        setLocation(200,150);
        setVisible(true);
        setSize(619,299);
        setSize(620,300);
       
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == b1)
        {
            try
            {   
            	String a  = tf1.getText();
                String b  = new String(pf2.getPassword());
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
                Statement s=connection.createStatement();
                System.out.println("CONNECTION ESTABLISHED");
                 String query="select * from Details where Username = '"+a+"' and Password = '"+b+"'";
                
                 ResultSet rs=s.executeQuery(query);
                 System.out.println("EXCECUTED");
                
                if(rs.next()){
                    String id = rs.getString("ID");
                    this.setVisible(false);
                    new MainDashboard(id).setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf2.setText("");
                }
                rs.close();
                s.close();
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }
        else if(ae.getSource() == b2)
        {
            this.setVisible(false);
           new signup();
           
        }
   
       
    } 
    
}

