import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
         int sum = brown + yellow;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2; i <= sum / 2; i++) {
            if (sum % i == 0)
                list.add(i);
        }
        list.add(sum);
        int[] answer = new int[2];
        for (int i = 1; i <= list.size() / 2; i++) {
            if (list.get(i) != 2) {
                int column = list.get(i); // 세로
                int low = sum / column; // 가로
                if ((low - 2) * (column - 2) == yellow) {
                    answer[0] = low;
                    answer[1] = column;
                    break;
                }
            }
        }
        return answer;
    }
}