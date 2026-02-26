import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int first = 0;
        int last = n-1;
        int result = 0;
        int x = Integer.parseInt(br.readLine());
        if(n == 1) {
            bw.write(0 + "");
            bw.flush();
            return;
        }

        while(first < last) {
            if(arr[first] + arr[last] == x) {
                first++;
                last--;
                result++;
            } else if(arr[first] + arr[last] > x) {
                last--;
            } else
                first++;
        }


        bw.write(result + "");
        bw.flush();
    }
}