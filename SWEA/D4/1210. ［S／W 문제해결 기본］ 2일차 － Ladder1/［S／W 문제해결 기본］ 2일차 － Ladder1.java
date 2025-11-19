import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			
			String caseNumber = br.readLine();
			
			int row = 99;
			int col = 0;
			
			int[][] map = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			// 목적지 찾기
			for(int i = 0; i < 100; i++) {
				
				if(map[99][i] == 2) {
					col = i;
					break;
				}
			}
			
			int prev = -1;
			
						
			// 출발지에 도착할 때 까지 계속 이동
			while(row > 0) {
				
				// 좌로 이동해야하는 경우 
				if(prev != 0 && col >= 1 && map[row][col - 1] == 1) {
					prev = 1;
					col--;
					continue;
				}
				
				
				// 우로 이동해야하는 경우  
				if(prev != 1 && col < 99 && map[row][col + 1] == 1) {
					prev = 0;
					col++;
					continue;
				}
				
				// 위로 이동해야하는 경우 
				if(map[row - 1][col] == 1) {
					row--;
					prev = -1;
				}
			}
			
			
			System.out.println("#" + test_case + " " + col);
			
		}
	}
}