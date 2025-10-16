import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < n-1; i++) {
            int next = Integer.parseInt(st.nextToken());
            if(list.get(list.size() - 1) < next)
                list.add(next);
            else {
                int start = 1;
                int end = list.size()-1;
                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (next <= list.get(mid))
                        end = mid - 1;
                    else
                        start = mid + 1;


                    if(end < start && next > list.get(mid))
                        list.set(mid+1, next);
                    else if(end < start && next < list.get(mid))
                        list.set(mid, next);
                }
            }
        }
        bw.write(list.size()-1 + "\n");
        bw.flush();
    }
}


