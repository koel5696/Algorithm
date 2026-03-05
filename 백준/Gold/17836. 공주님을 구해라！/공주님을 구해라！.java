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
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        inputY = Integer.parseInt(st.nextToken());
        inputX = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        arr = new int[inputY][inputX];
        visited = new boolean[inputY][inputX];

        for(int i = 0; i < inputY; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < inputX; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        int answer = dfs();

        if(answer == Integer.MAX_VALUE || answer > time) {
            bw.write("Fail");
        } else
            bw.write(answer + "");
        bw.flush();
    }

    public static int dfs() {
        int sword = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x[i] + curr[1];
                int ny = y[i] + curr[0];
                if(nx >= 0 && nx < inputX && ny >= 0 && ny < inputY
                        && !visited[ny][nx] && arr[ny][nx] != 1) {
                    if(nx == inputX-1 && ny == inputY-1) {
                        result = curr[2] + 1;
                        break;
                    }
                    if(arr[ny][nx] == 2) {
                        sword = (curr[2] + 1) + (inputX - 1 - nx) + (inputY - 1 - ny);
                    }
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx, curr[2] + 1});
                }
            }
        }
        return Math.min(sword, result);
    }
}