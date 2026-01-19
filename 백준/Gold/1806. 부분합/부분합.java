import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = arr[right];
        int answer = 100001;

        while(left <= right) {

            if(sum >= S) {
                answer = Math.min(answer, right - left + 1);
                sum -= arr[left];
                left++;

                if(left >= N) break;

            } else {
                right++;

                if(right >= N) break;

                sum += arr[right];
            }
        }

        if(answer == 100001) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }

    }
}