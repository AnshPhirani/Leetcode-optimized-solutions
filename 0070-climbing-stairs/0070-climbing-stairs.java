class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        
        int first = 1, second = 2;
        for(int stair = 3; stair <= n; stair++){
            int cur = first + second;
            first = second;
            second = cur;
        }
        return second;
    }
}