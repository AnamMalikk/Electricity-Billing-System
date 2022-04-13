package Customer.feedbck;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

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

public class button extends JFrame
{
	JLabel l1,l3,l2;
	JButton b1, b2;
	JTextArea t1;
	JPanel p;
	String id,name="";
	public button(String i)
	{
		id=i;
		setLocationRelativeTo(null);
		setBackground(Color.black);
	    setLayout(new BorderLayout());
		l1=new JLabel("Please Enter Feedback:");
		l1.setFont(new Font("HP Simplified Light",Font.BOLD,20));
		b1=new JButton("Submit");
		b1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b1.revalidate();
		b2=new JButton("Cancel");
		b2.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b2.revalidate();
		p=new JPanel(new GridLayout(1,2));
		t1=new JTextArea(5,18);
		//l1.setBounds(0, 0, 10, 10);
		add(l1,"North");
		//t1.setBounds(10,0,5,5);
        add(t1,"Center");
        //b1.setBounds(20,0,5,5);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				try {
	            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				try{
		            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
		            System.out.println("Connected");
		            String query="SELECT * FROM Details WHERE ID= '"+id+"'";
		            Statement preparedStatement=connection.createStatement();
		            ResultSet resultSet=preparedStatement.executeQuery(query);
		            while(resultSet.next()){
		            	name=resultSet.getString("CustomerName");
		            }
		           	connection.close();
		           	preparedStatement.close();
		           	resultSet.close();
				}
				catch(Exception e){
		            System.out.println(e);

				}
				final String un,pw;
		  		un="ebilljavaproject";
		  		pw="cl0ud@tlas";
		  		String fmail="ebilljavaproject@gmail.com";
		  		
		  		Properties p=new Properties();
		  		p.put("mail.smtp.auth", "true");
		  		p.put("mail.smtp.starttls.enable", "true");
		  		p.put("mail.smtp.host", "smtp.gmail.com");
		  		p.put("mail.smtp.port","587" );
		  	   Session s= Session.getInstance(p, new javax.mail.Authenticator() {
		  		   protected PasswordAuthentication getPasswordAuthentication() {
		  			   return new PasswordAuthentication(un,pw);
		  		   }
		  	   });
		  	   
		  	   MimeMessage msg=new MimeMessage(s);
		  	   try {
		  		   msg.setFrom(new InternetAddress(fmail));
		  		   msg.addRecipient(Message.RecipientType.TO, new InternetAddress("ebillfbackmail@gmail.com"));
		  		   msg.setSubject("Feedback By UserID "+id);
		  		   msg.setText("Feedback: "+t1.getText()+"\nSubmitted by "+name);
		  		   
		  		   Transport.send(msg);
		  		   System.out.println("SENT SUCCESSFULLY");
		  			JOptionPane.showMessageDialog(getContentPane(), "Feedback Received. Thank you for your valued input!");
		  			setVisible(false);
		  	   }catch(Exception e) {
		  		   System.out.println("UNSUCCESSFUL");
		  	   }} finally {
		           setCursor(Cursor.getDefaultCursor());
		       }
			}
		});
		p.add(b1);
		p.add(b2);
		add(p,"South");
		setSize(800,500);
		setVisible(true);
		setTitle("Feedback");
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(699,399);
        setSize(700,400);
	}
	
}
