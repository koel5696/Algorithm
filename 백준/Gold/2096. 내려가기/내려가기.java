import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][4];
        int[][] arr = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        dp[1][3] = arr[1][3];

        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]) + arr[i][2];
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]) + arr[i][3];
        }

        bw.write(Math.max(Math.max(dp[n][1], dp[n][2]), dp[n][3]) + " ");

        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(Math.min(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]) + arr[i][2];
            dp[i][3] = Math.min(dp[i - 1][2], dp[i - 1][3]) + arr[i][3];
        }

        bw.write(Math.min(Math.min(dp[n][1], dp[n][2]), dp[n][3]) + " ");
        bw.flush();
    }
}
