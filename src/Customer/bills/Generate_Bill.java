package Customer.bills;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;

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

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

public class Generate_Bill extends JFrame implements ActionListener {
	JLabel l1;
	JTextArea t1;
	JButton b1,b2, b3;
	Choice c1,c2;
	JPanel p1,p2;
	String id, filepath;
	public Generate_Bill(String i){
		setSize(500,700);
		id=i;
		setLayout(new BorderLayout());
		
		p1=new JPanel();
		p2=new JPanel();
		
		l1=new JLabel("Generate Bill");
		c2=new Choice();
		c1=new Choice();
		
		LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        
        for(int i1=1; i1<=12; i1++)
        {
        	c2.add(Month.of(i1).name());
        }
        for(int i2=2020; i2<=currentYear; i2++)
        {
        	c1.add(Integer.toString(i2));
        }
		
		
        
		t1=new JTextArea(40,15);
		JScrollPane jsp=new JScrollPane(t1);
		t1.setFont(new Font("Senserif",Font.ITALIC,18));
		
		b1=new JButton("Generate Bill");
		b2=new JButton("Print Bill");
		b3=new JButton("Pay Bill");
		
		b2.setEnabled(false);
		b3.setEnabled(false);
		
		p1.add(l1);
		p1.add(c2);
		p1.add(c1);
		add(p1,"North");
		
		add(jsp,"Center");
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.setLayout(new FlowLayout());
		add(p2,"South");
		b1.addActionListener(this);	
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
			        System.out.println("Connected");

			        String query="Select * FROM Bill WHERE ID='"+id+"' AND _year='"+c1.getSelectedItem()+"' AND _month='"+c2.getSelectedItem()+"'";
			        Statement preparedStatement=connection.createStatement();
			        ResultSet resultSet=preparedStatement.executeQuery(query);
			        System.out.println("query done");

			        String status="";
			        while(resultSet.next()){
			             status=resultSet.getString("Status");
			        }
			        System.out.println("Successful");
				
				
				if(status.equals("Not Paid"))
			{
			new bank(id,c2.getSelectedItem(),c1.getSelectedItem());
			}
				else
				{
					JOptionPane.showMessageDialog(null, "Bill For This Month is Already Paid");

				}

				   resultSet.close();
				   preparedStatement.close();
				   connection.close();
				}catch(Exception e)
				{
					System.out.println("UNSUCCESSFUL");
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				JFileChooser fc=new JFileChooser();    
			    int i=fc.showOpenDialog(getContentPane());    
			    if(i==JFileChooser.APPROVE_OPTION){    
			        File f=fc.getSelectedFile();    
			        filepath=f.getPath();   
			        System.out.println(filepath);
			        try {
						Document doc= new Document();
						PdfWriter.getInstance(doc, new FileOutputStream(filepath));
						doc.open();
						doc.add(new Paragraph(t1.getText()));
						doc.close();
					
					}catch(Exception e) {
						System.out.println("Unsuccessful");
					}
			        int a=JOptionPane.showConfirmDialog(getContentPane(),"Would you like to send bill via e-mail?");  
			        if(a==JOptionPane.YES_OPTION) {

			        	  String tmail=JOptionPane.showInputDialog(getContentPane(),"Enter recepient e-mail address:");  
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
			      		   msg.addRecipient(Message.RecipientType.TO, new InternetAddress(tmail));
			      		   msg.setSubject("Your Electricity Bill");
			      		   
			      		   Multipart econt=new MimeMultipart();
			      		   MimeBodyPart tb=new MimeBodyPart();
			      		   tb.setText("Hello! \nPlease find the attached bill. \nThank you, \nElectricity Billing Java Project");
			      		   
			      		   MimeBodyPart pdf=new MimeBodyPart();
			      		   pdf.attachFile(filepath);
			      		   
			      		   econt.addBodyPart(tb);
			      		   econt.addBodyPart(pdf);

			      		   msg.setContent(econt);
			      		   
			      		   Transport.send(msg);
			      		   System.out.println("SENT SUCCESSFULLY");
			      		 JOptionPane.showMessageDialog(getContentPane(),"Bill Printed Successfully");
			      	   }catch(Exception e) {
			      		   System.out.println("UNSUCCESSFUL");
			      	   }
			        }
			}
			}
		});
		
		
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		try {
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
	            System.out.println("CONNECTION ESTABLISHED");
	            String month=c2.getSelectedItem();
	            String year=c1.getSelectedItem();
	            

	            String sql="select * from Bill where ID='"+id+"' AND _year='"+year+"' AND _month='"+month+"'";
	            Statement ps=connection.createStatement();
	            ResultSet resset=ps.executeQuery(sql);
				System.out.println("QUERY EXECUTED 2");
	            
				if(resset.next())
				{
	            
	            String query="select * from Details where ID='"+id+"'";
	            Statement preparedStatement=connection.createStatement();
	            ResultSet rs=preparedStatement.executeQuery(query);
	            System.out.println("QUERY EXECUTED");
				
			t1.setText("\tELECTRICITY BILL FOR THE MONTH OF "+month+", "+year+" \n\n\n");	
			if(rs.next()) {
				t1.append("\n    Customer Name:"+rs.getString("CustomerName"));
				t1.append("\n    Meter Number:  "+rs.getString("Meter"));
				t1.append("\n    Sanctioned Load:  "+rs.getString("SanctionedLoad")+" kW");
				t1.append("\n    Address:            "+rs.getString("Address"));
				t1.append("\n    State:                 "+rs.getString("State"));
				t1.append("\n    District:                "+rs.getString("City"));
				t1.append("\n    Email:                "+rs.getString("Email"));
				t1.append("\n    Phone Number:   "+rs.getString("Phone"));
				t1.append("\n------------------------------------------------------");
				t1.append("\n");
			}

            
            String query1="select * from Bill where ID='"+id+"' AND _year='"+year+"' AND _month='"+month+"'";
            Statement preparedStatement1=connection.createStatement();
            ResultSet rs1=preparedStatement1.executeQuery(query1);
			System.out.println("QUERY EXECUTED 3");
			if(rs1.next()) {
				t1.append("\n    Units Consumed:"+rs1.getString("Units"));
				t1.append("\n    Fixed Charge:"+rs1.getString("Fixed_Charge"));
				t1.append("\n    Energy Charge:"+rs1.getString("Energy_Charge"));
				t1.append("\n    Electricity Duty (@5%):"+rs1.getString("EDuty"));
				t1.append("\n    Electricity Surcharge (@8%):"+rs1.getString("Surcharges"));
				t1.append("\n    Amount:"+rs1.getString("Amount_"));
				t1.append("\n    Status:"+rs1.getString("Status"));
				t1.append("\n------------------------------------------------------");
				t1.append("\n");
				t1.append("\n------------------------------------------------------");
				t1.append("\n");
				t1.append("\n    TOTAL PAYABLE AMOUNT:"+rs1.getString("Amount_"));


				t1.append("\n");
			}
			System.out.println("SUCCESSFULLY ACCESSED DATABASE");
			b2.setEnabled(true);
			b3.setEnabled(true);

			   rs.close();
			   rs1.close();
			   preparedStatement.close();
			   preparedStatement1.close();
				}
				else
				{
		      		 JOptionPane.showMessageDialog(getContentPane(),"No Billing History For This Period");
				}

				   resset.close();
				   ps.close();
				   connection.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}}
