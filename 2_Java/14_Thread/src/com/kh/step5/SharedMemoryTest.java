package com.kh.step5;

public class SharedMemoryTest {

	public static void main(String[] args) {

		// 스레드들은 공유자원을 서로 공유한다
		Calculator cla = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(cla);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(cla);
		user2.start();
	}

}
