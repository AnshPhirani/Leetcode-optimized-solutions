class Solution {
    
    List<List<Integer>> res;
    
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void helper(int i, int[] nums, List<Integer> cur){
        if(i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int j = i; j < nums.length; j++){
            swap(i, j, nums);
            cur.add(nums[i]);
            helper(i+1, nums, cur);
            cur.remove(cur.size()-1);
            swap(i, j, nums);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        this.res=  new ArrayList<>();
        helper(0, nums, new ArrayList<>());
        return res;
    }
}