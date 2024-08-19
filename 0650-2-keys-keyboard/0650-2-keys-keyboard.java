class Solution {
    
    
    private int helper(int str, int copy, int n){
        if(str == n) return 0;
        if(str > n) return 99999999;
        
        // paste and don't copy current screen 
        int withOutCopy = helper(str+copy, copy, n);
        
        // paste and copy the current scrren
        int withCopy = helper(str+copy, str+copy, n);
        
        return Math.min(1 + withOutCopy, 2 + withCopy);
    }
    
    
    public int minSteps(int n) {
        if(n == 1) return 0;
        return 1 +helper(1, 1, n);
        
    }
}