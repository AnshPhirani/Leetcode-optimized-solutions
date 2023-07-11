/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent;
    
    private void dfs(TreeNode cur, TreeNode p){
        if(cur == null) return;
        
        parent.put(cur, p);
        dfs(cur.left, cur);
        dfs(cur.right, cur);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.parent = new HashMap<>();
        dfs(root, null);
        
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(target);
        visited.add(target);
        
        List<Integer> res = new ArrayList<>();
        
        while(!que.isEmpty() && k > 0){
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
                TreeNode parentNode = parent.get(cur);
                if(parentNode != null && !visited.contains(parentNode)){
                    que.add(parentNode);
                    visited.add(parentNode);
                }
            }
            k--;
        }
        
        while(!que.isEmpty()) res.add(que.poll().val);
        return res;
        
    }
}