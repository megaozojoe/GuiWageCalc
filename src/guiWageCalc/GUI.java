package guiWageCalc;

import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;


public class GUI extends JFrame implements Runnable{//main class that includes both gui and multithread
	
	
	static final JTextField wagebx = new JTextField("0");	//the box where the wage is entered
	static boolean runBL = false;//boolean for the thread.
	static JButton calcBN = new JButton("Clock in!");//the clock in and out button
	static double wage = 0.0;//the wage of the person
	static JLabel moneyLB = new JLabel("Money: 0.0");//the constantly changing label
	static double wagesec = 0.0;//the wage per second
	static DecimalFormat df = new DecimalFormat();//sets the specific length for the decimal.
	
	static JFrame fme = new JFrame("Wage Calculator");//The frame to the program
	
	public static void GUI(){
		
		
		wagebx.setBounds(200, 60, 50, 25);//setting sizes
		
		moneyLB.setBounds(300, 50, 150, 50);
		
		calcBN.setBounds(25, 50, 100, 40);
	
		
		calcBN.addActionListener(new ActionListener(){//the action listener that is based off the button click
			public void actionPerformed(ActionEvent e){
				
				wage = Integer.parseInt(wagebx.getText());//sets the wage to the wage entered in the box.
				
				wage = wage/60;//calculating the wage per second
				wage = wage/60;
				
				runBL = !runBL;//Inverting the boolean
				
				if(runBL){//changing the text based on the boolean
					calcBN.setText("Clock out!");
				}
				else if(runBL == false){
					calcBN.setText("Clock in!");
				}
				new Thread(new Runnable(){//runs the method in a new thread that allows for multi threading and multiprocessing.
					public void run(){
						loop();
					}
				}).start();
				
				
				
				
				
			}
		});	
		
		frame();//runs the frame set up
		
	}
	
	public static void loop(){
		while(runBL){
			try {
				Thread.sleep(1000);//tries to wait a second
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				wagesec = wagesec + wage;//increases based of off the wage per second
				moneyLB.setText("Money: " + df.format(wagesec));	
		}
		
		
	}
	
	
	
	
	public static void frame(){
		fme.add(moneyLB);//adding the buttons
		fme.add(wagebx);
		fme.add(calcBN);
		
		fme.setSize(400, 200);
		fme.setLayout(null);
		fme.setVisible(true);
		
	}
	public static void main(String[] args){
		df.setMaximumFractionDigits(2);//sets the max decimal point to 2 spots
		
		GUI();//runs the GUI method
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
