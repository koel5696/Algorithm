import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<Character> leftSt = new Stack<>();
            Stack<Character> rightSt = new Stack<>();
            
            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if (!leftSt.isEmpty()) {
                        rightSt.push(leftSt.pop());
                    }
                } else if (c == '>') {
                    if (!rightSt.isEmpty()) {
                        leftSt.push(rightSt.pop());
                    }
                } else if (c == '-') {
                    if (!leftSt.isEmpty()) {
                        leftSt.pop();
                    }
                } else {
                    leftSt.push(c);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for (char c : leftSt) {
                sb.append(c);
            }
            while (!rightSt.isEmpty()) {
                sb.append(rightSt.pop());
            }

            bw.write(sb.toString());
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
