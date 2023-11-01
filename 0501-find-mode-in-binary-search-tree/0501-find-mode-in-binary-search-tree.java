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
    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        helper(root, freq);
        
        HashSet<Integer> modes = new HashSet();
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() == maxCount){
                modes.add(entry.getKey());
            }
        }
        
        int[] res = new int[modes.size()];
        int i = 0;
        for(int mode : modes){
            res[i++] = mode;
        }
        return res;
    }
    
    private void helper(TreeNode root, HashMap<Integer, Integer> freq){
        if(root == null) return;
        
        freq.put(root.val, freq.getOrDefault(root.val, 0)+1);
        maxCount = Math.max(maxCount, freq.get(root.val));
        
        helper(root.left, freq);
        helper(root.right, freq);
    }
}