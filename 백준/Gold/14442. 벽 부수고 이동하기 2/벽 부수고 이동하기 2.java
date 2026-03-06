import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int[] x = {-1, 1, 0 ,0};
    static int[] y = {0, 0, -1 ,1};
    static int[][] arr;
    static int inputX;
    static int inputY;
    static int wall;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        inputY = Integer.parseInt(st.nextToken());
        inputX = Integer.parseInt(st.nextToken());
        wall = Integer.parseInt(st.nextToken());
        visited = new boolean[inputY][inputX][wall+1];
        arr = new int[inputY][inputX];

        for(int i = 0; i < inputY; i++) {
            String graph = br.readLine();
            for (int j = 0; j < inputX; j++) {
                arr[i][j] = graph.charAt(j) - '0';
            }
        }
        bw.write(bfs() + "");
        bw.flush();
    }


    public static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if(current[0] == inputY - 1 && current[1] == inputX - 1) {
                return current[2];
            }
            for(int i = 0; i < 4; i++) {
                int ny = y[i] + current[0];
                int nx = x[i] + current[1];
                if(ny >= 0 && ny < inputY && nx >= 0 && nx < inputX) {
                    if (arr[ny][nx] == 1) { // 벽 일시
                        if(current[3] < wall && !visited[ny][nx][current[3] + 1]) { // 다음칸이 벽이고 횟수가 남았다면 부숨
                            visited[ny][nx][current[3] + 1] = true;
                            queue.add(new int[]{ny, nx, current[2] + 1, current[3] + 1});
                        }
                    } else if(!visited[ny][nx][current[3]]) {
                        visited[ny][nx][current[3]] = true;
                        queue.add(new int[]{ny, nx, current[2] + 1, current[3]});
                    }
                }
            }
        }
        return -1;
    }
}