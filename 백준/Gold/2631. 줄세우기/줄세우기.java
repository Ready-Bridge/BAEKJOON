import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        Arrays.fill(dp, 1);

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 1;

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(arr[i] < arr[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    if(dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
        }

        System.out.println(N - max);


        // 1 6 2 3 4 5 8 7

    }
}