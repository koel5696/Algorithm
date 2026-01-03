import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); //도시개수
        int m = Integer.parseInt(br.readLine()); //여행 루트

        s = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            s[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int judge = Integer.parseInt(st.nextToken());
                if (judge == 1) {
                    int parent1 = find(j);
                    int parent2 = find(i);
                    if (parent1 != parent2) {
                        s[parent2] = parent1;
                    }
                }
            }
        }

      /*  for (int i = 1; i <= n; i++) {
            s[i] = find(s[i]); // 기준이 없이 합친다면 꼬임. 최종적으로 부모가 어디인지 업데이트할 필요가있음!!
        }*/

        List<Integer> num = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }

        int parent = find(s[num.get(0)]);
        for (int i = 1; i < num.size(); i++) {
            if (parent != find(s[num.get(i)])) { // 여기서 확인 가능
                bw.write("NO");
                bw.flush();
                return;
            }
        }
        bw.write("YES");
        bw.flush();
    }

    private static int find(int num) {
        if (s[num] == num) {
            return num;
        }
        return s[num] = find(s[num]);
    }
}
