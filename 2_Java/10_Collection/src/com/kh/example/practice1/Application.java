package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
//		HashSet<Integer> setLotto = new HashSet<Integer>();
//		HashSet<Integer> setMy = new HashSet<Integer>();
//		
//		
//		while(setLotto.size() < 6) {
//			int random = (int)(Math.random()*45+1);
//			if(setLotto.size() < 6) {
//				setLotto.add(random);
//			}
//		}
//		System.out.println(setLotto);
//		
//		while(setMy.size() < 6) {
//			int random1 = (int)(Math.random()*45+1);
//			if(setMy.size() < 6) {
//				setMy.add(random1);
//			}
//		}
//		System.out.println(setMy);
//		
//		while(setMy == setLotto) {
//			
//		}
//		
	
		
/*-------------------------- 풀이 ------------------------------------*/


		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		// 기존 로또 번호는 6개, 보너스 번호가 필요해서 1개 더 추가
		while(lotto.size() < 7) {
			int num = (int)(Math.random()*45+1);
			if(!lotto.contains(num)) {
				lotto.add(num);
			}
		}
		
		// 0 ~ 6 까지 범위지정 후 로또 번호 6개 따로, 보너스 번호 따로
		List<Integer> lottoList = lotto.subList(0, 6);
		int bonus = (int)(Math.random()*45+1);
		
		
		 int count = 0;
		while(true) {
			count++;
			ArrayList<Integer> myLotto = new ArrayList<Integer>();
			
			while(myLotto.size() < 6) {
				int num = (int)(Math.random()*45+1);
				if(!myLotto.contains(num)) {
					myLotto.add(num);
			}
		}
			System.out.println("로또 번호 : "+lottoList);
			System.out.println("내 로또 번호 : "+myLotto);
			
			Collections.sort(lottoList);
			Collections.sort(myLotto);
			
			// 멈추는 조건 : 로또 번호와 내 번호가 정확히 일치 할 때
			if(lotto.equals(myLotto)) {
				System.out.println("횟수 : "+count);
				break;
			}
			
			int match = 0;
			
			for(Integer num : lottoList) {
				if(myLotto.contains(num)) {
					match++;
				}
			}
			
			if(match == 5) {
				if(myLotto.contains(bonus)) {
				System.out.println("2등 당첨! 보너스 번호 : " + bonus + ", 횟수  : "+ count);
				break;
				} else {
					System.out.println("3등 당첨1 횟수 : " + count);
				}
			}
	}
	}
}
		
	

