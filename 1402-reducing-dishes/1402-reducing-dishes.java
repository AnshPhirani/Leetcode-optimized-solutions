class Solution {
    
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        
        int sum = 0;
        int start = n-1;
        while(start >= 0 && sum + satisfaction[start] >= 0){
            sum += satisfaction[start];
            start--;
        }
        
        start++;
        
        int res = 0;
        int time = 1;
        while(start < n){
            res += time*satisfaction[start];
            time++;
            start++;
        }
        
        return res;
    }        
}