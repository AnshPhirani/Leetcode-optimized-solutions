class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        
        int idx = 0;
        while(idx < costs.length){
            int curCost = costs[idx++];
            if(coins < curCost) return idx-1;
            else coins -= curCost;
        }
        return costs.length;
    }
}