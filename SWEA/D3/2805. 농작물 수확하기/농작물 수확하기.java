import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] drow = {0, 0, -1, 1};
	static int[] dcol = {1, -1, 0, 0};
	
	static boolean isRange(int row, int col, int N) {
		
		if(row < 0 || row >= N || col < 0 || col >= N) {
			return false;
		}
		
		return true;
	}
 	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int answer = 0;
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}
			
			int center = N / 2;
			
			for(int i = 0; i < N; i++) {
				for(int k = 0; k < N; k++) {
					
					if(Math.abs(i - center) + Math.abs(k - center) <= center) {
						answer += map[i][k];
					}
					
				}
			}
			
					
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}