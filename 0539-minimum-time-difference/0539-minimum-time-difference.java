class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> li = new ArrayList<>();
        for(String time : timePoints){
            String[] point = time.split(":");
            int minutes = Integer.parseInt(point[0])*60 + Integer.parseInt(point[1]);
            li.add(minutes);
        }
        
        Collections.sort(li);
        
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < li.size(); i++){
            int curDiff = li.get(i)-li.get(i-1);
            minDiff = Math.min(minDiff, curDiff);
            minDiff = Math.min(minDiff, 24*60-curDiff);
        }
        
        int curDiff = li.get(li.size()-1)-li.get(0);
        minDiff = Math.min(minDiff, curDiff);
        minDiff = Math.min(minDiff, 24*60-curDiff);
        
        return minDiff;  
    }
}