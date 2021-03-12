
public class Solution {

	private boolean allNumberExist(boolean[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == false) {
				return false;
			}
		}
		
		return true;
	}
	
	private int getIntValueOfBinaryString(String s) {
		int total = 0;
		
		for (int i = 0; i < s.length(); i++) {
			total *= 2;
			total += (int)s.charAt(i) - 48;
		}
		
		return total;
	}
	
	public boolean hasAllCodes(String s, int k) {
		int lenS = s.length();
		int size = (int)Math.pow(2, k);
        boolean[] counterArray = new boolean[size];
        
        if (lenS > k) {
        	int value = getIntValueOfBinaryString(s.substring(0, k));
        	counterArray[value] = true;
        	
        	for (int i = k; i < lenS; i++) {
        		value *= 2;
        		value %= size;
        		value += (int)s.charAt(i) - 48;
        		counterArray[value] = true;
        	}
        }
        
        return allNumberExist(counterArray);
    }
	
	private void test() {
		String s = "0000000001011100";
		int k = 4;
		
		System.out.println("result : " + hasAllCodes(s, k));
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
