import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        dp.get(1).add(N);
        
        for(int i = 2; i <= 8; i++) {
            int concat = 0;
            for(int k = 0; k < i; k++){
                concat = concat * 10 + N;
            }
            dp.get(i).add(concat);
            for(int j = 1; j <= i-1; j++) {
                for(int num1 : dp.get(i-j)) {
                    for(int num2 : dp.get(j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if(num2 != 0) dp.get(i).add(num1 / num2);
                    }
                }
            }
        }
        int answer = -1;
        for(int i = 1; i <= 8; i++) {
            if(dp.get(i).contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}