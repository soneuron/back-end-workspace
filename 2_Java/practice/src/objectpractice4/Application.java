package objectpractice4;


import java.util.Scanner;
import objectpractice4.book.Book;
import objectpractice4.bookController.BookController;
import objectpractice4.myPage.MyPage;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	MyPage mp = new MyPage();
	BookController bc = new BookController();
	Book b = new Book();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.menu();
		
	}

	public void menu() {
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		mp.setName(name);
	
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		mp.setAge(age);
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int number = Integer.parseInt(sc.nextLine());
			
			if(number == 1) {
				System.out.println(mp);
			} else if (number == 2) {
				System.out.println(bc);
			}
		}
		

		
	}
}
