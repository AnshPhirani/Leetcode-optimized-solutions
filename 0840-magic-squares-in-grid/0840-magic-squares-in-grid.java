class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int count = 0;
        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < m-2; j++){
                if(isMagicSquare(i, j, grid)) count++;
            }
        }
        return count;
    }

    private boolean isMagicSquare(int startRow, int startCol, int[][] grid){
        Set<Integer> contains = new HashSet<>();

        // check rows
        for(int i = startRow; i < startRow+3; i++){
            int curRowSum = 0;
            for(int j = startCol; j < startCol+3; j++){
                curRowSum += grid[i][j];
                contains.add(grid[i][j]);
                if(grid[i][j] > 9) return false;
            }
            if(curRowSum != 15) return false;
        }

         // check cols
        for(int j = startCol; j < startCol+3; j++){
            int curColSum = 0;
            for(int i = startRow; i < startRow+3; i++){
                curColSum += grid[i][j];
                contains.add(grid[i][j]);
                if(grid[i][j] > 9) return false;
            }
            if(curColSum != 15) return false;
        }
        

        // check diagonls
        if(grid[startRow][startCol] + grid[startRow+1][startCol+1] + grid[startRow+2][startCol+2] != 15) return false;
        if(grid[startRow+2][startCol] + grid[startRow+1][startCol+1] + grid[startRow][startCol+2] != 15) return false;

        return contains.size() == 9;
    }

}
