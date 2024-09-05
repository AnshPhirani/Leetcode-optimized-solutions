class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int rollsSum = Arrays.stream(rolls).sum();
        int targetSum = mean*(n+m) - rollsSum;
        
        if(targetSum < n || targetSum > n*6) return new int[]{};
        
        int avg = targetSum/n;
        int[] ans = new int[n];
        for(int i= 0; i < n; i++){
            ans[i] = avg;
            targetSum -= avg;
        }
        
        int i = 0;
        while(targetSum > 0){
            ans[i++]++;
            targetSum--;
        }
        
        return ans;
    }
}