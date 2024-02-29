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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 0;
        while(!que.isEmpty()){
            int size = que.size();
            int prevVal = level%2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(size-- > 0){
                TreeNode cur = que.poll();
                int curVal = cur.val;
                if(level%2 == 0 && !(curVal > prevVal && curVal%2 == 1)) return false;
                if(level%2 == 1 && !(curVal < prevVal && curVal%2 == 0)) return false;
                prevVal = curVal;
                
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
            level++;
        }
        
        return true;
    }
}