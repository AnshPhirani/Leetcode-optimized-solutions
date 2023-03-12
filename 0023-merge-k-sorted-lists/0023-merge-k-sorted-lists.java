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

    private ListNode mergeLL(ListNode first, ListNode second){
        ListNode head = new ListNode(-1);
        ListNode curr = head;
            
        while(first != null && second != null){
            if(first.val <= second.val){
                curr.next = first;
                first = first.next;
            }
            else{
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        
        if(first != null) curr.next = first;
        if(second != null) curr.next = second;
        
        return head.next;
        
    }
    
    private ListNode mergeSort(ListNode[] lists, int s, int e){
        if(s > e) return null;
        if(s == e) return lists[s];
        
        int mid = (s+e)/2;
        ListNode first = mergeSort(lists, s, mid);
        ListNode second = mergeSort(lists, mid+1, e);
        return mergeLL(first, second);
    }
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        
        return mergeSort(lists, 0, n-1);
        
    }
}