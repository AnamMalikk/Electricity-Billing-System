package Customer.user;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

class modify extends JFrame{
	JLabel l1, l2, l4, l5, l6, l7, l8, l9;
	JTextField n, c, s, gn, ad, em, ph, sl;
	JButton sub, can;
	Choice ch;
	String id;
	modify(String i)
	{
		setSize(600,400);
		id=i;
		setTitle("Modify Customer Details");
		getContentPane().setBackground(Color.black);
		l1 = new JLabel("   Name");
		l1.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l1.setForeground(Color.white);
		
		l2 = new JLabel("   Guardian's Name");
		l2.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l2.setForeground(Color.white);

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
		
		l9 = new JLabel("   Sanctioned Load");
		l9.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l9.setForeground(Color.white);
		
		n=new JTextField(20);

		s=new JTextField(20);
		gn=new JTextField(20);
		ad=new JTextField(20);
		em=new JTextField(20);
		ph=new JTextField(20);
		sl=new JTextField(20);


		ch=new Choice();
		
		ch.add("East Delhi");
		ch.add("New Delhi");
		ch.add("Central Delhi");
		ch.add("North Delhi");
		ch.add("West Delhi");
		ch.add("South Delhi");
		ch.add("South East Delhi");
		ch.add("North East Delhi");
		ch.add("South West Delhi");
		ch.add("North West Delhi");
		ch.add("Shahadara");
		
		sub=new JButton("Submit");
		sub.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        sub.revalidate();
		can=new JButton("Cancel");
		can.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        can.revalidate();
		try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
            System.out.println("YES");
            String query="SELECT * FROM Details WHERE ID= '"+id+"'";
            Statement preparedStatement=connection.createStatement();
            ResultSet resultSet=preparedStatement.executeQuery(query);
            while(resultSet.next()){
           	n.setText(resultSet.getString("CustomerName"));
           	gn.setText(resultSet.getString("Guardian"));
           	s.setText(resultSet.getString("State"));
           	s.setEnabled(false);
           	ad.setText(resultSet.getString("Address"));
           	em.setText(resultSet.getString("Email"));
           	ph.setText(resultSet.getString("Phone"));
           	sl.setText(resultSet.getString("SanctionedLoad"));

           	connection.close();
           	preparedStatement.close();
           	resultSet.close();
            }
		}
		catch(Exception e){
            System.out.print(e.toString());

		}
		
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
		                    rs.updateString("City", ch.getSelectedItem());  
		                    rs.updateString("Address", ad.getText());  
		                    rs.updateString("Email", em.getText());  
		                    rs.updateString("Phone", ph.getText());  
		                    rs.updateInt("SanctionedLoad", Integer.parseInt(sl.getText()));  

		                    rs.updateRow();
		                 }                                  
		            System.out.println("UPDATED");

		            st.close(); 
		            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
		            setVisible(false);
		           	connection.close();
		           	rs.close();
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
		
		add(l1);
		add(n);
		add(l9);
		add(sl);
		add(l2);
		add(gn);
		add(l4);
		add(s);
		add(l5);
		add(ch);
		add(l6);
		add(ad);
		add(l7);
		add(em);
		add(l8);
		add(ph);
		
		add(sub);
		add(can);
		
		setLayout(new GridLayout(9,2));
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
}

