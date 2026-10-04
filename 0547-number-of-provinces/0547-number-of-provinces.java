class Solution {
    public static void dfs(int node , ArrayList<ArrayList<Integer>> adj, int visited[]){
        visited[node]=1;
        for(Integer neighbour: adj.get(node)){
            if(visited[neighbour]==0){
              dfs(neighbour, adj, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=isConnected.length ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i+1).add(j+1);
                }
            }
        }
        
        int visited[]= new int[n+1];
        int count =0;
        for(int i=1; i<=n ; i++){
            if(visited[i] == 0){
                count++;
                dfs(i, adj , visited);
            }
        }
        return count;
    }
}