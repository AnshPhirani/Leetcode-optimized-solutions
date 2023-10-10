class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int[] newArr = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(newArr);
        
        int n = nums.length;
        int ans = n;
        for(int idx = 0; idx < newArr.length; idx++){
            int startValue = newArr[idx];
            int endValue = startValue + n-1;
            int pos = Arrays.binarySearch(newArr, endValue);
            if(pos < 0)  pos = -pos-2;
            ans = Math.min(ans, n-(pos-idx+1));
        }
        
        return ans;
        
    }
}