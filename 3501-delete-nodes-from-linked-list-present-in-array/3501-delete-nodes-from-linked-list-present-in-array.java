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

        while(head != null && set.contains(head.val)) head = head.next;

        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(set.contains(cur.next.val)) cur.next = cur.next.next;
            else cur = cur.next; 
        }

        return head;
    }
}