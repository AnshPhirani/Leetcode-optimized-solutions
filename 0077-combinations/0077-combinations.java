class Solution {
    
    List<List<Integer>> res;
    
    private void helper(int i, int n, int k, List<Integer> cur){
        if(cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(i > n) return;
        
        cur.add(i);
        helper(i+1, n, k, cur);
        cur.remove(cur.size()-1);
        
        helper(i+1, n, k, cur);
        
    }
    
    public List<List<Integer>> combine(int n, int k) {
        this.res=  new ArrayList<>();
        helper(1, n, k, new ArrayList<>());
        return res;
    }
}