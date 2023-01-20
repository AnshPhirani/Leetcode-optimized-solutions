class Solution {
    Set<List<Integer>> res;
    
    private void helper(int idx, int[] nums, List<Integer> curSeq){
        if(idx == nums.length){
            if(curSeq.size() >= 2) res.add(new ArrayList<>(curSeq));
            return;
        }
        
        // include curr element
        if(curSeq.size() == 0 || nums[idx] >= curSeq.get(curSeq.size()-1)){
            curSeq.add(nums[idx]);
            helper(idx+1, nums, curSeq);
            curSeq.remove(curSeq.size()-1);
        }
        
        // skip curr element
        helper(idx+1, nums, curSeq);
        
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new HashSet<>();
        helper(0, nums, new ArrayList<>());
        
        return new ArrayList<>(res);
        
    }
}