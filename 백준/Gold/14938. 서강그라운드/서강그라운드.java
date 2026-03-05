import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static List<List<int[]>> list = new ArrayList<>();
    static int[] dijkstra;
    static int[] items;
    /*static int[] x = {-1, 1, 0 ,0};
    static int[] y = {0, 0, -1 ,1};
    static int[][] arr;
    static int inputX;
    static int inputY;
    static boolean[][] visited;*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int locate = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        items = new int[locate];
        dijkstra = new int[locate+1];

        for(int i = 0; i <= locate; i++) {
            dijkstra[i] = Integer.MAX_VALUE;
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < locate; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new int[]{to, weight});
            list.get(to).add(new int[]{from, weight});
        }

        int answer = 0;
        for(int i = 1; i <= locate; i++) {
            answer = Math.max(answer, dijkstra(range, i));
            dijkstra = new int[locate+1];
            for(int j = 0; j <= locate; j++) {
                dijkstra[j] = Integer.MAX_VALUE;
            }
        }
        bw.write(answer + "");
        bw.flush();
    }

    public static int dijkstra(int range, int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dijkstra[start] = 0;
        queue.add(new int[]{start, 0});
        int result = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(dijkstra[curr[0]] < curr[1]) // 저장된 값이 더 작으면 건너뜀.
                continue;

            for(int[] node : list.get(curr[0])) {
                int vertex = node[0];
                int weight = node[1] + curr[1];
                if(weight <= range && dijkstra[vertex] > weight) {
                    dijkstra[vertex] = weight;
                    queue.add(new int[]{vertex, weight});
                }
            }
        }
        for(int i = 1; i < dijkstra.length; i++) {
            if(dijkstra[i] != Integer.MAX_VALUE) {
                result += items[i-1];
            }
        }
        return result;
    }
}