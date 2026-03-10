import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {

        int v;
        int weight;

        Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        List<List<Node>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, weight));
            graph.get(v).add(new Node(u, weight));
        }

        Queue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        int cntMst = 0;
        int cntNode = 0;

        q.offer(new Node(1, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();

            int v = node.v; // now
            int weight = node.weight;

            if(cntNode == N) break;

            if(visited[v]) continue;

            visited[v] = true;
            cntMst += weight;
            cntNode++;

            for(Node next : graph.get(v)) {
                if(!visited[next.v]) {
                    q.offer(next);
                }
            }
        }

        System.out.println(cntMst);
    }
}