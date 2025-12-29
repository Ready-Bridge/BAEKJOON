import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] move = new int[101];
        int[] dist = new int[101];

        Arrays.fill(dist, -1);

        for(int i = 1; i <= 100; i++) {
            move[i] = i;
        }

        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            move[start] = end;
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {1, 0});

        while(!q.isEmpty()) {

            int[] temp = q.poll();
            int pos = temp[0];
            int cnt = temp[1];

            if(pos == 100) {
                break;
            }

            for(int d = 1; d <= 6; d++) {
                int next = pos + d;
                if(next > 100) break;

                next = move[next];

                if(dist[next] == -1) {
                    dist[next] = cnt + 1;
                    q.add(new int[] {next, cnt + 1});
                }
            }

        }

        System.out.println(dist[100]);

    }
}