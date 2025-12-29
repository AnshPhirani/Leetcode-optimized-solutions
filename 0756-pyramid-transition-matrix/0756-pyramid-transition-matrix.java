class Solution {
    public boolean pyramidTransition(String bottom, List<String> alloweds) {
        Map<String, List<Character>> allowedMap = new HashMap<>();
        for(String allowed : alloweds){
            char left = allowed.charAt(0), right = allowed.charAt(1), top = allowed.charAt(2);
            allowedMap.computeIfAbsent(left+"*"+right, k -> new ArrayList<>()).add(top);
        }

        return solve(bottom, allowedMap);
    }

    private boolean solve(String bottom, Map<String, List<Character>> allowedMap){
        if(bottom.length() == 1) return true;

        return buildNextRow(bottom,"", 0, allowedMap);
    }

    private boolean buildNextRow(String bottom, String curRow, int idx, Map<String, List<Character>> allowedMap){
        if(idx == bottom.length()-1){
            if(solve(curRow, allowedMap)) return true;
            return false;
        }

        String key = bottom.charAt(idx)+"*"+bottom.charAt(idx+1);
        if(!allowedMap.containsKey(key)) return false;

        for(char ch : allowedMap.get(key)){
            if(buildNextRow(bottom, curRow+ch, idx+1, allowedMap)) return true;
        }

        return false;
    }
}