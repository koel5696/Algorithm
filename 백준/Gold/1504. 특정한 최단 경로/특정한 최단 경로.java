
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

       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       int vertex = Integer.parseInt(st.nextToken());
       int edge = Integer.parseInt(st.nextToken());
       dijkstra = new int[vertex + 1];

        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(startNode).add(new int[]{endNode, weight});
            graph.get(endNode).add(new int[]{startNode, weight});
        }
        st = new StringTokenizer(br.readLine(), " ");

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int result1 = 0;
        int result2 = 0;

        if(isExistV1V2(v1, v2, vertex)) {
            bw.write("-1");
            bw.flush();
            return;
        }

        dist(1);
        result1 += dijkstra[v1];
        result2 += dijkstra[v2];

        dist(v1);
        result1 += dijkstra[v2];
        result2 += dijkstra[vertex];

        dist(v2);
        result1 += dijkstra[vertex];
        result2 += dijkstra [v1];

        bw.write(Math.min(result1, result2) + "");
        bw.flush();
    }

    public static void dist(int startVertex) {
        for (int i = 1; i < dijkstra.length; i++) {
            dijkstra[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{startVertex, 0});
        dijkstra[startVertex] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(dijkstra[curr[0]] < curr[1]) {
                continue;
            }

            for(int[] edge : graph.get(curr[0])) {
                int to = edge[0];
                int totalWeight = curr[1] + edge[1];
                if(dijkstra[to] > totalWeight) {
                    dijkstra[to] = totalWeight;
                    q.add(new int[]{to, totalWeight});
                }
            }
        }
    }

    public static boolean isExistV1V2(int v1, int v2, int vertex) {
        dist(1);
        return dijkstra[v1] == Integer.MAX_VALUE || dijkstra[v2] == Integer.MAX_VALUE ||
                dijkstra[vertex] == Integer.MAX_VALUE;
    }
}
