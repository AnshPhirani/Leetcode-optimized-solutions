class Solution {
    
    private int helper(int n, char lastChar, Map<Character, List<Character>> map, Map<String, Integer> memo){
        if(n == 0) return 1;
        
        String key = n+"*"+lastChar;
        if(memo.containsKey(key)) return memo.get(key);
        
        final int MOD = (int)1e9 + 7;
        int ans = 0;
        for(char curChar : map.get(lastChar)){
            ans += helper(n-1, curChar, map, memo);
            ans %= MOD;
        }
        
        memo.put(key, ans);
        return ans;
    }
    
    public int countVowelPermutation(int n) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('\0', List.of('a', 'e', 'i', 'o', 'u'));
        map.put('a', List.of('e'));
        map.put('e', List.of('a', 'i'));
        map.put('i', List.of('a', 'e', 'o', 'u'));
        map.put('o', List.of('i', 'u'));
        map.put('u', List.of('a'));
        
        Map<String, Integer> memo = new HashMap<>();
        
        return helper(n, '\0', map, memo);
        
    }
}