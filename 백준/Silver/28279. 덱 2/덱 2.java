
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine()," ");
int x = Integer.parseInt(st.nextToken());
int y = Integer.parseInt(st.nextToken());*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> arr = new LinkedList<>();

        while(n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            switch (a) {
                case 1:
                    arr.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    arr.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3: {
                    if (arr.isEmpty())
                        System.out.println(-1);
                     else {
                        System.out.println(arr.peekFirst());
                        arr.removeFirst();
                    }
                    break;
                }
                case 4: {
                    if (arr.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arr.peekLast());
                        arr.removeLast();
                    }
                    break;
                }
                case 5: {
                    System.out.println(arr.size());
                    break;
                }
                case 6: {
                    if (arr.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                }
                case 7: {
                    if (arr.isEmpty()) {
                        System.out.println(-1);
                    } else
                        System.out.println(arr.peekFirst());
                    break;
                }
                case 8: {
                    if (arr.isEmpty()) {
                        System.out.println(-1);
                    } else
                        System.out.println(arr.peekLast());
                    break;
                }
            }
        }
    }
}
