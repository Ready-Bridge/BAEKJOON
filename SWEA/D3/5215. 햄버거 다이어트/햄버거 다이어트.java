import java.io.*;
import java.util.*;

public class Solution {
	
	static int answer;
	
	static void dfs(int idx, int sum, int cal, int[][] arr) {
		
		//칼로리 오버
		if(cal < 0) {
			return;
		}
		
		// 모든 재료 다 확인
		if(idx == arr.length) {
			answer = Math.max(answer, sum);
			return;
		}
		
		dfs(idx + 1, sum + arr[idx][0], cal - arr[idx][1], arr); // 지금 재료 넣었을 때
		dfs(idx + 1, sum, cal, arr); // 지금 재료 안넣었을 때
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= t; test_case++) {
			
			answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, L, arr);
		
			
			System.out.println("#" + test_case + " " + answer);
			
		} 
	}
}