/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    TreeNode node;
    int xAxis;
    public Pair(TreeNode node, int x){
        this.node = node;
        this.xAxis = x;        
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(root, 1));
        int maxWidth = 0;
        
        while(!que.isEmpty()){
            int size = que.size();
            maxWidth = Math.max(maxWidth, que.peekLast().xAxis-que.peekFirst().xAxis+1);
            while(size-- > 0){
                Pair cur = que.pollFirst();
                if(cur.node.left != null) que.addLast(new Pair(cur.node.left, cur.xAxis*2));
                if(cur.node.right != null) que.addLast(new Pair(cur.node.right, cur.xAxis*2+1));
            }
        }
        
        return maxWidth;
    }
}