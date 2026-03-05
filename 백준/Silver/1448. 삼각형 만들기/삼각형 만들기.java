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

        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int curr1 = pq.poll();
        int curr2 = pq.poll();
        int curr3 = pq.poll();
        int result = 0;

        if(curr1 < curr2 + curr3) {
            result = curr1 + curr2 + curr3;
        } else {
            while(!pq.isEmpty()) {
                curr1 = curr2;
                curr2 = curr3;
                curr3 = pq.poll();
                if (curr1 < curr2 + curr3) {
                    result = curr1 + curr2 + curr3;
                    break;
                }
            }
        }

        result = (result == 0) ? -1 : result;
        bw.write(result + "");
        bw.flush();
    }
}