class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) freq.put(num, freq.getOrDefault(num, 0)+1);

        int ans = 0;
        for(int key : freq.keySet()){
            int count = freq.get(key);
            if(freq.containsKey(key-1)){
                ans = Math.max(ans, count+freq.get(key-1));
            }
            if(freq.containsKey(key+1)){
                ans = Math.max(ans, count+freq.get(key+1));
            }
        }

        return ans;
    }
}