package Customer.user;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class view extends JFrame{
	JLabel n, c, s, m, dor, gn, ad, em, ph,sl;
	JLabel l1, l2,l3, l4, l5, l6, l7, l8, l9,l10;
	String id;

	public view(String i)
	{ 
		setSize(400,600);
		id=i;
		setTitle("Customer Details");
		getContentPane().setBackground(Color.black);
		try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
            String query="SELECT * FROM Details WHERE ID= '"+id+"'";
            Statement preparedStatement=connection.createStatement();
            ResultSet resultSet=preparedStatement.executeQuery(query);
            while(resultSet.next()){
            	 m= new JLabel(resultSet.getString("Meter"));
            	    m.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    m.setForeground(Color.gray);
                 n= new JLabel(resultSet.getString("CustomerName"));
                    n.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    n.setForeground(Color.gray);
                 gn= new JLabel(resultSet.getString("Guardian"));
                    gn.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    gn.setForeground(Color.gray);
                 dor= new JLabel(resultSet.getString("RegistrationDate"));
                    dor.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    dor.setForeground(Color.gray);
                 s= new JLabel(resultSet.getString("State"));
                    s.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    s.setForeground(Color.gray);
                 c= new JLabel(resultSet.getString("City")); 
                    c.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    c.setForeground(Color.gray);
                 ad= new JLabel(resultSet.getString("Address")); 
                    ad.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    ad.setForeground(Color.gray);
                 em= new JLabel(resultSet.getString("Email")); 
                    em.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    em.setForeground(Color.gray);
                 ph= new JLabel(resultSet.getString("Phone")); 
                    ph.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    ph.setForeground(Color.gray);
                 sl= new JLabel(resultSet.getString("SanctionedLoad")); 
                    sl.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    sl.setForeground(Color.gray);
            }
            System.out.println("Successful");
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
                    
            l10=new JLabel("   Sanctioned Load");
                    l10.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                    l10.setForeground(Color.white);
            
            add(l1);
            add(n);
            add(l10);
            add(sl);
            add(l2);
            add(gn);
            add(l3);
            add(dor);
            add(l4);
            add(s);
            add(l5);
            add(c);
            add(l6);
            add(m);
            add(l7);
            add(ad);
            add(l8);
            add(em);
            add(l9);
            add(ph);
            setLayout(new GridLayout(10,2));
            setLocationRelativeTo(null);
    		setVisible(true);
           	connection.close();
           	preparedStatement.close();
           	resultSet.close();
        }catch(Exception e){
            System.out.println("Error in connection");

        }
}}

