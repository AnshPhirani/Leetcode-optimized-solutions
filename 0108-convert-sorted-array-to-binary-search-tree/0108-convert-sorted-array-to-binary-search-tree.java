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
    
    private TreeNode helper(int l, int r, int[] nums){
        if(l > r) return null;
        int mid = (l+r)/2;
        int val = nums[mid];
        TreeNode root = new TreeNode(val);
        root.left = helper(l, mid-1, nums);
        root.right = helper(mid+1, r, nums);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length-1, nums);
    }
}