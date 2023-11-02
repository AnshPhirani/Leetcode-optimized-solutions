
class Solution {
    
    int ans = 0;
    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{0, 0};
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int totalNodes = 1 + left[0] + right[0];
        int totalSum = root.val + left[1] + right[1];
        
        if(totalSum/totalNodes == root.val) ans++;
        return new int[]{totalNodes, totalSum};
    }
    
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
}