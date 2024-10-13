class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n*2][2];
        for(int i = 0; i < n; i++){
            arr[i*2] = new int[]{intervals[i][0], 1};
            arr[i*2+1] = new int[]{intervals[i][1]+1, -1};
        }
        
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0] * 3 + o[1]));
        
        int curRooms = 0;
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            curRooms += arr[i][1];
            ans = Math.max(ans, curRooms);
        }
        
        return ans;
    }
}