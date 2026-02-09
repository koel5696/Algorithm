import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] words = br.readLine().toCharArray();
            int buffer = 1;
            int sum = 0;
            for (char word : words) {
                if (word == 'O') {
                    sum += buffer++;
                } else {
                    buffer = 1;
                }
            }
            bw.write(sum + "\n");
        }
        bw.flush();
    }
}
