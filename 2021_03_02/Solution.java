
public class Solution {

	private void fillCounterArray(int[] counterArray, int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			counterArray[nums[i]]++;
		}
	}
	
	public int[] findErrorNums(int[] nums) {
		final int MAX = 10001;
		int[] resultArray = new int[2];
		int[] counterArray = new int[MAX];
		int index = 0;
		
		fillCounterArray(counterArray, nums);
		
		for (int i = 1; i < MAX && index < 2; i++) {
			if (counterArray[i] == 0) {
				resultArray[1] = i;
				index++;
			} else if (counterArray[i] == 2) {
				resultArray[0] = i;
				index++;
			}
		}
		
		return resultArray;
    }
	
	private void test() {
		int[] nums = {1, 2, 2, 4};
		int[] resultArray;
		
		resultArray = findErrorNums(nums);
		
		System.out.println("[0]: " + resultArray[0] + " - [1]: " + resultArray[1]);
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
