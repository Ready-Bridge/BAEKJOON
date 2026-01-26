import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][][] dp;
    static int N, M;
    // MAX_VALUE 대신 안전한 큰 값을 사용합니다. (N, M <= 1000, 비용 <= 100 이므로 1,000,000이면 충분)
    static final int INF = 1_000_001;

    static void find() {
        for(int i = 1; i < N; i++) {
            for(int k = 0; k < M; k++) {
                // 0: 왼쪽 대각선 위에서 오는 경우
                if(k - 1 >= 0) {
                    dp[i][k][0] = Math.min(dp[i - 1][k - 1][1], dp[i - 1][k - 1][2]) + arr[i][k];
                }

                // 1: 바로 위에서 오는 경우
                dp[i][k][1] = Math.min(dp[i - 1][k][0], dp[i - 1][k][2]) + arr[i][k];

                // 2: 오른쪽 대각선 위에서 오는 경우
                if(k + 1 < M) {
                    dp[i][k][2] = Math.min(dp[i - 1][k + 1][0], dp[i - 1][k + 1][1]) + arr[i][k];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M][3];

        for(int i = 0; i < N; i++) {
            for(int k = 0; k < M; k++) {
                Arrays.fill(dp[i][k], INF); // INF로 초기화
            }
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < M; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            for(int k = 0; k < 3; k++) {
                dp[0][i][k] = arr[0][i];
            }
        }

        find();

        int answer = INF;
        for(int i = 0; i < M; i++) {
            for(int k = 0; k < 3; k++) {
                answer = Math.min(answer, dp[N - 1][i][k]);
            }
        }

        System.out.println(answer);
    }
}