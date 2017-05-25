package guiWageCalc;

import javax.swing.*;
import java.awt.event.*;


public class GUI extends JFrame{
	
	
	static final JTextField wagebx = new JTextField();	
	static boolean pressed = true;
	static JButton calcBN = new JButton("Clock in!");
	static double wage = 0.0;
	static JLabel moneyLB = new JLabel("0.0");
	static int inc = 0;
	static String temp = null;
	static double total = 0.0;
	
	static JFrame fme = new JFrame("Wage Calculator");
	
	public static void GUI(){
		
		wagebx.setBounds(200, 60, 50, 25);
		
		moneyLB.setBounds(300, 50, 150, 50);
		
		calcBN.setBounds(25, 50, 100, 40);
		
		wagebx.setText("0");
		
		

		
		calcBN.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				wage = Integer.parseInt(wagebx.getText());
				
				
				total = total + wage;
				
				
				temp = Double.toString(total);
				moneyLB.setText(temp);	
				
			}
		});
		
		frame();
		
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
		GUI();
		
	}

}
