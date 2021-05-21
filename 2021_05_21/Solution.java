import java.util.ArrayList;
import java.util.List;

public class Solution {

	private void initCharArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = '-';
		}
	}
	
	private boolean isSamePattern(String word, String pattern) {
		char[] patternArray = new char[26];
		char[] wordArray = new char[26];
		char patternChar;
		char wordChar;
		
		initCharArray(patternArray);
		initCharArray(wordArray);
		
		for (int i = 0; i < word.length(); i++) {
			wordChar = word.charAt(i);
			patternChar = pattern.charAt(i);
			
			if (wordArray[(int)wordChar - 97] == '-' && patternArray[(int)patternChar - 97] == '-') {
				wordArray[(int)wordChar - 97] = patternChar;
				patternArray[(int)patternChar - 97] = wordChar;
			} else {
				if (wordArray[(int)wordChar - 97] == '-' || patternArray[(int)patternChar - 97] == '-') {
					return false;
				}
				else {
					if (wordArray[(int)wordChar - 97] != patternChar || patternArray[(int)patternChar - 97] != wordChar) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> strList = new ArrayList<String>();
        
        for (int i = 0; i < words.length; i++) {
        	if (isSamePattern(words[i], pattern)) {
        		strList.add(new String(words[i]));
        	}
        }
        
        return strList;
    }

	private void printPatternMatchList(List<String> strList) {
		for (int i = 0; i < strList.size(); i++) {
			System.out.print(strList.get(i) + " ");
		}
		
		System.out.println();
	}
	
	private void test() {
		String[] words = {"a", "b", "c"};
		printPatternMatchList(findAndReplacePattern(words, "a"));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
