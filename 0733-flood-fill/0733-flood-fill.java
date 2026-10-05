class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m= image[0].length;
        int cpsh = image[sr][sc];
        boolean visited[][] = new boolean[n][m];
        dfs(image, sr, sc, color, visited, m, n, cpsh);
        return image;
    }
    public void dfs(int image[][], int sr, int sc, int color, boolean visited[][], int m, int n, int cpsh){
        if(sr < 0 || sr >=n || sc <0 || sc >= m || visited[sr][sc]==true || image[sr][sc] != cpsh){
            return;
        }
        visited[sr][sc] = true;
        image[sr][sc]= color;

        dfs(image, sr-1, sc , color, visited, m, n, cpsh);
        dfs(image, sr, sc-1 , color, visited, m, n, cpsh);
        dfs(image, sr+1, sc , color, visited, m, n, cpsh);
        dfs(image, sr, sc+1 , color, visited, m, n, cpsh);
    }
}