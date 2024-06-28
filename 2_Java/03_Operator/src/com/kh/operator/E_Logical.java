package com.kh.operator;

import java.util.Scanner;

public class E_Logical {

		/*
		 * 논리 연산자
		 * - 두개의 논리값을 연산해 주는 연산자
		 * - 논리 연산한 결과마저 논리값
		 * 
		 * 논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘 다 true인 경우만 결과값이 true
		 * 논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중 하나라도 true일 경우 결과값이 true
		 * */
		
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		E_Logical e = new E_Logical();
		e.method1();
//		e.method2();
//		e.practice();
	}
	
	public void method1() {
		// 사용자가 입력한 정수값이 1부터 100사이의 값인지 확인
		System.out.print("정수값을 입력해 주세요 > ");
		int number = sc.nextInt();
		// 1 <= number && number <= 100
		boolean result = 1 <= number && number <= 100;
		System.out.print("1부터 100사이의 값인가요? " + result);
	}
	
	public void method2() {
		int number = 10;
		boolean result = false;
		
		// Short Cut Evaluation
		
		// &&
		// true && true = true
		// true && false = false
		// false && true = false
		// false && false = false
		// && 연산자를 기준으로 앞에서 이미 false 이기 때문에 굳이 뛰쪽의 연산을 수행하지 않는다.
		result = (number < 5) && (++number > 0);
		
		// result? number?
		System.out.println(result); // false
		System.out.println(number); // 10
		
		// || 
		// true || true = true
		// true || false = true
		// false || true = true
		// false || false = false
		result = (number < 20) || (++number > 0 );
		
		System.out.println(result); // true
		System.out.println(number); // 10\
	}
	
		/*
		 * 실습문제
		 * 
		 * 사용자가 입력한 문자값이 알파벳인지 확인하기
		 * A ~ Z : 65 ~ 90, a ~ z : 97 ~ 122
		 * */
	public void practice() {
		/*
		 * System.out.print("문자를 입력하세요 : ");
			int num1 = sc.nextInt();
			boolean result = (num1 >= 65 && num1 < 90) || (num1 >=97 && num1 < 122);
			System.out.print((char)num1);
		 */
		
		System.out.print("문자 값 >> ");
		char a = sc.nextLine().charAt(0);
		
		boolean check = ('A' <= a && a <= 'Z' ) || ('a' <= a && a < 'z');
		System.out.println(check);
		
	}
}
