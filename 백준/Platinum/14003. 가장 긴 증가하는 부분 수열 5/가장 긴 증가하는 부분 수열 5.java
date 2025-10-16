import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //현재 수의 부모(이전 리스트수)의 인덱스를 저장하고 역추적해야됨.
    static List<Integer> list = new ArrayList<>();
    static int[] parent; // 임시 Lis를 담을 배열 요소의 각 부모 인덱스

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<int[]> binary = new ArrayList<>();
        parent = new int[n];
        for (int i = 0; i < n; i++)
            list.add(Integer.parseInt(st.nextToken()));

        binary.add(new int[] {list.get(0), 0});
        parent[0] = -1; // 첫번째 수의 부모는 없으므로 -1
        for (int i = 1; i < n; i++) {
            if(list.get(i) > binary.get(binary.size() - 1)[0]) {
                parent[i] = binary.get(binary.size()-1)[1]; // 수가 새롭게 들어오면 리스트의 이전 숫자가 부모가 됨.
                binary.add(new int[] {list.get(i) , i});
            }
            else {
                int start = 0;
                int end = binary.size()-1;

                while(start < end) {
                    int mid = (start + end)/2;

                    if(binary.get(mid)[0] < list.get(i))
                        start = mid + 1;
                    else if(binary.get(mid)[0] > list.get(i))
                        end = mid;
                    else
                        break;
                }
                if(start == end) {
                    binary.set(start, new int[] {list.get(i) , i});
                    if(start == 0)
                        parent[i] = -1;
                    else
                        parent[i] = binary.get(start-1)[1];
                }
            }
        }

        for (int i = binary.size()-1; i >= 1; i--) {
            int pIndex = binary.get(i)[1]; // 현재 바이너리 리스트의 마지막 숫자의 시작 인덱스
            binary.set(i - 1, new int[] {list.get(parent[pIndex]), parent[pIndex]});
        }

        bw.write(binary.size() + "\n");
        for(int[] i : binary)
            bw.write(i[0] + " ");
        bw.flush();

    }
}