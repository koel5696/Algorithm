
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[] red;
    static int[] green;
    static int[] blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][3];
        red = new int[n+1];
        green = new int[n+1];
        blue = new int[n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = red[1];
        dp[1][1] = green[1];
        dp[1][2] = blue[1];

        List<Integer> result = new ArrayList<>();
        if(n == 2) {
            dp[2][0] = red[2] + Math.min(green[1], blue[1]);
            dp[2][1] = green[2] + Math.min(red[1], blue[1]);
            dp[2][2] = blue[2] + Math.min(red[1], green[1]);
            int a = Math.min(dp[2][0], Math.min(dp[2][1], dp[2][2]));
            bw.write(a+"");
            bw.flush();
            return;
        }
        result.add(red(n));
        dp = new int[n + 1][3];
        result.add(green(n));
        dp = new int[n + 1][3];
        result.add(blue(n));
        Collections.sort(result);

        bw.write(result.get(0) +"");
        bw.flush();
    }

    public static int red(int n) {
        dp[2][0] = 0;
        dp[2][1] = red[1] + green[2];
        dp[2][2] = red[1] + blue[2];

        dp[3][0] = red[3] + Math.min(dp[2][1], dp[2][2]);
        dp[3][1] = green[3] + dp[2][2];
        dp[3][2] = blue[3] + dp[2][1];

        for (int i = 4; i <= n; i++) {
            if(i == n) {
                dp[i][1] = green[i] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = blue[i] + Math.min(dp[i-1][0], dp[i-1][1]);
                continue;
            }
            dp[i][0] = red[i] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = green[i] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = blue[i] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[n][1], dp[n][2]);
    }

    public static int green(int n) {
        dp[2][0] = green[1] + red[2];
        dp[2][1] = 0;
        dp[2][2] = green[1] + blue[2];

        dp[3][0] = red[3] + dp[2][2];
        dp[3][1] = green[3] + Math.min(dp[2][0], dp[2][2]);
        dp[3][2] = blue[3] + dp[2][0];

        for (int i = 4; i <= n; i++) {
            if(i == n) {
                dp[i][0] = red[i] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][2] = blue[i] + Math.min(dp[i-1][0], dp[i-1][1]);
                continue;
            }
            dp[i][0] = red[i] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = green[i] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = blue[i] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[n][0], dp[n][2]);
    }

    public static int blue(int n) {
        dp[2][0] = blue[1] + red[2];
        dp[2][1] = blue[1] + green[2];
        dp[2][2] = 0;

        dp[3][0] = red[3] + dp[2][1];
        dp[3][1] = green[3] + dp[2][0];
        dp[3][2] = blue[3] + Math.min(dp[2][0], dp[2][1]);

        for (int i = 4; i <= n; i++) {
            if(i == n) {
                dp[i][0] = red[i] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = green[i] + Math.min(dp[i-1][0], dp[i-1][2]);
                continue;
            }
            dp[i][0] = red[i] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = green[i] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = blue[i] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}
