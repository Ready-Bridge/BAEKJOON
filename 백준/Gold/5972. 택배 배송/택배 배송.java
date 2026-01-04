import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 헛간
        int M = Integer.parseInt(st.nextToken()); // 양방향 길

        ArrayList<int[]>[] graph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[] {b, c});
            graph[b].add(new int[] {a, c});
        }

        int[] dist = new int[N + 1]; // 1 ~ N 까지 사용
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        dist[1] = 0;
        q.offer(new int[]{1, 0}); // 가려는 노드, 이동 가중치

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            int nowNode = temp[0];
            int nowWeight = temp[1];

            if(nowNode == N) {
                break;
            }

            if(nowWeight > dist[nowNode]) continue;

            for(int[] arr : graph[temp[0]]) {

                int nextNode = arr[0];
                int nextWeight = arr[1];

                int tempDist = nowWeight + nextWeight;

                if(tempDist < dist[nextNode]) {
                    q.offer(new int[] {nextNode, tempDist});
                    dist[nextNode] = tempDist;
                }
            }
        }

        System.out.println(dist[N]);

    }
}