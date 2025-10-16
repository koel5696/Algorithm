import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < count; right++) {
            int num = arr[right];
            map.put(num, map.getOrDefault(num, 0) + 1);

            // 숫자 종류가 2개를 초과하면 왼쪽 포인터 이동
            while (map.size() > 2) {
                int leftNum = arr[left];
                map.put(leftNum, map.get(leftNum) - 1);
                if (map.get(leftNum) == 0) {
                    map.remove(leftNum);
                }
                left++;
            }

            // 현재 윈도우 길이 계산
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
