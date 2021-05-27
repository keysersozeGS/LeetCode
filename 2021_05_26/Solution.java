class Solution {
    public int minPartitions(String n) {
        int min = 1;
        
        for (int i = 0; i < n.length(); i++) {
            int digit = (int)n.charAt(i) - 48;
            if (digit > min) {
                min = digit;
            }
        }
        
        return min;
    }
	
	private void test() {
		String n = "27346209830709182346";
		
		System.out.println("result : " + minPartitions(n));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
