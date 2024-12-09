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
        
        // System.out.println(Arrays.toString(prefixParityCount));
        
        int k = 0;
        boolean[] ans = new boolean[queries.length];
        for(int[] query : queries){
            int left = query[0], right = query[1];
            if(left == right) {
                ans[k++] = true;
                continue;
            }
            
            int parityCount = prefixParityCount[right] - prefixParityCount[left];
            if(parityCount == 0) ans[k++] = true;
            else ans[k++] = false;
        }
        
        return ans;
    }
}


// [3,4,1,2,6]
