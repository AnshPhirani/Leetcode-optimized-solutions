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

    int maxLength = 0;
    
    private void dfs(TreeNode root, int direction, int curLength){
        if(root == null) return;
        maxLength = Math.max(maxLength, curLength);
        if(direction==1){
            dfs(root.left,0,curLength+1);
            dfs(root.right,1,1);
        }
        else{
            dfs(root.right,1,curLength+1);
            dfs(root.left,0,1);
        }
    }
    
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        dfs(root, 1, 0);
        return maxLength;
    }
}