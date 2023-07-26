class Solution {
    
    private boolean isPossibleToArrive(int[] dist, double hour, int speed){
        double timeTaken = 0;
        for(int d : dist){
            timeTaken = Math.ceil(timeTaken);
            timeTaken += (1d * d)/speed;
        }
        return timeTaken <= hour;
    }
    
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 0, high = 10000000;
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(isPossibleToArrive(dist, hour, mid)) {
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