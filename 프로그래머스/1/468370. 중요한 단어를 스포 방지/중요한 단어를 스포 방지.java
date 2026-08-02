import java.io.*;
import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        List<String> messages = new ArrayList<>();
        Collections.addAll(messages, message.split(" ")); //
        List<String> non_filter = new ArrayList<>(messages);
        List<String> filters = new ArrayList<>();

        int bufferEnd = 0;
        for (int i = 0; i < spoiler_ranges.length; i++) {
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];

            while (start > 0 && message.charAt(start) != ' ')
                start--;
            while (end < message.length() && message.charAt(end) != ' ')
                end++;

            if(bufferEnd > start) {
                start = bufferEnd;
            }
            String word = message.substring(start, end);
            if(!word.isEmpty())
                Collections.addAll(filters, word.trim().split(" "));
            bufferEnd = end;
        }
        for (String word : filters)
            non_filter.remove(word);

        List<String> beforeFilter = new ArrayList<>();
        for (String word : filters) {
            if (!beforeFilter.contains(word) && !non_filter.contains(word)) {
                beforeFilter.add(word);
                answer++;
            }
        }

        return answer;
    }
}