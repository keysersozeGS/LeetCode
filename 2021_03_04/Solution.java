
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
	
	private ListNode getLastNode(ListNode head) {
		ListNode previous = null;
		
		while (head != null) {
			previous = head;
			head = head.next;
		}
		
		return previous;
	}
	
	private void invertList(ListNode head) {
		ListNode curr = head;
		ListNode previous = null;
		ListNode next;
		
		while (curr != null) {
			next = curr.next;
			curr.next = previous;
			previous = curr;
			curr = next;
		}
	}
	
	private ListNode getElementN(ListNode head, int n) {
		int counter = 0;
		
		while (counter < n) {
			head = head.next;
			counter++;
		}
		
		return head;
	}
	
	private void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		
		System.out.println();
	}
	 
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		ListNode lastNodeA = getLastNode(headA);
		ListNode lastNodeB = getLastNode(headB);
		
		if (lastNodeA != lastNodeB) {
			return null;
		}
		
		int sizeA = getListSize(headA);
		int sizeB = getListSize(headB);
		
		invertList(headA);
		int sizeC = getListSize(headB);
		int n = ((sizeA + sizeB + sizeC + 1) / 2) - (sizeA + 1);
		
		invertList(lastNodeA);
		
		return getElementN(headB, n);
    }

	private void test() {
		
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
