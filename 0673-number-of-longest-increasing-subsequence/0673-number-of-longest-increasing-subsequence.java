class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] count = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        int longest = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(lis[j]+1 > lis[i]) {
                        lis[i] = lis[j]+1;
                        count[i] = 0;
                    }
                    if(lis[j]+1 == lis[i]) count[i] += count[j];
                }
            } 
            longest = Math.max(longest, lis[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            if(lis[i] == longest) res += count[i];
        }
        return res;
    }
}