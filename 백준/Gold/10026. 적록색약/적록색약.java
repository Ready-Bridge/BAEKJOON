import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    static char[][] map1;
    static char[][] map2;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] visitedMap1;
    static boolean[][] visitedMap2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map1 = new char[N][N];
        map2 = new char[N][N];
        visitedMap1 = new boolean[N][N];
        visitedMap2 = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char[] temp = st.nextToken().toCharArray();

            for(int j = 0; j < N; j++){
                map1[i][j] = temp[j];

                if(temp[j] == 'G') {
                    map2[i][j] = 'R';
                } else {
                    map2[i][j] = temp[j];
                }
            }
        }

        int cntMap1 = 0;

        // map1 탐색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visitedMap1[i][j]) {
                    cntMap1++;
                    bfs1(i, j);
                }
            }
        }

        int cntMap2 = 0;

        // map2 탐색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visitedMap2[i][j]) {
                    cntMap2++;
                    bfs2(i, j);
                }
            }
        }

        System.out.println(cntMap1 + " " +  cntMap2);

    }

    static void bfs1(int row, int col) {

        Queue<int[]> q = new LinkedList<>();

        visitedMap1[row][col] = true;
        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            int nowRow = temp[0];
            int nowCol = temp[1];

            for (int d = 0; d < 4; d++) {
                int nextRow = nowRow + dx[d];
                int nextCol = nowCol + dy[d];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                    continue;
                }

                if (map1[nextRow][nextCol] != map1[nowRow][nowCol]) {
                    continue;
                }

                if (visitedMap1[nextRow][nextCol]) {
                    continue;
                }

                visitedMap1[nextRow][nextCol] = true;
                q.offer(new int[]{nextRow, nextCol});
            }
        }
    }

    static void bfs2(int row, int col) {

        Queue<int[]> q = new LinkedList<>();

        visitedMap2[row][col] = true;
        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            int nowRow = temp[0];
            int nowCol = temp[1];

            for (int d = 0; d < 4; d++) {
                int nextRow = nowRow + dx[d];
                int nextCol = nowCol + dy[d];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                    continue;
                }

                if (map2[nextRow][nextCol] != map2[nowRow][nowCol]) {
                    continue;
                }

                if (visitedMap2[nextRow][nextCol]) {
                    continue;
                }

                visitedMap2[nextRow][nextCol] = true;
                q.offer(new int[]{nextRow, nextCol});
            }
        }
    }
}