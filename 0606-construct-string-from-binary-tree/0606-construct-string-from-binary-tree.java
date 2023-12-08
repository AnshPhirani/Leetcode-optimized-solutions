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
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        
        String cur = root.val + "";
        
        if(root.right == null && root.left == null){
            return cur;
        }
        else if(root.right == null){
            cur += "(" + tree2str(root.left)+ ")";
        }
        else if(root.left == null){
            cur += "()(" + tree2str(root.right)+ ")";
        }
        else{
            cur += "(" + tree2str(root.left)+ ")";
            cur += "(" + tree2str(root.right)+ ")";
        }
        
        return cur;
    }
}