class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int ans = 0;
        for(int num : freq.keySet()){
            int count = freq.get(num);
            if(count == 1) return -1;
            ans += count/3;
            if(count%3 != 0) ans++;
        }
        return ans;
        
    }
}