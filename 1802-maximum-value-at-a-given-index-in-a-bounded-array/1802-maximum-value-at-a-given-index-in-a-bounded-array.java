class Solution {
    
    private long minPossibleSum(int indexVal, int leftCount, int rightCount){
        long val = indexVal-1;
        
        long leftSum = 0;
        if(leftCount <= val){
            long temp = val-leftCount;
            leftSum = val*(val+1)/2 - temp*(temp+1)/2;
        }
        else{
            long temp = leftCount-val;
            leftSum = val*(val+1)/2 + 1*temp;
        }
        
        long rightSum = 0;
        if(rightCount <= val){
            long temp = val-rightCount;
            rightSum = val*(val+1)/2 - temp*(temp+1)/2;
        }
        else{
            long temp = rightCount-val;
            rightSum = val*(val+1)/2 + 1*temp;
        }
        
        return leftSum + indexVal + rightSum;
    }
    
    public int maxValue(int n, int index, int maxSum) {
        int l = 1, h = maxSum;
        int leftCount = index, rightCount = n-index-1;
        
        while(l <= h){
            int mid = l + (h-l)/2;
            if(minPossibleSum(mid, leftCount, rightCount) <= maxSum){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        
        return h;
    }
}