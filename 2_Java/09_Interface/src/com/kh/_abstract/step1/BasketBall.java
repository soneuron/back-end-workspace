package com.kh._abstract.step1;

public class BasketBall extends Sports {

	public BasketBall(int numberOfPlayers) {
		super(numberOfPlayers);
		
	}

	@Override
	public void rule() {
		System.out.println("BasketBall의 선수의 수는 " + this.numberOfPlayers+"명, 발이아닌 손으로 해야한다.");
	}
	
}
