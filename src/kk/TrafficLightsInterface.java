package kk;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class TrafficLightsInterface implements ActionListener {

	private JLabel light1_red;
	private JLabel light1_yellow;
	private JLabel light1_green;
	private JLabel light2_red;
	private JLabel light2_yellow;
	private JLabel light2_green;
	private JLabel light1_int2_red;
	private JLabel light1_int2_yellow;
	private JLabel light1_int2_green;
	private JLabel light2_int2_yellow;
	private JLabel light2_int2_red;
	private JLabel light2_int2_green;
	private JLabel light1_int3_red;
	private JLabel light1_int3_yellow;
	private JLabel light1_int3_green;
	private JLabel light2_int3_red;
	private JLabel light2_int3_yellow;
	private JLabel light2_int3_green;
	private boolean running = false;
	private boolean toExit = false;
	private TrafficLightSimulator tl1_int1;
	private TrafficLightSimulator tl2_int1;
	private TrafficLightSimulator tl1_int2;
	private TrafficLightSimulator tl1_int3;
	private TrafficLightSimulator tl2_int2;
	private TrafficLightSimulator tl2_int3;
	private Cars car1, car2, car3;
	
	private JLabel time;
	private JLabel lblCar1, lblCar2, lblCar3;
	TrafficLightsInterface() { 
		 
	    // Create a new JFrame container. 
	    JFrame jfrm = new JFrame("Traffic Lights System"); 
	 
	    // Give the frame an initial size. 
	    jfrm.setSize(750, 600); 
	    
	    // Give the frame a Layout
	    jfrm.setLayout(null);
	    
	    // Terminate the program when the user closes the application. 
	    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    // Intersections labels
	    JLabel int1 = new JLabel("Intersection 1");
	    JLabel int2 = new JLabel("Intersection 2");
	    JLabel int3 = new JLabel("Intersection 3");
	    int1.setBounds(50,10,100,30);
	    int2.setBounds(300,10,100,30);
	    int3.setBounds(550,10,100,30);
	    
	    // Buttons
	    JButton start = new JButton("Start");
	    JButton pause = new JButton("Pause");
	    JButton stop = new JButton("Stop");
	    
	    start.addActionListener(this); 
	    pause.addActionListener(this);
	    stop.addActionListener(this);
	    
	    start.setBounds(50, 500, 80, 30);
	    pause.setBounds(150, 500, 80, 30);
	    stop.setBounds(250, 500, 80, 30);
	    pause.addActionListener(this);
	    stop.addActionListener(this);
	    
	    // Create traffic lights.
	    // Intersection 1
	    // Traffic light 1
	    light1_red = new JLabel(" ");
	    light1_red.setBounds(50,40,40,30);
	    light1_red.setBackground(Color.red);
	    light1_red.setOpaque(true);
	    light1_yellow = new JLabel(" ");
	    light1_yellow.setBounds(50,70,40,30);
	    light1_yellow.setBackground(Color.yellow);
	    light1_yellow.setOpaque(true);
	    light1_green = new JLabel(" ");
	    light1_green.setBounds(50,100,40,30);
	    light1_green.setBackground(Color.green);
	    light1_green.setOpaque(true);
	    
	    // Traffic light 2
	    light2_red = new JLabel(" ");
	    light2_red.setBounds(120,140,40,30);
	    light2_red.setBackground(Color.red);
	    light2_red.setOpaque(true);
	    light2_yellow = new JLabel(" ");
	    light2_yellow.setBounds(120,170,40,30);
	    light2_yellow.setBackground(Color.yellow);
	    light2_yellow.setOpaque(true);
	    light2_green = new JLabel(" ");
	    light2_green.setBounds(120,200,40,30);
	    light2_green.setBackground(Color.green);
	    light2_green.setOpaque(true);
	    
	    
	    // Intersection 2
	    // Traffic light 1
	    light1_int2_red = new JLabel(" ");
	    light1_int2_red.setBounds(300,40,40,30);
	    light1_int2_red.setBackground(Color.red);
	    light1_int2_red.setOpaque(true);
	    light1_int2_yellow = new JLabel(" ");
	    light1_int2_yellow.setBounds(300,70,40,30);
	    light1_int2_yellow.setBackground(Color.yellow);
	    light1_int2_yellow.setOpaque(true);
	    light1_int2_green = new JLabel(" ");
	    light1_int2_green.setBounds(300,100,40,30);
	    light1_int2_green.setBackground(Color.green);
	    light1_int2_green.setOpaque(true);
	    
	    // Traffic light 2
	    light2_int2_red = new JLabel(" ");
	    light2_int2_red.setBounds(370,140,40,30);
	    light2_int2_red.setBackground(Color.red);
	    light2_int2_red.setOpaque(true);
	    light2_int2_yellow = new JLabel(" ");
	    light2_int2_yellow.setBounds(370,170,40,30);
	    light2_int2_yellow.setBackground(Color.yellow);
	    light2_int2_yellow.setOpaque(true);
	    light2_int2_green = new JLabel(" ");
	    light2_int2_green.setBounds(370,200,40,30);
	    light2_int2_green.setBackground(Color.green);
	    light2_int2_green.setOpaque(true);
	    
	    // Intersection 3
	    // Traffic light 1
	    light1_int3_red = new JLabel(" ");
	    light1_int3_red.setBounds(550,40,40,30);
	    light1_int3_red.setBackground(Color.red);
	    light1_int3_red.setOpaque(true);
	    light1_int3_yellow = new JLabel(" ");
	    light1_int3_yellow.setBounds(550,70,40,30);
	    light1_int3_yellow.setBackground(Color.yellow);
	    light1_int3_yellow.setOpaque(true);
	    light1_int3_green = new JLabel(" ");
	    light1_int3_green.setBounds(550,100,40,30);
	    light1_int3_green.setBackground(Color.green);
	    light1_int3_green.setOpaque(true);
	    
	    // Traffic light 2
	    light2_int3_red = new JLabel(" ");
	    light2_int3_red.setBounds(620,140,40,30);
	    light2_int3_red.setBackground(Color.red);
	    light2_int3_red.setOpaque(true);
	    light2_int3_yellow = new JLabel(" ");
	    light2_int3_yellow.setBounds(620,170,40,30);
	    light2_int3_yellow.setBackground(Color.yellow);
	    light2_int3_yellow.setOpaque(true);
	    light2_int3_green = new JLabel(" ");
	    light2_int3_green.setBounds(620,200,40,30);
	    light2_int3_green.setBackground(Color.green);
	    light2_int3_green.setOpaque(true);
	    time = new JLabel();
	    time.setBounds(500, 400, 200, 50);
	    
	    lblCar1 = new JLabel();
	    lblCar2 = new JLabel(); 
	    lblCar3 = new JLabel();
	    
	    lblCar1.setBounds(50, 300, 450, 50);
	    lblCar2.setBounds(50, 325, 450, 50);
	    lblCar3.setBounds(50, 350, 450, 50);
	    // Add the label to the content pane. 
	    jfrm.add(int1); 
	    jfrm.add(int2);
	    jfrm.add(int3);
	    
	    jfrm.add(time);
	    jfrm.add(lblCar1);
	    jfrm.add(lblCar2);
	    jfrm.add(lblCar3);
	    
	    jfrm.add(light1_red); 
	    jfrm.add(light1_yellow);
	    jfrm.add(light1_green);
	    jfrm.add(light2_red); 
	    jfrm.add(light2_yellow);
	    jfrm.add(light2_green);
	    
	    jfrm.add(light1_int2_red); 
	    jfrm.add(light1_int2_yellow);
	    jfrm.add(light1_int2_green);
	    jfrm.add(light2_int2_red); 
	    jfrm.add(light2_int2_yellow);
	    jfrm.add(light2_int2_green);
	    
	    jfrm.add(light1_int3_red); 
	    jfrm.add(light1_int3_yellow);
	    jfrm.add(light1_int3_green);
	    jfrm.add(light2_int3_red); 
	    jfrm.add(light2_int3_yellow);
	    jfrm.add(light2_int3_green);
	    
	    jfrm.add(start); 
	    jfrm.add(pause);
	    jfrm.add(stop);
	    // Display the frame. 
	    jfrm.setVisible(true); 
	 } 
	 
	
    
	
	private boolean stop = true;
	private Thread t;
	 // Handle button events. 
	 public void actionPerformed(ActionEvent ae) { 
	    if(ae.getActionCommand().equals("Start"))  {
	    	if (stop == true) {
	    		
		    	tl1_int1 = new TrafficLightSimulator(TrafficLightColor.GREEN, "Interception 1, Light 1", light1_red, light1_yellow, light1_green, 10000, 2000, 12000); 
		    	tl2_int1 = new TrafficLightSimulator(TrafficLightColor.RED, "Interception 1, Light 2", light2_red, light2_yellow, light2_green, 10000, 2000, 12000);
		    	
		    	tl1_int2 = new TrafficLightSimulator(TrafficLightColor.RED, "Interception 2, Light 1", light1_int2_red, light1_int2_yellow, light1_int2_green, 5000, 2000, 7000); 
		    	tl2_int2 = new TrafficLightSimulator(TrafficLightColor.GREEN, "Interception 2, Light 2", light2_int2_red, light2_int2_yellow, light2_int2_green, 5000, 2000, 7000);
		    	
		    	tl1_int3 = new TrafficLightSimulator(TrafficLightColor.GREEN, "Interception 3, Light 1", light1_int3_red, light1_int3_yellow, light1_int3_green, 7000, 2000, 9000); 
		    	tl2_int3 = new TrafficLightSimulator(TrafficLightColor.RED, "Interception 3, Light 2", light2_int3_red, light2_int3_yellow, light2_int3_green, 7000, 2000, 9000);
		    	car1 = new Cars(lblCar1, Color.RED, 0);
		    	car2 = new Cars(lblCar2, Color.RED, 200);
		    	car3 = new Cars(lblCar3, Color.RED, 500);
		    	car1.t.start();
		    	car2.t.start();
		    	car3.t.start();
		    	tl1_int1.t.start();
		    	tl2_int1.t.start();
		    	tl1_int2.t.start();
		    	tl2_int2.t.start();
		    	tl1_int3.t.start();
		    	tl2_int3.t.start();
		    	toExit = false;
		    	t = new Thread(new Runnable() {
		    		@Override
		            public void run() {
		                while(!toExit){
		                    // Your code
		                    try {
		                    	tl1_int1.waitForChange();
		                    	tl2_int1.waitForChange();
		                    	tl1_int2.waitForChange();
		                    	tl2_int2.waitForChange();
		                    	tl1_int3.waitForChange();
		                    	tl2_int3.waitForChange();
		                    	if (car1.getX() < 1000)
		                    		car1.setLight(tl2_int1.getColor());
		                    	else if (car1.getX() < 2000)
		                    		car1.setLight(tl2_int2.getColor());
		                    	else
		                    		car1.setLight(tl2_int3.getColor());
		                    	if (car2.getX() < 1000)
		                    		car2.setLight(tl2_int1.getColor());
		                    	else if (car2.getX() < 2000)
		                    		car2.setLight(tl2_int2.getColor());
		                    	else
		                    		car2.setLight(tl2_int3.getColor());
		                    	if (car3.getX() < 1000)
		                    		car3.setLight(tl2_int1.getColor());
		                    	else if (car3.getX() < 2000)
		                    		car3.setLight(tl2_int2.getColor());
		                    	else
		                    		car3.setLight(tl2_int3.getColor());
		                    	Thread tt = new Thread(new TimeThread(time));
		                    	tt.start();
		    					Thread.sleep(100);
		    					car1.increment();
		    					car2.increment();
		    					car3.increment();
		    				} catch (InterruptedException e) {
		    					// TODO Auto-generated catch block
		    					e.printStackTrace();
		    				}
		                }
		            }
		        });
		    	t.start();
	    	}
	    	else {
	    		t.resume();
	    		car1.t.resume();
	    		car2.t.resume();
	    		car3.t.resume();
	    		tl1_int1.t.resume();
		    	tl2_int1.t.resume();
		    	tl1_int2.t.resume();
		    	tl2_int2.t.resume();
		    	tl1_int3.t.resume();
		    	tl2_int3.t.resume();
	    	}
	    	
	    	
	    }
	    else if (ae.getActionCommand().equals("Stop")) {
	    	toExit = true;
	    	stop = true;
	    	// Intersection 1
		    // Traffic light 1
		    light1_red.setBackground(Color.red);
		    light1_yellow.setBackground(Color.yellow);
		    light1_green.setBackground(Color.green);
		    
		    // Traffic light 2
		    light2_red.setBackground(Color.red);
		    light2_yellow.setBackground(Color.yellow);
		    light2_green.setBackground(Color.green);
		    
		    
		    // Intersection 2
		    // Traffic light 1
		    light1_int2_red.setBackground(Color.red);
		    light1_int2_yellow.setBackground(Color.yellow);
		    light1_int2_green.setBackground(Color.green);
		    
		    // Traffic light 2
		    light2_int2_red.setBackground(Color.red);
		    light2_int2_yellow.setBackground(Color.yellow);
		    light2_int2_green.setBackground(Color.green);
		    
		    // Intersection 3
		    // Traffic light 1
		    light1_int3_red.setBackground(Color.red);
		    light1_int3_yellow.setBackground(Color.yellow);
		    light1_int3_green.setBackground(Color.green);
		    
		    // Traffic light 2
		    light2_int3_red.setBackground(Color.red);
		    light2_int3_yellow.setBackground(Color.yellow);
		    light2_int3_green.setBackground(Color.green);
	    }
	    else {
	    	t.suspend();
	    	tl1_int1.t.suspend();
	    	tl2_int1.t.suspend();
	    	tl1_int2.t.suspend();
	    	tl2_int2.t.suspend();
	    	tl1_int3.t.suspend();
	    	tl2_int3.t.suspend();
	    	car1.t.suspend();
    		car2.t.suspend();
    		car3.t.suspend();
	    	stop = false;
	    }
	 } 
	
	 public static void main(String args[]) { 
		 // Create the frame on the event dispatching thread. 
		 SwingUtilities.invokeLater(new Runnable() { 
			 public void run() { 
				 new TrafficLightsInterface(); 
			 } 
		 }); 
	  } 
	 
	  

}
