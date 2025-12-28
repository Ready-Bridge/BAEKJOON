import java.io.*;
import java.util.*;

public class Main {

    static boolean isEnd(int[] arr, int K) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) cnt++;
        }
        return cnt >= K;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[2 * N];
        boolean[] visited = new boolean[2 * N];

        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        while (true) {
            answer++;

            int temp = arr[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
                visited[i] = visited[i - 1];
            }
            arr[0] = temp;
            visited[0] = false;

            visited[N - 1] = false;

            for (int i = N - 2; i >= 0; i--) {
                if (visited[i] && !visited[i + 1] && arr[i + 1] >= 1) {
                    visited[i] = false;
                    visited[i + 1] = true;
                    arr[i + 1]--;
                }
            }

            visited[N - 1] = false;

            if (arr[0] >= 1 && !visited[0]) {
                visited[0] = true;
                arr[0]--;
            }

            if (isEnd(arr, K)) break;
        }

        System.out.println(answer);
    }
}
