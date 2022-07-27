 package kk;
import java.awt.Color;
import java.util.Date;

import javax.swing.JLabel;
import java.util.Random;
public class Cars implements Runnable {
	JLabel jtf;
	private double x = 0;
	private double y = 0;
	private double speed = 1; // moves 1 m/s
	private double time = 0;
	private Color light;
	Thread t;
	Cars(JLabel jtf, Color light, double x){
		t = new Thread();
		this.jtf = jtf;
		this.light = light;
		this.x = x;
	}
	
    @Override
  	public void run() {
    	
	      try {
	        Thread.sleep(1000);
	        
	      } catch (InterruptedException e) {
	        System.out.printf("The FileClock has been interrupted");
	      }
	    
	 }
    
    synchronized void setLight(Color light) {
    	this.light = light;
    }
    
    synchronized double getX() {
    	return this.x;
    }
    
    synchronized void increment() { 
    	if (this.light == Color.red && ((x >= 850 && x <= 1000))) {
	    	  speed = 0;
	    }
	    else {
	    	speed = (new Random()).nextDouble() * 2 + 0.5;
	    }
    	time += 0.01;
        x += speed * time;
        if ((x >= 850 && x <= 1000)) {
        	jtf.setText(String.format("Car: x = %.2f, y = %.2f speed = %.2f m/s At intersection 1", x, y, speed));
        }
        else if ((x >= 1850 && x <= 2000)) {
        	jtf.setText(String.format("Car: x = %.2f, y = %.2f speed = %.2f m/s At intersection 2", x, y, speed));
        }
        else if ((x >= 2850 && x <= 3000)) {
        	jtf.setText(String.format("Car: x = %.2f, y = %.2f speed = %.2f m/s At intersection 3", x, y, speed));
        }
        else {
        	jtf.setText(String.format("Car: x = %.2f, y = %.2f speed = %.2f m/s", x, y, speed));
        }
    } 
}
