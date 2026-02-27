import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int max = citations.length;
        
        for(int i = 1; i <= max; i++) {
            for(int j = 0; j < max; j++) {
                if(citations[j] >= i && max-j >= i) {
                    answer = i;
                }
            }
        }
        return answer;
    }
}