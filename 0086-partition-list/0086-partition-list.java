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
    public ListNode partition(ListNode head, int x) {
        ListNode first = null, second = null;
        ListNode firstHead = null, secondHead = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next = null;
            
            if(head.val < x){
                if(first == null){
                    firstHead = head;
                    first = head;
                }
                else{
                    first.next = head;
                    first = head;
                }
            }
            else{
                if(second == null){
                    secondHead = head;
                    second = head;
                }
                else{
                    second.next = head;
                    second = head;
                }
            }
            head = next;
        }
        
        if(firstHead == null) return secondHead;
        first.next = secondHead;
        return firstHead;
    }
}