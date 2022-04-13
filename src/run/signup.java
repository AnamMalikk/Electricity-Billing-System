package run;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class signup extends JFrame{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t14;
	JPasswordField t12,t13;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	Choice ch;
	JPanel p1,p2,p3,p4,p5,mainpane;
	CardLayout c=new CardLayout();
	
	signup()
	{
		setSize(400,400);
		p1=new JPanel();
		p1.setBackground(Color.black);
		p2=new JPanel();
		p2.setBackground(Color.black);
		p3=new JPanel();
		p3.setBackground(Color.black);
		p4=new JPanel();
		p4.setBackground(Color.black);
		p5=new JPanel();
		p5.setBackground(Color.black);
		mainpane=new JPanel();
		l1 = new JLabel("  Name");
		l1.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l1.setForeground(Color.white);
		
		l10 = new JLabel("  Meter Number");
		l10.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l10.setForeground(Color.white);
		
		l2 = new JLabel("   Guardian's Name");
		l2.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l2.setForeground(Color.white);

		l3 = new JLabel("   Address");
		l3.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l3.setForeground(Color.white);

		l4 = new JLabel("   State");
		l4.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l4.setForeground(Color.white);

		l5 = new JLabel("   District");
		l5.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l5.setForeground(Color.white);

		l6 = new JLabel("   Email");
		l6.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l6.setForeground(Color.white);

		l7 = new JLabel("   Phone");
		l7.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l7.setForeground(Color.white);

		l8 = new JLabel("   Username");
		l8.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l8.setForeground(Color.white);
		
		l9 = new JLabel("   Password");
		l9.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l9.setForeground(Color.white);
		
		l11 = new JLabel("   Confirm Username");
		l11.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l11.setForeground(Color.white);
		
		l12 = new JLabel("   Confirm Password");
		l12.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l12.setForeground(Color.white);
		
		l13 = new JLabel("   Sanctioned Load (kW)");
		l13.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l13.setForeground(Color.white);
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t7=new JTextField(20);
		t8=new JTextField(20);
		t9=new JTextField(20);
		t10=new JTextField(20);
		t11=new JTextField(20);
		t12=new JPasswordField(20);
		t13=new JPasswordField(20);
		t14=new JTextField(20);
		
		t5.setText("Delhi");
		t5.setEnabled(false);
		
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


		b1=new JButton("Next");
		b1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b1.revalidate();
		b2=new JButton("Cancel");
		b2.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b2.revalidate();
        
		b3=new JButton("Next");
		b3.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b3.revalidate();
		b4=new JButton("Go back");
		b4.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b4.revalidate();
        
		
		b5=new JButton("Next");
		b5.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b5.revalidate();
		b6=new JButton("Go back");
		b6.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b6.revalidate();
        
		b7=new JButton("Finish");
		b7.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b7.revalidate();
		b8=new JButton("Go back");
		b8.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b8.revalidate();
        
        b1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		c.show(mainpane, "panel2");
        	}
        });

        b3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		c.show(mainpane, "panel3");
        	}
        });
        
        b5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		c.show(mainpane, "panel4");
        	}
        });
        
        b4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		c.show(mainpane, "panel1");
        	}
        });
        
        b6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		c.show(mainpane, "panel2");
        	}
        });
        
        b8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		c.show(mainpane, "panel3");
        	}
        });
        
        b2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
				JOptionPane.showMessageDialog(null, "Operation Cancelled");
        		setVisible(false);
        	}
        });
        
        b7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		String s1=new String(t12.getPassword());
        		String s2=new String(t13.getPassword());
        		if(t10.getText().equals(t11.getText()) && s1.equals(s2))
        		{
        			  try {
        		            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        		            try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
		            System.out.println("Connected Successfully");
		            String sql = "INSERT INTO Details(Meter, CustomerName, Guardian, RegistrationDate, City, Address, Email, Phone,Username,Password, SanctionedLoad, State) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		            PreparedStatement pstmt = (PreparedStatement)connection.prepareStatement(sql);
		            pstmt.setString(1, t2.getText());
		            pstmt.setString(2, t1.getText());
		            pstmt.setString(3, t3.getText());
		    	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    	    Date date = new Date();  
		    	    String d=formatter.format(date);
		    	    pstmt.setString(4, d);
		            pstmt.setString(5, ch.getSelectedItem());
		            pstmt.setString(6, t4.getText());
		            pstmt.setString(7, t7.getText());
		            pstmt.setString(8, t8.getText());
		            pstmt.setString(9, t11.getText());
		            String string = new String(t13.getPassword());
		            pstmt.setString(10, string);
		            pstmt.setInt(11,Integer.parseInt(t14.getText()));
		            pstmt.setString(12, "Delhi");
		            pstmt.executeUpdate();
		            
		            pstmt.close();
		            System.out.println("EXECUTED !1");
		            LocalDate currentdate = LocalDate.now();
		            int currentYear = currentdate.getYear();
		            Date dt=new Date();
		            LocalDate localDate = dt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		            int month = localDate.getMonthValue();
		            
		            String query="SELECT * FROM Details WHERE Username='"+t11.getText()+"' AND Password='"+string+"'";
		            Statement preparedStatement=connection.createStatement();
		            int my_id=0;
		            ResultSet resultSet=preparedStatement.executeQuery(query);
		            while(resultSet.next()){
		            	my_id=Integer.parseInt(resultSet.getString("ID"));
		            	System.out.println("ID");
		            }
		            String sql2 = "INSERT INTO Bill(ID,Meter, _year, _month, SanctionedLoad,Status,Payable) VALUES (?,?,?,?,?,?,?)";

		            PreparedStatement pstmt2 = (PreparedStatement)connection.prepareStatement(sql2);
		            pstmt2.setInt(1, my_id);
		            pstmt2.setString(2, t2.getText());
		            pstmt2.setString(3, Integer.toString(currentYear));
		            pstmt2.setString(4, Month.of(month).name());
		            pstmt2.setInt(5,Integer.parseInt(t14.getText()));
		            pstmt2.setString(6, "Not Paid");
		            pstmt2.setString(7, "No");

		            pstmt2.executeUpdate();
		            System.out.println("EXECUTED");
		            pstmt2.close();   
		            connection.close();
		            
		            final String un1,pw1;
		      		un1="ebilljavaproject";
		      		pw1="cl0ud@tlas";
		      		String fmail="ebilljavaproject@gmail.com";
		      		String tmail=t7.getText();
		      		
		      		Properties p=new Properties();
		      		p.put("mail.smtp.auth", "true");
		      		p.put("mail.smtp.ssl.enable", "true");
		      		p.put("mail.smtp.host", "smtp.gmail.com");
		      		p.put("mail.smtp.port","465" );
		      	   Session s= Session.getInstance(p, new javax.mail.Authenticator() {
		      		   protected PasswordAuthentication getPasswordAuthentication() {
		      			   return new PasswordAuthentication(un1,pw1);
		      		   }
		      	   });
		      	   System.out.println("CONNECTED TO MAIL");
		      	   MimeMessage msg=new MimeMessage(s);
		      		   msg.setFrom(new InternetAddress(fmail));
		      		   msg.addRecipient(Message.RecipientType.TO, new InternetAddress(tmail));
		      		   msg.setSubject("Your Electricity Bill");
		      		   msg.setText("Hello, "+t1.getText()+" ! \n\nYou have been registered as a new user on Electricity Billing Application. We welcome you to the community and hope your stay here is pleasant and convenient! \n\nThank you for using Electricity Billing Application! We look forward to your continued support! \n\nSent by Customer Service \n(NO REPLY)");		      		   
		      		   Transport.send(msg);
		      		   System.out.println("SENT SUCCESSFULLY");
		            System.out.println("NEW RECORD CREATED");


		            JOptionPane.showMessageDialog(null, "New Account Created");
		            setVisible(false);
		            new login();
		        }catch(java.lang.NumberFormatException ne)
        		            {
		            JOptionPane.showMessageDialog(null, "Enter Sanctioned Load Correctly");
        		            }
        		            
        		catch(Exception e){
		            System.out.println(e);
		            }

		        } finally {
		            setCursor(Cursor.getDefaultCursor());
		        }
        		}
        		else
        		{
		            JOptionPane.showMessageDialog(null, "Username or password do not match");
        		}
        	}
        });
        
        p1.add(l1);
        p1.add(t1);
        p1.add(l10);
        p1.add(t2);
        p1.add(l13);
        p1.add(t14);
        p1.add(l2);
        p1.add(t3);
        p1.add(b1);
        p1.add(b2);
        p1.setLayout(new GridLayout(5,2));
        
        p2.add(l3);
        p2.add(t4);
        p2.add(l4);
        p2.add(t5);
        p2.add(l5);
        p2.add(ch);
        p2.add(b3);
        p2.add(b4);
        p2.setLayout(new GridLayout(4,2));
        
  
       
        
        p3.add(l6);
        p3.add(t7);
        p3.add(l7);
        p3.add(t8);
        p3.add(b5);
        p3.add(b6);
        p3.setLayout(new GridLayout(3,2));
        
        p4.add(l8);
        p4.add(t10);
        p4.add(l11);
        p4.add(t11);
        p4.add(l9);
        p4.add(t12);
        p4.add(l12);
        p4.add(t13);
        p4.add(b7);
        p4.add(b8);
        p4.setLayout(new GridLayout(5,2));
        
        mainpane.setLayout(c);
        
        mainpane.add(p1, "panel1");
        mainpane.add(p2, "panel2");
        mainpane.add(p3, "panel3");
        mainpane.add(p4, "panel4");

        this.setContentPane(mainpane);
        c.show(mainpane, "panel1");
		setTitle("Signup");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

}

