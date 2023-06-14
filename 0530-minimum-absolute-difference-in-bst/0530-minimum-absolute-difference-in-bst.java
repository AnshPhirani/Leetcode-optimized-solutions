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
    
    int prev = -999999;
    int minDiff = Integer.MAX_VALUE;
    
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
    
        minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;
        
        inorder(root.right);
    }
    
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
}