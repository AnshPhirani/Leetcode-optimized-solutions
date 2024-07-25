class Solution {
    public int[] sortArray(int[] nums) {
        int[] count = new int[1000001];
        for(int num : nums){
            count[num+50000]++;
        }
        
        int k = 0;
        int val = 0;
        int[] res = new int[nums.length];
        while(k < nums.length){
            while(count[val] > 0){
                res[k++] = val-50000;
                count[val]--;
            }
            val++;
        }
        return res;
    }
}