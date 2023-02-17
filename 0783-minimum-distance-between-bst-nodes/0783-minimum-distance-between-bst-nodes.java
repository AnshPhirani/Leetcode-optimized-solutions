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
    int minDiff= Integer.MAX_VALUE;
    int prev = -9999999;
    
    public int minDiffInBST(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        
        minDiffInBST(root.left);
        
        minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;
        
        minDiffInBST(root.right);
        
        return minDiff;
    }
}