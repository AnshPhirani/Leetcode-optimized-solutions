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
    
    public boolean isCompleteTree(TreeNode root) {
     
        Queue<TreeNode> que  = new LinkedList<>();
        que.add(root);

        boolean gotNullSoFar = false;
        
        while(!que.isEmpty()){
            TreeNode curr = que.poll();
            if(curr == null){
                gotNullSoFar = true;
            }
            else{
                if(gotNullSoFar) return false;
                que.add(curr.left);
                que.add(curr.right);   
            }
        }

        return true;
        
    }
}