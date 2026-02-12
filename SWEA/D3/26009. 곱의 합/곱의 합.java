import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
 public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        long result;
        int mod = 998244353;
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long a = Long.parseLong(st.nextToken());
            a = a * (a + 1) / 2;

            long b = Long.parseLong(st.nextToken());
            b = b * (b + 1) / 2;

            long c = Long.parseLong(st.nextToken());
            c = c * (c + 1) / 2;

            result = (((a % mod) * (b % mod)) % mod * (c % mod)) % mod;
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}