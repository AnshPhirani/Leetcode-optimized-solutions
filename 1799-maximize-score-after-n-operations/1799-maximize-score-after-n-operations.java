class Solution {
    
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
   
    private boolean isBitSet(int visited, int bitIdx){
        int mask = (1 << bitIdx);
        return ((visited&mask) != 0);
    }
    
    private int setBit(int visited, int bitIdx){
        return visited | (1 << bitIdx);
    }
    
    private Map<Integer, Integer> memo;
    
    private int helper(int[] nums, int visited, int operation){
        int n = nums.length;
        if(operation > n/2) return 0; 
        
        if(memo.containsKey(visited)) return memo.get(visited);
        
        int maxScore = 0;
        
        for(int i = 0; i < n; i++){
            if(isBitSet(visited, i)) continue;
            for(int j = i+1; j < n; j++){
                if(isBitSet(visited, j)) continue;
                
                int newVisited = visited;
                newVisited = setBit(newVisited, i);
                newVisited = setBit(newVisited, j);
                
                int curScore = operation * gcd(nums[i], nums[j]) + helper(nums, newVisited, operation+1);
                maxScore = Math.max(maxScore, curScore);
                
            }
        }
        
        memo.put(visited, maxScore);
        return maxScore;
    }
    
    public int maxScore(int[] nums) {
        int visited = 0;
        this.memo = new HashMap<>();
        return helper(nums, visited, 1);
    
    }
}