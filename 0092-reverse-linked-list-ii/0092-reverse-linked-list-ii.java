/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode smallAns = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return smallAns;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        
        int pos = 1;
        ListNode cur = head;
        ListNode prev = null;

        while(pos < left){
            prev = cur;
            cur = cur.next;
            pos++;
        }
        if(prev != null)
            prev.next = null;
        ListNode leftEnd = prev;
        
        
        ListNode start = cur;
        prev = null;
        while(pos <= right){
            prev = cur;
            cur = cur.next;
            pos++;
        }
        prev.next = null;
        ListNode end = prev;
        
        ListNode reversed = reverse(start);
    
        if(left == 1){
            start.next = cur;
            return reversed;
        }
        else{
            leftEnd.next = reversed;
            start.next = cur;
            return head;
        }
        
    }
}