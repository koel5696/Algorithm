import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*static List<List<int[]>> list = new ArrayList<>();
    static int[] dijkstra;
    static int[] items; */
    static int[] x = {-1, 1, 0 ,0};
    static int[] y = {0, 0, -1 ,1};
    static int[][] arr;
    static int inputX;
    static int inputY;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        inputY = Integer.parseInt(st.nextToken());
        inputX = Integer.parseInt(st.nextToken());
        visited = new boolean[inputY][inputX];
        arr = new int[inputY][inputX];

        int total = 0;
        for(int i = 0; i < inputY; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < inputX; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    total++;
                }
            }
        }
        bw.write(run(total) + "");
        bw.flush();
    }

    public static int run(int total) {
        int answer = 0;
        for(int i = 0; i < inputY; i++) {
            for (int j = 0; j < inputX; j++) {
                if (arr[i][j] > 0) {
                    visited[i][j] = true;
                    int[] curr = bfs(j, i);
                    if(curr[0] == total) {
                        answer++;
                        total = curr[1];
                    } else {
                        return answer;
                    }
                    visited = new boolean[inputY][inputX];
                }
            }
        }
        return 0;
    }

    public static int[] bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        int[] total = new int[2];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            total[0]++; // 순회 도는 요소 갯수 체크
            int count = 0;
            for(int i = 0; i < 4; i++) {
                int ny = y[i] + current[0];
                int nx = x[i] + current[1];
                if(ny >= 0 && ny < inputY && nx >= 0 && nx < inputX && !visited[ny][nx]) {
                    if (arr[ny][nx] > 0) { // 아직 방문하지 않았고 빙산이 있어야함.
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    } else if(arr[ny][nx] <= 0) {
                        count++; // 방문여부와 상관없이 인접 장소가 바다면 카운트
                    }
                }
            }
            arr[current[0]][current[1]] -= count;
            if(arr[current[0]][current[1]] > 0) {
                total[1]++;
            }
        }
        return total;
    }
}