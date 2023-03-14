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
    
    private int helper(TreeNode root, int curNum){
        if(root == null) return 0;
        
        int temp = curNum*10 + root.val;
        
        if(root.left == null && root.right == null) {
            return temp;
        }
        
        return helper(root.left, temp) + helper(root.right, temp);
        
    }
    
    public int sumNumbers(TreeNode root) {  
        return helper(root, 0);
        
    }
}