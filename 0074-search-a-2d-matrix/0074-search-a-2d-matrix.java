class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        
        int low = 0, high = n*m-1;
        while(low <= high){
            int mid = (low+high)/2;
            int r = mid/m, c = mid%m;
            if(matrix[r][c] > target) high = mid-1;
            else if(matrix[r][c] < target) low = mid+1;
            else return true;
        }
        
        return false;
    }
}