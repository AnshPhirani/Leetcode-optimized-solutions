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
    
    private void leafSeq(TreeNode root, List<Integer> seq){
        if(root == null) return;
        if(root.left == null && root.right == null){
            seq.add(root.val);
            return;
        }
        leafSeq(root.left, seq);
        leafSeq(root.right, seq);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        leafSeq(root1, first);
        leafSeq(root2, second);
        return first.equals(second);
    }
}