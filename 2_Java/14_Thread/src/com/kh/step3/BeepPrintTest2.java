package com.kh.step3;

public class BeepPrintTest2 extends Thread {
	
	// 경고음 5번 출력하는 작업
	public void run() {
	for(int i = 0; i<5; i++) {
		System.out.println("띵~");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
}
