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
    public ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        
        ListNode kthBeg = null;
        ListNode kthEnd = null;
        
        while(temp != null){
            len++;
            if(len == k) kthBeg = temp;
            temp = temp.next;
        }
        
        temp = head;
        k = len-k;
        while(k > 0){
            temp = temp.next;
            k--;
        }
        
        kthEnd = temp;
        
        // swapping values
        int t = kthBeg.val;
        kthBeg.val = kthEnd.val;
        kthEnd.val = t;
        
        return head;
    }
}