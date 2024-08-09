import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			Cantor(n);
			System.out.println();
		}
	}


	public static void Cantor(int n) {
		if(n == 0)
			System.out.print("-");
		else {
			Cantor(n-1);
			System.out.print(" ".repeat((int)Math.pow(3, n - 1)));
			Cantor(n-1);
		}
	}
}