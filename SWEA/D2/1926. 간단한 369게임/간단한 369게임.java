import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder answer = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			
			boolean flag = false;
			int cnt = 0;
			
			String temp = String.valueOf(i);
			
			for(char c : temp.toCharArray()) {
				if(c != '0' && (int)c % 3 == 0) {
					flag = true;
					cnt++;
				}
			}
			
			if(flag) {
				for(int k = 0; k < cnt; k++) {
					answer.append("-");
				}
				
				answer.append(" ");
			} else {
				answer.append(temp);
				answer.append(" ");
			}
			
		} 
		
		System.out.println(answer.toString());
	}
}