class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]) candies[i] += candies[i-1];
            else candies[i] = 1;
        }   

        int[] candies2 = new int[n];
        Arrays.fill(candies2, 1);
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]) candies2[i] += candies2[i+1];
            else candies2[i] = 1;
        }

        int ans = 0;
        for(int i = 0; i < n; i++) ans += Math.max(candies[i], candies2[i]);
        return ans;
    }
}