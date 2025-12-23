import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //투포인터 -> 탑에 대한 거리 중 2번째 거리가 크다면 2번째 탑을 계속 이동시킴.
    //1번째 거리가 역전한다면 첫번째 거리를 이동시킴. 2번째 인덱스가 범위를 넘으면 종료.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n];
        int[] sum = new int[n + 1];
        sum[0] = 0;

        for (int i = 1; i <= n; i++) {
            distance[i - 1] = Integer.parseInt(br.readLine());
            sum[i] += sum[i - 1] + distance[i - 1];
        }

        int result = Integer.MIN_VALUE;
        int sum1;
        int sum2;
        int num1 = 1;
        int num2 = 2;

        while (num2 <= n) {
            sum1 = sum[num2 - 1] - sum[num1 - 1];
            sum2 = sum[sum.length - 1] - sum[num2 - 1] + sum[num1 - 1];
            result = Math.max(result, Math.min(sum1, sum2));
            if (sum1 < sum2) {
                num2++;
            } else {
                num1++;
            }
        }
        bw.write(result + "");
        bw.flush();
    }
}
