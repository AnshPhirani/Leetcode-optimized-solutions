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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        int maxSum = Integer.MIN_VALUE, maxSumLevel = 0;
        
        while(!que.isEmpty()){
            int size = que.size();
            int curSum = 0;
            while(size-- > 0){
                TreeNode cur = que.poll();
                curSum += cur.val;
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
            if(curSum > maxSum){
                maxSum = curSum;
                maxSumLevel = level;
            }
            level++;
        }
        
        return maxSumLevel;
        
    }
}