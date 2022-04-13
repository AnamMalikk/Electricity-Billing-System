package Customer.bills;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

class bank extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JComboBox c1,c2;
	JTextField t1,t2;
	ImageIcon i1,i2,i3,i4;
	JButton b1,b2;
	int count=0;
	String id, mth,yr;
	JPasswordField p1,p2;
	bank(String i, String mth, String yr)
	{
		id=i;
		this.mth=mth;
		this.yr=yr;
		l1=new JLabel("Debit Card");
		l7=new JLabel("________");
		p1=new JPasswordField();
		p2=new JPasswordField();
		l2=new JLabel("Card Holder Number");
		l3=new JLabel("Expiry Date");
		l4=new JLabel("Card Holder Name");
		l5=new JLabel("CVV");
		l6=new JLabel("/");
		l8=new JLabel("Enter Captcha");
		l10=new JLabel("");
		i1=new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\cpt1.jpg");
		i2=new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\cpt2.jpg");
		i3=new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\cpt3.jpg");
		i4=new ImageIcon("C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\cpt4.jpg");
		l9=new JLabel(i1);
		t1=new JTextField(15);
		t2=new JTextField(15);
		b1=new JButton("Refresh");
		b2=new JButton("Submit");
		String mon[]= {"01","02","03","04","05","06","07","08","09","10","11","12"};
		String year[]= {"2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
		c1=new JComboBox(mon);
		c2=new JComboBox(year);
		setLayout(null);
		add(l1);
		l1.setBounds(10,10,100,20);
		add(l7);
		l7.setBounds(10,20,200,20 );
		add(l2);
		l2.setBounds(30,70,150, 20);
		add(p1);
		p1.setBounds(200, 70, 150,20 );
		add(l3);
		l3.setBounds(30,120, 100, 20);
		add(c1);
		c1.setBounds(200,120,50,20);
		add(l6);
		l6.setBounds(270, 120, 10,20);
		add(c2);
		c2.setBounds(300,120, 70, 20);
		add(l4);
		l4.setBounds(30, 170,150, 20);
		add(t1);
		t1.setBounds(200, 170, 150, 20);
		add(l5);
		l5.setBounds(30,220,150,20);
		add(p2);
		p2.setBounds(200, 220,150,20);
		add(l8);
		l8.setBounds(30,270,150,20);
		add(t2);
		t2.setBounds(200, 270,150,20);
		add(l9);
		l9.setBounds(390,270,250,100);
		add(b1);
		b1.setBounds(670, 270, 100, 30);
		add(l10);
		l10.setBounds(390,400 , 150, 20);
		add(b2);
		b2.setBounds(470,600,150,20);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(900,900);
		setTitle("Fill details");
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String msg=ae.getActionCommand();
		String msg1=t2.getText();
		if(msg.equals("Refresh"))
		{
			count++;
			if(count==1)
			{
				l9.setIcon(i2);
				
			}
			else if(count==2)
			{
				l9.setIcon(i3);
			}
			else if(count==3)
			{
				l9.setIcon(i4);
			}
			else
			{
				l9.setIcon(i1);
				count=0;
			}
		}
		if(msg.equals("Submit"))
		{
		if(msg1.equals("Td4eva") && count==0)
		{
			JOptionPane.showMessageDialog(null, "Submitted Successfully");
			setVisible(false);
			sub();
			
		}
		else if(msg1.equals("6138B") && count==1)
		{
			JOptionPane.showMessageDialog(null, "Submitted Successfully");
			setVisible(false);
			sub();
		}
		else if(msg1.equals("RET9MX") && count==2)
		{
			JOptionPane.showMessageDialog(null, "Submitted Successfully");
			setVisible(false);
			sub();
		}
		else if(msg1.equals("hfnhv") && count==3)
		{
			JOptionPane.showMessageDialog(null, "Submitted Successfully");
			setVisible(false);
			sub();
		}
		
		else
		{
			l10.setText("Enter again");
		}
		}
	}
	void sub()
	{
		try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
            System.out.println("Connected Successfully");
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "Select * FROM Bill WHERE ID='"+id+"' AND _year='"+yr+"' AND _month='"+mth+"'";

            ResultSet rs = st.executeQuery(sql);  
            System.out.println("QUERY DONE");

            if (rs != null) 
                while (rs.next()) 
                {
                    rs.updateString("Status", "Paid");  
                    rs.updateRow();
                    System.out.println("UPDATED");
                 }                                  
           

            st.close(); 
            rs.close();
      		new receipt(id,mth,yr);
      	   connection.close();
           setVisible(false);
      	   
        }catch(Exception e){
            System.out.println("Error in connection");

        }
		
	}
}
