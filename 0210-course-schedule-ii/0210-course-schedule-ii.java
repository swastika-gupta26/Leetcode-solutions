class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (Integer neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }
        int arr[]= new int[ans.size()];
        if (ans.size() == V) {
            for(int i=0;  i<V; i++){
                arr[i] = ans.get(i);
            }
            return arr;
        }
         else {
            return new int[0];
        }

    }
}