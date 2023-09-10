//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    Integer[][] memo;
    
    private int dfs(int src, int visited, int[][] cost){
        visited |= (1<<src);
        if(visited == (1<<cost.length)-1){
            return cost[src][0];
        }
       
        if(memo[src][visited] != null) return memo[src][visited];
        
        int minCost = 9999999;
        for(int neigh = 0; neigh < cost.length; neigh++){
            if(neigh == src || (visited&(1<<neigh)) != 0) continue;
            minCost = Math.min(minCost, cost[src][neigh] + dfs(neigh, visited , cost));
        }
        

        return memo[src][visited] = minCost;
    }
    
    public int total_cost(int[][] cost)
    {
        if(cost.length == 1) return 0;
        this.memo = new Integer[cost.length][1<<cost.length + 1];
        
        int minCost = Integer.MAX_VALUE;

        for(int neigh = 1; neigh < cost.length; neigh++){
            minCost = Math.min(minCost, cost[0][neigh] + dfs(neigh, 1, cost));
        }
        return minCost;
    }
}