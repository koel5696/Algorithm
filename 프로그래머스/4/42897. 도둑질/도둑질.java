import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length - 1;
        int[] excludeFirst = new int[n]; // index 0 미포함
        int[] excludeLast = new int[n]; // index n-1 미포함

        excludeFirst[0] = money[1];
        excludeFirst[1] = money[2];

        excludeLast[0] = money[0];
        excludeLast[1] = money[1];

        int answer;
        for (int i = 2; i < n; i++) {
            if (i >= 3)
                excludeFirst[i] = Math.max(excludeFirst[i - 2], excludeFirst[i - 3]) + money[i + 1];
            else
                excludeFirst[i] = excludeFirst[i - 2] + money[i + 1];
        }
        answer = Math.max(excludeFirst[n - 1], excludeFirst[n - 2]);

        for (int i = 2; i < n; i++) {
            if (i >= 3)
                excludeLast[i] = Math.max(excludeLast[i - 2], excludeLast[i - 3]) + money[i];
            else
                excludeLast[i] = excludeLast[i - 2] + money[i];
        }
        answer = Math.max(answer, Math.max(excludeLast[n - 1], excludeLast[n - 2]));
        return answer;
    }
}