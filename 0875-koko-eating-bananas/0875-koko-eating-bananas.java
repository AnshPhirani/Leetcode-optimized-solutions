class Solution {
    
    private boolean canEat(int[] piles, int k, int maxHours){
        int hoursTaken = 0;
        for(int pile : piles){
            hoursTaken += (pile%k == 0) ? pile/k : pile/k + 1;
        }
        return hoursTaken <= maxHours;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        
        while(low < high){
            int mid = low + (high-low)/2;
            if(canEat(piles, mid, h)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        
        return low;
    }
}