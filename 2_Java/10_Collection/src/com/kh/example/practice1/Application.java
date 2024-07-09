package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Application {

	public static void main(String[] args) {
		
		HashSet<Integer> setLotto = new HashSet<Integer>();
		HashSet<Integer> setMy = new HashSet<Integer>();
		
		
		while(setLotto.size() < 6) {
			int random = (int)(Math.random()*45+1);
			if(setLotto.size() < 6) {
				setLotto.add(random);
			}
		}
		System.out.println(setLotto);
		
		while(setMy.size() < 6) {
			int random1 = (int)(Math.random()*45+1);
			if(setMy.size() < 6) {
				setMy.add(random1);
			}
		}
		System.out.println(setMy);
		
		while(setMy == setLotto) {
			
		}
		
	}
		
}



// set.size
// set.contains
//

//주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)
//
//1 : 3
//2 : 2
//3 : 1
//4 : 0
//5 : 4
//6 : 0
//
//*/
//public void method5() {
//int[] dice = new int[6];
//
//for(int i = 0; i<10; i++) {
//	int random = (int) (Math.random()*6); // 1~6 -> 0~5
//	dice[random]++;
//}
//
//for(int i = 0; i < dice.length; i++) {
//	System.out.println((i+1) + " : " + dice[i]);

///*
//0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
//7
//3
//4
//2
//3
//4
//0
//*/
//public void method4() {
//while(true) {
//	int random = (int) (Math.random()*11);
//	System.out.println(random);
//	if(random == 0) break;
//}
//}