import java.io.*;
import java.util.*;

public class Solution {
	
	// 우 -> 하 -> 좌 -> 상 (map 크기 넘어가거나 그 다음 셀이 0이 아니라면 방향 전환)
	
	static int[] drow = new int[] {0, 1, 0, -1};
	static int[] dcol = new int[] {1, 0, -1, 0};
	
	static boolean isChange(int row, int col, int N, int[][] arr) {
		
		if(row < 0 || row >= N || col < 0 || col >= N) {
			return true;
		}
		
		if(arr[row][col] != 0) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= t; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			int d = 0; // 방향
			int row = 0;
			int col = 0;
			int value = 1;
			int cnt = N * N;
			
			while(cnt-- > 0) {
				
				arr[row][col] = value++;
				
				// 방향을 바꿔야한다면
				if(isChange(row + drow[d], col + dcol[d], N, arr)) {
					d = (d + 1) % 4;
				}
				
				row += drow[d];
				col += dcol[d];
				
			}
			
			System.out.println("#" + test_case);
			
			for(int i = 0; i < N; i++) {
				for(int k = 0; k < N; k++) {
					System.out.print(arr[i][k] + " ");
				}
				System.out.println();
			}
			
		} 
	}
}