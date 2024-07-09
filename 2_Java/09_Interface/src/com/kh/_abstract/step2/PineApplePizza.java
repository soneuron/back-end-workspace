package com.kh._abstract.step2;

public class PineApplePizza extends Pizza {

	public PineApplePizza(int price, String brand, String topping) {
		super(price, brand, topping);
		
	}

	@Override
	public void info() {
		System.out.println(brand + "의 "+topping+"피자 가격은 " + this.price + "원");
	}

	@Override
	public void topping() {
		System.out.println("토핑은 "+topping+"을 포함시킨다.");
	}

	
	
}
