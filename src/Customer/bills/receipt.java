package Customer.bills;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.awt.*;
import javax.swing.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import java.sql.*;
import java.util.Properties;

public class receipt {
	String id,month,year;
receipt(String ID, String mt, String y)
{
	id=ID;
	month=mt;
	year=y;
	try {
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
    System.out.println("Connected");
    String tmail=""; 
    String query="Select * FROM Details WHERE ID='"+id+"'";
    Statement preparedStatement=connection.createStatement();
    ResultSet resultSet=preparedStatement.executeQuery(query);
    System.out.println("query done");
		Document document = new Document();
		ByteArrayOutputStream bpt=new ByteArrayOutputStream();
	    PdfWriter.getInstance(document,bpt);
	     
	    document.open();
	     
	    document.addTitle("Electricity Bill "+month+", "+year);
	    document.addAuthor("Electricity Billing Project");
	    document.addCreator("Electricity Billing Project");
	     
	    Paragraph paragraph = new Paragraph();
	   paragraph.add("\tELECTRICITY BILL FOR THE MONTH OF "+month+", "+year+" \n\n\n");	
		if(resultSet.next()) {
	    	tmail=resultSet.getString("Email");
			paragraph.add("\n    Customer Name:"+resultSet.getString("CustomerName"));
			paragraph.add("\n    Meter Number:  "+resultSet.getString("Meter"));
			paragraph.add("\n    Sanctioned Load:  "+resultSet.getString("SanctionedLoad")+" kW");
			paragraph.add("\n    Address:            "+resultSet.getString("Address"));
			paragraph.add("\n    State:                 "+resultSet.getString("State"));
			paragraph.add("\n    District:                "+resultSet.getString("City"));
			paragraph.add("\n    Email:                "+resultSet.getString("Email"));
			paragraph.add("\n    Phone Number:   "+resultSet.getString("Phone"));
			paragraph.add("\n------------------------------------------------------");
			paragraph.add("\n");
		}

        
        String query1="select * from Bill where ID='"+id+"' AND _year='"+year+"' AND _month='"+month+"'";
        Statement preparedStatement1=connection.createStatement();
        ResultSet rs1=preparedStatement1.executeQuery(query1);
		System.out.println("QUERY EXECUTED 2");
		
		if(rs1.next()) {
			paragraph.add("\n\n");
			paragraph.add("\n    Units Consumed:"+rs1.getString("Units"));
			paragraph.add("\n    Fixed Charge:"+rs1.getString("Fixed_Charge"));
			paragraph.add("\n    Energy Charge:"+rs1.getString("Energy_Charge"));
			paragraph.add("\n    Electricity Duty (@5%):"+rs1.getString("EDuty"));
			paragraph.add("\n    Electricity Surcharge (@8%):"+rs1.getString("Surcharges"));
			paragraph.add("\n    Amount:"+rs1.getString("Amount_"));
			paragraph.add("\n    Status:"+rs1.getString("Status"));
			paragraph.add("\n------------------------------------------------------");
			paragraph.add("\n");
			paragraph.add("\n    TOTAL PAYABLE AMOUNT:"+rs1.getString("Amount_"));
			paragraph.add("\n");
			paragraph.add("\n------------------------------------------------------");

		}
		System.out.println("SUCCESSFULLY ACCESSED DATABASE");
	     
		document.add(paragraph);
	    document.close();
	    

	    byte[] bytes=bpt.toByteArray();
        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
        MimeBodyPart pdfBodyPart = new MimeBodyPart();
        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
        pdfBodyPart.setFileName("electricityBill.pdf");
        
        
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
	   msg.setFrom(new InternetAddress(fmail));
	   msg.addRecipient(Message.RecipientType.TO, new InternetAddress(tmail));
	   msg.setSubject("Your Electricity Bill");
	   
	   Multipart econt=new MimeMultipart();
	   MimeBodyPart tb=new MimeBodyPart();
	   tb.setText("Hello! \nPlease find the attached bill. \nThank you, \nElectricity Billing Java Project");
	   
	   
	   econt.addBodyPart(tb);
	   econt.addBodyPart(pdfBodyPart);

	   msg.setContent(econt);
	   
	   Transport.send(msg);
	   System.out.println("SENT SUCCESSFULLY");
	   

	   resultSet.close();
	   rs1.close();
	   preparedStatement.close();
	   preparedStatement1.close();
	   connection.close();
	}catch(Exception e) {
	   System.out.println("UNSUCCESSFUL");}}}

