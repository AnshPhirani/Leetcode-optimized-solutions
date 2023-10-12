/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    private int binarySearch(int l, int h, int target, MountainArray mountainArr, boolean isIncreasing){
        
        while(l <= h){
            int mid = (l+h)/2;
            int cur = mountainArr.get(mid);
            if(cur == target) return mid;
            else if(cur < target){
                if(isIncreasing) l = mid+1;
                else h = mid-1;
            }
            else{
                if(isIncreasing) h = mid-1;
                else l = mid+1;
            }
        }
        return -1;
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // finding peek of Mountain
        int l = 0, h = n-1;
        int peekIdx = -1;
        while(l < h){
            int mid = l+(h-l)/2;
            int cur = mountainArr.get(mid);
            int next = (mid+1 < n)? mountainArr.get(mid+1) : Integer.MIN_VALUE;
            if(next > cur){
                peekIdx = mid+1;
                l = mid+1;
            }
            else{
                h = mid;
            }
        }
        
        int ans = binarySearch(0, peekIdx, target, mountainArr, true);
        if(ans != -1) return ans;
        return binarySearch(peekIdx, n-1, target, mountainArr, false);
        
    }
}