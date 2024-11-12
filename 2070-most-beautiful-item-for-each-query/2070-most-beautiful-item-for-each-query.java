class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        for(int i = 1; i < n; i++){
            items[i][1] = Math.max(items[i-1][1], items[i][1]);
        }
        
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            int target = queries[i];
            int l = 0, r = n-1;
            int maximumBeauty = 0;
            while(l <= r){
                int mid = (l+r)/2;
                if(items[mid][0] > target){
                    r = mid-1;
                }
                else{
                    maximumBeauty = items[mid][1];
                    l = mid+1;
                }
            }
            ans[i] = maximumBeauty;
        }
        
        return ans;
    }
}