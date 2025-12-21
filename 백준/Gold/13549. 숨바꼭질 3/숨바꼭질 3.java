import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<int[]>> graph = new ArrayList<>();
    static Boolean[] visited;
    static int[] dijkstra;
    static int m;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max = Math.max(n, m);

        for (int i = 0; i <= max + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new Boolean[max + 2];
        Arrays.fill(visited, false);

        for (int i = 0; i < graph.size(); i++) {
            if (i != 0) {
                graph.get(i).add(new int[]{i * 2, 0});
                graph.get(i).add(new int[]{i - 1, 1});
            }
            graph.get(i).add(new int[]{i + 1, 1});
        }
        visited[n] = true;
        bfs(n, max);
        bw.write(length + "");
        bw.flush();
    }


    public static void bfs(int n, int max) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == m) {
                length = curr[1];
                return;
            }
            for (int[] child : graph.get(curr[0])) {
                if (child[0] <= max + 1 && !visited[child[0]]) {
                    visited[child[0]] = true;
                    int next = child[0];
                    int nextLength = child[1];
                    queue.add(new int[]{next, nextLength + curr[1]});

                }
            }
        }
    }
}
