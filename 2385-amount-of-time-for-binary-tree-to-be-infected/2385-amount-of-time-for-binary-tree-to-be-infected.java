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
    
    private TreeNode buildParent(TreeNode root, Map<TreeNode, TreeNode> parent, int start){
        if(root == null) return null;
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);
        TreeNode left = buildParent(root.left, parent, start);
        TreeNode right = buildParent(root.right, parent, start);
        
        if(root.val == start) return root;
        return (left != null) ? left : right;
    }
    
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startNode = buildParent(root, parent, start);
        parent.put(root, null);
        
        // bfs
        Queue<TreeNode> que = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        visited.add(startNode);
        que.add(startNode);
        int level = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                TreeNode cur = que.poll();
                if(cur.left != null && !visited.contains(cur.left)){
                    que.add(cur.left);
                    visited.add(cur.left);
                }
                if(cur.right != null && !visited.contains(cur.right)){
                    que.add(cur.right);
                    visited.add(cur.right);
                }
                if(parent.getOrDefault(cur, null) != null && !visited.contains(parent.get(cur))){
                    que.add(parent.get(cur));
                    visited.add(parent.get(cur));
                }
            }
            level++;
        }
        
        return level-1;
        
    }
}