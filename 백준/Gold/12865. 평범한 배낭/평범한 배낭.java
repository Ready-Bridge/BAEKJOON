import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N + 1][K + 1]; // n번째까지의 짐, 가방 수용 무게
		List<int[]> list = new ArrayList<>(); 
		list.add(new int[] {-1, -1}); // 인덱스 번호를 맞추기위해 0번인덱스를 채워넣음 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {W, V});
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				
				// 수용 무게보다 현재 짐의 무게가 더 크면 
				if(list.get(i)[0] > j) {
					dp[i][j] = dp[i - 1][j]; // 이전 짐까지의 최대 가치를 따라
				} else {
					dp[i][j] = Math.max(list.get(i)[1] + dp[i - 1][j - list.get(i)[0]], dp[i - 1][j]); // 현재 짐을 넣는 경우와 넣지 않는 경우 
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
}