package Admin.customers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class modifycustomer extends JFrame{
	JLabel l1, l2,l3, l4, l5, l6, l7, l8, l9,l10, l11;
	JTextField n, c, s, dor, gn, ad, em, ph,m, sl;
	JButton sub, can, b1;
	Choice c1;
	JPanel p1,p2;
	String id;
	public modifycustomer()
	{
		setSize(600,400);
		setTitle("Modify Customer Details");
		getContentPane().setBackground(Color.black);
		
		p1=new JPanel();
		p1.setBackground(Color.black);
		
		p2=new JPanel();
		p2.setBackground(Color.black);
		
		l1 = new JLabel("   Name");
		l1.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l1.setForeground(Color.white);
		
		l2 = new JLabel("   Guardian's Name");
		l2.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l2.setForeground(Color.white);

		l3 = new JLabel("   Date Of Registration");
		l3.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l3.setForeground(Color.white);

		l4 = new JLabel("   State");
		l4.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l4.setForeground(Color.white);

		l5 = new JLabel("   District");
		l5.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l5.setForeground(Color.white);

		l6 = new JLabel("   Address");
		l6.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l6.setForeground(Color.white);

		l7 = new JLabel("   Email");
		l7.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l7.setForeground(Color.white);

		l8 = new JLabel("   Phone");
		l8.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l8.setForeground(Color.white);
		
		l9 = new JLabel("   Customer ID:");
		l9.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l9.setForeground(Color.white);
		
		l10 = new JLabel("   Meter Number");
		l10.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l10.setForeground(Color.white);
        
        l11=new JLabel("   Sanctioned Load (kW)");
        l11.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
        l11.setForeground(Color.white);
        l11.setBounds(50,245,160,30);
		
		n=new JTextField(20);
		c=new JTextField(20);
		s=new JTextField(20);
		dor=new JTextField(20);
		gn=new JTextField(20);
		ad=new JTextField(20);
		em=new JTextField(20);
		ph=new JTextField(20);
		m=new JTextField(20);
		sl=new JTextField(20);

		sub=new JButton("Modify");
		sub.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        sub.revalidate();
		can=new JButton("Cancel");
		can.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        can.revalidate();
        b1=new JButton("View");
		b1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b1.revalidate();
        
		
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
        
		b1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent ae)
			{
				try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
		            String query="SELECT * FROM Details WHERE ID= '"+c1.getSelectedItem()+"'";
		            id=c1.getSelectedItem();
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
		
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
		            System.out.println("Connected Successfully");
		            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		            String sql = "Select * FROM Details WHERE ID= '"+id+"'";

		            ResultSet rs = st.executeQuery(sql);  
		            System.out.println("QUERY DONE");

		            if (rs != null) 
		                while (rs.next()) 
		                {
		                    rs.updateString("CustomerName", n.getText());
		                    rs.updateString("Guardian", gn.getText());
		                    rs.updateString("City", c.getText());  
		                    rs.updateString("State", s.getText()); 
		                    rs.updateString("RegistrationDate", dor.getText()); 
		                    rs.updateString("Address", ad.getText());  
		                    rs.updateString("Email", em.getText());  
		                    rs.updateString("Phone", ph.getText()); 
		                    rs.updateString("Meter", m.getText());  
		                    rs.updateInt("SanctionedLoad", Integer.parseInt(sl.getText()));

		                    rs.updateRow();
		                 }                                  
		            System.out.println("UPDATED");

		            st.close(); 
		            rs.close();
		            connection.close();
		            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
		            setVisible(false);
		            
		        }catch(Exception e){
		            System.out.println("Error in connection");

		        }
			}
		});
		can.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null, "Operation Cancelled");
	            setVisible(false);
			}
		});
		
		
		p1.add(l9);
		p1.add(c1);
		p1.add(b1);
		p1.setLayout(new FlowLayout());		
		
		p2.add(l1);
		p2.add(n);
		p2.add(l11);
		p2.add(sl);
		p2.add(l10);
		p2.add(m);
		p2.add(l2);
		p2.add(gn);
		p2.add(l3);
		p2.add(dor);
		p2.add(l4);
		p2.add(s);
		p2.add(l5);
		p2.add(c);
		p2.add(l6);
		p2.add(ad);
		p2.add(l7);
		p2.add(em);
		p2.add(l8);
		p2.add(ph);
		
		p2.add(sub);
		p2.add(can);
		
		p2.setLayout(new GridLayout(11,2));
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
