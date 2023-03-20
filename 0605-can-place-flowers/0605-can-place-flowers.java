class Solution {
    public boolean canPlaceFlowers(int[] arr, int k) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if((i-1 < 0 || arr[i-1] == 0) && arr[i] == 0 && (i+1 >= n || arr[i+1] == 0)){
                arr[i] = 1;
                k--;
            }
        }
        
        return k <= 0;
    }
}