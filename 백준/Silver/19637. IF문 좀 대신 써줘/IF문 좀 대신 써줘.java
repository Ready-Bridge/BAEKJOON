import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] styles = new String[N];
        int[] boundaries = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String style = st.nextToken();
            int boundary = Integer.parseInt(st.nextToken());

            styles[i] = style;
            boundaries[i] = boundary;
        }

        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            int start = 0;
            int end = N - 1;
            int mid = 0;
            int answer = 0;

            while(start <= end) {

                mid = (start + end) / 2;

                if(num <= boundaries[mid]) {
                    answer = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            System.out.println(styles[answer]);
        }
    }
}