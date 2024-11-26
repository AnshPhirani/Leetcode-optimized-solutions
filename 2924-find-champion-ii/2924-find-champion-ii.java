class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for(int[] edge : edges){
            inDegree[edge[1]]++;
        }
        
        int zeroInDegreeCount = 0;
        int champion = -1;
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                zeroInDegreeCount++;
                champion = i;
            }
            if(zeroInDegreeCount == 2) return -1;
        }
        
        
        return champion;
        
    }
}