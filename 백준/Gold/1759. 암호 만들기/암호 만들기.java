import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static List<String> cases = new ArrayList<>();
    static List<String> result = new ArrayList<>();
    static int consonants = 0;
    static int vowel = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            cases.add(st.nextToken());
        }
        Collections.sort(cases);

        visited = new boolean[m];
        backTracking(0, n, m);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void backTracking(int start, int n, int m) {
        if (result.size() == n) {
            String buffer = String.join("", result);
            Collections.sort(result);
            String bufferSort = String.join("", result);

            if (buffer.equals(bufferSort) && consonants >= 2 && vowel >= 1) {
                sb.append(buffer).append("\n");
            }
            return;
        }

        for (int i = start; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (isVowel(cases.get(i).charAt(0))) {
                    vowel++;
                } else {
                    consonants++;
                }
                result.add(cases.get(i));
                backTracking(i + 1, n, m);
                visited[i] = false;
                if (isVowel(cases.get(i).charAt(0))) {
                    vowel--;
                } else {
                    consonants--;
                }
                result.remove(result.size() - 1);
            }
        }
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
