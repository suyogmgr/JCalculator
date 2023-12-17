package com.calculator;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdvCalculator implements ActionListener{
		
	private JFrame frame;
	private JTextField textField;
	private JButton[] numberButtons = new JButton[10];
	private JButton[] functionButtons = new JButton[9];
	private JButton addBtn, subBtn, mulBtn, divBtn, decBtn, eqlBtn, clrBtn, delBtn, negBtn;
	private JPanel panel;
	char operator;
	double num1 = 0, num2 = 0, result = 0;
	private Font myFont = new Font("Xenera", Font.PLAIN, 28);
	private Color myColor = new Color(10,20,30);
 	
	public AdvCalculator() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Advance Calculator");
		frame.setSize(420,550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		//frame.getContentPane().setBackground(myColor);
		
		textField = new JTextField();
		textField.setFont(myFont);
		textField.setBounds(60,25,300,50);
		textField.setEditable(false);
		frame.add(textField);
		
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		divBtn = new JButton("/");
		mulBtn = new JButton("*");
		decBtn = new JButton(".");
		eqlBtn = new JButton("=");
		clrBtn = new JButton("Clr");
		negBtn = new JButton("(-)");
		delBtn = new JButton("Del");
		
		functionButtons [0] = addBtn;
		functionButtons [1] = subBtn;
		functionButtons [2] = divBtn;
		functionButtons [3] = mulBtn;
		functionButtons [4] = decBtn;
		functionButtons [5] = eqlBtn;
		functionButtons [6] = clrBtn;
		functionButtons [7] = negBtn;
		functionButtons [8] = delBtn;
		
		for(int i = 0; i<9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i = 0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].addActionListener(this);
		}
		
		negBtn.setBounds(60,430,100,50);
		delBtn.setBounds(160, 430, 100, 50);
		clrBtn.setBounds(260, 430, 100, 50);
		frame.add(negBtn);
		frame.add(delBtn);
		frame.add(clrBtn);
		
		panel = new JPanel();
		panel.setBounds(60,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		//panel.setBackground(myColor);
		frame.add(panel);
		
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addBtn);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subBtn);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulBtn);
		panel.add(decBtn);
		panel.add(numberButtons[0]);
		panel.add(eqlBtn);
		panel.add(divBtn);
		
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decBtn) {
			textField.setText(textField.getText().concat("."));
		}
		
		if(e.getSource() == addBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		
		if(e.getSource() == subBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		
		if(e.getSource() == mulBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		
		if(e.getSource() == divBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		
		if(e.getSource() == eqlBtn) {
			num2 = Double.parseDouble(textField.getText());
			
			
			switch(operator) {
			
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource() == clrBtn) {
			textField.setText("");
		}
		if(e.getSource() == delBtn) {
			String temp = textField.getText();
			
			textField.setText("");
			
			for(int i = 0; i<temp.length()-1; i++) {
				textField.setText(textField.getText()+temp.charAt(i));
			}
			
			if(e.getSource() == negBtn) {
				double temp1 = Double.parseDouble(textField.getText());
				temp1 *= -1;
				textField.setText(String.valueOf(temp1));
			}
		}
	}

}
