class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int visited[][] = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfs(grid, visited, i, j, m, n);
                }
            }
        }
        return count;
    }

    public void dfs(char grid[][], int visited[][], int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n ||
                visited[i][j] == 1 || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = 1;
        dfs(grid, visited, i - 1, j, m, n);
        dfs(grid, visited, i, j - 1, m, n);
        dfs(grid, visited, i + 1, j, m, n);
        dfs(grid, visited, i, j + 1, m, n);
    }
}