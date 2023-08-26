class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[1]-b[1]);
        
        // greedy
        int ans = 0;
        int prevEnd = Integer.MIN_VALUE;
        for(int[] pair : pairs){
            if(pair[0] > prevEnd){
                ans++;
                prevEnd = pair[1];
            }
        }
        
        return ans;
    }
}