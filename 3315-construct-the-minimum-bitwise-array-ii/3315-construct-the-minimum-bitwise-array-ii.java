class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int len = nums.size();
        int[] ans = new int[len];
        for(int idx = 0; idx < len; idx++){
            int pos = 0;
            int val = nums.get(idx);
            if(val == 2){
                ans[idx] = -1;
                continue;
            }
            while((val&(1<<pos)) != 0){
                pos++;
            }
            int mask = ~(1 << (pos-1));
            ans[idx] = val & mask;
        }

        return ans;
    }
}