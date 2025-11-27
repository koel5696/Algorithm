
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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k+1][n+1];
        int[][] sum = new int[k+1][n+1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(i == 1 || j == 1)
                    dp[j][i] = j % 1000000000;
                else
                    dp[j][i] = sum[j][i - 1] % 1000000000;

                sum[j][i] = (sum[j - 1][i] + dp[j][i]) % 1000000000;
            }
        }
        
        bw.write(dp[k][n] + "\n");
        bw.flush();

    }
}
