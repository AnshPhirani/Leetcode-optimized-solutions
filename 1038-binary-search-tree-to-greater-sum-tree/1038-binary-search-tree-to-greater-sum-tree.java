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
    
    int treeSum;
    
    private int sum(TreeNode root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    
    private void buildGreaterTree(TreeNode root){
        if(root == null) return;
        buildGreaterTree(root.left);
        int temp = root.val;
        root.val = treeSum;
        treeSum -= temp;
        buildGreaterTree(root.right);
    }
    
    public TreeNode bstToGst(TreeNode root) {
        this.treeSum = sum(root);
        buildGreaterTree(root);
        return root;
    }
}