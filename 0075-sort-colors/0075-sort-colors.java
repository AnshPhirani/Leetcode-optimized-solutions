class Solution {
    
    private void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void sortColors(int[] arr) {
        int l = 0, mid = 0, r = arr.length-1;
        
        while(mid <= r){
            if(arr[mid] == 1) mid++;
            else if(arr[mid] == 0){
                swap(mid, l, arr);
                mid++;
                l++;
            }
            else{
                swap(mid, r, arr);
                r--;
            }
        }
        
    }
}