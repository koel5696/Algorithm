
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

        int lineCount = Integer.parseInt(br.readLine());

        List<int[]> line = new ArrayList<>();
        line.add(new int[]{0, 0});

        for (int i = 0; i < lineCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            line.add(new int[]{start, end});
        }
        int[] dp = new int[lineCount + 1];

        line.sort((a, b) -> {
            if (a[0] < b[0])
                return -1;
            if (a[0] > b[0])
                return 1;
            return 0;
        });

        int[] a = new int[lineCount + 1];
        for (int i = 1; i <= lineCount; i++) {
            a[i] = line.get(i)[1];
        }

        dp[1] = 1;
        int max = dp[1];
        for (int i = 2; i <= lineCount; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(a[i] > a[j]) {
                    int buff = dp[j] + 1;
                    dp[i] = Math.max(dp[i], buff);
                }
                max = Math.max(max, dp[i]);
            }
        }

        bw.write(lineCount - max + "\n");
        bw.flush();

    }
}
