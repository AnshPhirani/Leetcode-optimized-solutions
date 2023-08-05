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
    
    Map<Pair<Integer, Integer>, List<TreeNode>> memo;
    
    private List<TreeNode> helper(int start, int end){
        
        Pair<Integer, Integer> key = new Pair(start, end);
        if(memo.containsKey(key)) return memo.get(key);
        
        List<TreeNode> curAns = new ArrayList<>();
        
        if(start > end){
            curAns.add(null);
            return curAns;
        }
        
        for(int rootVal = start; rootVal <= end; rootVal++){
            List<TreeNode> leftAns = helper(start, rootVal-1);
            List<TreeNode> rightAns = helper(rootVal+1, end);
            for(TreeNode left : leftAns){
                for(TreeNode right : rightAns){
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    curAns.add(root);
                }
            }
        }
        
        memo.put(key, curAns);
        return curAns;
    }
    
    public List<TreeNode> generateTrees(int n) {
        this.memo = new HashMap<>();
        return helper(1, n);
    }
}