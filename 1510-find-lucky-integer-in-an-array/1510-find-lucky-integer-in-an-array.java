class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for(int val : arr) freq[val]++;

        for(int val = 500; val >= 1; val--){
            if(freq[val] == val) return val;
        }
        return -1;
    }
}