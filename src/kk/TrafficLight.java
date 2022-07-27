package kk;
import java.awt.Color;

import javax.swing.JLabel;

// Try This 12-1

// A simulation of a traffic light that uses 
// an enumeration to describe the light's color. 
 
// An enumeration of the colors of a traffic light. 
enum TrafficLightColor {  
  RED, GREEN, YELLOW 
} 
 
// A computerized traffic light. 
class TrafficLightSimulator implements Runnable { 
  private TrafficLightColor tlc; // holds the current traffic light color 
  private boolean stop = false; // set to true to stop the simulation 
  private boolean changed = false; // true when the light has changed
  Thread t;
  private int time1;
  private int time2;
  private int time3;
  private JLabel labelRed, labelYellow, labelGreen;
  TrafficLightSimulator(TrafficLightColor init, String name, JLabel label1, JLabel label2, JLabel label3, int time1, int time2, int time3) {
	  t = new Thread(this, name);
	  tlc = init; 
	  this.labelRed = label1;
	  this.labelYellow = label2;
	  this.labelGreen = label3;
	  this.time1 = time1;
	  this.time2 = time2;
	  this.time3 = time3;
  } 
 
  TrafficLightSimulator() {  
    tlc = TrafficLightColor.RED; 
  } 
 
  // Start up the light. 
  public void run() { 
    while(!stop) { 
      try { 
        switch(tlc) { 
          case GREEN: 
            Thread.sleep(time1); // green for 10 seconds 
            break; 
          case YELLOW: 
            Thread.sleep(time2);  // yellow for 2 seconds 
            break; 
          case RED: 
            Thread.sleep(time3); // red for 12 seconds 
            break; 
        } 
      } catch(InterruptedException exc) { 
        System.out.println(exc); 
      } 
      changeColor(); 
    }  
  } 
 
  // Change color. 
  synchronized void changeColor() { 
    switch(tlc) { 
      case RED: 
        tlc = TrafficLightColor.GREEN; 
        break; 
      case YELLOW: 
        tlc = TrafficLightColor.RED; 
        break; 
      case GREEN: 
       tlc = TrafficLightColor.YELLOW; 
    } 
 
    changed = true;
    notify(); // signal that the light has changed 
  } 
 
  // Wait until a light change occurs. 
  synchronized void waitForChange() { 
    switch(tlc) { 
	      case RED: 
		        this.labelRed.setBackground(Color.RED); 
		        this.labelYellow.setBackground(Color.gray); 
		        this.labelGreen.setBackground(Color.gray); 
		        break; 
	      case YELLOW: 
	    	  this.labelYellow.setBackground(Color.YELLOW);
	    	  this.labelRed.setBackground(Color.gray); 
		      this.labelGreen.setBackground(Color.gray);
		      break; 
	      case GREEN:
	    	  this.labelGreen.setBackground(Color.GREEN); 
	    	  this.labelRed.setBackground(Color.gray); 
		      this.labelYellow.setBackground(Color.gray);
		 
      }
      changed = false; 
  } 
 
  // Return current color. 
  synchronized Color getColor() { 
	  switch(tlc) { 
      case RED: 
        return Color.RED;
      case YELLOW: 
        return Color.YELLOW;
      case GREEN: 
       	return Color.GREEN; 
    }
	return null; 
  } 
 
  // Stop the traffic light. 
  synchronized void cancel() { 
    stop = true; 
  } 
}  
  
