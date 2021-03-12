
public class Solution {

	private boolean isAnagram(int[] counterArray1, int[] counterArray2) {
		for (int i = 0; i < counterArray1.length; i++) {
			if (counterArray1[i] != counterArray2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	private void fillCounterArray(String s, int[] counterArray) {
		for (int i = 0; i < s.length(); i++) {
			counterArray[(int)s.charAt(i)]++;
		}
	}
	
	public boolean isAnagram(String s, String t) {
		int[] sCounter = new int[256];
		int[] tCounter = new int[256];
		
		fillCounterArray(s, sCounter);
		fillCounterArray(t, tCounter);
		
		return isAnagram(sCounter, tCounter);
	}
	
	private void test() {
		String s = "newyork times";
		String t = "monkeys writr";
		long start = System.currentTimeMillis();
		boolean result = isAnagram(s, t);
		long end = System.currentTimeMillis();
		
		System.out.println("result : " + result + " in " + (end - start) + " milliseconds");
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
