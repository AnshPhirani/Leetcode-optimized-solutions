class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0, high = cells.length - 1;

        int latestDay = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canCrossOnKthDay(row, col, cells, mid)) {
                low = mid + 1;
                latestDay = mid;
            } else {
                high = mid - 1;
            }
        }

        return latestDay;
    }

    private boolean canCrossOnKthDay(int row, int col, int[][] cells, int k) {
        int[][] matOnKthDay = new int[row][col];
        for (int day = 1; day <= k; day++) {
            matOnKthDay[cells[day - 1][0] - 1][cells[day - 1][1] - 1] = 1;
        }

        int[][] memo = new int[row][col]; //  {0 -> notVisited, 1-> true, 2-> false, 3-> inStack}
        for (int j = 0; j < col; j++) {
            if (canReachEndRow(0, j, matOnKthDay, memo))
                return true;
        }

        return false;
    }

    private boolean canReachEndRow(int i, int j, int[][] matrix, int[][] memo) {
        if (i == matrix.length)
            return true;

        if (i < 0 || j < 0 || j >= matrix[0].length || i >= matrix.length ||  matrix[i][j] == 1 || memo[i][j] == 2 || memo[i][j] == 3)
            return false;

        memo[i][j] = 3;

        boolean canReach = canReachEndRow(i + 1, j, matrix, memo) || canReachEndRow(i, j + 1, matrix, memo)
                || canReachEndRow(i, j - 1, matrix, memo) || canReachEndRow(i - 1, j, matrix, memo);

        if(canReach) {
            memo[i][j] = 1;
            return canReach;
        }
        else{
            memo[i][j] = 2;
            return false;
        }

    }

}