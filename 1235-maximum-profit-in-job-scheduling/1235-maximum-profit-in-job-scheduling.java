class Job{
    int start, end, profit;
    public Job(int s, int e, int p){
        start = s;
        end = e;
        profit = p;
    }
}

class Solution {
    
    private int helper(int idx, Job[] jobs, Integer[] memo){
        if(idx >= jobs.length) return 0;
        
        if(memo[idx] != null) return memo[idx];
        
        int skip = helper(idx+1, jobs, memo);
        int j = idx+1; 
        while(j < jobs.length && jobs[j].start < jobs[idx].end)j++;
        int include = jobs[idx].profit + helper(j, jobs, memo);
        
        return memo[idx] = Math.max(skip, include);
        
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int idx = 0; idx < n; idx++){
            jobs[idx] = new Job(startTime[idx], endTime[idx], profit[idx]);
        }
        
        Arrays.sort(jobs, (a, b) -> a.start != b.start? a.start-b.start : a.end-b.end);
        
        Integer[] memo = new Integer[n];
        return helper(0, jobs, memo);
    }
}