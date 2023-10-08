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
    
    private TreeNode dfs(TreeNode root, int start, Map<TreeNode, TreeNode> parent){
        if(root == null) return null;
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);
        
        TreeNode left = dfs(root.left, start, parent);
        TreeNode right = dfs(root.right, start, parent);
        
        if(root.val == start) return root;
        else if(left != null) return left;
        else return right;
    }
    
    private int maxHeight(TreeNode root, Map<TreeNode, TreeNode> parent, Set<TreeNode> visited){
        if(root == null || visited.contains(root)) return 0;
        visited.add(root);
        
        int leftHeight = maxHeight(root.left, parent, visited);
        int rightHeight = maxHeight(root.right, parent, visited);
        int topHeight = maxHeight(parent.getOrDefault(root, null), parent, visited);
        return 1 + Math.max(topHeight, Math.max(leftHeight, rightHeight));
    }
    
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode newRoot = dfs(root, start, parent);
        
        return maxHeight(newRoot, parent, new HashSet<>())-1;
    }
}