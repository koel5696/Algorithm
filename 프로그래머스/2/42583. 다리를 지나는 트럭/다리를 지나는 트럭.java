import java.util.*;
class Solution {
    // 일단 풀긴 했는데 제대로 된 큐 활용을 통한 사고를 다시 해볼 필요 있음!
    // 일단 풀긴 했는데 제대로 된 큐 활용을 통한 사고를 다시 해볼 필요 있음!
    // 일단 풀긴 했는데 제대로 된 큐 활용을 통한 사고를 다시 해볼 필요 있음!
    // 일단 풀긴 했는데 제대로 된 큐 활용을 통한 사고를 다시 해볼 필요 있음!
    // 일단 풀긴 했는데 제대로 된 큐 활용을 통한 사고를 다시 해볼 필요 있음!
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<int[]> queue = new LinkedList<>();
        Deque<Integer> trucks = new LinkedList<>();

        for (int truck : truck_weights)
            trucks.add(truck);

        int time = 1;
        int cur = trucks.element();
        queue.add(new int[]{trucks.poll(), 1});

        while (!queue.isEmpty() || !trucks.isEmpty()) {
            for (int i = 0; i < queue.size(); i++)
                queue.get(i)[1] += 1;
            for (int i = 0; i < queue.size(); i++) {
                if (queue.getFirst()[1] > bridge_length)// 다리를 넘어갔다면 그 트럭은 끝
                    cur -= queue.poll()[0];
            }

            //현재 무게와 현재 다리 위의 트럭 수가 제시된 값보다 작거나 같으면 수행
            if (!trucks.isEmpty() && cur + trucks.getFirst() <= weight && queue.size() + 1 <= bridge_length) {
                queue.add(new int[]{trucks.peek(), 1});
                cur += trucks.poll();
            }
            time++;
        }
        return time;
    }
}