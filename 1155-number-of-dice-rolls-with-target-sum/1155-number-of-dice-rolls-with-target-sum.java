class Solution {
    
    Map<String, Integer> memo = new HashMap<>();
    
    public int numRollsToTarget(int n, int k, int target) {
        if(target < 0) return 0;
        if(n == 0) return target == 0 ? 1 : 0;
        
        String key = n+"*"+target;
        if(memo.containsKey(key)) return memo.get(key);
        
        int MOD = (int)1e9+7;
        int count = 0;
        for(int face = 1; face <= k; face++){
            count += numRollsToTarget(n-1, k, target-face);
            count %= MOD;
        }
        
        memo.put(key, count);
        return count;
    }
}