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
    static StringBuilder sb = new StringBuilder();
    static List<String> cases = new ArrayList<>();
    static List<String> result = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int consonants = 0;
        int vowel = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            cases.add(st.nextToken());
        }
        Collections.sort(cases);
        backTracking(0, n, m, consonants, vowel);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void backTracking(int start, int n, int m, int consonants, int vowel) {
        if (result.size() == n) {
            if (consonants >= 2 && vowel >= 1) {
                sb.append(String.join("", result)).append("\n");
            }
            return;
        }

        for (int i = start; i < m; i++) {
            result.add(cases.get(i));
            if (isVowel(cases.get(i).charAt(0))) {
                backTracking(i + 1, n, m, consonants, vowel + 1);
            } else {
                backTracking(i + 1, n, m, consonants + 1, vowel);
            }
            result.remove(result.size() - 1);
        }
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
