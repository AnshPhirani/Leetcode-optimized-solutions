class Solution {
    Map<String, Integer> memo;
    
    private int helper(int idx, int k, int prevEnd, int[][] events){
        if(k == 0 || idx == events.length) return 0;
        
        String key = idx+"*"+k+"*"+prevEnd;
        if(memo.containsKey(key)) return memo.get(key);
        
        
        // attend current event
        int attend = events[idx][0] > prevEnd ? events[idx][2] + helper(idx+1, k-1, events[idx][1], events) : 0;
        
        // skip current event
        int skip = helper(idx+1, k, prevEnd, events);              
        
        memo.put(key, Math.max(attend, skip));
        return memo.get(key);
    }
    
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0]-b[0]);
        this.memo = new HashMap<>();
        return helper(0, k, -1, events);       
    }
}