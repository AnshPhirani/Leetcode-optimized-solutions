class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> dp = new HashMap<>();
        
        int ans = 0;
        for(int num : arr){
            if(dp.containsKey(num-difference)){
                dp.put(num, dp.get(num-difference)+1);
            }
            else{
                dp.put(num, 1);
            }
            ans = Math.max(ans, dp.get(num));
        }
        
        return ans;
    }
}