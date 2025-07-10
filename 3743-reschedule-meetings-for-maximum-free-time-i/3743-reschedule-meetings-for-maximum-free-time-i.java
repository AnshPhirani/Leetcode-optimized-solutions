class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> gaps = new ArrayList<>();
        int prevEnd = 0;
        for(int i = 0; i < startTime.length; i++){
            int start = startTime[i], end = endTime[i];
            gaps.add(start-prevEnd);
            prevEnd = end;
        }
        gaps.add(eventTime-prevEnd);

        // find window of size k+1 with max sum
        System.out.println(gaps);
        int curWindowSum = 0;
        int maxWindowSum = 0;
        for(int i = 0; i < gaps.size(); i++){
            curWindowSum += gaps.get(i);
            if(i >= k+1) curWindowSum -= gaps.get(i-(k+1));
            maxWindowSum = Math.max(maxWindowSum, curWindowSum);
        }

        return maxWindowSum;
    }
}