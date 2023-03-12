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

    
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(int i = 0; i < n; i++){
            if(lists[i] != null) pq.add(lists[i]);
        }
        
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = curr;
            
            if(curr.next != null) pq.add(curr.next);
            
        }
        
        return head.next;
        
        
    }
}