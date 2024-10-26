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
    
    int[] nodeLevel = new int[100001];
    int[] nodeHeight = new int[100001];
    int[][] top2Height = new int[100001][2];
    
    
    private int helper(TreeNode root, int level){
        if(root == null) return 0;
        
        int leftHeight = helper(root.left, level+1);
        int rightHeight = helper(root.right, level+1);
        
        int curHeight = 1 + Math.max(leftHeight, rightHeight);
        nodeHeight[root.val] = curHeight;
        nodeLevel[root.val] = level;
        if(curHeight >= top2Height[level][0]){
            top2Height[level][1] = top2Height[level][0];
            top2Height[level][0] = curHeight;
        }
        else if(curHeight > top2Height[level][1]) top2Height[level][1] = curHeight;
        
        return curHeight;
    }
    
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        helper(root, 0);
        
        
        int[] ans = new int[queries.length];
        int k = 0;
        for(int node : queries){
            int curNodeLevel = nodeLevel[node];
            int curNodeHeight = nodeHeight[node];
            int maxHeight = top2Height[curNodeLevel][0] == curNodeHeight ? top2Height[curNodeLevel][1] : top2Height[curNodeLevel][0];

            ans[k++] = maxHeight + curNodeLevel - 1;
        }
        
        return ans;
    }
}