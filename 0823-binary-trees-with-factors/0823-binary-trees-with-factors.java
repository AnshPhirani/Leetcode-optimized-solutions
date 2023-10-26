class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        
        Map<Integer, Long> dp = new HashMap<>();
        for(int rootVal : arr) dp.put(rootVal, 1l);
        
        for(int rootVal : arr){
            for(int firstChildVal : arr){
                if(firstChildVal > Math.sqrt(rootVal)) break;
                if(rootVal%firstChildVal != 0) continue;
                int secondChildVal = rootVal/firstChildVal;
                if(!set.contains(secondChildVal)) continue;
                long count = dp.get(firstChildVal) * dp.get(secondChildVal);
                if(firstChildVal == secondChildVal) dp.put(rootVal, dp.get(rootVal) + count);
                else dp.put(rootVal, dp.get(rootVal) + count*2);
            }
        }
        
        final int MOD = (int)1e9 + 7;
        long ans = 0;
        for(long val : dp.values()) ans = (ans + val) % MOD;
        return (int)ans;
    }
}