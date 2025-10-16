import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] y = {-1, 1, 0, 0};
    static int[] x =  {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[2][n][m]; // 벽은 부순 루트와 부수지 않은 루트

        for(int i = 0; i < n; i++){
            char[] num = br.readLine().toCharArray();
            for(int j = 0; j < m; j++)
                arr[i][j] = num[j] - '0';
        }

        int result;
        if(n == 1 && m == 1 && arr[0][0] == 0)
            result = 1;
        else if(n == 1 && m == 1 && arr[0][0] == 1)
            result = -1;
        else
            result = bfs(n, m);

        bw.write(result +" ");
        bw.flush();

    }

    public static int bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1, 0}); // x, y, depth, destroy 유무
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y[i] + cur[0];
                int nx = x[i] + cur[1];
                int depth = cur[2];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) // 범위에서 벗어나면 안함
                    continue;

                if(ny == n-1 && nx == m-1) // 도착지에 도달했던 끝
                    return depth+1;

                if (arr[ny][nx] == 1 && cur[3] == 0 && !visited[1][ny][nx]) {  // 지금까지 벽을 한번도 부시지 않았다면 부시고 이동
                    queue.add(new int[]{ny, nx, depth + 1, 1});
                    visited[1][ny][nx] = true;
                }

                if(arr[ny][nx] == 0 && !visited[cur[3]][ny][nx]) { // 다음이 그냥 길이면 간다
                    queue.add(new int[]{ny, nx, depth + 1, cur[3]});
                    visited[cur[3]][ny][nx] = true;

                }
            }
        }
        return -1;
    }
}