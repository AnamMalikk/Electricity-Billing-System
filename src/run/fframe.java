package run;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;
public class fframe extends JFrame implements Runnable{
    Thread t1;
    public fframe()
    {        super("Electricity Billing System");
        getContentPane().setBackground(Color.white);
        setLayout(new FlowLayout());       
		final BufferedImage img=new imgscale().scaleImage(878, 702,"C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\elec.jpg");
		JLabel label=new JLabel(new ImageIcon((Image)img));
       add(label);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(6000);
            this.setVisible(false);
           
            login l = new login();
            l.setVisible(true);}
        catch(Exception e)
        {e.printStackTrace();}}}
