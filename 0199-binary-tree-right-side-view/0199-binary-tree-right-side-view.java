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
    
    private void dfs(TreeNode root, int level, List<Integer> rightSide){
        if(root == null) return;
        
        if(rightSide.size() == level){
            rightSide.add(root.val);
        }
        
        dfs(root.right, level+1, rightSide);
        dfs(root.left, level+1, rightSide);
        
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        dfs(root, 0, rightSide);
        return rightSide;
    }
}