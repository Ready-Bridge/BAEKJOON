import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s, cnt;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st1.nextToken());
        s = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        find(0, 0);

        // 합이 0이 되는 경우에는 공집합도 포함되므로 cnt에서 1을 빼줌
        if(s == 0) {
            System.out.println(cnt - 1);
        } else {
            System.out.println(cnt);
        }

    }

    public static void find(int index, int sum) {

        // 각 경우에 대해 마지막 인덱스까지 도달했으면 현재 선택된 수열의 sum 값과 목표 값 n이 일치하면 cnt를 1 늘림
        if(index == n) {
            if(sum == s) {
                cnt++;
            }

            return;
        }

        find(index + 1, sum + arr[index]); // 현재 index가 부분 수열에 포함될 경우 sum에 값을 더해주고 넘겨줌
        find(index + 1, sum); // 현재 index가 부분 수열에 포함되지 않는 경우 sum을 현재 값 그대로 넘겨줌
    }
}