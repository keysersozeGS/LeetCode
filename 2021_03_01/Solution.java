import java.util.HashSet;


public class Solution {

	private int getMin(int a, int b) {
		if (a < b) {
			return a;
		}
		
		return b;
	}
	
	public int distributeCandies(int[] candyType) {
        int maxCandyType = candyType.length / 2;
        HashSet<Integer> candySet = new HashSet<Integer>();
        
        for (int i = 0; i < candyType.length; i++) {
        	candySet.add(candyType[i]);
        }
        
        return getMin(maxCandyType, candySet.size());
    }
	
	private void test() {
		int[] candyType = {6,6,6,6};
		
		System.out.println("result : " + distributeCandies(candyType));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
