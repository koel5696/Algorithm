import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        s = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            s[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int judge = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (judge == 0) {
                int parent1 = find(to);
                int parent2 = find(from);
                if (parent1 != parent2) {
                    s[parent1] = parent2;
                }
            } else {
                if (find(from) == find(to)) {
                    bw.write("YES" + "\n");
                } else {
                    bw.write("NO" + "\n");
                }
            }
        }
        bw.flush();
    }

    private static int find(int num) {
        if (s[num] == num) {
            return num;
        }
        return s[num] = find(s[num]);
    }
}
