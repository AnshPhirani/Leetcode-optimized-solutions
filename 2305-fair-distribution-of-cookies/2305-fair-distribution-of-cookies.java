class Solution {
    
    private int dfs(int idx, int[] cookies, int[] cookiesSum){
        if(idx == cookies.length){
            int unfairness = 0;
            for(int count : cookiesSum) unfairness = Math.max(unfairness, count);
            return unfairness;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < cookiesSum.length; i++){
            cookiesSum[i] += cookies[idx];
            ans = Math.min(ans, dfs(idx+1, cookies, cookiesSum));
            cookiesSum[i] -= cookies[idx];
        }
        return ans;
    }
    
    public int distributeCookies(int[] cookies, int k) {
        int[] cookiesSum = new int[k];
        return dfs(0, cookies, cookiesSum);
    }
}