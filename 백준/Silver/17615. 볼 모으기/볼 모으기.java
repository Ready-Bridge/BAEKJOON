import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int totalR = 0;
        int totalB = 0;

        // 전체 개수 세기
        for (char c : arr) {
            if (c == 'R') totalR++;
            else totalB++;
        }

        int answer = Integer.MAX_VALUE;

        int cnt = totalR;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') cnt--;
            else break;
        }
        answer = Math.min(answer, cnt);

        cnt = totalR;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'R') cnt--;
            else break;
        }
        answer = Math.min(answer, cnt);

        cnt = totalB;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'B') cnt--;
            else break;
        }
        answer = Math.min(answer, cnt);

        cnt = totalB;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'B') cnt--;
            else break;
        }
        answer = Math.min(answer, cnt);

        System.out.println(answer);
    }
}