import java.io.*;
import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N + 1][N + 1];
			
			for(int i = 1; i <= N; i++) {
				int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
				
				for(int k = 1; k <= N; k++) {
					map[i][k] = map[i - 1][k] + map[i][k - 1] + arr[k - 1] - map[i - 1][k - 1];
				}
			}
			
			int max = 0;
			int sum = 0;
			
			for(int i = M; i <= N; i++) {
				for(int k = M; k <= N; k++) {
					
					sum = map[i][k] - map[i - M][k] - map[i][k - M] + map[i - M][k - M];
					max = Math.max(sum,  max);
				}
			}
			
			
			
			System.out.println("#" + test_case + " " + max);
		}
				
	}
}