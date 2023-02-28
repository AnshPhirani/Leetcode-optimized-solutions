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
    
    List<TreeNode> res;
    
    
    private String dfs(TreeNode root, Map<String, Integer> freq){
        if(root == null) return "";
        String leftSubtree = dfs(root.left, freq);
        String rightSubtree = dfs(root.right, freq);
        
        String curRepresentation = "(" + leftSubtree + ")" + root.val + "(" + rightSubtree + ")"; 
        
        freq.put(curRepresentation, freq.getOrDefault(curRepresentation, 0) + 1);
        if(freq.get(curRepresentation) == 2) res.add(root);
        
        return curRepresentation;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, new HashMap<>());
        return res;
    }
}