class Solution {
    public int mySqrt(int x) {
        long l = 0, h = x;
        long ans = 0;
        while(l <= h){
            long mid = l+ (h-l)/2;
            if(mid*mid <= x) {
                ans = mid;
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return (int)ans;
    }
}