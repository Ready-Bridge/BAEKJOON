import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = 0;
        int max = arr[arr.length - 1];

        while(min <= max) {

            boolean flag = false;
            int mid = (min + max) / 2;

            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    sum += mid;
                }

                if(sum > M) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }


        }

        System.out.println(max);


    }
}