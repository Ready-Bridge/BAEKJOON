import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			
			long answer = 0;
			int max = -1;
			
			int N = Integer.parseInt(br.readLine());
			
			int[] days = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = N - 1; i >= 0; i--) {
				
				if(max < days[i]) {
					max = days[i];
				} else {
					answer += (max - days[i]);
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
	}

}
