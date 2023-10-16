class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex+1);
        ans.add(1);
        for(int row = 1; row <= rowIndex; row++){
            ans.add(1);
            for(int col = row-1; col > 0; col--){
                ans.set(col, ans.get(col) + ans.get(col-1));
            }
        }
        return ans;
    }
}