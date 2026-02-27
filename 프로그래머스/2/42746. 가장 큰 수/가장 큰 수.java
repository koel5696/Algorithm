import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] result = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            result[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(result, (a, b) -> (a+b).compareTo(b+a));
       
         if(result[result.length - 1].equals("0")) {
            return "0";
        }
        
        for(int i = result.length - 1; i >= 0; i--) {
            answer += result[i];
        }
        
        return answer;
    }
}