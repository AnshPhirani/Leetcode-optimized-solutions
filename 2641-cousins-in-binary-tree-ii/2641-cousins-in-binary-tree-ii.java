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
    
    private int[] levelSums = new int[100000];
    
    private void calcLevelSum(TreeNode root, int level){
        if(root == null) return;
        
        levelSums[level] += root.val;
        calcLevelSum(root.left, level+1);
        calcLevelSum(root.right, level+1);
    }
    
    private void helper(TreeNode root, int siblingSum, int level){
        if(root == null) return;
        
        if(level <= 1) {
            root.val = 0;
        }
        else{
            root.val = levelSums[level] - (root.val + siblingSum);
        }
        
        int leftChildVal = root.left == null ? 0 : root.left.val;
        int rightChildVal = root.right == null ? 0 : root.right.val;
        
        helper(root.left, rightChildVal, level+1);
        helper(root.right, leftChildVal, level+1);
    }
    
    public TreeNode replaceValueInTree(TreeNode root) {
        calcLevelSum(root, 0);
        helper(root, 0, 0);
        return root;
    }
}