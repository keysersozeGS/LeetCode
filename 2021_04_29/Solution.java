
public class Solution {

	private int binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid = (high + low) / 2;
		
		while (low <= high) {
			if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				return mid;
			}
			
			mid = (high + low) / 2;
		}
		
		return -1;
	}
	
	private int getMinIndex(int[] nums, int index, int target) {
		int minIndex = index;
		index--;
		
		while (index >= 0 && nums[index] == target) {
			minIndex = index;
			index--;
		}
		
		return minIndex;
	}
	
	private int getMaxIndex(int[] nums, int index, int target) {
		int maxIndex = index;
		index++;
		
		while (index < nums.length && nums[index] == target) {
			maxIndex = index;
			index++;
		}
		
		return maxIndex;
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		int index = binarySearch(nums, target);
		
		if (index != -1) {
			result[0] = getMinIndex(nums, index, target);
			result[1] = getMaxIndex(nums, index, target);
		} else {
			result[0] = -1;
			result[1] = -1;
		}
		
        return result;
    }
	
	private void test() {
		int[] nums = {5,7,7,8,8,10};
		int[] result = searchRange(nums, 5);
		
		System.out.println("result index : [" + result[0] + ", " + result[1] + "]");
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
