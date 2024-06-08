class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sum%=k;
            if(map.containsKey(sum) && i-map.get(sum) >= 2)
                return true;
            if(!map.containsKey(sum)) map.put(sum, i);
     
        }
        return false;
    }
}