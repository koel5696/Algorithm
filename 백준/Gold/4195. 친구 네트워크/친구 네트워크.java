import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, String> s;
    static Map<String, Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); //도시개수
        for (int i = 0; i < n; i++) {
            s = new LinkedHashMap<>();
            result = new HashMap<>();
            int m = Integer.parseInt(br.readLine());

            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!s.containsKey(name1)) {
                    s.put(name1, name1);
                    result.put(name1, 1);
                }
                if (!s.containsKey(name2)) {
                    s.put(name2, name2);
                    result.put(name2, 1);
                }
                s.putIfAbsent(name2, name2);

                String parent1 = find(name1);
                String parent2 = find(name2);

                if (!parent1.equals(parent2)) {
                    s.put(parent1, parent2);
                    result.put(parent2, result.getOrDefault(parent2, 0) + result.get(parent1));
                }

                bw.write(result.get(parent2) + "\n");
            }
        }
        bw.flush();

    }

    private static String find(String name) {
        if (s.get(name).equals(name)) {
            return name;
        }
        String parent = find(s.get(name));
        s.put(name, parent);
        
        return parent;
    }

}
