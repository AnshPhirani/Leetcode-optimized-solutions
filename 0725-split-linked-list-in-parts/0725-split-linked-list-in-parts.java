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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        int groupLen = len/k;
        int extras = len%k;
        
        int idx = 0;
        while(idx < k){
            res[idx] = head;
            ListNode prev = null;
            for(int i =  0; i < groupLen && head != null; i++){
                prev = head;
                head = head.next;
            }
            if(extras > 0 && head != null) {
                prev = head;
                head = head.next;
                extras--;
            }
            
            if(prev != null) prev.next = null;
            idx++;
        }
        
        return res;
        
    }
}