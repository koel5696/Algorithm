import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
// dp[n] = 2(자기 자신 모양) + dp[n-2]*3(2x3 모양 종류는 3가지) + (dp[n-4]+dp[n-6]...dp[2]) * 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 2];

        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] += 2 + dp[i - 2] * 3;
            int sum = 0;
            for (int j = i - 4; j >= 2; j -= 2) {
                sum += dp[j];
            }
            dp[i] += sum * 2;
        }
        bw.write(dp[n] +"");
        bw.flush();
    }
}
