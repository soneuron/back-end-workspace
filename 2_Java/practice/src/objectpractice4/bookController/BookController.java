package objectpractice4.bookController;

import objectpractice4.book.Book;
import objectpractice4.myPage.MyPage;

public class BookController {
	
	private MyPage member = new MyPage();
	
	// 내 정보 추가
	public void addMember(String name, int age) {
		member.setName(name);
		member.setAge(age);
	}
	
	// 마이페이지
	public MyPage myPage() {
		return member;
	}
	
	// 책 대여
	public void rentBook() {
		
	}
	
}