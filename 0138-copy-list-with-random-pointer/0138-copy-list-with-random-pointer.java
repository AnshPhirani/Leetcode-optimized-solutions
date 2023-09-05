/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    Map<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);
        
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.random = copyRandomList(head.random);
        newHead.next = copyRandomList(head.next);
        
        return newHead;
    }
}