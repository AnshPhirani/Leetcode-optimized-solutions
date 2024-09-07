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
    
    private void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode smallAns = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return smallAns;
    }
    
    public void reorderList(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        
        ListNode first = head;
        temp = head;
        int i = 0;
        while(i++ < n/2-1){
            temp = temp.next;
        }
        
        ListNode second = temp.next;
        temp.next = null;
        second = reverse(second);
    
        
        head = new ListNode(-1);
        while(first != null && second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            head.next = first;
            head = head.next;
            head.next = second;
            head = head.next;
            first = firstNext;
            second = secondNext;
        }
        
    }
}