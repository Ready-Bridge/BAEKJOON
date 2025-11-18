import java.io.*;
import java.util.*;

public class Solution {
	
	static int max = -1;
	static boolean[][] visited = new boolean[1000000][11];
	
	static String swap(String s, int i, int k) {
		
		StringBuilder sb = new StringBuilder();
		char[] arr = s.toCharArray(); 
		
		for(int idx = 0; idx < arr.length; idx++) {
			if(idx == i) {
				sb.append(arr[k]);
			}else if(idx == k) {
				sb.append(arr[i]);
			} else {
				sb.append(arr[idx]);
			}
		}
		
		return sb.toString();
	}
	
	static void dfs(String ss, int cnt) {
		
		if(cnt == 0) {
			max = Math.max(max, Integer.parseInt(ss));
			return;
		}
		
		for(int i = 0; i < ss.length(); i++) {
			for(int k = i + 1; k < ss.length(); k++) {
				
				String s = swap(ss, i , k);
				
				if(visited[Integer.parseInt(s)][cnt - 1]) {
					continue;
				} else {
					visited[Integer.parseInt(s)][cnt - 1] = true;
					dfs(s, cnt - 1);
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= t; test_case++) {
			
			max = -1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			dfs(st.nextToken(), Integer.parseInt(st.nextToken()));
			
			System.out.println("#" + test_case + " " + max);
			
		} 
	}
}