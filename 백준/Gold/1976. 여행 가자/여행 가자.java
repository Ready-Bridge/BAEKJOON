import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[][] arr;

    static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);

        if(a > b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int n) {

        if(parent[n] != n) {
            parent[n] = find(parent[n]);
        }

        return parent[n];
    }

    static boolean isConnected(int n1, int n2) {
        return find(n1) == find(n2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        arr = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int k = 1; k <= N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int k = 1; k <= N; k++) {
                if(arr[i][k] == 1) {
                    union(i, k);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int[] path = new int[M];

        for(int i = 0; i < M; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }

        boolean answer = true;

        for(int i = 1; i < M; i++) {
            if(!isConnected(path[i], path[i - 1])) {
                answer = false;
                break;
            }
        }

        if(answer) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}