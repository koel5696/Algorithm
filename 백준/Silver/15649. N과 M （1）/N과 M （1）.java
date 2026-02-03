import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static boolean[] check;
    static int[][] list;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> buff = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = j + 1;
            }
        }
        check = new boolean[n];
        backTracking(0, m, n);
        bw.write(sb.toString());
        bw.flush();
    }

    static void backTracking(int row, int m, int n) {
        if (row == m) {
            for (int num : buff) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                check[i] = true;
                buff.add(list[row][i]);
                backTracking(row + 1, m, n); //자식노드 방문
                check[i] = false; //자식노드 방문했으면 부모노드 다시 방문기록지움
                buff.remove(buff.size() - 1);
            }
        }
    }

}
