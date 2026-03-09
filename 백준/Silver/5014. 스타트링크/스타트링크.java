import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()); // 총 F층
        int S = Integer.parseInt(st.nextToken()); // 현재 있는 곳
        int G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 위치
        int U = Integer.parseInt(st.nextToken()); // 위로 가는 버튼
        int D = Integer.parseInt(st.nextToken()); // 아래로 가는 버튼

        int[] arr = new int[F + 1];

        Arrays.fill(arr, -1);

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {S, 0});
        arr[S] = 0;

        while(!q.isEmpty()) {

            int[] temp = q.poll();
            int pos = temp[0];
            int cnt = temp[1];

            if(pos == G) {
                System.out.println(cnt);
                return;
            }

            if(pos + U >= 1 && pos + U <= F) {
                if(arr[pos + U] == -1) {
                    arr[pos + U] = cnt;
                    q.add(new int[] {pos + U, cnt + 1});
                }
            }

            if(pos - D >= 1 && pos - D <= F) {
                if(arr[pos - D] == -1) {
                    arr[pos - D] = cnt;
                    q.add(new int[] {pos - D, cnt + 1});
                }
            }
        }

        System.out.println("use the stairs");

    }
}