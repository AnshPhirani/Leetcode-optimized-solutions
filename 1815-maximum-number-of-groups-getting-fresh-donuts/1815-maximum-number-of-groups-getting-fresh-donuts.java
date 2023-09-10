class Solution {

    int batchSize;
    Map<String, Integer> memo;
    
    private int helper(int remaining, int[] freq){
        
        String key = Arrays.toString(freq);
        if(memo.containsKey(key)) return memo.get(key);
        
        int ans = 0;
        for(int val = 1; val < batchSize; val++){
            if(freq[val] > 0){
                freq[val]--;
                int newRemaining = (remaining-val+batchSize)%batchSize;
                int smallAns = helper(newRemaining, freq) + (remaining == 0 ? 1 : 0);
                ans = Math.max(ans, smallAns);
                freq[val]++;
            }
        }
        
        memo.put(key, ans);
        return ans;
    }
    
    public int maxHappyGroups(int batchSize, int[] groups) {

        int[] freq = new int[batchSize];
        for(int groupCount : groups) freq[groupCount%batchSize]++;
        
        int ans = freq[0];
        
        for(int i = 1; i <= batchSize/2; i++){
            int j = batchSize - i;
            int minFreq = (i == j) ? freq[i]/2 : Math.min(freq[i], freq[j]);
            
            ans += minFreq;
            freq[i] -= minFreq;
            freq[j] -= minFreq;
        }
        
        
        this.memo = new HashMap<>();
        this.batchSize = batchSize;
        
        ans += helper(0, freq);
        return ans;
    }
}