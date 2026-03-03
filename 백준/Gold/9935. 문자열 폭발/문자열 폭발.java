import java.io.*;

public class Main {
    //static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String stack = br.readLine();
        String c4 = br.readLine();

        StringBuilder sb = new StringBuilder();
        int index = c4.length();

        for (char ch : stack.toCharArray()) {
            sb.append(ch);

            if(sb.length() >= index && sb.substring(sb.length()-index).equals(c4)) {
                sb.delete(sb.length()-index, sb.length());
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }

    }
}

