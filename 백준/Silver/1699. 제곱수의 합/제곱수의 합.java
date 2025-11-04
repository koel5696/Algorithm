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
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dijkstra;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sp = (int) Math.sqrt(i);
            int buff = dp[i-1] + 1;
            for (int j = 2; j <= sp; j++) {
                int ap = (int) Math.pow(j, 2);
                buff = Math.min(buff, dp[i-ap] + 1);
            }
            dp[i] = buff;
        }

        bw.write(dp[n] + "\n");
        bw.flush();

    }
}