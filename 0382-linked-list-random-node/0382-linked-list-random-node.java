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
    
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int i = 1, res = head.val;
        ListNode cur = head.next;
        while(cur != null){
            if(rand.nextInt(0, i+1) == 0){
                res = cur.val;
            }
            cur = cur.next;
            i++;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */