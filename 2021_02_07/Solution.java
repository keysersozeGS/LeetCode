import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	private int getMin(int a, int b) {
		if (b < a) {
			return b;
		}
		
		return a;
	}
	
	private List<Integer> getIndexList(String s, char c) {
		List<Integer> indexList = new ArrayList<Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				indexList.add(i);
			}
		}
		
		return indexList;
	}
	
	public int[] shortestToChar(String s, char c) {
		int[] distArray = new int[s.length()];
		List<Integer> indexList = getIndexList(s, c);
		int currentIndex = 0;
		int min = indexList.get(currentIndex);
		int max = indexList.get(currentIndex);
		int listSize = indexList.size();
		
        for (int i = 0; i < s.length(); i++) {
        	if ((currentIndex < listSize) && (i > indexList.get(currentIndex))) {
        		if ((currentIndex + 1) < listSize) {
        			max = indexList.get(currentIndex + 1);
        		}
        		
        		min = indexList.get(currentIndex);
        		currentIndex++;
        	}
        	
        	distArray[i] = getMin(Math.abs(i - min),  Math.abs(i - max));
        }
		
		return distArray;
    }

	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
	}
	
	private void test() {
		String s = "babaa";
		char c = 'b';
		
		printArray(shortestToChar(s, c));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
