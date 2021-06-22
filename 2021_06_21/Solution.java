import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascalList = new ArrayList<List<Integer>>();
		List<Integer> integerList = new ArrayList<Integer>();
		List<Integer> prevList = integerList;
		
		integerList.add(1);
		pascalList.add(integerList);
		
		for (int i = 1; i < numRows; i++) {
			integerList = new ArrayList<Integer>();
			integerList.add(1);
			
			for (int j = 0; j < i - 1; j++) {
				integerList.add(prevList.get(j) + prevList.get(j + 1));
			}
			
			integerList.add(1);
			pascalList.add(integerList);
			prevList = integerList;
		}
		
		return pascalList;
    }
	
	private void printList(List<List<Integer>> listOfList) {
		for (int i = 0; i < listOfList.size(); i++) {
			List<Integer> tempList = listOfList.get(i);
			
			for (int j = 0; j < tempList.size(); j++) {
				System.out.print(tempList.get(j) + " ");
			}
			
			System.out.println();
		}
	}
	
	private void test() {
		printList(generate(8));
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
