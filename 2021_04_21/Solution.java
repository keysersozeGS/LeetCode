import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	private int getMin(int a, int b) {
		if (a < b) {
			return a;
		}
		
		return b;
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int listSize = triangle.size();
		List<Integer> lastRow = triangle.get(listSize - 1);
        int[] totalArray = new int[lastRow.size()];
        
        for (int i = 0; i < lastRow.size(); i++) {
        	totalArray[i] = lastRow.get(i).intValue();
        }
        
        for (int i = listSize - 2; i >= 0; i--) {
        	List<Integer> currentRow = triangle.get(i);
        	
        	for (int j = 0; j < currentRow.size(); j++) {
        		totalArray[j] = currentRow.get(j).intValue() + getMin(totalArray[j], totalArray[j + 1]);
        	}
        }
        
        return totalArray[0];
    }

	private void test() {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		triangle.add(a);
		
		a = new ArrayList<Integer>();
		a.add(3);
		a.add(4);
		triangle.add(a);
		
		a = new ArrayList<Integer>();
		a.add(6);
		a.add(5);
		a.add(7);
		triangle.add(a);
		
		a = new ArrayList<Integer>();
		a.add(4);
		a.add(1);
		a.add(8);
		a.add(3);
		triangle.add(a);
		
		System.out.println("min total : " + minimumTotal(triangle));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
