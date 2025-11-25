
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];
        int[] num = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if(num[i] <= k)
                dp[num[i]] = 1;
            min = Math.min(min, num[i]);
        }

        for (int i = 0; i <= k ; i++) {
            if(dp[i] == 0)
                dp[i] = Integer.MAX_VALUE;
        }

        for (int i = min+1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if(i-num[j] >= 0 && dp[i-num[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i-num[j]]+1, dp[i]);
            }
        }
        if(dp[k] == Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(dp[k] + "\n");
        bw.flush();
    }
}
