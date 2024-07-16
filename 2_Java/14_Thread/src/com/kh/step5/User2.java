package com.kh.step5;

public class User2 extends Thread {
		
	private Calculator calculator;
	
	public void setCalculator(Calculator claculator) {
		setName("ClaculatorUser2");
		this.calculator = claculator;
	}
		
		public void run() {
			calculator.setMemory(50);
	}
}
