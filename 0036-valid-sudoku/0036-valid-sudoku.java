class Solution {

    public boolean isValidCell(int x, int y, char[][] board){
        char cur = board[x][y];
        for(int j = 0; j < 9; j++){
            if(j == y) continue;
            if(board[x][j] == cur) return false;
        }

        for(int i = 0; i < 9; i++){
            if(i == x) continue;
            if(board[i][y] == cur) return false;
        }

        int rowFactor = x - (x%3);
        int colFactor = y - (y%3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == x%3 && j == y%3) continue;
                if(board[rowFactor+i][colFactor+j] == cur) return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !isValidCell(i, j, board)){
                    return false;
                }
            }
        }
        return true;
    }
}