import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m ,v;
    static ArrayList<Integer> [] arr;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];

        // 정점이 1부터 시작하니까 index도 맞춰줌
        for(int i = 1; i < n + 1; i++)
            arr[i] = new ArrayList<Integer>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[n + 1];
        dfs(v);

        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);

    }

    public static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;

        for(int i : arr[start]) {
            if(!visited[i])
                dfs(i);

        }

    }

    public static void bfs(int start) {

        ArrayDeque<Integer> toVisit = new ArrayDeque<>();

        toVisit.add(start);

        while(!toVisit.isEmpty()) {
            int a = toVisit.pop();
            System.out.print(a + " ");
            visited[a] = true;

            for(int i = 0; i < arr[a].size(); i++) {
                int b = arr[a].get(i);
                if(!visited[b]) {
                    visited[b] = true;
                    toVisit.add(b);
                }
            }
        }
    }
}