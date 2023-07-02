class Solution {
    
    private int dfs(int idx, int[] degree, int[][] requests){
        if(idx == requests.length){
            for(int d : degree) if(d != 0) return Integer.MIN_VALUE;
            return 0;
        }
        
        int ans = Integer.MIN_VALUE;
        int from = requests[idx][0];
        int to = requests[idx][1];
        
        // approve current request
        degree[from]--;
        degree[to]++;
        ans = Math.max(ans, 1 + dfs(idx+1, degree, requests));
        degree[from]++;
        degree[to]--;
        
        // decline current request
        ans = Math.max(ans, dfs(idx+1, degree, requests));
        
        return ans;
    }
    
    public int maximumRequests(int n, int[][] requests) {
        int[] degree = new int[n];
        return dfs(0, degree, requests);
    }
}