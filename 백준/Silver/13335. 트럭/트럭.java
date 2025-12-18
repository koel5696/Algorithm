
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dijkstra;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int truckCount = Integer.parseInt(st.nextToken());
        int bridgeLength = Integer.parseInt(st.nextToken());
        int bridgeWeight = Integer.parseInt(st.nextToken());
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < truckCount; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        int current = 0;

        while(true) {
            int insert;
            if(truck.isEmpty()) {
                insert = 0;
            } else
                insert = truck.peek();
            //현재 다리가 꽉차면
            if(bridge.size() == bridgeLength) {
                current -= bridge.poll();
            }
            //현재 아직 다리 칸이 남아있으면서 새 트럭이 들어올때 하중이 버티지 못하는 경우
            if(bridge.size() < bridgeLength && current + insert > bridgeWeight) {
                bridge.add(0);
                result++;
                continue;
            }
            if(insert == 0)
                bridge.add(0);
            else
                bridge.add(truck.poll());
            current += insert;
            result++;
            if(bridge.size() == bridgeLength && current == 0) {
                break;
            }
        }

        bw.write(result + "");
        bw.flush();

    }
}
