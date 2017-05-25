package guiWageCalc;

import javax.swing.*;
import java.awt.event.*;


public class GUI extends JFrame{
	
	
	static final JTextField wagebx = new JTextField();	
	static boolean runBL = false;
	static JButton calcBN = new JButton("Clock in!");
	static double wage = 0.0;
	static JLabel moneyLB = new JLabel("0.0");
	static String temp = null;
	static double total = 0.0;
	static double wagesec = 0.0;
	
	
	static JFrame fme = new JFrame("Wage Calculator");
	
	public static void GUI(){
		
		wagebx.setBounds(200, 60, 50, 25);
		
		moneyLB.setBounds(300, 50, 150, 50);
		
		calcBN.setBounds(25, 50, 100, 40);
		
		wagebx.setText("0");
		
		

		
		calcBN.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				calcing();
			}
		});
		while(runBL){
			wagesec = wagesec + wage;
			temp = Double.toString(wagesec);
			moneyLB.setText(temp);	
			
		}
		
		
		
		frame();
		
	}
	
	public static void calcing(){
		
		wage = Integer.parseInt(wagebx.getText());
		
		wage = wage/60;
		wage = wage/60;
		
		runBL = !runBL;
		
		if(runBL){
			
			calcBN.setText("Clock out!");
			
						
		}
		else if(runBL){
			calcBN.setText("Clock out!");
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
		GUI();
		
	}

}
