class Solution {
    Long[] memo; 

    private long helper(int idx, int[] power){
        if(idx >= power.length) return 0;

        if(memo[idx] != null) return memo[idx];

        long curPower = power[idx];
        long ans = 0;

        // skip curPower
        int nextUniquePowerIdx = idx+1;
        while(nextUniquePowerIdx < power.length && curPower == power[nextUniquePowerIdx]){
            nextUniquePowerIdx++;
        }
        ans = Math.max(ans, helper(nextUniquePowerIdx, power));

        // choose curPower
        int nextIdx = idx+1;
        while(nextIdx < power.length && power[nextIdx] <= curPower+2){
            nextIdx++;
        }
        ans = Math.max(ans, curPower*(nextUniquePowerIdx-idx) + helper(nextIdx, power));

        return memo[idx] = ans;
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        this.memo = new Long[power.length];
        return helper(0, power);
    }
}