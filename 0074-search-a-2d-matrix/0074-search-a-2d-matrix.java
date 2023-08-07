class Solution {
    
    private boolean bSearch(int[] arr, int target){
        int idx = Arrays.binarySearch(arr, target);
        return idx >= 0;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(matrix[mid][0] > target) high = mid-1;
            else if(matrix[mid][m-1] < target) low = mid+1;
            else return bSearch(matrix[mid], target);
        }
        
        return false;
    }
}