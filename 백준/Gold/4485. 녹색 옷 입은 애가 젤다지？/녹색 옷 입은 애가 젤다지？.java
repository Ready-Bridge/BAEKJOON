import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] result;
    static int N;
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    static boolean isRange(int row, int col) {
        if(row < 0 || row >= N || col < 0 || col >= N) {
            return false;
        }

        return true;
    }

    static void find() {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.offer(new int[] {0, 0, map[0][0]});

        while(!q.isEmpty()) {

            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            int cost = pos[2];

            if(cost >= result[row][col]) {
                continue;
            }

            result[row][col] = cost;

            for(int d = 0; d < 4; d++) {

                int newRow = row + drow[d];
                int newCol = col + dcol[d];

                if(isRange(newRow, newCol)) {
                    int newCost = cost + map[newRow][newCol];

                    q.offer(new int[] {newRow, newCol, newCost});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int problem = 1;

        while(true) {

            N = Integer.parseInt(br.readLine());

            if(N == 0) {
                break;
            }

            map = new int[N][N];
            result = new int[N][N];

            for(int i = 0; i < N; i++) {
                Arrays.fill(result[i], Integer.MAX_VALUE);
            }

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int k = 0; k < N; k++) {
                    map[i][k] = Integer.parseInt(st.nextToken());
                }
            }

            find();

            System.out.println("Problem " + problem++ + ": " + result[N - 1][N - 1]);
        }
    }
}