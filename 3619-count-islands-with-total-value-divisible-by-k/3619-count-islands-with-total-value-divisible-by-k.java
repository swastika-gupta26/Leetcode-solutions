class Solution {
    public int countIslands(int[][] grid, int k) {
        int n= grid.length;
        int m = grid[0].length;
        int count=0;
        boolean visited[][] = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    if(solve(i, j, grid, visited)%k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }   
        public long solve(int i, int j, int[][] grid, boolean visited[][]){
            if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0 || visited[i][j] == true){
                return 0;
            }
            visited[i][j] = true;
            long up = solve(i-1, j, grid, visited);
            long left = solve(i, j-1, grid, visited);
            long down = solve(i+1, j, grid, visited);
            long right = solve(i, j+1, grid, visited);

            return up + left + down + right+ grid[i][j];
        }

    
}