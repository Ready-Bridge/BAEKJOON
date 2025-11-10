import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	
	static boolean isSame(int n, int r, int c) {
		int firstVal = map[r][c];
		for(int i = r; i < r + n; i++) {
			for(int j = c; j < c + n; j++) {
				if(map[i][j] != firstVal) {
					return false; // 하나라도 다르면 false
				}
			}
		}
		return true; // 모두 같으면 true
	}
	
	static void quadTree(int n, int r, int c) {
	
		if(isSame(n, r, c)) {
			sb.append(map[r][c]);
			return;
		}
		
		sb.append("("); 
		
		n /= 2; // 영역 크기를 절반으로 줄임
		
		quadTree(n, r, c);             // 1. 좌상
		quadTree(n, r, c + n);         // 2. 우상
		quadTree(n, r + n, c);         // 3. 좌하
		quadTree(n, r + n, c + n);     // 4. 우하
		
		sb.append(")"); 
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int row = 0; row < N; row++) { 

			String line = br.readLine();
			for(int col = 0; col < N; col++) {
				map[row][col] = line.charAt(col) - '0';
			}
		}
		
		quadTree(N, 0, 0);
		
		System.out.println(sb.toString());
	}
}