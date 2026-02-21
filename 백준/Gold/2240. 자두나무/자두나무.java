import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken()); // 시간(시도 횟수)
        int max = Integer.parseInt(st.nextToken()); // 최대 이동 횟수
        int[][] dp = new int[t + 1][max + 1];
        int[] arr = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= t; i++) {
            for (int j = 0; j <= max; j++) {
                int current = j % 2 != 1 ? 1 : 2;
                if (j == 0) { // 이동 횟수가 0번, 현위치가 떨구는 곳이면 +1 아니면 그대로
                    dp[i][j] = arr[i] == 1 ? dp[i - 1][j] + 1 : dp[i - 1][j];
                } else { // 이동 횟수가 1회 이상이고
                    // 현위치와 자두 떨어지는 위치가 같다면 + 1 아니면 이전 값 그대로
                    dp[i][j] = arr[i] == current ? dp[i - 1][j] + 1 : dp[i - 1][j];
                    int buffer = i < j ? 0 : dp[i - 1][j - 1] + 1; //시간보다 이동횟수가 많다면 무조건 0
                    dp[i][j] = Math.max(dp[i][j], buffer);
                } //이동횟수와 시간이 모두 이전이던 것에 이동을 통하여 + 1을 하고 더 큰 것.
            }
        }
        int result = 0;
        for (int i = 0; i <= max; i++) {
            result = Math.max(result, dp[dp.length - 1][i]);
        }
        bw.write(result + "");
        bw.flush();

    }
}
