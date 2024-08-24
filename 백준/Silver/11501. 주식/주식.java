import java.io.*;
import java.util.*;

public class Main {
    static long high; // 고점, 테스트케이스, 날의 수
    static int N, T;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {

            result = 0; // 테스트케이스마다 결과값 초기화
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long[] chart = new long[N];

            // 입력되는 날의 수를 Int 배열로 변환
            for(int i = 0; i < N; i++) {
                chart[i] = Long.parseLong(st.nextToken());
            }

            high = 0;

            for (int i = chart.length - 1; i >= 0; i--) {
                if (chart[i] > high) {
                    high = chart[i];
                } else {
                    result += (high - chart[i]);
                }
            }
            System.out.println(result);
        }
    }
}