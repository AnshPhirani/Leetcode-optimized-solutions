class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        
        // case : either subtract or add k to all elements
        int ans = nums[n-1] - nums[0];
        
        for(int i = 0; i < n-1; i++){
            int min = Math.min(nums[0]+k, nums[i+1]-k);
            int max = Math.max(nums[i]+k, nums[n-1]-k);
            ans = Math.min(ans, max-min);
        }
        
        return ans;
    }
}



// [1,3,6] k = 2
//    [3, 5, 4]
    
// // min = 1 = 3
// // max = 6 = 4

// 1, 3, 9
// k = 3

// 4 6 6
    
    
//     1,2,3,4,5 k = 2
//     3,4,5,2,3 ans = 3
//     3,4,1,2,3 ans = 3


//     7/2 = 3
    
//        1,2,3,4,5,6 k = 2
//        3,4,5,2,3,4 ans = 3
//        3,4,1,2,3,4 ans = 3
//        

     

// 7 8 8
// either add or subtract k to all elements

    
// [7,8,8,5,2]
// 4

// ans = 5
// // 2,5,7,8,8 k = 4
//    min = (6, 1) = 1
//    max = (4, 6) = 6

