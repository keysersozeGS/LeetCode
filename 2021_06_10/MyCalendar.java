
public class MyCalendar {

	public class ListNode {
		int start;
		int end;
		ListNode next;
		ListNode() {}
		ListNode(int start, int end) { this.start = start; this.end = end;}
		ListNode(int start, int end, ListNode next) { this.start = start; this.end = end; this.next = next; }
	}
	
	ListNode head;
	
	public MyCalendar() {
        head = null;
    }
    
	private ListNode insert(int start, int end, ListNode next) {
		return new ListNode(start, end, next);
	}
	
    public boolean book(int start, int end) {
        ListNode current = head;
        ListNode prev = null;
        
        while (current != null) {
        	if (end <= current.start) {
        		if (prev == null) {
        			head = insert(start, end, current);
        			return true;
        		} else {
        			prev.next = insert(start, end, current);
        			return true;
        		}
        	} else if (start < current.end) {
        		return false;
        	}
        	
        	prev = current;
        	current = current.next;
        }
        
        if (head == null) {
        	head = insert(start, end, current);
        } else {
        	prev.next = insert(start, end, current);
        }
        
        return true;
    }
}
