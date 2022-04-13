package Admin.customers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class createbill extends JFrame {
Choice id, yr,mth;
JLabel l1,l2,l3,l4,l5,l6;
JTextField u,p,s;
JButton b1,b2,b3;
JPanel p1,p2;
String meter;
int sanctl;

public createbill()
{
	id=new Choice();
	p1=new JPanel();
	p2=new JPanel();
	
	try {
		  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
        String query="SELECT * FROM Details";
        Statement preparedStatement=connection.createStatement();
        ResultSet resultSet=preparedStatement.executeQuery(query);
        while(resultSet.next()){
        	id.add(resultSet.getString("ID"));
        }
        System.out.println("Successful");

 	   resultSet.close();
 	   preparedStatement.close();
 	   connection.close();

 	  LocalDate currentdate = LocalDate.now();
      int currentYear = currentdate.getYear();
      
      mth=new Choice();
      yr=new Choice();
      
      for(int i=1; i<=12;i++)
      {
    	  mth.add(Month.of(i).name());
      }
      
      for(int i=2020; i<=currentYear; i++)
      {
    	  yr.add(Integer.toString(i));
      }
      
		l1 = new JLabel("   ID");
		l1.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l1.setForeground(Color.white);

		l2 = new JLabel("   Year");
		l2.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l2.setForeground(Color.white);

		l3 = new JLabel("   Month");
		l3.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l3.setForeground(Color.white);

		l4 = new JLabel("   Billed Units");
		l4.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l4.setForeground(Color.white);

		l5 = new JLabel("   Payment Satus");
		l5.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l5.setForeground(Color.white);

		l6 = new JLabel("   Billing Cycle Concluded");
		l6.setFont(new Font("HP Simplified Light", Font.BOLD, 14));
		l6.setForeground(Color.white);
		
		u=new JTextField(20);
		p=new JTextField(20);
		s=new JTextField(20);
		
		u.setEnabled(false);
		p.setEnabled(false);
		s.setEnabled(false);
		mth.setEnabled(false);

		b1=new JButton("Open");
		b1.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b1.revalidate();
        b1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent ae)
			{

				try {
					  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
				String qq="SELECT * FROM Details WHERE ID= '"+id.getSelectedItem()+"'";
		        Statement prest=connection.createStatement();
		        ResultSet rest=prest.executeQuery(qq);
		        meter="";
		        sanctl=0;
		        while(rest.next()){
		        	meter=rest.getString("Meter");
		        	sanctl=rest.getInt("SanctionedLoad");
		        }
		        
		        String qq1="SELECT * FROM Bill WHERE ID= '"+id.getSelectedItem()+"' AND _year='"+yr.getSelectedItem()+"'";
		        Statement prst=connection.createStatement();
		        ResultSet rs=prst.executeQuery(qq1);
		        while(rs.next()){
		        	mth.remove(rs.getString("_month"));
		        	
		        }
		        mth.setEnabled(true);

				u.setEnabled(true);
				p.setEnabled(true);
				s.setEnabled(true);
				b3.setEnabled(true);

				p.setText("No");
				s.setText("Not Paid");
				
				rs.close();
				prst.close();
				rest.close();
				prest.close();
				connection.close();
				}
				catch(Exception e)
				{
					System.out.println("Error");
				}
		        
			}
		}); 
		
		
        b3=new JButton("Create");
		b3.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b3.revalidate();
        b3.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent ae)
			{
				try {
					  Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			        Connection connection= DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\CUSTOMERS_DB.accdb");
				String sql = "INSERT INTO Bill(ID, Meter, _year, _month, SanctionedLoad, Units, Status, Payable) VALUES (?,?,?,?,?,?,?,?)";

		        PreparedStatement pstmt = (PreparedStatement)connection.prepareStatement(sql);
		        pstmt.setString(1,id.getSelectedItem());
		        pstmt.setString(2, meter);
		        pstmt.setString(3, yr.getSelectedItem());
		        pstmt.setString(4, mth.getSelectedItem());
		        pstmt.setInt(5, sanctl);
		        pstmt.setInt(6, Integer.parseInt(u.getText()));
		        pstmt.setString(7, s.getText());
		        pstmt.setString(8, p.getText());

		        pstmt.executeUpdate(); 
		        
		        System.out.println("CREATED");
		        
		        pstmt.close();
		        connection.close();
		        JOptionPane.showMessageDialog(null, "Bill Created");

		        setVisible(false);
				}
				catch(Exception e)
				{
					System.out.println("Error");
				}
			}
		}); 
		b3.setEnabled(false);

        b2=new JButton("Cancel");
		b2.setFont(new Font("HP Simplified Light", Font.PLAIN, 14));
        b2.revalidate();
        b2.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
			}
		}); 
		
	p1.add(l1);
	p1.add(id);
	p1.add(l2);
	p1.add(yr);
	p1.add(b1);

    p1.setBackground(Color.black);
	p1.setLayout(new FlowLayout());
	
	p2.add(l3);
	p2.add(mth);
	p2.add(l4);
	p2.add(u);
	p2.add(l5);
	p2.add(s);
	p2.add(l6);
	p2.add(p);
	p2.add(b2);
	p2.add(b3);

    p2.setBackground(Color.black);
	p2.setLayout(new GridLayout(5,2));
	
	setLayout(new BorderLayout());
    
    add(p1,BorderLayout.NORTH);
    add(p2,BorderLayout.CENTER);
    
    setSize(600,300);
    setLocationRelativeTo(null);
    setVisible(true);
    }
	catch(Exception e)
	{
		System.out.println("Error");
	}
}
}
