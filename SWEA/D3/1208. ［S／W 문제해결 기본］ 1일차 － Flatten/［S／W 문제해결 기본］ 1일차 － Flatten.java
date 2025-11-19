import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			
			int answer = 0;
			
			int dump = Integer.parseInt(br.readLine());
			
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		
			for(int i = 0; i < dump; i++) {
				arr[0] += 1;
				arr[arr.length - 1] -= 1;
				
				Arrays.sort(arr);
				
				if(arr[arr.length - 1] - arr[0] <= 1) {
					break;
				}
			}
			
			answer = arr[arr.length - 1] - arr[0];
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}