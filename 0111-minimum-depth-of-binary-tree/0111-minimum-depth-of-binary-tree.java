
class Solution {
    
    private int dfs(TreeNode root){
        if(root == null) return 99999;
        if(root.left == null && root.right == null) return 1;
        return 1 + Math.min(dfs(root.left), dfs(root.right));
    }
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root);
    }
}