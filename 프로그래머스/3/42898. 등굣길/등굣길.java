import java.io.*;
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
       long[][] dp = new long[n][m];

        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            dp[y][x] = -1; // 잠긴 곳 표시
        }
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] != -1) { // 물에 잠긴 지역
                    if (i - 1 >= 0 && dp[i - 1][j] != -1) // y축으로 윗칸에서 온 방법.
                        dp[i][j] += dp[i - 1][j] % 1_000_000_007;
                    if (j - 1 >= 0 && dp[i][j - 1] != -1) // x축으로 윗칸에서 온 방법.
                        dp[i][j] += dp[i][j - 1] % 1_000_000_007;
                }
                dp[i][j] %= 1_000_000_007;
            }
        }
        return (int) dp[n - 1][m - 1];
    }
}