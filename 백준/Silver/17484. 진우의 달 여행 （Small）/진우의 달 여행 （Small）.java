import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][][] dp = new int[N][M][3]; // 0 : 왼쪽, 1 : 가운데, 2 : 오른쪽 에서 옴

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < 3; j++) {
                dp[0][i][j] = map[0][i];
            }
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){

                // 왼쪽에서 오는 경우
                if(j - 1 >= 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + map[i][j];
                } else {
                    dp[i][j][0] = 100001;
                }

                // 가운데서 오는 경우
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];

                // 오른쪽에서 오는 경우
                if(j + 1 < M) {
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + map[i][j];
                } else {
                    dp[i][j][2] = 100001;
                }
            }
        }

        int answer = 100001;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[N - 1][i][j]);
            }
        }

        System.out.println(answer);
    }
}