class Solution {
    
    private boolean timeEnough(int[] time, long givenTime, int totalTrips){
        long tripsCount = 0;
        for(int t : time){
            tripsCount += givenTime/t;
        }
        return tripsCount >= totalTrips;
    }
    
    
    public long minimumTime(int[] time, int totalTrips) {
        
        long minTime = Integer.MAX_VALUE;
        for(int t : time){
            minTime = Math.min(minTime, t);
        }
        
        long low = minTime;
        long high = minTime*totalTrips;
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