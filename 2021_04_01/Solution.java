public class Solution {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	private int getListSize(ListNode head) {
		int size = 0;

		while (head != null) {
			size++;
			head = head.next;
		}

		return size;
	}
	
	public boolean isPalindrome(ListNode head) {
        int listSize = getListSize(head);
        
        if (listSize == 1) {
        	 return true;
        }
        
        int counter = 0;
        ListNode curr = head;
		ListNode previous = null;
		ListNode next = null;
        
        while (counter < (listSize / 2))
        {
        	next = curr.next;
        	curr.next = previous;
        	previous = curr;
        	curr = next;
        	
        	counter++;
        }
        
        if (listSize % 2 == 1) {
        	next = next.next;
        }
        
        counter = 0;
        
        while (counter < (listSize / 2)) {
        	if (previous.val != next.val) {
        		return false;
        	}
        	
        	previous = previous.next;
        	next = next.next;
        	
        	counter++;
        }
        
        return true;
    }
	
	private void test() {
		ListNode a = new ListNode(1);
		ListNode temp = new ListNode(2);
		a.next = temp;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(1);
		
		System.out.println("isPalindrome : " + isPalindrome(a));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
