public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode previous = null;
        ListNode curr = head;
        ListNode listEnd = head;
        
        for (int i = 0; i < n; i++) {
        	listEnd = listEnd.next;
        }
        
        while (listEnd != null) {
        	previous = curr;
        	curr = curr.next;
        	listEnd = listEnd.next;
        }
        
        if (previous != null) {
        	previous.next = curr.next;
        	curr = null;
        } else {
        	head = curr.next;;
        }
        
        return head;
    }
	
	private void printList(ListNode head) {
    	ListNode curr = head;
    	
    	while (curr != null) {
    		System.out.print(curr.val + " ");
    		curr = curr.next;
    	}
    	
    	System.out.println();
    }
	
	private void test() {
		ListNode head = new ListNode(0);
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode t4 = new ListNode(4);
		
		head.next = t1;
		t1.next = t2;
		t2.next = t3;
		t3.next = t4;
		
		printList(head);
		head = removeNthFromEnd(head, 1);
		printList(head);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
