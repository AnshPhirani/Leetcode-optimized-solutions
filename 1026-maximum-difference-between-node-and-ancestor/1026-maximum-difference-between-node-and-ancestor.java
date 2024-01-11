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
class Solution {
    
    private int dfs(TreeNode root, int min, int max){
        if(root == null) return 0;
        int v = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
        int left = dfs(root.left, Math.min(min, root.val), Math.max(max, root.val));
        int right = dfs(root.right, Math.min(min, root.val), Math.max(max, root.val));
        return Math.max(v, Math.max(left, right));
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
}