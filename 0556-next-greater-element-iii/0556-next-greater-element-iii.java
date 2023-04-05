class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int len = arr.length;
        
        int peek = len-2;
        while(peek >= 0){
            if(arr[peek] < arr[peek+1]) break;
            peek--;
        }
        
        if(peek == -1) return -1; // not possible
        
        int i = peek+1;
        for(int j = peek+1; j < len; j++){
            if(arr[j] > arr[peek] && arr[j] <= arr[i]){
                i = j;
            }
        }
        
        // swap
        char temp = arr[peek];
        arr[peek] = arr[i];
        arr[i] = temp;
        
        Arrays.sort(arr, peek+1, len);
        
        long res = Long.parseLong(new String(arr));
        if(res > Integer.MAX_VALUE) return -1;
        else return (int) res;
        
        
    }
}