/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    private void helper(Node first, Node second){
        if(first == null || second == null) return;
        
        first.next = second;
        
        helper(first.left, first.right);
        helper(first.right, second.left);
        helper(second.left, second.right);
        
    }
    
    public Node connect(Node root) {
        if(root == null) return null;
        helper(root.left, root.right);
        return root;
    }
}