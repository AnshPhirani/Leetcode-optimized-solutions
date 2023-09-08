class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        
        for(int i = 1; i < n; i++){
            List<Integer> prevRow = res.get(i-1);
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            for(int j = 1; j < i; j++){
                curRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            curRow.add(1);
            res.add(curRow);
        }
        
        return res;
    }
}