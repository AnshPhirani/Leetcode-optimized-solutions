class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int idx = 1;
        int candies = n;
        
        while(idx < n){
            if(ratings[idx] == ratings[idx-1]){
                 idx++;
                 continue;
            }
            
            int peak = 0;
            while(ratings[idx] > ratings[idx-1]){
                peak++;
                candies += peak;
                idx++;
                if(idx == n) return candies;
            }
            
            int valley = 0;
            while(idx < n && ratings[idx] < ratings[idx-1]){
                valley++;
                candies += valley;
                idx++;
            }
            
            candies -= Math.min(peak, valley);
        }
        return candies;
    }
}