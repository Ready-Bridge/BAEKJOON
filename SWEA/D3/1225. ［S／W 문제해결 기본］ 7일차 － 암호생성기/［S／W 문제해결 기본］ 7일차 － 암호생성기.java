import java.io.*;
import java.util.*;

public class Solution {
	
 	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case = 1; test_case <= 10; test_case++) {
						
			
			int T = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			
			while(st.hasMoreTokens()) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 1;
			
			while(true) {
				
				int temp = q.poll();
				temp -= (cnt++);
				
				
				if(temp <= 0) {
					temp = 0;
					q.add(temp);
					break;
				}
				
				q.add(temp);
				
				if(cnt == 6) {
					cnt = 1;
				}
				
			}
			
			
			while(!q.isEmpty()) {
				sb.append(q.poll());
				sb.append(" ");
			}
			
			System.out.println("#" + test_case + " " + sb.toString());
			
		}
	}
}