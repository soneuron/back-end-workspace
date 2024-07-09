package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza {

	public BulgogiPizza(int price, String brand, String topping) {
		super(price, brand, topping);
		
		
	}

	@Override
	public void info() {
		System.out.println(brand + "의 "+topping+" 가격은 " + this.price + "원");
	}

	@Override
	public void topping() {
		System.out.println("토핑은 "+topping+"를 포함시킨다.");
	}

	
//	Pizza[] pizza = {
//			new BulgogiPizza(30000, "피자헛"),
//			new PotataoPizza(20000, "도미노피자"),
//			new PineAppliePizza(10000, "잭슨피자")
//	}
	
//	 * 피자헛의 불고기 피자 가격은 30000원
//	 * 피자 반죽과 함께 도우를 빚다.
//	 * 토핑은 불고기를 포함시킨다.
//	 * 피자를 180도에서 10분간 구운다.
//	 * 피자를 8등분으로 자른다.
//	 * 피자를 포장한다.
	
//	@Override
//	public void makePizza() {
//		System.out.println(this.brand+"의 " + this.topping+ "피자 가격은 " + this.price + "원");
//		System.out.println("피자 반죽과 함께 도우를 빚다.");
//		System.out.println("토핑은 "+this.topping+"를 포함시킨다.");
//		System.out.println("피자를 180도에서 10분간 구운다.");
//		System.out.println("피자를 8등분으로 자른다.");
//		System.out.println("피자를 포장한다.");
//	}
//	

	
}
