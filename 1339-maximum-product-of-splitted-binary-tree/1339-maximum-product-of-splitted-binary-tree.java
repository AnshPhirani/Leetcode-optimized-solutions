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

    private static final int MOD = (int)1e9 + 7;
    private long ans, totalSum;

    public int maxProduct(TreeNode root) {
        this.ans = Integer.MIN_VALUE;
        this.totalSum = getTotalSum(root);
        dfs(root);
        return (int)(ans%MOD);
    }

    private long getTotalSum(TreeNode root){
        if(root == null) return 0;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }

    private long dfs(TreeNode root){
        if(root == null) return 0;
        long leftSum = dfs(root.left);
        long rightSum = dfs(root.right);

        // remove the left edge of current subtree
        long firstSplitSum = leftSum;
        long secondSplitSum = totalSum-leftSum;
        ans = Math.max(ans, (firstSplitSum * secondSplitSum));

        // remove the right edge of current subtree
        firstSplitSum = totalSum-rightSum;
        secondSplitSum = rightSum;
        ans = Math.max(ans, (firstSplitSum * secondSplitSum));

        return root.val + leftSum + rightSum;
    }

}