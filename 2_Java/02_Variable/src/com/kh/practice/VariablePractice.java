package com.kh.practice;

public class VariablePractice {
	
	public static void main(String[] args) {
		VariablePractice practice = new VariablePractice();
		practice.method1();
		practice.method2();
		practice.method3();
		practice.method4();
		practice.method5();
		practice.method6();
		practice.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		int adult = 10000;
		int child = 7000;
		System.out.println("--- Q1 ---");
		System.out.println(adult * 2 + child * 3);
	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		System.out.println("--- Q2 ---");
		System.out.println("x=" + y);
		System.out.println("y=" + z);
		System.out.println("z=" + x);
	}

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		int first = 23;
		int second = 7;
		System.out.println("--- Q3 ---");
		System.out.println("첫 번째 정수 : " + first);
		System.out.println("두 번째 정수 : " + second);
		System.out.println("더하기 : " + (first + second));
		System.out.printf("빼기 : %d\n", first - second);
		System.out.println("곱하기 : " + first*second);
		System.out.println("나누기 몫 : " + first/second);
	}

	/*
	 * 키보드로 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		double width = 13.5;
		double height = 41.7;
		System.out.println("--- Q4 ---");
		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
		System.out.println("면적 : " + width*height);
		System.out.println("둘레 : " + (width+height)*2);
	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		System.out.println("--- Q5 ---");
		System.out.println();
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		char c = 'A';
		System.out.println("--- Q6 ---");
		System.out.println(c + " unicide :" + (int)c);
		System.out.println((char)(c+1) + " unicide :" + ((int)c +1));
		
	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		int k = 75;
		int en = 63;
		int math = 80;
		System.out.println("--- Q7 ---");
		System.out.println("국어 : " + k);
		System.out.println("수학 : " + math);
		System.out.println("영어 : " + en);
		System.out.printf("총점은%d점 이고, 평균은%.2f점 입니다.", (k+math+en),((double)(k+math+en)/3));
	}

}
