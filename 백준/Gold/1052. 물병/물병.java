import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m > Integer.bitCount(n)) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        while (Integer.bitCount(n) > m) {
            int firstOne = n & -n; // 뒤집고 1을 더해라.
            answer += firstOne;
            n += firstOne;

        }

        bw.write(answer + "\n");
        bw.flush();

    }
}
