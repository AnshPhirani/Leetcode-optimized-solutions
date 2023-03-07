class Solution {
    
    private boolean timeEnough(int[] time, long givenTime, int totalTrips){
        long tripsCount = 0;
        for(int t : time){
            tripsCount += givenTime/t;
        }
        return tripsCount >= totalTrips;
    }
    
    
    public long minimumTime(int[] time, int totalTrips) {
        
        long maxTime = 0;
        for(int t : time){
            maxTime = Math.max(maxTime, t);
        }
        
        long low = 0;
        long high = maxTime*totalTrips;
        while(low < high){
            long mid = low  + (high-low)/2;
            if(timeEnough(time, mid, totalTrips)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        
        return low;

    }
}