class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int prefixMax = arrays.get(0).get(arrays.get(0).size()-1);
        int prefixMin = arrays.get(0).get(0);
        
        int maxDist = 0;
        for(int i = 1; i < arrays.size(); i++){
            List<Integer> arr = arrays.get(i);
            int curMax = arr.get(arr.size()-1);
            int curMin = arr.get(0);
            maxDist = Math.max(maxDist, Math.abs(curMax-prefixMin));
            maxDist = Math.max(maxDist, Math.abs(prefixMax-curMin));
            prefixMax = Math.max(prefixMax, curMax);
            prefixMin = Math.min(prefixMin, curMin);
        }
        return maxDist;
    }
}