package Customer.user;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class confirm extends JFrame {
   
	JPasswordField f1;
	JButton b1, b2;
	JLabel l1;
	int flag;
	String id, pw;
	public confirm(int f, String i)
	{
		setSize(400,100);
		flag=f;
		id=i;
		getContentPane().setBackground(Color.black);
		
		l1=new JLabel("Enter Password To Proceed : ");
		l1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
		l1.setForeground(Color.white);
		
		b1=new JButton("Confirm");
		 b1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
         b1.revalidate();
		b2=new JButton("Cancel");
		 b2.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
         b2.revalidate();
		f1=new JPasswordField(20);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
	               

		            String query="SELECT * FROM Details WHERE ID = '"+id+"'";
		            Statement preparedStatement=connection.createStatement();
		            ResultSet resultSet=preparedStatement.executeQuery(query);
	         

		            while(resultSet.next()){
		            	 pw=resultSet.getString("Password");
		                }


		            connection.close();
		            preparedStatement.close();
		            resultSet.close();
				    }catch(Exception e){
		                System.out.println("Error in connection");

		            }
				if(new String(f1.getPassword()).equals(pw))
				{
					setVisible(false);
					switch(flag)
					{
					case 1: new modify(id);
					break;
					case 2: new userid(id);
					break;
					case 3: new passwrd(id);
					break;
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Password");
		            f1.setText("");
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
		add(f1);
		add(b1);
		add(b2);
		
		setLayout(new GridLayout(2,2));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}

