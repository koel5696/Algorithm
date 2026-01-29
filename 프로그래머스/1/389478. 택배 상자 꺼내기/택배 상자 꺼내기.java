class Solution {
   public int solution(int n, int w, int num) {
        int answer = 1;
        int floor = num % w != 0 ? (num / w) + 1 : num / w;
        int add;
        while (true) {
            add = ((w * floor) - num) * 2 + 1;
            if (num + add > n) {
                break;
            } else {
                num += add;
                answer++;
                floor++;
            }
        }
        return answer;
    }
}