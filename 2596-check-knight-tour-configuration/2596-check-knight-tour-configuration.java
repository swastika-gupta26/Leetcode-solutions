class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int positions[][] = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                positions[grid[i][j]][0] = i;
                positions[grid[i][j]][1] = j;
            }
        }
        boolean sats = true;
        for (int i = 0; i < n * n - 1; i++) {
            int dx = Math.abs(positions[i][0] - positions[i + 1][0]);
            int dy = Math.abs(positions[i][1] - positions[i + 1][1]);
            if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
                sats = true;
            } else {
                return false;
            }
        }
        return true;
    }
}