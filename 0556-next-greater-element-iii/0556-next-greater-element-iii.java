class Solution {
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void reverse(int[] arr, int i, int j){
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        
        int peek = -1;
        for(int i = n-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                peek = i;
                break;
            }
        }
        
        if(peek == -1){
            // reverse(arr, 0, n-1);
            Arrays.fill(arr, 0);
            arr[n-1] = -1;
            return;
        }
        
        int idx = peek+1;
        for(int i = peek+1; i < n; i++){
            if(arr[i] > arr[peek] && arr[i] <= arr[idx]){
                idx = i;
            }
        }
        
        swap(arr, peek, idx);
        reverse(arr, peek+1, n-1);
        
        
    }
    
    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        int len = num.length();

        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = num.charAt(i) - '0';
        }
        
        nextPermutation(arr);

        long res = 0;
        for(int i = 0; i < len; i++){
            res = res*10 + arr[i];
        }
        
        if(res > Integer.MAX_VALUE) res = -1;
        
        return (int) res;
        
    }
}