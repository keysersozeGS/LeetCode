
public class Solution {
	
	public int[] constructArray(int n, int k) {
        int[] resultArray = new int[n];
        int factor = 1;
        int i = 0;
        resultArray[0] = 1;
        
        for (i = 0; i < k; i++) {
        	resultArray[i + 1] = resultArray[i] + ((k - i) * factor);
        	factor *= -1;
        }
        
        k += 2;
        
        while ((i + 1) < n) {
        	resultArray[i + 1] = k;
        	k++;
        	i++;
        }
        
        return resultArray;
    }
	
	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
	}
	
	private void test() {
		printArray(constructArray(5, 4));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
