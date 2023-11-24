class Solution {
    public int maxCoins(int[] piles) {
        int n  = piles.length/3;
        
        Arrays.sort(piles);
        for(int i = 0; i < piles.length/2; i++){
            int temp = piles[i];
            piles[i] = piles[piles.length-i-1];
            piles[piles.length-i-1] = temp;
        }
        
        int ans = 0;
        for(int i = 1; i < 2*n; i+=2){
            ans += piles[i];
        }
        return ans;
    }
}