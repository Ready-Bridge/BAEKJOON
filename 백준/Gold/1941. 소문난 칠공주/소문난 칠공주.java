import java.util.*;
import java.io.*;

public class Main {
	
	static int[] drow = {-1, 1, 0, 0};
	static int[] dcol = {0, 0, -1, 1};
	static String[][] map;
	static int[] selected= new int[7];
	static int answer;

	static boolean isRange(int row, int col, boolean[][] isVisited) {
		
		// map 넘어가면 
		if(row < 0 || row >= 5 || col < 0 || col >= 5) {
			return false;
		}
		
		// 이미 방문했다면 (이미 해당 지역이 칠공주 구성에 들어가있다면)
		if(isVisited[row][col]) {
			return false;
		}
		
		return true;
	}
	
	static boolean isConnected() {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[][] isVisited = new boolean[5][5];
		boolean[][] isMember = new boolean[5][5];
		
		for(int i = 0; i < 7; i++) {
			int row = selected[i] / 5;
			int col = selected[i] % 5;
			
			isMember[row][col] = true;
		}
		
		queue.add(selected[0]); 
		
		int row = selected[0] / 5;
		int col = selected[0] % 5;
		
		isVisited[row][col] = true;
		
		int people = 1;
		
		while(!queue.isEmpty()) {
			
			int idx = queue.poll();
			row = idx / 5;
			col = idx % 5;
			
			
			for(int i = 0; i < 4; i++) {
				if(isRange(row + drow[i], col + dcol[i], isVisited)) {
					if(isMember[row + drow[i]][col + dcol[i]]) {
						
						isVisited[row + drow[i]][col + dcol[i]] = true;
						queue.add((row + drow[i]) * 5 + (col + dcol[i]));
						people++;
					}
				}
			}
		}
		
		return people == 7;
		
	}
	
	static void find(int idx, int cnt, int sCnt) {
		
		if(cnt == 7) {
			if(sCnt >= 4) {
				if(isConnected()) {
					answer++;
				}
			}
			
			return;
		}
		
		if(idx == 25) {
			return;
		}
		
		//지금 index를 칠공주에 포함시킬 경우 
		
		int row = idx / 5;
		int col = idx % 5;
		
		selected[cnt] = idx;
		
		int nextsCnt = sCnt;
		
		if(map[row][col].equals("S")) {
			nextsCnt = sCnt + 1;
		}
		
		find(idx + 1, cnt + 1, nextsCnt);
		
		// 지금 index를 칠공주에 포함시키지 않을 경우 
		find(idx + 1, cnt, sCnt);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new String[5][5];
		
		for(int i = 0; i < 5; i++) {
			String[] temp = br.readLine().split("");
			map[i] = temp;
		}
		
		find(0, 0, 0);
		
		
		System.out.println(answer);		
	}
	
}