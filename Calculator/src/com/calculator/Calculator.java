package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10]; // to store the number Buttons
	JButton[] functionButtons = new JButton[9]; // to store the function Buttons
	JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;

	Font myFont = new Font("Xenara", Font.PLAIN, 28);
	double num1 = 0, num2 = 0, result = 0;
	char operator;

	Calculator() {
		frame = new JFrame("Calcualtor"); // setting the title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);

		textField = new JTextField();
		textField.setBounds(60, 25, 300, 50);
		textField.setEditable(false);// now can't directly enter values in the textField
		textField.setFont(myFont);
		frame.add(textField);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		// adding actionListener and font on all the functionButtons
		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false); // to remove the annoying outline on the button
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(60,430,100,50);
		delButton.setBounds(160, 430, 100, 50);
		clrButton.setBounds(260, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(60,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10)); 
	  /*adding the following respectively 
	   *Rows: 4
	   *Columns: 
	   *Horizontal Gap: 10 pixels
	    Vertical Gap: 10 pixels */
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(negButton);
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.setResizable(false);
		frame.setLocation(300,300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}
		
		if(e.getSource() == addButton ) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		
		if(e.getSource() == subButton ) {
			num1  = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());
			
			switch(operator) {
			case'+':
				result = num1+num2;
				break;
			case'-':
				result = num1-num2;
				break;
			case'*':
				result = num1*num2;
				break;
			case'/':
				result = num1/num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource() == clrButton) {
			textField.setText("");
		}
		
		if(e.getSource() == delButton) {
			String temp = textField.getText();
			
			textField.setText("");
			
			for(int i = 0; i<temp.length()-1; i++) {
				textField.setText(textField.getText()+temp.charAt(i));
			}
		}
		if(e.getSource() == negButton) {
			double temp1 = Double.parseDouble(textField.getText());
			temp1 *= -1;
			textField.setText(String.valueOf(temp1));
		}
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
}
