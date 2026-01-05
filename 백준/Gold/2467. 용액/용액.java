import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;

        while(left < right) {
            int sum = arr[left] + arr[right];

            if(sum == 0) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                break;
            }

            if(Math.abs(sum) < Math.abs(min)) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                min = sum;
            }

            if(sum < 0) {
                left++;
            } else {
                right--;
            }

        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}