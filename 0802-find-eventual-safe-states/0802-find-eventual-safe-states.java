class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean visited[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        boolean check[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                checkCycle(i, graph, visited, pathVis, check);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean checkCycle(int start, int graph[][], boolean visited[], boolean pathVis[], boolean check[]) {
        visited[start] = true;
        pathVis[start] = true;
        check[start] = false;

        for (int neighbour : graph[start]) {
            if (!visited[neighbour]) {
               if(checkCycle(neighbour, graph, visited, pathVis, check)==true){
                return true;
               }
                    
            } else if (pathVis[neighbour]) {
                return true;
            }
        }
        check[start] = true;
        pathVis[start] = false;
        return false;
        
    }

}