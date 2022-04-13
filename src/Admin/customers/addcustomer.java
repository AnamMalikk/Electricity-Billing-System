package Admin.customers;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class addcustomer extends JFrame {
	JLabel l1,l2,l3,l4,l5,l6,l7,l10,l13,l14,l15,l16, l17,l18,l19,l20;
	JTextField t1,t2,t3,t4,t5,t7,t8,t9,t14,t15,t16,t17,t18,t19;
	JButton b1,b2,b3,b4,b5,b6,b9,b10;
	Choice mth,yr,ch;
	JPanel p1,p2,p3,p4,mainpane;
	CardLayout c=new CardLayout();
	
	public addcustomer()
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
		
		l13 = new JLabel("   Sanctioned Load (kW)");
		l13.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l13.setForeground(Color.white);
		
		l14 = new JLabel("   Month");
		l14.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l14.setForeground(Color.white);
		
		l15 = new JLabel("   Year");
		l15.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l15.setForeground(Color.white);
		
		
		l16 = new JLabel("   Billed Units");
		l16.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l16.setForeground(Color.white);
		
		l17 = new JLabel("   Status");
		l17.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l17.setForeground(Color.white);
		
		l18 = new JLabel("   Billing Cycle Concluded");
		l18.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l18.setForeground(Color.white);

		l19 = new JLabel("--------CREATE", JLabel.RIGHT);
		l19.setFont(new Font("HP Simplified Light", Font.BOLD, 17));
		l19.setForeground(Color.white);

		l20 = new JLabel("  NEW BILL--------",JLabel.LEFT);
		l20.setFont(new Font("HP Simplified Light", Font.BOLD, 17));
		l20.setForeground(Color.white);
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t7=new JTextField(20);
		t8=new JTextField(20);
		t9=new JTextField(20);
		t14=new JTextField(20);
		t15=new JTextField(20);
		t16=new JTextField(20);
		t17=new JTextField(20);
		t18=new JTextField(20);
		t19=new JTextField(20);

		t5.setText("Delhi");
		t5.setEnabled(false);
		
		LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        Date dt=new Date();
        LocalDate localDate = dt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
	      
	    t15.setText(Month.of(month).name());
	    t16.setText(Integer.toString(currentYear));
		t17.setText(Integer.toString(0));
		t18.setText("Not Paid");
		t19.setText("No");

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
        
		b9=new JButton("Next");
		b9.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b9.revalidate();
		b10=new JButton("Go back");
		b10.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b10.revalidate();
        
		b5=new JButton("Create");
		b5.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b5.revalidate();
		b6=new JButton("Go back");
		b6.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b6.revalidate();
        
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
        

        
        b4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		c.show(mainpane, "panel1");
        	}
        });
        
        b6.addActionListener(new ActionListener() {
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

        b9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
				c.show(mainpane, "panel4");
        	}
        });

        b10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
				c.show(mainpane, "panel2");
        	}
        });
        
        b5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae)
        	{
        		String un,pw;
        	    Random rand = new Random();
            	String path;
                int r = rand.nextInt(45678);
        		un=t1.getText()+r;
                int r1 = rand.nextInt(45678);
        		pw=r+"pwrd";
        		 try {
 		            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        		try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
		            System.out.println("Connected Successfully");
		            String sql = "INSERT INTO Details(Meter, CustomerName, Username, Password, Guardian, RegistrationDate, State, City, Address, Email, Phone, SanctionedLoad) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

		            PreparedStatement pstmt = (PreparedStatement)connection.prepareStatement(sql);
		            pstmt.setString(1, t2.getText());
		            pstmt.setString(2, t1.getText());
		            pstmt.setString(3, un);
		            pstmt.setString(4, pw);
		            pstmt.setString(5, t3.getText());
		    	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    	    Date date = new Date();  
		    	    String d=formatter.format(date);
		    	    pstmt.setString(6, d);
		            pstmt.setString(7, t5.getText());
		            pstmt.setString(8, ch.getSelectedItem());
		            pstmt.setString(9, t4.getText());
		            pstmt.setString(10, t7.getText());
		            pstmt.setString(11, t8.getText());
		            pstmt.setInt(12,Integer.parseInt(t14.getText()));
		            pstmt.executeUpdate();
		            
		            String qq="SELECT * FROM Details WHERE Username='"+un+"' AND Password='"+pw+"'";
		            Statement prepst=connection.createStatement();
		            ResultSet rest=prepst.executeQuery(qq);
		            String user_id="";
		            while(rest.next()) {
		            	user_id=rest.getString("ID");
		            }
		            
		            
		            String sql1 = "INSERT INTO Bill(ID,_month, _year, Units, Meter, Status, Payable, SanctionedLoad) VALUES (?,?,?,?,?,?,?,?)";

		            PreparedStatement pstmt1 = (PreparedStatement)connection.prepareStatement(sql1);
		            pstmt1.setString(1, user_id);
		            pstmt1.setString(2, t15.getText());
		            pstmt1.setString(3, t16.getText());
		            pstmt1.setInt(4, Integer.parseInt(t17.getText()));
		            pstmt1.setString(5, t2.getText());
		            pstmt1.setString(6, t18.getText());
		            pstmt1.setString(7, t19.getText());
		            pstmt1.setInt(8, Integer.parseInt(t14.getText()));

		            pstmt1.executeUpdate();
		            System.out.println("Successful");
		            
		            pstmt.close();  
		            pstmt1.close();
		            prepst.close();
		            rest.close();
		            System.out.println("NEW RECORD CREATED");
		            final String un1,pw1;
		      		un1="ebilljavaproject";
		      		pw1="cl0ud@tlas";
		      		String fmail="ebilljavaproject@gmail.com";
		      		String tmail=t7.getText();
		      		
		      		Properties p=new Properties();
		      		p.put("mail.smtp.auth", "true");
		      		p.put("mail.smtp.starttls.enable", "true");
		      		p.put("mail.smtp.host", "smtp.gmail.com");
		      		p.put("mail.smtp.port","587" );
		      	   Session s= Session.getInstance(p, new javax.mail.Authenticator() {
		      		   protected PasswordAuthentication getPasswordAuthentication() {
		      			   return new PasswordAuthentication(un1,pw1);
		      		   }
		      	   });
		      	   
		      	   MimeMessage msg=new MimeMessage(s);
		      	   try {
		      		   msg.setFrom(new InternetAddress(fmail));
		      		   msg.addRecipient(Message.RecipientType.TO, new InternetAddress(tmail));
		      		   msg.setSubject("Your Electricity Bill");
		      		   msg.setText("Hello, "+t1.getText()+" ! \n\nYou have been registered as a new user by admin. Here are your account details: \n\nUsername: "+un+"\nPassword: "+pw+"\n\nThank you for using Electricity Billing Application! We look forward to your continued support! \n\nSent by Customer Service \n(NO REPLY)");		      		   
		      		   Transport.send(msg);
		      		   System.out.println("SENT SUCCESSFULLY");
		      	   }catch(Exception e){
			            System.out.println("Error in connection");

			        }
		            JOptionPane.showMessageDialog(null, "New Customer Account Created");
		            setVisible(false);
		        }catch(Exception e){
		            System.out.println("Error in connection");

		        }} finally {
		               setCursor(Cursor.getDefaultCursor());
		           }

        	}
        });
        
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t3);
        p1.add(b1);
        p1.add(b2);
        p1.setLayout(new GridLayout(3,2));
        
        p2.add(l3);
        p2.add(t4);
        p2.add(l4);
        p2.add(t5);
        p2.add(l5);
        p2.add(ch);
        p2.add(b3);
        p2.add(b4);
        p2.setLayout(new GridLayout(4,2));
        
        p4.add(l10);
        p4.add(t2);
        p4.add(l13);
        p4.add(t14);
        p4.add(l19);
        p4.add(l20);
        p4.add(l14);
        p4.add(t15);
        p4.add(l15);
        p4.add(t16);
        p4.add(l16);
        p4.add(t17);
        p4.add(l17);
        p4.add(t18);
        p4.add(l18);
        p4.add(t19);
        p4.add(b5);
        p4.add(b6);
        p4.setLayout(new GridLayout(9,2));
        
        p3.add(l6);
        p3.add(t7);
        p3.add(l7);
        p3.add(t8);
        p3.add(b9);
        p3.add(b10);
        p3.setLayout(new GridLayout(3,2));
        
        mainpane.setLayout(c);
        
        mainpane.add(p1, "panel1");
        mainpane.add(p2, "panel2");
        mainpane.add(p3, "panel3");
        mainpane.add(p4,"panel4");

        this.setContentPane(mainpane);
        c.show(mainpane, "panel1");
		setTitle("Signup");
		setLocationRelativeTo(null);
		setVisible(true);}}
