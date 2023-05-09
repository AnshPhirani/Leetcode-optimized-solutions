class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rs = 0, re = matrix.length-1;
        int cs = 0, ce = matrix[0].length-1;
        
        int total = (re+1)*(ce+1);
        
        while(res.size() < total){
            for(int j = cs; j <= ce && res.size() < total; j++) res.add(matrix[rs][j]);
            rs++;
            for(int i = rs; i <= re && res.size() < total; i++) res.add(matrix[i][ce]);
            ce--;
            for(int j = ce; j >= cs && res.size() < total; j--) res.add(matrix[re][j]);
            re--;
            for(int i = re; i >= rs && res.size() < total; i--) res.add(matrix[i][cs]);
            cs++;
        }
        return res;
    }
}