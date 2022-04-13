package Admin.customers;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.*;

public class editbill extends JFrame {
	Choice id, yr,mth;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField u,p,s;
	JButton b1,b2,b3;
	JPanel p1,p2;

	public editbill()
	{
		id=new Choice();
		p1=new JPanel();
		p2=new JPanel();
		
		try {
			  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
	        String query="SELECT * FROM Details";
	        Statement preparedStatement=connection.createStatement();
	        ResultSet resultSet=preparedStatement.executeQuery(query);
	        while(resultSet.next()){
	        	id.add(resultSet.getString("ID"));
	        }
	        System.out.println("Successful");
	 	  
	      mth=new Choice();
	      yr=new Choice();
	      
	      LocalDate currentdate = LocalDate.now();
	      int currentYear = currentdate.getYear();
	      
	      for(int i=2020; i<=currentYear; i++)
	      {
	    	  yr.add(Integer.toString(i));
	      }
	      for(int i=1; i<=12;i++)
	      {
	    	  mth.add(Month.of(i).name());
	      }
	      
			l1 = new JLabel("   ID");
			l1.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
			l1.setForeground(Color.white);

			l2 = new JLabel("   Year");
			l2.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
			l2.setForeground(Color.white);

			l3 = new JLabel("   Month");
			l3.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
			l3.setForeground(Color.white);

			l4 = new JLabel("   Billed Units");
			l4.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
			l4.setForeground(Color.white);

			l5 = new JLabel("   Payment Satus");
			l5.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
			l5.setForeground(Color.white);

			l6 = new JLabel("   Billing Cycle Concluded");
			l6.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
			l6.setForeground(Color.white);
			
			u=new JTextField(20);
			p=new JTextField(20);
			s=new JTextField(20);
			
			b1=new JButton("Open");
			b1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
	        b1.revalidate();
	        b1.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent ae)
				{

					try {
						  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
					
				        String test="SELECT * FROM Bill WHERE ID= '"+id.getSelectedItem()+"' AND _year='"+yr.getSelectedItem()+"' AND _month='"+mth.getSelectedItem()+"'";
				        Statement psm=connection.createStatement();
				        ResultSet rS=psm.executeQuery(test);
				        System.out.println("B1 DONE");
						if (rS.next()) {
							u.setEnabled(true);
							p.setEnabled(true);
							s.setEnabled(true);
							b3.setEnabled(true);
							String q_1 = "SELECT * FROM Bill WHERE ID= '" + id.getSelectedItem() + "' AND _year='"+ yr.getSelectedItem() + "' AND _month='" + mth.getSelectedItem() + "'";
							Statement ps_m = connection.createStatement();
							ResultSet rs2 = ps_m.executeQuery(q_1);
							while (rs2.next()) {
								u.setText(Integer.toString(rs2.getInt("Units")));
								p.setText(rs2.getString("Payable"));
								s.setText(rs2.getString("Status"));
								System.out.println("DONE");
							}
				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(null, "No Billing History For Selected Period");
				        }
					psm.close();
					rS.close();
					connection.close();
					}
					catch(Exception e)
					{
						System.out.println("Error");
					}
			        
				}
			}); 
			
	        b3=new JButton("Change");
			b3.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
	        b3.revalidate();
	        b3.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent ae)
				{
					try {
						  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
				        System.out.println("Connected Successfully");
			            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			            String sql = "SELECT * FROM Bill WHERE ID= '"+id.getSelectedItem()+"' AND _year='"+yr.getSelectedItem()+"' AND _month='"+mth.getSelectedItem()+"'";

			            ResultSet rs = st.executeQuery(sql);  
			            System.out.println("QUERY DONE");

			            if (rs != null) 
			                while (rs.next()) 
			                {
			                	rs.updateInt("Units", Integer.parseInt(u.getText()));
			                	rs.updateString("Payable", p.getText());
			                	rs.updateString("Status", s.getText());
			                	rs.updateRow();
	                 }                                  
	            System.out.println("UPDATED");

	            st.close(); 
	            rs.close();
			        connection.close();
			        JOptionPane.showMessageDialog(null, "Bill Updated");
		            setVisible(false);
					}
					catch(Exception e)
					{
						System.out.println("Error");
					}
				}
			}); 
	        
	        b2=new JButton("Cancel");
			b2.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
	        b2.revalidate();
	        b2.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent ae)
				{
					setVisible(false);
				}
			}); 
	        

			u.setEnabled(false);
			p.setEnabled(false);
			s.setEnabled(false);
			b3.setEnabled(false);
			
		p1.add(l1);
		p1.add(id);
		p1.add(l2);
		p1.add(yr);
		p1.add(l3);
		p1.add(mth);
		p1.add(b1);

	    p1.setBackground(Color.black);
		p1.setLayout(new FlowLayout());
		
		p2.add(l4);
		p2.add(u);
		p2.add(l5);
		p2.add(s);
		p2.add(l6);
		p2.add(p);
		p2.add(b2);
		p2.add(b3);

	    p2.setBackground(Color.black);
		p2.setLayout(new GridLayout(4,2));
		
		setLayout(new BorderLayout());
	    
	    add(p1,BorderLayout.NORTH);
	    add(p2,BorderLayout.CENTER);
	    
	    setSize(600,300);
	    setLocationRelativeTo(null);
	    setVisible(true);


	 	   resultSet.close();
	 	   preparedStatement.close();
	 	   connection.close();

	    }
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
