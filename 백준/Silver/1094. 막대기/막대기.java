import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		
		int X = Integer.parseInt(br.readLine());
		
		while(X > 0) {
			
			if(X % 2 == 1) {
				cnt ++;
			}
			
			
			X /= 2;
		}
		
		System.out.println(cnt);
		
	}
}