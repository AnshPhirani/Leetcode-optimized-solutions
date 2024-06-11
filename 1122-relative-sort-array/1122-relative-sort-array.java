class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        
        for(int val : arr1) freq[val]++;
        
        int idx = 0;
        for(int val : arr2){
            while(freq[val] > 0){
                arr1[idx++] = val;
                freq[val]--;
            }
        }
        
        for(int val = 0; val <= 1000; val++){
            while(freq[val] > 0){
                arr1[idx++] = val;
                freq[val]--;
            }
        }
        
        return arr1;
        
    }
}