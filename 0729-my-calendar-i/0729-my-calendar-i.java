class ListNode {
    int start;
    int end;
    ListNode next;

    public ListNode(int s, int e) {
        start = s;
        end = e;
        next = null;
    }
}

class MyCalendar {
    ListNode head;

    public MyCalendar() {
        head = new ListNode(-1, -1);
    }


     private boolean addToList(ListNode head, int start, int end){
        ListNode prev = head;
        head = head.next;
        while (head != null) {
            if (start >= prev.end && end <= head.start) {
                break;
            }
            prev = head;
            head = head.next;
        }
        
        if(start >= prev.end){
            ListNode newNode = new ListNode(start, end);
            prev.next = newNode;
            newNode.next = head;
            return true;
        }

        return false;
    }

    public boolean book(int start, int end) {
        return addToList(head, start, end);
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
