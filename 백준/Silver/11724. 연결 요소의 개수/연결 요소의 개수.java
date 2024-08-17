import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, cnt;
    static int [][] arr;
    static int [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        visited = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            if(visited[i] == 0) {
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int start){

        visited[start] = 1;

        for (int i = 1; i < n + 1; i++) {
            if (arr[start][i] == 1)
                if (visited[i] != 1)
                    dfs(i);

        }
    }
}