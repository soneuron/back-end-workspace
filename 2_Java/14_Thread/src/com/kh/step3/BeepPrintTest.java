package com.kh.step3;

import java.awt.Toolkit;

public class BeepPrintTest {

	public static void main(String[] args) {

//		// 경고음 5번 울리는 작업
//		Toolkit tool = Toolkit.getDefaultToolkit();
//		for(int i = 0; i <5; i++) {
//			tool.beep();
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		// 경고음 5번 출력하는 작업
//		for(int i = 0; i<5; i++) {
//			System.out.println("띵~");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		BeepPrintTest1 test1 = new BeepPrintTest1();
		BeepPrintTest2 test2 = new BeepPrintTest2();
		
		Thread ts1 = new Thread(test1, "thing"); 
		Thread ts2 = new Thread(test2, "띵");
		
		ts1.start();
		ts2.start();
	}
}


