class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        HashSet<Integer>[][] dp = new HashSet[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        dp[n - 1][m - 1].add(grid[n - 1][m - 1]);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    continue;
                } else if (i == n - 1) {
                    for (int x : dp[i][j + 1]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                } else if (j == m - 1) {
                    for (int x : dp[i + 1][j]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                } else {
                    for (int x : dp[i][j + 1]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                    for (int x : dp[i + 1][j]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x : dp[0][0]) {
            ans = Math.min(ans, x);
        }
        return ans;

    }
}