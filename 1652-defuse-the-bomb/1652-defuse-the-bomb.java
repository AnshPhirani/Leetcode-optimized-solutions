class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if(k == 0) return new int[n];
        
        int start = k > 0 ? 1 : n+k;
        k = Math.abs(k);
        int[] ans = new int[n];
        int curWindowSum = 0;
        int i = start, j = 0;
        while(j < n){
            curWindowSum += code[i%n];
            if(i >= start+k-1) {
                ans[j++] = curWindowSum;
                curWindowSum -= code[(i-k+1)%n];
            }
            i++;
        }
        
        return ans;
        
    }
}