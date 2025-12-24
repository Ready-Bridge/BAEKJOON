import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[10001];

        // 1로만 표현
        for(int i = 0; i <= 10000; i++) {
            dp[i] = 1;
        }

        for(int i = 2; i <= 10000; i++) {
            dp[i] += dp[i - 2];
        }

        for(int i = 3; i <= 10000; i++) {
            dp[i] += dp[i - 3];
        }

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int number =  Integer.parseInt(br.readLine());

            System.out.println(dp[number]);
        }
    }
}