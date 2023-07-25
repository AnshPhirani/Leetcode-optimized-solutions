class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1;
        int h = arr.length-2;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if(arr[mid+1] > arr[mid]) l = mid+1;
            else h = mid-1;
        }
        return -1;
    }
}