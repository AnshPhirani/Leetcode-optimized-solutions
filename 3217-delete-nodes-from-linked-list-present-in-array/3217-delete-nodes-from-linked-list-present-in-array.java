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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        
        while(head != null && set.contains(head.val)){
            head = head.next;
        }
        if(head == null) return head;
        
         ListNode newHead = head;
         while(head != null && head.next != null){
             if(set.contains(head.next.val)){
                 head.next = head.next.next;
             }
             else{
                head = head.next;
             }
             
         }
        
        return newHead; 
    }
}