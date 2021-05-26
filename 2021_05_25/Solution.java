import java.util.Stack;

public class Solution {
	
	private boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}
	
	private int performOperation(int a, int b, String operator) {
		if (operator.equals("+")) {
			return a + b;
		} else if (operator.equals("-")) {
			return a - b;
		} else if (operator.equals("*")) {
			return a * b;
		}
		
		return a / b;
	}
	
	public int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<Integer>();
        
        for (int i = 0; i < tokens.length; i++) {
        	if (isOperator(tokens[i])) {
        		int b = numberStack.pop().intValue();
        		int a = numberStack.pop().intValue();
        		numberStack.push(performOperation(a, b, tokens[i]));
        	} else {
        		numberStack.push(Integer.valueOf(tokens[i]));
        	}
        }
        
        return numberStack.pop().intValue();
    }

	private void test() {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println("result : " + evalRPN(tokens));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
