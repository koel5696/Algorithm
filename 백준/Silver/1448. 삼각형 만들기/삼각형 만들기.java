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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, (a, b) -> b - a);

        int result = 0;
        for(int i = 0; i < n-2; i++) {
            if(arr[i+1] + arr[i+2] > arr[i]) {
                result = arr[i] + arr[i+1] + arr[i+2];
                break;
            }
        }
        result = (result == 0) ? -1 : result;
        bw.write(result + "");
        bw.flush();
    }
}