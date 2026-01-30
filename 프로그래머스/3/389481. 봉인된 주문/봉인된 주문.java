import java.util.*;

class Solution {
 public String solution(long n, String[] bans) {
        long[] number = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            number[i] = decimalNumbers(bans[i]);
        }
        Arrays.sort(number);

        for (long num : number) {
            if (num <= n)
                n++;
        }
        return function(n);
    }

    public String function(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) (--n % 26 + 97));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public long decimalNumbers(String word) {
        long result = 0;
        for (int i = 0; i < word.length(); i++) {
            result = result * 26 + (word.charAt(i) - 'a' + 1);
        }
        return result;
    }
}