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

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root, 1, findDepth(root));
    }

    private TreeNode dfs(TreeNode root, int curDepth, int maxDepth){
        if(root == null) return null;

        if(curDepth == maxDepth) return root;

        TreeNode left = dfs(root.left, curDepth+1, maxDepth);
        TreeNode right = dfs(root.right, curDepth+1, maxDepth);

        if(left != null && right != null) return root;
        else if(left == null) return right;
        else if(right == null) return left;
        return null;
    }

    private int findDepth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

}