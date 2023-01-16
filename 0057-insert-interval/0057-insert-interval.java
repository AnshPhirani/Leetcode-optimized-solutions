class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        
        int idx = 0;
        while(idx < n){
            int[] curInterval = intervals[idx];
            int commonStart = Math.max(curInterval[0], newInterval[0]);
            int commonEnd = Math.min(curInterval[1], newInterval[1]);
            if(commonEnd >= commonStart){
                newInterval[0] = Math.min(curInterval[0], newInterval[0]);
                newInterval[1] = Math.max(curInterval[1], newInterval[1]);
            }
            else if(newInterval[0] != Integer.MAX_VALUE && newInterval[1] < curInterval[0]){
                res.add(newInterval);
                newInterval = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}; // added succesfully
                res.add(curInterval);
            }
            else{
                res.add(curInterval);
            }
            idx++;
        }
        
        if(newInterval[0] != Integer.MAX_VALUE) res.add(newInterval);

        int[][] resArray = new int[res.size()][];
        for(int i = 0; i < res.size(); i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}