class Solution {
    private static final int MOD = (int)1e9 + 7;
    Integer[][] memo;
    
    private int helper(int idx, int e, int fuel, int[] locations){
        if(fuel < 0) return 0;
        
        if(memo[idx][fuel] != null) return memo[idx][fuel];
        
        int count = 0;
        if(idx == e) count += 1;
        
        for(int i = 0; i < locations.length; i++){
            if(i == idx) continue;
            int fuelCost = Math.abs(locations[idx] - locations[i]);
            count += helper(i, e, fuel-fuelCost, locations);
            count %= MOD;
        }
        return memo[idx][fuel] = count;
    }
    
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.memo = new Integer[101][201];
        return helper(start, finish, fuel, locations);
    }
}