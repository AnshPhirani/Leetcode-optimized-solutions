class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        for(int num : nums) freq[num]++;
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int num = 1; num <= n; num++){
            int count = freq[num];
            int row = 0;
            while(row < count){
                if(ans.size() == row) ans.add(new ArrayList<>());
                ans.get(row).add(num);
                row++;
            }
        }
        
        return ans;
    }
}