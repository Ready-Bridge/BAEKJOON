import java.io.*;
import java.util.*;

public class Main {

    static int cnt = 0;
    static int N, K, P;
    static int[] X;
    static int[][] change = new int[][] {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}};

    static int[] numToArr(int num) {
        int[] res = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            res[i] = num % 10;
            num /= 10;
        }
        return res;
    }

    static boolean canConvert(int floor) {

        int[] arr = numToArr(floor);

        int sum = 0;

        for(int i = 0; i < K; i++) {

            sum += (change[X[i]][arr[i]]);

            if(sum > P) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 최대 층 수
        K = Integer.parseInt(st.nextToken()); // 자리의 수
        P = Integer.parseInt(st.nextToken()); // LED 바꿀 수 있는 갯수
        int x = Integer.parseInt(st.nextToken()); // 현재 층 수
        X = numToArr(x);

        int cnt = 0;

        for(int i = 1; i <= N; i++) {
            if(canConvert(i)) cnt++;
        }

        System.out.println(cnt - 1); // 자기자신 제외
    }
}
