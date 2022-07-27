package kk;
import java.util.Date;

import javax.swing.JLabel;

class TimeThread implements Runnable {
	
	JLabel jtf;
	public TimeThread(JLabel jtf){
		this.jtf = jtf;
	}
	
    @Override
  	public void run() {
	      Date d1 = new Date();
	      jtf.setText(d1.toString());
	      try {
	        Thread.sleep(1000);
	      } catch (InterruptedException e) {
	        System.out.printf("The FileClock has been interrupted");
	      }
	    
	 }
 }