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
    private void dfs(TreeNode root, String curPath, List<String> paths){
        if(root == null) return;
        
        
        
        if(root.left == null && root.right == null){
            curPath += root.val;
            paths.add(curPath);
            return;
        }
        
        curPath += root.val + "->";
        dfs(root.left, curPath, paths);
        dfs(root.right, curPath, paths);
        return;
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }
}