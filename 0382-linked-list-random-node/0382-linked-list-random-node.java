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
    List<Integer> ll;
    
    public Solution(ListNode head) {
        this.ll = new ArrayList<>();
        
        while(head != null){
            ll.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        Random rand = new Random();
        int idx = rand.nextInt(ll.size());
        return ll.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */