
public class Solution {
	
	private void fillAlphabetArray(boolean[] alphabet, String word) {
		for (int i = 0; i < word.length(); i++) {
			alphabet[(int)word.charAt(i) - 97] = true;
		}
	}
	
	private boolean areSeparateLetters(boolean[] alphabet, String word) {
		for (int i = 0; i < word.length(); i++) {
			if (alphabet[(int)word.charAt(i) - 97] == true) {
				return false;
			}
		}
		
		return true;
	}
	
	private void initAlphabetArray(boolean[] alphabet) {
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = false;
		}
	}
	
	public int maxProduct(String[] words) {
		boolean[] alphabet = new boolean[26];
		int arrayLen = words.length;
		int max = 0;
		
        for (int i = 0; i < arrayLen - 1; i++) {
        	int firstStrLen = words[i].length();
        	initAlphabetArray(alphabet);
        	fillAlphabetArray(alphabet, words[i]);
        	
        	for (int j = i + 1; j < arrayLen; j++) {
        		int temp = firstStrLen * words[j].length();
        		
        		if (temp > max && areSeparateLetters(alphabet, words[j])) {
        			max = temp;
        		}
        	}
        }
        
        return max;
    }
	
	private void test() {
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		
		System.out.println("max : " + maxProduct(words));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
