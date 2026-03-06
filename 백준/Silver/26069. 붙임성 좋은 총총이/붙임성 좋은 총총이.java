import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int count = 0;
       HashSet<String> arr = new HashSet<>();

       //추가가 안되면 true값이 있다는 것으로 가정해 카운트함.
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            boolean aExists = arr.contains(a); // 존재하면 참 없으면 거짓
            boolean bExists = arr.contains(b); // 입력값이 들어있는지 확인

            if((aExists || bExists) && !(aExists && bExists)) {
                arr.add(a);
                arr.add(b);
                count++; // 둘 다 존재하면 이미 새로운 존재는 추가되지 않으므로
            //카운트 되지 않고 하나는 추가되어 있는 값이 하나는 새로운 값이라면 새롭게 감염되어
            //카운트 추가함.
            } else if((a.equals("ChongChong") || b.equals("ChongChong")) && !(aExists && bExists)) {
                arr.add(a);
                arr.add(b);
                //총총이 둘다 나오면 하나만 늘리고 둘 중 하나면 카운트 2개 증가.
                if(a.equals("ChongChong") && b.equals("ChongChong"))
                    count++;
                else
                    count+=2;
            }
        }
        System.out.println(count);
    }
}
