package Customer;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.*;

import run.imgscale;
class Tips extends JFrame implements Runnable
{
JLabel l1;
Thread t1;
public Tips()
{
        setLayout(new FlowLayout());
        setTitle("TIPS FOR SAVING ELECTRICITY");
        getContentPane().setBackground(Color.white);
        Random random = new Random();
        	 String path;
             int r = random.nextInt(9 - 1) + 1;;
             path="C:\\Users\\NAZIM MALIK\\OneDrive\\Documents\\Electricity Billing System (Summer Internship Project, Java)\\images\\tip"+r+".jpg";
             final BufferedImage img=new imgscale().scaleImage(600,400,path);
     		 JLabel label=new JLabel(new ImageIcon((Image)img));
             add(label);
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
        t1 = new Thread(this);
        t1.start();
}
 
	 public void run(){
	        try{
	            Thread.sleep(4000);
	            this.setVisible(false);
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
} }
