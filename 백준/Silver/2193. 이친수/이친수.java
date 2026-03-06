import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int n = Integer.parseInt(br.readLine());
       dp = new long[n+1];
       dp[1] = 1;
       if(n >= 2) dp[2] = 1;
       fibo(n);
       bw.write(String.valueOf(dp[n]));
       bw.flush();
    }

    private static long fibo(int n) {
        if (n == 1 || n == 2)
            return 1;

        if(dp[n] != 0)
            return dp[n];

        return dp[n] = fibo(n - 1) + fibo(n - 2);
    }
}
