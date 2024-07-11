package com.kh.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class A_String {

	
	public void method2() {
		
		// 6. toUpperCase() / toLowerCase() : String
		//	  문자열을 모두 대/소문자로 변경한 새로운 문자열 생성해서 리턴
		String str6 = str.toUpperCase();
		String str7 = str.toLowerCase();
		
		// 7. trim() : String
		// 	  문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성해서 리턴
		String str8 = "                      Hello, Java!                ";
		System.out.println("7. trim 전 : " + str8);
		String str9 = str8.trim();
		System.out.println("trim 후 : " + str9);
		
		// 8. toCharArray() : char[] // 문자 배열
		//    문자열의 문자들을 문자 배열에 담아서 해당 배열의 주소값 리턴
		char[] arr = str.toCharArray();
		System.out.println("8. toCharArray : " + arr);
		System.out.println(Arrays.toString(arr));
		
		// 배열을 리스트(ArrayList)로 변환
		List<Character> arrList = new ArrayList<>();
		for(char word: arr) {
			arrList.add(word);
		}
		System.out.println(arrList);
		
		// 9. static valueOf(문자 배열) : String
		//    문자열로 변경해서 리턴
		String str10 = String.valueOf(arr);
		System.out.println("9. valueOf : " + str10);
		
		System.out.println(str);
		
	}
	
	/*
	 * StringBuilder & StringBuffer
	 * - 가변의 클래스 : String 클래스와 달리 내부의 문자열을 수정 할 수 있다.
	 * - 16개의 문자를 저장 할 수 잇는 버퍼가 미리 생성되고 문자가 저장됨에 따라 자동 증가
	 * - StringBuilder : 동기화 불가능 -> 단일 스레드 환경 권장
	 * - StringBuffer : 동기화 가능 -> 멀티 스레드 환경 권장
	 * */
	
	public void method3() {
		StringBuilder sb = new StringBuilder("Hello, ");
		
		// 1. append(String str) : StringBuilder
		//    기존 문자열 뒤에 문자열 추가
		sb.append("Java!");
		
		// 2. insert(int offset, String str) : StringBuilder
		//    문자열의 offset 위치부터 전달받은 문자열 추가
		sb.insert(1, "eeeee");
		
		// 3. delete(int start, int end) : StringBuilder
		//    start에서 end-1까지의 인덱스에 해당하는 문자열 삭제
		sb.delete(1,6);
		
		// 4. reverse() : StringBuilder
		//    문자열의 순서를 역으로 바꾼다.
		sb.reverse();
		System.out.println(sb);
		
		//
		StringBuilder sb2 = new StringBuilder("Java Program");
		// IPA avaJ
		// 메서드 체이닝 : 메서드를 이어서 쓸 수 있다.
		sb2.append(" API").delete(4, 12).reverse();
//		sb2.append("API");
//		sb2.insert(3, " ");
		System.out.println(sb2);
	
	}
	
	/*
	 * StringTokenizer
	 * - java.util 패키지에서 제공하는 클래스
	 * - 객체 생성 시 생성자로 전달받은 문자열을 구분자를 이용하여 분리
	 * - 분리된 최소 단위를 토큰이라고 부른다
	 * */
	
	public void method4() {
		
		String str = "HTML,CSS,javaScript,MySQL,Java,JDBS,Servlet,JSP,jQuery,MyBatis,Spring,React";
		
		// 1. String 클래스의 split 메서드 이용
		//    split(String regex) : String[]
		//    입력받은 구분자로 문자열을 분리해서 문자열의 배열로 담아서 리턴
		String[] strArr = str.split(",");
		System.out.println("과목 개수 : " + strArr.length);
		for(String s : strArr) {
			System.out.println(s);
		}
		
		// 2. StringTokenizer 객체 이용
		StringTokenizer st = new StringTokenizer(str, ",");
		
		// hasMoreTokens : 남아 있는 토큰이 있는지 확인
//		System.out.println(st.hasMoreTokens());
		// nextToken : 토큰을 하나씩 꺼내옴
//		System.out.println(st.nextToken());
		
		// countTokens : 꺼내지 않고 남아있는 토큰의 수를 확인
		System.out.println("과목 개수 : " + st.countTokens()); // countTokens - length
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("꺼내고 남은 과목 개수 : " + st.countTokens());
		
		
		
		
		
		
		
		
	}

	
	public static void main(String[] args) {
		A_String a = new A_String();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
	}



	
	
}
