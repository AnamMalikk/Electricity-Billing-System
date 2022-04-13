package Customer.user;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

class userid extends JFrame{
	JLabel l1, l2, l3, l4;
	JTextField n1, n2;
	JButton b1, b2;
	String id;
	userid(String i)
	{
		setSize(400,200);
		id=i;
		String uid;
		setTitle("Change User ID");
		getContentPane().setBackground(Color.black);
		
		try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\CUSTOMERS_DB.accdb");
            System.out.println("Connected");

            String query="SELECT * FROM Details WHERE ID = '"+id+"'";
            Statement preparedStatement=connection.createStatement();
            ResultSet resultSet=preparedStatement.executeQuery(query);
            System.out.println("Executed");

            while(resultSet.next()){
            	l4=new JLabel(resultSet.getString("Username"));
            	l4.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
        		l4.setForeground(Color.white);
                }
            System.out.println("Done");
           	connection.close();
           	preparedStatement.close();
           	resultSet.close();

		    }catch(Exception e){
                System.out.println("Error in connection");

            }
		
		l1=new JLabel("   Current User ID");
		l1.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l1.setForeground(Color.white);
		
		l2=new JLabel("   New User ID");
		l2.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l2.setForeground(Color.white);
		
		l3=new JLabel("   Confirm New User ID");
		l3.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l3.setForeground(Color.white);
		
		n1=new JTextField(20);
		n2=new JTextField(20);
		
		b1=new JButton("Confirm");
		b1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b1.revalidate();
		b2=new JButton("Cancel");
		b2.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b2.revalidate();
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				if(n1.getText().equals(n2.getText()))
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
			                    rs.updateString("Username", n2.getText());			               
			                    rs.updateRow();
			                 }                                  
			            System.out.println("UPDATED");

			            st.close(); 
			           	connection.close();
			            rs.close();
			            JOptionPane.showMessageDialog(null, "User ID Updated Successfully");
			            setVisible(false);
			        }catch(Exception e){
			            System.out.println("Error in connection");

			        }
				}
				else
				{
					JOptionPane.showMessageDialog(null, "User IDs Don't Match");
					n1.setText("");
					n2.setText("");
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null, "Operation Cancelled");
	            setVisible(false);
			}
		});
		
		add(l1);
		add(l4);
		add(l2);
		add(n1);
		add(l3);
		add(n2);
		add(b1);
		add(b2);
		
		setLayout(new GridLayout(4,2));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}

