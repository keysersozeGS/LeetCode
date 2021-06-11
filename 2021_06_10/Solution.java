
public class Solution {

	private void test() {
		MyCalendar myCalendar = new MyCalendar();
		System.out.println("result : " + myCalendar.book(10, 20));
		System.out.println("result : " + myCalendar.book(15, 25));
		System.out.println("result : " + myCalendar.book(20, 30));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
