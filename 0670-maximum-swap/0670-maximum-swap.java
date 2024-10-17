class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        if(arr.length == 1) return num;
        
        outer:
        for(int i = 0; i < arr.length; i++){
            int maxLeftIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(maxLeftIndex != i && arr[j] >= arr[maxLeftIndex]) {
                    maxLeftIndex = j;
                }
                else if(arr[j] > arr[maxLeftIndex]) maxLeftIndex = j;
            }
            if(maxLeftIndex > i){
                char temp = arr[i];
                arr[i] = arr[maxLeftIndex];
                arr[maxLeftIndex] = temp;
                break;
            }
        }
        
        return Integer.parseInt(new String(arr));

    }
}