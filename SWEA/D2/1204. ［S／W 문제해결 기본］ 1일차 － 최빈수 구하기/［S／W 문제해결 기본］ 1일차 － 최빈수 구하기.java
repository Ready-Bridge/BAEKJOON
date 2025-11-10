import java.io.*;
import java.util.*;

public class Solution {

	
	public static void main(String[] args) throws IOException {
		
		int answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			String test = br.readLine();
			
			int prevValue = 0;
			
			Map<Integer, Integer> treeMap = new TreeMap<>((a, b) -> b - a);
			
			String[] stringNumbers = br.readLine().split(" ");
			
			int[] numbers = Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).toArray();
			
			for(int number : numbers) {
				if(treeMap.containsKey(number)) {
					treeMap.put(number, treeMap.get(number) + 1);
				} else {
					treeMap.put(number , 1);
				}
			}
			
			for(Map.Entry<Integer, Integer> entrySet : treeMap.entrySet() ) {
				
				if(entrySet.getValue() > prevValue) {
					answer = entrySet.getKey();
					prevValue = entrySet.getValue();
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
			
		}
		
	}

}
