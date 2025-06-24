class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        boolean[] isKDistant = new boolean[n];

        int latestIdx = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] == key){
                latestIdx = i+k;
            }
            if(i <= latestIdx) isKDistant[i] = true;
        }

        latestIdx = n;
        for(int i = n-1; i >= 0; i--){
            if(nums[i] == key){
                latestIdx = i-k;
            }
            if(i >= latestIdx) isKDistant[i] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(isKDistant[i]) ans.add(i);
        }
        return ans;
    }
}