class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1]-a[1]);

        int maxUnits = 0;
        for(int idx = 0; idx < boxTypes.length && truckSize > 0; idx++){
            maxUnits += Math.min(truckSize, boxTypes[idx][0]) * boxTypes[idx][1];
            truckSize -= Math.min(truckSize, boxTypes[idx][0]);
        }
        return maxUnits;
    }
}