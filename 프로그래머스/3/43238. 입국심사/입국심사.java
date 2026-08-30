import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
      Arrays.sort(times);

        long max = (long) Arrays.stream(times).max().getAsInt() * n;
        long min = 0;

        while (max > min) {
            long mid = min + (max - min) / 2;
            long count = 0;
            for (int time : times)
                count += mid / time;
            if (count >= n) {
                max = mid;
            } else
                min = mid + 1;
        }

        return max;
    }
}