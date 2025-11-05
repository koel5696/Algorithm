
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
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dijkstra;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertex = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        dijkstra = new int[vertex+1];

        for (int i = 0; i <= vertex; i++)
            graph.add(new ArrayList<>());

        for (int i = 1; i <= vertex; i++)
            dijkstra[i] = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 1; i <= edges; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, weight});
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra[start] = 0;

        dijkstraBfs(start);

        bw.write(dijkstra[end] + "\n");
        bw.flush();
    }

    public static void dijkstraBfs(int startVertex) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{startVertex, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(dijkstra[cur[0]] < cur[1]) // 저장된 값이 더 작으면 건너뜀.
                continue;

            for (int[] edge : graph.get(cur[0])) {
                int to = edge[0];
                int weight = edge[1] + cur[1];
                if(dijkstra[to] > weight) {
                    dijkstra[to] = weight;
                    q.add(new int[]{to, weight});
                }
            }
        }
    }
}
