import java.io.*;
import java.util.*;

public class Main {
	
	static int[] numbers;
	
	
	static boolean isGood(int numberIdx) {
		
		int i = 0;
		int j = numbers.length - 1;
		
		while(i < j) {
			
			//Good을 만족하면  
			if(numbers[i] + numbers[j] == numbers[numberIdx]) {
				
				if(i != numberIdx && j != numberIdx) {
					return true;
					
				}else if(i == numberIdx) {
					i++;
					
				} else if(j == numberIdx) {
					j--;
				}
				
			} else if(numbers[i] + numbers[j] > numbers[numberIdx]) {
				
				j--;
				
			} else if(numbers[i] + numbers[j] < numbers[numberIdx]) {
				i++;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			
			if(isGood(i)) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
}