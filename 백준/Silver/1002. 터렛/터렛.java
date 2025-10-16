import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

            if(x1 == x2 && y1 == y2 && r1 == r2)
                System.out.println(-1); // 다 같으면 무한대
            else if((r1 + r2 < d) || (r1+d < r2) || (r2 +d < r1))
                System.out.println(0); // 첫줄에서 삼각형의 정의 성립 여부 확인.
            else if((r1+r2 == d) || (r1+d == r2) || (r2 + d == r1))
                System.out.println(1); //거리와 r간 의 거리가 같으면 1.
            else if((x1 == x2 && y1 == y2)) //각 점의 위치만 같고 r은 다르면 불가능.
                System.out.println(0);
            else if (r1+r2 > d) // 일반적으로 두개의 r거리가 d보다 크면 2가지 경우가 나옴.
                System.out.println(2);

        }
    }
}


