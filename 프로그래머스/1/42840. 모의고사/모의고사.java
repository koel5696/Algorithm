import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] counts = {0, 0, 0};
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < answers.length; i++) {
            if(a[i % a.length] == answers[i])
                counts[0] += 1;
            if(b[i % b.length] == answers[i]) 
                counts[1] += 1;
            if(c[i % c.length] == answers[i]) 
                counts[2] += 1;
        }
        max = Math.max(max, Math.max(counts[0], Math.max(counts[1], counts[2])));
        
        for (int i = 0; i < 3; i++) {
            if(max == counts[i])
                list.add(i+1);
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}