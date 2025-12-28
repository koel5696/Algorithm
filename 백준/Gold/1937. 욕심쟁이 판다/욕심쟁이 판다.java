import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] x = {-1, 1, 0, 0};
    static int[] y = {0, 0, -1, 1};
    static int[][] graph;
    static int[][] dp;
    static int n;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                max = Math.max(max, dfs(i, j, 1));
            }
        }
        bw.write(max + "");
        bw.flush();
    }

    public static int dfs(int currX, int currY, int count) {
        int result = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x[i] + currX;
            int ny = y[i] + currY;
            if ((nx > 0 && ny > 0) && (nx <= n && ny <= n)) {
                if (graph[nx][ny] > graph[currX][currY]) {
                    if (dp[nx][ny] > 0) {
                        result = Math.max(result, dp[nx][ny] + 1);
                        continue;
                    }
                    result = Math.max(result, dfs(nx, ny, count + 1) + 1);
                }
            }
        }

        dp[currX][currY] = result;
        return dp[currX][currY];
    }
}
