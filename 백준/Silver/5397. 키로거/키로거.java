import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            LinkedList<Character> password = new LinkedList<>();
            char[] input = br.readLine().toCharArray();
            int index = 0;
            for (char value : input) {
                if (value == '<') {
                    if (index > 0) {
                        index--;
                    }
                } else if (value == '>') {
                    if (index < password.size()) {
                        index++;
                    }
                } else if (value == '-') {
                    if (index > 0) {
                        password.remove(--index);
                    }
                } else {
                    password.add(index, value);
                    index++;
                }
            }
            String result = password.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            bw.write(result + "\n");
            bw.flush();
        }
    }
}
