class Solution {
    
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    
    private Map<String, Integer> memo;
    
    private int helper(int[] nums, boolean[] visited, int operation){
        int n = nums.length;
        if(operation > n/2) return 0; 
        
        String key = Arrays.toString(visited);
        if(memo.containsKey(key)) return memo.get(key);
        
        int maxScore = 0;
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            for(int j = i+1; j < n; j++){
                if(visited[j]) continue;
                
                visited[i] = visited[j] = true;
                int curScore = operation * gcd(nums[i], nums[j]) + helper(nums, visited, operation+1);
                maxScore = Math.max(maxScore, curScore);
                visited[i] = visited[j] = false; // backtrack
            }
        }
        
        memo.put(key, maxScore);
        return maxScore;
    }
    
    public int maxScore(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        this.memo = new HashMap<>();
        return helper(nums, visited, 1);
    
    }
}