import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int max = -1;
        int prev = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (M == 1) {
            int temp = Integer.parseInt(st.nextToken());
            max = Math.max(temp, N - temp);
        } else {
            int start = Integer.parseInt(st.nextToken());
            max = Math.max(max, start - 0);
            prev = start;

            for (int i = 0; i < M - 2; i++) {
                int now = Integer.parseInt(st.nextToken());
                max = Math.max(max, (now - prev + 1) / 2);
                prev = now;
            }

            int end = Integer.parseInt(st.nextToken());
            max = Math.max(max, N - end);
        }

        System.out.println(max);
    }
}