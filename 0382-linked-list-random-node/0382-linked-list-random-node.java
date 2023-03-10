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
    ListNode head;
    int size;
    
    public Solution(ListNode head) {
        this.head = head;
        this.size = 0;
        
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
    }
    
    public int getRandom() {
        Random rand = new Random();
        
        int idx = rand.nextInt(size);
        ListNode temp = head;
        while(idx-- > 0) temp = temp.next;
        
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */