import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        boolean flag = false;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] != 0) {
                flag = true;
            }
        }

        if(flag) {

            // 누적합
            int[] sum = new int[N];
            sum[0] = arr[0];

            // 누적합 배열
            for(int i = 1; i < N; i++) {
                sum[i] = sum[i - 1] + arr[i];
            }

            int max = sum[X - 1];
            int seq = 1;

            // 누적합으로 계산
            for(int i = X; i < N; i++) {
                int result = sum[i] - sum[i - X];

                if(result > max) {
                    max = result;
                    seq = 1;
                } else if(result == max) {
                    seq++;
                }
            }

            System.out.println(max);
            System.out.println(seq);

        } else {
            System.out.println("SAD");
        }



    }
}