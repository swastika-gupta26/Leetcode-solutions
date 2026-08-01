class Solution {
     List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int chess[][] = new int[n][n];
        solveQueens(chess, 0, n);
        return result;
    }

    public void solveQueens(int chess[][], int row, int n) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    if (chess[i][j] == 1) {
                        s = s + "Q";
                    } else {
                        s = s + ".";
                    }
                }
                board.add(s);
            }
            result.add(board);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafeForQueen(chess, row, col) == true) {
                chess[row][col] = 1;
                solveQueens(chess, row + 1, n);
                chess[row][col] = 0;
            }
        }
    }

    public boolean isSafeForQueen(int chess[][], int row, int col) {
        for (int i = row; i >= 0; i--) {
            if (chess[i][col] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}