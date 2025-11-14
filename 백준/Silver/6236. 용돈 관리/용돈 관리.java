import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;
	static int N, M;
	
	static boolean isCheck(int money) {
		int current = money;
		int K = 1;
		
		for(int need : arr) {
			if(current < need) {
				K++;
				current = money;
			}
			
			current -= need;
			
		}
		
		return K <= M;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		int start = 0;
		int end = 0;
		int answer = 0; // 최소 금액 K
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			end += arr[i]; // end는 전체 사용 금액을 한 번에 인출할 수 있는 금
			
			if(start < arr[i]) {
				start = arr[i]; // start는 사용하는 금액이 가장 높은 날의 금
			}
		}
		
		while(start <= end) {
			
			int mid = (start + end) / 2;
			
			if(isCheck(mid)) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(answer);
		
	}
}