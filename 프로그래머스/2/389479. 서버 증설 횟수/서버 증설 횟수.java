import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
       int answer = 0;
        int currServer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k-1; i++)
            queue.add(0);

        for (int i = 0; i < players.length; i++) {
            if (players[i] > currServer * m + (m-1)) { // 현재 증설된 서버 갯수에 따른 최대 인원보다 많을 시 증설
                answer += players[i] / m - currServer; // 이미 증설되어 있는 서버는 제하고 추가
                queue.add(players[i] / m - currServer);
                currServer = players[i] / m; // 현재 증설된 서버 갯수
                currServer -= queue.poll();
            } else {
                queue.add(0);
                int server = queue.poll();
                if (server != 0)
                    currServer -= server;
            }
        }

        return answer;
    }
}