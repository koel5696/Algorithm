import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> sour = new ArrayList<>();
    static List<Integer> bitter = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = (int) Math.pow(2, n) - 1;
        if (count == 0) {
            count = 1;
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sour.add(Integer.parseInt(st.nextToken()));
            bitter.add(Integer.parseInt(st.nextToken()));
        }

        long min = Long.MAX_VALUE;
        for (int i = 1; i <= count; i++) {
            List<Integer> temp = new ArrayList<>();
            String binary = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    temp.add(j);
                }
            }
            long sour1 = sour.get(temp.get(0));
            long bitter1 = bitter.get(temp.get(0));

            for (int j = 1; j < temp.size(); j++) {
                sour1 *= sour.get(temp.get(j));
                bitter1 += bitter.get(temp.get(j));
            }
            min = Math.min(min, Math.abs(sour1 - bitter1));
        }

        bw.write(min + "\n");
        bw.flush();
    }


}
