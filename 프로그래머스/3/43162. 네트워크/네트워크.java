import java.util.*;

class Solution {
    static boolean[][] visited;
    
     public int solution(int n, int[][] computers) {
        visited = new boolean[n][n];
        int result = 0;
        if (n > 1) {
            for (int i = 0; i < n; i++) {
                if (!visited[i][i]) {
                    result++;
                    visited[i][i] = true;
                    dfs(i, n, computers);
                }
            }
        } else {
            return 1;
        }
        return result;
    }

    public void dfs(int x, int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (i == x) {
                visited[x][i] = true;
                continue;
            }
            if (!visited[x][i] && computers[x][i] == 1) {
                visited[x][i] = true;
                visited[i][x] = true;
                dfs(i, n, computers);
            }
        }
    }
}