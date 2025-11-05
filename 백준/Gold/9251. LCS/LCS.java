
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
    “현재 문자가 같으면 이전까지의 최장 공통 부분 수열에 1을 더한 게 최선이고,
    다르면 둘 중 더 긴 이전 값 중 하나를 그대로 이어받으면 된다.”
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dijkstra;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 0;
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(a.charAt(i-1) != b.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else
                    dp[i][j] = dp[i - 1][j - 1] + 1;
            result = Math.max(result, dp[i][j]);
        }
    }

        bw.write(String.valueOf(result));
        bw.flush();



    }
}

