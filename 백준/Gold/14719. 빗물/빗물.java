import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[W];

        for(int i = 0 ; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 1; i < W - 1; i++) {

            int left = 0;
            int right = 0;

            for(int k = 0; k < i; k++) {
                left = Math.max(left, arr[k]);
            }

            for(int k = i + 1; k < W; k++) {
                right = Math.max(right, arr[k]);
            }

            int min = Math.min(left, right);

            if(min > arr[i]) {
                answer += (min - arr[i]);
            }

        }

        System.out.println(answer);
    }
}