package objectpractice4.myPage;

public class MyPage {

	private String name;
	private int age;
	private int coupon;
	
	public MyPage() {
	}
	
	public MyPage(String name, int age, int coupon) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
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
	@Override
	public String toString() {
		return "MyPage [name=" + name + ", age=" + age + ", coupon=" + coupon + "]";
	}
	
	
}
