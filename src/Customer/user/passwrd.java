package Customer.user;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

class passwrd extends JFrame{
	JLabel l2, l3;
	JPasswordField n1, n2;
	JButton b1, b2;
	String id;
	passwrd(String i)
	{
		setSize(400,150);
		setTitle("Change Password");
		getContentPane().setBackground(Color.black);
		id=i;
		
		l2=new JLabel("   New Password");
		l2.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l2.setForeground(Color.white);
		
		l3=new JLabel("   Confirm Password");
		l3.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l3.setForeground(Color.white);
		
		n1=new JPasswordField(20);
		n2=new JPasswordField(20);
		
		b1=new JButton("Confirm");
		b1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b1.revalidate();
		b2=new JButton("Cancel");
		b2.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b2.revalidate();
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				String n_1=new String(n1.getPassword());
				String n_2=new String(n2.getPassword());
				if(n_1.equals(n_2))
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
			                    rs.updateString("Password", n_2);			               
			                    rs.updateRow();
			                 }                                  
			            System.out.println("UPDATED");

			            st.close(); 
			           	connection.close();
			           	rs.close();
			            JOptionPane.showMessageDialog(null, "Password Updated Successfully");
			            setVisible(false);
			        }catch(Exception e){
			            System.out.println("Error in connection");

			        }
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Passwords Don't Match");
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
		
		add(l2);
		add(n1);
		add(l3);
		add(n2);
		add(b1);
		add(b2);
		
		setLayout(new GridLayout(3,2));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}

