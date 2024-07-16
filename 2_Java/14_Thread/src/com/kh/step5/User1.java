package com.kh.step5;

public class User1 extends Thread {
	
	private Calculator calculator;
	
	public void setCalculator(Calculator claculator) {
		setName("ClaculatorUser1");
		this.calculator = claculator;
	}
		
		public void run() {
			calculator.setMemory(100);
	}
}
