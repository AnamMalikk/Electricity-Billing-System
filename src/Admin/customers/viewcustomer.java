package Admin.customers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import javax.swing.JLabel;

public class viewcustomer extends JFrame {
	JLabel n, c, s, m, dor, gn, ad, em, ph, sl;
	JLabel l1, l2,l3, l4, l5, l6, l7, l8, l9, l10,l11;
	Choice c1;
	JPanel p1,p2;
	JButton b1,b2;

	public viewcustomer()
	{ 
		setSize(400,600);
		p1=new JPanel();
		p1.setBackground(Color.black);
		p2=new JPanel();
		p2.setBackground(Color.black);
		
		n=new JLabel("");
		c=new JLabel(""); 
		s=new JLabel("");
		m=new JLabel(""); 
		dor=new JLabel("");
		gn=new JLabel("");
		ad=new JLabel("");
		em=new JLabel("");
		ph=new JLabel("");
		sl=new JLabel("");
		
		c1=new Choice();
		
		try {
		  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
          String query="SELECT * FROM Details";
          Statement preparedStatement=connection.createStatement();
          ResultSet resultSet=preparedStatement.executeQuery(query);
          while(resultSet.next()){
          	c1.add(resultSet.getString("ID"));
          }
          System.out.println("Successful");

   	   resultSet.close();
   	   preparedStatement.close();
   	   connection.close();
		 }catch(Exception e){
	            System.out.println("Error in connection");

	        }
		
		b1=new JButton("View");
		b2=new JButton("Exit");
		b2.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b2.revalidate();
        b2.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
			}
		}); 
		
		setTitle("Customer Details");
		getContentPane().setBackground(Color.black);
		
		b1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent ae)
			{
				try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
		            String query="SELECT * FROM Details WHERE ID= '"+c1.getSelectedItem()+"'";
		            Statement preparedStatement=connection.createStatement();
		            ResultSet resultSet=preparedStatement.executeQuery(query);
		            while(resultSet.next()){
		            	 m.setText(resultSet.getString("Meter"));
		            	    m.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		                    m.setForeground(Color.gray);
		                 n.setText(resultSet.getString("CustomerName"));
		                    n.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		                    n.setForeground(Color.gray);
		                 gn.setText(resultSet.getString("Guardian"));
		                    gn.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		                    gn.setForeground(Color.gray);
		                 dor.setText(resultSet.getString("RegistrationDate"));
		                    dor.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		                    dor.setForeground(Color.gray);
		                 s.setText(resultSet.getString("State"));
		                    s.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		                    s.setForeground(Color.gray);
		                 c.setText(resultSet.getString("City")); 
		                    c.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		                    c.setForeground(Color.gray);
		                 ad.setText(resultSet.getString("Address")); 
		                    ad.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		                    ad.setForeground(Color.gray);
		                 em.setText(resultSet.getString("Email")); 
		                    em.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		                    em.setForeground(Color.gray);
		                 ph.setText(resultSet.getString("Phone")); 
		                    ph.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		                    ph.setForeground(Color.gray);
		                 sl.setText(Integer.toString(resultSet.getInt("SanctionedLoad"))); 
			                    sl.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
			                    sl.setForeground(Color.gray);
		                    
		            }
		            System.out.println("Successful");

		        	   resultSet.close();
		        	   preparedStatement.close();
		        	   connection.close();
		        	   
				}catch(Exception e)
				{
					System.out.println("Unsuccessful");
					}
			}
		}); 
		
		b1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b1.revalidate();

            
            l1=new JLabel("   Name");
                    l1.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l1.setForeground(Color.white);
                    
            l2=new JLabel("   Guardian's Name");
                    l2.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l2.setForeground(Color.white);
                   
            l3=new JLabel("   Date Of Registration");
                    l3.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l3.setForeground(Color.white);
                   
            l4=new JLabel("   State");
                    l4.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l4.setForeground(Color.white);
                    
            l5=new JLabel("   District");
                    l5.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l5.setForeground(Color.white);
                    
            l6=new JLabel("   Meter Number");
                    l6.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l6.setForeground(Color.white);
                    
                    
            l7=new JLabel("   Address");
                    l7.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l7.setForeground(Color.white);
                    
            l8=new JLabel("   E-mail");
                    l8.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l8.setForeground(Color.white);
                    
            l9=new JLabel("   Phone Number");
                    l9.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l9.setForeground(Color.white);
                    
            l10=new JLabel("   Customer ID");
                    l10.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l10.setForeground(Color.white);
                    l10.setBounds(50,245,160,30);
                    
            l11=new JLabel("   Sanctioned Load (kW)");
                    l11.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l11.setForeground(Color.white);
                    l11.setBounds(50,245,160,30);
                    
            p1.add(l10);
            p1.add(c1);
            p1.add(b1);
            p1.setLayout(new FlowLayout());            
                    
            p2.add(l1);
            p2.add(n);
            p2.add(l11);
            p2.add(sl);
            p2.add(l2);
            p2.add(gn);
            p2.add(l3);
            p2.add(dor);
            p2.add(l4);
            p2.add(s);
            p2.add(l5);
            p2.add(c);
            p2.add(l6);
            p2.add(m);
            p2.add(l7);
            p2.add(ad);
            p2.add(l8);
            p2.add(em);
            p2.add(l9);
            p2.add(ph);
            p2.setLayout(new GridLayout(10,2));
            
            setLayout(new BorderLayout());
            
            add(p1,BorderLayout.NORTH);
            add(p2,BorderLayout.CENTER);
            add(b2,BorderLayout.SOUTH);
            
            setLocationRelativeTo(null);
    		setVisible(true);
       
		}

}

