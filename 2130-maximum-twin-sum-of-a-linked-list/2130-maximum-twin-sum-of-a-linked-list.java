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
    
    public int pairSum(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;   
        ListNode first = head;
        ListNode second = reverse(slow);
    
        int ans = 0;
        while(first != null){
            ans = Math.max(ans, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return ans;
    }
}