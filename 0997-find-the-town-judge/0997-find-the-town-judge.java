class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        
        for(int[] edge : trust){
            int u = edge[0]-1;
            int v = edge[1]-1;
            inDegree[v]++;
            outDegree[u]++;
        }
        
        for(int i = 0; i < n; i++){
            if(inDegree[i] == n-1 && outDegree[i] == 0) return i+1;
        }
        
        return -1;
    }
}