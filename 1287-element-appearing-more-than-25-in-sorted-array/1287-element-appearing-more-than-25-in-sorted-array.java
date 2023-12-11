class Solution {
    public int findSpecialInteger(int[] arr) {
        int curEle = -1, curEleCount = 0;
        for(int val : arr){
            if(val == curEle) curEleCount++;
            else{
                curEle = val;
                curEleCount = 1;
            }
            if(curEleCount > arr.length/4) return curEle;
        }
        return -1;
    }
}