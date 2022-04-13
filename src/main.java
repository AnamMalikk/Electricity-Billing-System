import run.*;
import Customer.user.*;
import Customer.bills.*;

import javax.swing.SwingUtilities;

import Customer.*;

public class main {

	public static void main(String[] args){
		 fframe f1 = new fframe();
	        f1.setVisible(true);
	        int i;
	        int x=1;
	        for(i=2; i<=700; i+=4, x+=1){
	            f1.setLocationRelativeTo(null);
	            f1.setSize(i+x,i);

	            try{
	                Thread.sleep(8);
	            }
	            catch(Exception e){ }
	}
	}

}
