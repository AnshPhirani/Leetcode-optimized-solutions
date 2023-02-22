class Solution {
    
    private boolean canShipWithinDays(int[] weights, int days, int maxWeight){
        int curWeight = 0;
        for(int weight : weights){
            if(weight > maxWeight) return false;
            if(curWeight + weight > maxWeight){
                days--;
                curWeight = weight;
            }
            else{
                curWeight += weight;
            }
        }
        return days > 0;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0;
        int high = Arrays.stream(weights).sum();

        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canShipWithinDays(weights, days, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
        
    }
}