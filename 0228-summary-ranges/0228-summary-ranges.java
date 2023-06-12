class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new ArrayList<>();
        
        if(nums.length == 0) return res;
        
        int s = 0;
        int e = 1;
        while(e < nums.length){
            if(nums[e-1] + 1 == nums[e]){
                e++;
            }
            else{
                if(s+1 == e){
                    res.add("" + nums[s]);
                }
                else{
                    res.add(nums[s] + "->" + nums[e-1]);
                }
                s = e;
                e++;
            }
        }
        
        if(s+1 == e){
            res.add("" + nums[s]);
        }
        else{
            res.add(nums[s] + "->" + nums[e-1]);
        }
        
        return res;
    }
}