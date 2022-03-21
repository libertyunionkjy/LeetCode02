package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MovingCount {
    int m, n, k;
    private boolean[][] visited;
    public int movingCount(int m, int n, int k){
        return bfs(m, n, k);
    }

    int dfs(int i, int j, int si, int sj){
        if(i >= m || j >= n || si + sj > k || visited[i][j] == true) return 0;
        visited[i][j] = true;
        int belowCount = dfs(i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1,sj);
        int leftCount = dfs(i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1);
        return 1 + belowCount + leftCount;
    }

    int bfs(int m, int n,int k){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        this.visited = new boolean[m][n];
        int res = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1], si = cur[2], sj = cur[3];
            if(i >= m || j >= n || si + sj > k || visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            queue.offer(new int[]{i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj});
            queue.offer(new int[]{i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1});
        }
        return res;
    }
}

// 递归终止条件
//      1.越界：
//      2.数位和越界：si + sj > k
//      3.访问过了：
// 下方和右方的数位和：
//          下方：newSi = (i + 1 % 10 == 0 ? si - 8 : si + 1) , newSj = sj
//          右方：newSi = si, newSj = (j + 1 % 10 == 0 ? : sj - 8 : sj + 1)
// 下方和右方只和 + 1
