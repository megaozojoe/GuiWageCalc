package guiWageCalc;

import javax.swing.*;
import java.awt.event.*;


public class GUI extends JFrame{
	
	static boolean pressed = true;
	static boolean working = false;
	static JButton calcBN = new JButton("Clock in!");
	static double wage = 0.0;
	static double wagesec = 0.0;
	static final JTextField wagebx = new JTextField();
	static JLabel money = new JLabel("0.0");
	
	static JFrame fme = new JFrame("Wage Calculator");
	
	public static void GUI(){
		
		wagebx.setBounds(200, 60, 50, 25);
		
		money.setBounds(300, 50, 150, 50);
		
		calcBN.setBounds(25, 50, 100, 40);
		
		calcBN.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				calcing();		
				
			}
		});
		
		frame();
		
	}
	
	public static void calcing(){
		
		pressed = !pressed;
		
		wage = Integer.parseInt(wagebx.getText());
		wage = wage/60;
		wage = wage/60;
		
		if(pressed){//if clocked in 
			calcBN.setText("Clock out!");
			working  = true;	
		}
		else if (pressed == false){
			calcBN.setText("Clock in!");
			working = false;
		}
		String test = "";
		if(working){
			while(working){
				try {
					Thread.sleep(1000);
					wagesec = wagesec + wage;
					test = test.valueOf(wagesec);
					
					money.setText(test);
						
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}	
		}
	}
	
	
	public static void frame(){
		fme.add(money);//adding the buttons
		fme.add(wagebx);
		fme.add(calcBN);
		
		fme.setSize(400, 200);
		fme.setLayout(null);
		fme.setVisible(true);
		
	}
	public static void main(String[] args){
		GUI();
		
	}

}
