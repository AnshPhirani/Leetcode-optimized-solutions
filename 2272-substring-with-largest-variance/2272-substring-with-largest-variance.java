class Solution {
    
    private int kadane(String s){
        int res = 0;
        
        for(char first = 'a'; first <= 'z'; first++){
            for(char second = 'a'; second <= 'z'; second++){
                if(first == second) continue;
                // kadane's Algo
                int firstCount = 0, secondCount = 0;
                int maxSum = 0;
                int curSum = 0;
                for(char ch : s.toCharArray()){
                    if(ch == first) {
                        curSum++;
                        firstCount++;
                    }
                    else if(ch == second){
                        curSum--;
                        secondCount++;
                    }
                    
                    if(curSum < 0) {
                        curSum = firstCount = secondCount = 0;
                    }
                    if(firstCount > 0 && secondCount > 0)
                        maxSum = Math.max(maxSum, curSum);
                }
                res = Math.max(res, maxSum);
            }
        }
        
        return res;
    }
    
    public int largestVariance(String s) {
        int res = kadane(s);
        s = new StringBuilder(s).reverse().toString();
        res = Math.max(res, kadane(s));
        return res;
    }
}