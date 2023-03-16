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
    
    private TreeNode helper(int is, int ie, int ps, int pe, int[] inorder, int[] postorder){
        if(is > ie || ps > pe) return null;
        if(is == ie) return new TreeNode(inorder[is]);
        
        TreeNode root = new TreeNode(postorder[pe]);
        
        int rootLocInorder = 0;
        
        for(int i = is; i <= ie; i++){
            if(inorder[i] == root.val){
                rootLocInorder = i;
                break;
            } 
        }
        
        
        int lis = is;
        int lie = rootLocInorder-1;
        int ris = rootLocInorder+1;
        int rie = ie;
        
        int lps = ps;
        int lpe = ps + (lie-lis);
        int rps = lpe+1;
        int rpe = pe-1;
        
        root.left = helper(lis, lie, lps, lpe, inorder, postorder);
        root.right = helper(ris, rie, rps, rpe, inorder, postorder);
        
        return root;
        
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, inorder.length-1, 0, postorder.length-1, inorder, postorder);
    }
}