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
    
    List<List<Integer>> res;
    
    private void dfs(TreeNode root, int level){
        if(root == null) return;
        
        if(level == res.size()) res.add(new ArrayList<>());
        
        res.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, 0);
        
        for(int i = 1; i < res.size(); i+=2) Collections.reverse(res.get(i));
        return res;
        
    }
}