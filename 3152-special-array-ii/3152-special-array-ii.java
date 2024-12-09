class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        
        int[] prefixParityCount = new int[n+1];
        for(int i = 0; i < n-1; i++){
            if(nums[i]%2 == nums[i+1]%2) 
                prefixParityCount[i+1] += 1 + prefixParityCount[i];
            else
                prefixParityCount[i+1] = prefixParityCount[i];
        }
        
 
        
        int k = 0;
        boolean[] ans = new boolean[queries.length];
        for(int[] query : queries){
            int left = query[0], right = query[1];            
            ans[k++] = prefixParityCount[right] - prefixParityCount[left] == 0;
        }
        
        return ans;
    }
}


// [3,4,1,2,6]
