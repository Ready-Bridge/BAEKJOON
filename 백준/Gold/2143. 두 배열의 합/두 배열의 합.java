import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		long answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int m = Integer.parseInt(br.readLine());
		int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			
			int sum = 0;
			
			for(int j = i; j < n; j++) {
				
				sum += a[j];
				
				aList.add(sum);
			}
		}
		
		for(int i = 0; i < m; i++) {
			
			int sum = 0;
			
			for(int j = i; j < m; j++) {
				
				sum += b[j];
				
				bList.add(sum);
			}
		}
		
		Collections.sort(aList);
		Collections.sort(bList);
		
		int aPointer = 0;
		int bPointer = bList.size() - 1;
		
		while(aPointer < aList.size() && bPointer >= 0) {
			
			int left = aList.get(aPointer);
			int right= bList.get(bPointer);
			int sum = left + right;
			
			
			if(sum == T) {
				
				int leftCnt = 0;
				int rightCnt = 0;
				
				
				while(aPointer < aList.size() && aList.get(aPointer) == left) {
					aPointer++;
					leftCnt++;
				}
				
				while(bPointer >= 0 && bList.get(bPointer) == right) {
					bPointer--;
					rightCnt++;
				}
				
				
				answer += ((long)leftCnt * rightCnt);
				
			} else if(sum < T) {
				aPointer++;
			} else if(sum > T) {
				bPointer--;
			}
			
		}
		
		System.out.print(answer);
	
	}
}