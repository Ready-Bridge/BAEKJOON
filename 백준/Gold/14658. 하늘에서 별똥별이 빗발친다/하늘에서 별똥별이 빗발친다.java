import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Integer result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] stars = new int[K][2];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            stars[i][0] = x;
            stars[i][1] = y;
        }

        int max = -1;

        for(int i = 0; i < K; i++) {
            int x = stars[i][0];

            for(int k = 0; k < K; k++) {
                int y = stars[k][1];

                int[] startPoint = new int[] {x, y};
                int[] endPoint = new int[] {x + L, y + L};


                int cnt = 0;

                for(int j = 0; j < K; j++) {
                    if(stars[j][0] >= startPoint[0] && stars[j][0] <= endPoint[0] && stars[j][1] >= startPoint[1] && stars[j][1] <= endPoint[1]) {
                        cnt++;
                    }
                }

                max = Math.max(max, cnt);
            }
        }

        System.out.println(K - max);
    }
}