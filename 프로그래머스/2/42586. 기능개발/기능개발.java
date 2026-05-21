import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.push(progresses[i]);
        }

        int num = 0;
        while (num < progresses.length) {
            if (progresses[num] >= 100) {
                int result = 1;
                num++;
                for (int i = num; i < progresses.length; i++) {
                    if (progresses[i] >= 100) {
                        result++;
                        num++;
                    } else
                        break;
                }
                answer.add(result);
            }
            for (int i = num; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}