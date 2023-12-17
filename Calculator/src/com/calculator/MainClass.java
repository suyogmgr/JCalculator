package com.calculator;

import javax.swing.SwingUtilities;

public class MainClass {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdvCalculator calc = new AdvCalculator();
			}
		});
		}
			
}
