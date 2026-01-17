import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int INF = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String initial = br.readLine();
        String target = br.readLine();

        char[] arrA = initial.toCharArray(); // 첫 번째 스위치 안 누름
        char[] arrB = initial.toCharArray(); // 첫 번째 스위치 누름

        push(arrB, 0);

        int res1 = solve(arrA, target.toCharArray(), false);
        int res2 = solve(arrB, target.toCharArray(), true);

        int answer = Math.min(res1, res2);
        System.out.println(answer == INF ? -1 : answer);
    }

    // idx 스위치를 눌렀을 때 주변 전구 상태 변경
    static void push(char[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < N) {
                arr[i] = (arr[i] == '0') ? '1' : '0';
            }
        }
    }

    static int solve(char[] current, char[] target, boolean pushedFirst) {
        int count = pushedFirst ? 1 : 0;

        // 1번 인덱스 스위치부터 순차적으로 결정
        for (int i = 1; i < N; i++) {
            // i-1번째 전구가 목표와 다르다면 i번째 스위치를 반드시 눌러야 함
            if (current[i - 1] != target[i - 1]) {
                push(current, i);
                count++;
            }
        }

        // 마지막 상태가 타겟과 일치하는지 확인
        return Arrays.equals(current, target) ? count : INF;
    }
}