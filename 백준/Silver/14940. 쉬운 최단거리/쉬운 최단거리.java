import java.io.*;
import java.util.*;

public class Main {

    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    static boolean isRange(int[][] answer, int[][] map, int row, int col) {

        if(row < 0 || row >= map.length || col < 0 || col >= map[0].length) {
            return false;
        }

        if(map[row][col] == 0) {
            return false;
        }

        if(answer[row][col] != 0) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] answer = new int[n][m];
        int[] target = new int[3];

        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int k = 0; k < m; k++) {
                if(map[i][k] == 2) {
                    target[0] = i;
                    target[1] = k;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(target);

        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int row = arr[0];
            int col = arr[1];
            int value = arr[2];

            for(int d = 0; d < 4; d++) {

                int newRow = row + drow[d];
                int newCol = col + dcol[d];
                int newValue = value + 1;

                if(isRange(answer, map, newRow, newCol)) {
                    answer[newRow][newCol] = newValue;
                    q.add(new int[] {newRow, newCol, newValue});
                }

            }
        }

        answer[target[0]][target[1]] = 0;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(answer[row][col] == 0 && map[row][col] == 1) {
                    answer[row][col] = -1;
                }
            }
        }

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                System.out.print(answer[row][col] + " ");
            }

            System.out.println();
        }

    }
}