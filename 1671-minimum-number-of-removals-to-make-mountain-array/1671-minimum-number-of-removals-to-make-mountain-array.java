class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        int[] lis = new int[n];
        int[] lds = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        
        // builing lcs array
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        
        // building lds array
        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(nums[i] > nums[j]){
                    lds[i] = Math.max(lds[i], lds[j]+1);
                }
            }
        }

        int maxMountainLen = 0;
        for(int i = 1; i < n-1; i++){
            if(lis[i] <= 1 || lds[i] <= 1) continue;
            int curMountainLen = lis[i] + lds[i] - 1;
            maxMountainLen = Math.max(maxMountainLen, curMountainLen);
        }
        
        return n-maxMountainLen;
        
    }
}