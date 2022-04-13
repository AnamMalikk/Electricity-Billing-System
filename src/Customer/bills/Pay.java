package Customer.bills;

import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.awt.event.*;
import javax.swing.*;

import run.login;

import java.util.Date;

public class Pay extends JFrame implements ActionListener {
JLabel l2,l3,l4,l5,l6,l7,l8;
JLabel m,n,u,b,s,mth,yr;
Choice c1,c2;
JButton b1,b2;
JPanel p;
String id,payable;
public Pay(String i)  {
	id=i;
	payable="Yes";

    LocalDate currentdate = LocalDate.now();
    int currentYear = currentdate.getYear();
    Date date=new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int month = localDate.getMonthValue();
    
    mth= new JLabel(Month.of(month).name());
    mth.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
    
    yr= new JLabel(Integer.toString(currentYear));
    yr.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
    
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
        System.out.println("Connected");

        String query="Select * FROM Bill WHERE ID='"+id+"' AND _year='"+Integer.parseInt(yr.getText())+"' AND _month='"+mth.getText()+"'";
        Statement preparedStatement=connection.createStatement();
        ResultSet resultSet=preparedStatement.executeQuery(query);
        System.out.println("query done");
	    m=new JLabel("");	    
	    u=new JLabel("");
	    b=new JLabel("");	    
	    s=new JLabel("");
        while(resultSet.next()){
        	 m.setText(resultSet.getString("Meter"));
        	    m.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                
             u.setText(Integer.toString(resultSet.getInt("Units")));
                u.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
               
             b.setText(Integer.toString(resultSet.getInt("Amount_")));
                b.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                
             s.setText(resultSet.getString("Status"));
                s.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
                
             payable=resultSet.getString("Payable");
        }
        System.out.println("Successful");
        String query1="SELECT * FROM Details WHERE ID= '"+id+"'";
        Statement preparedStatement1=connection.createStatement();
        ResultSet resultSet1=preparedStatement1.executeQuery(query1);
        while(resultSet1.next()) {
        n= new JLabel(resultSet1.getString("CustomerName"));
    	    n.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
        }
        System.out.println("query done");
        

 	   resultSet.close();
 	   resultSet1.close();
 	   preparedStatement.close();
 	   preparedStatement1.close();
 	   connection.close();
 	   
	setTitle("Pay Bill");

	setBackground(Color.white);

	
	l2=new JLabel("Meter Number");
	l2.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
	l3=new JLabel("Name");
	l3.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
	l4=new JLabel("Month");
	l4.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
	l5=new JLabel("Units");
	l5.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
	l6=new JLabel("Total Bill");
	l6.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
	l7=new JLabel("Status");
	l7.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
	l8=new JLabel("Year");
	l8.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
				
	
	
	
	b1=new JButton("Pay");
	b2=new JButton("Back");
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	b1.setBackground(Color.BLACK);
	b1.setForeground(Color.WHITE);
	
	b2.setBackground(Color.BLACK);
	b2.setForeground(Color.WHITE);
	p=new JPanel(new GridLayout(8,2));

	p.add(l2);
	System.out.println("1");
	
	p.add(m);
	System.out.println("2");
	p.add(l3);
	System.out.println("3");
	p.add(n);
	System.out.println("1");
	p.add(l4);
	System.out.println("1");

	p.add(mth);
	System.out.println("1");

	p.add(l8);
	System.out.println("1");

	p.add(yr);
	System.out.println("1");

	p.add(l5);
	System.out.println("1");

	p.add(u);
	System.out.println("1");

	p.add(l6);
	System.out.println("1");

	p.add(b);
	System.out.println("1");

	p.add(l7);
	System.out.println("1");

	p.add(s);
	System.out.println("1");

	p.add(b1);
	System.out.println("1");

	p.add(b2);
	System.out.println("1");


	add(p);
	System.out.println("1");

	setSize(650,500);
	setLocationRelativeTo(null);
	setVisible(true);
	}catch(Exception e) {System.out.println(e);}
	
}

	public void actionPerformed(ActionEvent ae)
	{
		String s1=ae.getActionCommand();
		if(s1.equals("Back"))
			setVisible(false);
		else if(s1.equals("Pay")&&s.getText().equals("Not Paid")&&payable.equals("Yes"))
			{
			new bank(id,mth.getText(),yr.getText());
			setVisible(false);
			}
		else if(s.getText().equals("Paid"))
		{
			JOptionPane.showMessageDialog(null, "Bill For This Month is Already Paid");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Current Billing Cycle Ongoing");
		}
	
	}
}
