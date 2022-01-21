package LeetCode;

import basicalgorithm.UF;

public class solve130 {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        UF unionFind = new UF(m * n + 1);
        int dummy = m * n;
        int[][] move = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if(board[i][j] == 'O'){
                    int p = i * n + j;
                    for (int k = 0; k < 4; k++) {
                        int x = i + move[k][0];
                        int y = j + move[k][1];
                        if(board[x][y] == 'O'){
                            int q = x * n + y;
                            unionFind.union(p,q);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(board[0][i] == 'O'){
                unionFind.union(i,dummy);
            }
            if(board[m - 1][i] == 'O'){
                unionFind.union((m - 1) * n + i, dummy);
            }
        }
        for (int i = 0; i < m; i++) {
            if(board[i][0] == 'O'){
                unionFind.union(i * n, dummy);
            }
            if(board[i][n - 1] == 'O'){
                unionFind.union(i * n + n - 1,dummy);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && !unionFind.connect(i * n + j,dummy))
                    board[i][j] = 'X';
            }
        }
    }
}
