class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inMinusOutDegree = new int[n];
        
        for(int[] edge : trust){
            int u = edge[0]-1;
            int v = edge[1]-1;
            inMinusOutDegree[v]++;
            inMinusOutDegree[u]--;
        }
        
        for(int i = 0; i < n; i++){
            if(inMinusOutDegree[i] == n-1) return i+1;
        }
        
        return -1;
    }
}