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

// n == 0 return null;
// n == 1 return (0);

// n = 7;
// (0)
// (6, 0) (5, 1) (4, 2) (3, 3) (4, 2) (5, 1) (0, 6)




class Solution {
    List<TreeNode>[] memo = new ArrayList[21];

    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0) return new ArrayList<>(); // not possible
        
        if(memo[n] != null) return memo[n];
        
        if(n == 1) return List.of(new TreeNode(0));
            
        List<TreeNode> curPossible = new ArrayList<>();
        int remainingNodes = n-1;
        for(int i = 1; i <= remainingNodes; i+=2){
            List<TreeNode> leftPossible = allPossibleFBT(i);
            List<TreeNode> rightPossible = allPossibleFBT(remainingNodes-i);
            for(TreeNode leftSubTree : leftPossible){
                for(TreeNode rightSubTree : rightPossible){
                    TreeNode root = new TreeNode(0);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    curPossible.add(root);
                }
            }
        }
        memo[n] = curPossible;
        return curPossible;
    }
}