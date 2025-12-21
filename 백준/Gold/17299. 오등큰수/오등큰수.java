import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];
        int[] frequencyList = new int[n];
        int[] result = new int[n];
        Map<Integer, Integer> frequency = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            frequencyList[i] = frequency.get(arr[i]);
        }

        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && frequencyList[stack.peek()] < frequencyList[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            if (result[i] == 0) {
                result[i] = -1;
            }
        }

        String result1 = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        bw.write(result1);
        bw.flush();

    }
}
