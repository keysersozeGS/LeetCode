import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public int leastBricks(List<List<Integer>> wall) {
        int maxVal = 0;
		Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
        
		for (int i = 0; i < wall.size(); i++) {
			int sum = 0;
			List<Integer> currentRow = wall.get(i);
			
			for (int j = 0; j < currentRow.size() - 1; j++) {
				sum += currentRow.get(j).intValue();
				Integer brickCount = counterMap.get(sum);
				if (brickCount == null) {
					brickCount = 0;
				}
				
				brickCount++;
				counterMap.put(sum, brickCount);
				
				if (brickCount > maxVal) {
					maxVal = brickCount;
				}
			}
		}
		
		return wall.size() - maxVal;
    }
	
	private void test() {
		List<List<Integer>> wall = new ArrayList<List<Integer>>();
		wall.add(Arrays.asList(1, 2, 2, 1));
		wall.add(Arrays.asList(3, 1, 2));
		wall.add(Arrays.asList(1, 3, 2));
		wall.add(Arrays.asList(2, 4));
		wall.add(Arrays.asList(3, 1, 2));
		wall.add(Arrays.asList(1, 3, 1, 1));
		
		System.out.println("leastBricks : " + leastBricks(wall));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
