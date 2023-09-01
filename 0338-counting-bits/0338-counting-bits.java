class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        if(n == 0) return res;
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i <= n; i++){
            if(i%2 == 0){
                res[i] = res[i/2];
            }
            else{
                res[i] = 1 + res[i/2];
            }
        }
        
        return res;
    }
}