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
    int ans;
    int maxLevel;
    
    private void dfs(TreeNode root, int level ){
        if(root == null) return;
        if(level > maxLevel){
            maxLevel = level;
            ans = root.val;
        }
        if(root.left != null) dfs(root.left, level+1);
        if(root.right != null) dfs(root.right, level+1);
        
    }
    
    public int findBottomLeftValue(TreeNode root) {
        this.maxLevel = -1;
        this.ans = root.val;
        dfs(root, 0);
        return ans;
    }
}