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
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer :: parseInt).toArray();
			}
			
			int[][] dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
			
			q.add(new int[] {0, 0, map[0][0]});
			dist[0][0] = map[0][0];
			
			while(!q.isEmpty()) {
				
				int[] arr = q.poll();
				int row = arr[0];
				int col = arr[1];
				int nowDist = arr[2];
				
				for(int d = 0; d < 4; d++) {
					int newRow = row + drow[d];
					int newCol = col + dcol[d];
					
					if(isRange(newRow, newCol, N)) {
						
						if(map[newRow][newCol] + nowDist < dist[newRow][newCol]) {
							
							dist[newRow][newCol] = map[newRow][newCol] + nowDist;
							q.add(new int[] {newRow, newCol, dist[newRow][newCol]});
						}
					}
				}
				
			}
					
			System.out.println("#" + test_case + " " + dist[N - 1][N - 1]);
			
		}
	}
}