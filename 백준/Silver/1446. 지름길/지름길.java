import java.io.*;
import java.util.*;

public class Main {

    static class Shortcut {
        int start, end, dist;

        Shortcut(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            // 의미 없는 지름길 제거
            if (end > D) continue;
            if (dist >= end - start) continue;

            shortcuts.add(new Shortcut(start, end, dist));
        }

        // dp 배열
        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // i를 0부터 D까지 이동
        for (int i = 0; i <= D; i++) {

            // 기본 이동
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }

            // 지름길 적용
            for (Shortcut s : shortcuts) {
                if (s.start == i) {
                    dp[s.end] = Math.min(dp[s.end], dp[i] + s.dist);
                }
            }
        }

        System.out.println(dp[D]);
    }
}