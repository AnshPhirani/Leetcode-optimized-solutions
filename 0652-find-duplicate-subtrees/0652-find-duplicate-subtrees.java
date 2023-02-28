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
    
    
    private int dfs(TreeNode root, Map<Integer, Integer> freq, Map<String, Integer> tripletToId){
        if(root == null) return 0;
        
        int left = dfs(root.left, freq, tripletToId);
        int right = dfs(root.right, freq, tripletToId);
        
        String curTriplet = left + "," + root.val + "," + right; 
        
        tripletToId.putIfAbsent(curTriplet, tripletToId.size()+1);
        
        int curId = tripletToId.get(curTriplet);
        
        freq.put(curId, freq.getOrDefault(curId, 0) + 1);
        if(freq.get(curId) == 2) res.add(root);
        
        return curId;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, new HashMap<>(), new HashMap<>());
        return res;
    }
}