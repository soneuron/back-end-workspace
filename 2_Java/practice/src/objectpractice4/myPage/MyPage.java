package objectpractice4.myPage;

import java.awt.print.Book;
import java.util.Arrays;

public class MyPage {

	private String name; // 이름
	private int age; // 나이
	private int coupon; // 쿠폰개수
	private Book[] bookList = new Book[2]; // 빌린 책
	
	public MyPage() {
	}
	public MyPage(String name, int age, int coupon, Book[] bookList) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.bookList = bookList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public Book[] getBookList() {
		return bookList;
	}
	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}
	
	@Override
	public String toString() {
		return "MyPage [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}

	
}
	