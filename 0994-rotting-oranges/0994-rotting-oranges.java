class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                    visited[i][j] = 1;
                }
            }
        }
        int time= bfs(grid, visited, n, m, q);
        for(int i=0; i<n; i++){
            for(int j=0;  j<m; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;

    }

    public int bfs(int grid[][], int visited[][], int n, int m, 
    Queue<int[]> q) {
      int time =0;
      
      while(!q.isEmpty()){
        int size = q.size();
      for(int k=0; k<size; k++){
         int[] current = q.poll();
         int i=current[0];
         int j=current[1];

         if(i-1>=0 && visited[i-1][j]!=1 && grid[i-1][j] ==1){
            visited[i-1][j]=1;
            grid[i-1][j]=2;
            q.add(new int[]{i-1, j});
        }
        if(i+1 <n && visited[i+1][j]!=1 && grid[i+1][j] ==1){
             visited[i+1][j]=1;
             grid[i+1][j]=2;
             q.add(new int[]{i+1, j});
        }
         if(j-1>=0 &&  visited[i][j-1]!=1 && grid[i][j-1] ==1){
             visited[i][j-1]=1;
             grid[i][j-1]=2;
            q.add(new int[]{i, j-1});
        }
        if(j+1 <m && visited[i][j+1]!=1 && grid[i][j+1] ==1){
             visited[i][j+1]=1;
             grid[i][j+1]=2;
             q.add(new int[]{i, j+1});
        }
        
      }
       if(!q.isEmpty()){
        time++;
       }

         
      }
       
      
       return time;

    }

}