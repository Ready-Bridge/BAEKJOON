import java.util.*;
import java.io.*;

public class Solution { 	
	 
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			String answer = "Possible";
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[st.countTokens()];
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int total = 0;
			
			for(int i = 0; i < arr.length; i++) {
				
				total = (arr[i] / M) * K;
				
				if(total < i + 1) {
					answer = "Impossible";
					break;
				}
			}
					 
			System.out.println("#" + test_case + " " + answer);
		}
		
	}
}