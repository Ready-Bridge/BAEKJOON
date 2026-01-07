import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> list = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;

    static void dfs(int idx) {
        visited[idx] = true;
        int next = arr[idx];
        
        if (!visited[next]) {
            dfs(next);
        }
        // 방문했지만 아직 DFS가 끝나지 않은 노드 → 진짜 사이클
        else if (!finished[next]) {
            int cur = next;
            do {
                list.add(cur);
                cur = arr[cur];
            } while (cur != next);
        }

        // DFS 종료 처리
        finished[idx] = true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int x : list) {
            System.out.println(x);
        }
    }
}
