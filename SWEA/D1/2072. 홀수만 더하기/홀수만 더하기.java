import java.io.*;
import java.util.Arrays;

public class Solution {

static int findAnswer(int[] numbers) {
		
		int sum = 0;
		
		for(int i = 0; i < 10; i++) {
			int number = numbers[i];
			
			if(number % 2 != 0) {
				sum += number;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		
		int sum = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			
			String[] tempNumbers = br.readLine().split(" ");
			
			
			int[] numbers = Arrays.stream(tempNumbers).mapToInt(Integer::parseInt).toArray();
			
			sum = findAnswer(numbers);
			
			System.out.println("#" + i + " " + sum);
		}
	}

}
