
import java.util.*;
import java.io.*;

class Solution
{
	public static int[] arr = {-2, -1, 1, 2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		for(int i = 1; i <= 10; i++) {
			int count = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ArrayList<Integer> num = new ArrayList<>();
			for(int j = 1; j <= count; j++) {
				num.add(Integer.parseInt(st.nextToken()));
			}
			int result = 0;
			for (int j = 2; j < num.size() - 2; j++) {
				int current = num.get(j);
				int max = 0;
				for (int buff : arr) {
					max = Math.max(max, num.get(j-buff));
				}
				if(max < current) {
					result += current - max;
				}
			}
			bw.write("#" + i +" "+ result + "\n");
			bw.flush();
			
		}
	}
}