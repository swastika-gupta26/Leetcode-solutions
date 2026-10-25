class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int count = 0;
       
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                 boolean[] sats = {true};
                if (grid[i][j] == 0 && !visited[i][j]) {
                    solve(grid, visited, i, j, sats);
                    if(sats[0] == true){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void solve(int[][] grid, boolean visited[][], int i, int j, boolean[] sats) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] == 1) {
            return;
        }
        if(grid[i][j]==0 && (i==0 || j ==0 || i == grid.length-1 || j == grid[0].length-1)){
              sats[0] = false;
              return;
        } 
        visited[i][j] = true;
        solve(grid, visited, i - 1, j, sats);
        solve(grid, visited, i, j - 1, sats);
        solve(grid, visited, i + 1, j, sats);
        solve(grid, visited, i, j + 1, sats);

    }
}