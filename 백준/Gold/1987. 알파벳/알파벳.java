import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static boolean[] alphaUsed = new boolean[26];
    static int answer = 0;
    static int R, C;
    static int[] drow = {-1, 1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};

    static void dfs(int row, int col, int cnt) {
        // 매 단계마다 최댓값을 갱신
        answer = Math.max(answer, cnt);

        if (answer == 26) return;

        for (int d = 0; d < 4; d++) {
            int nRow = row + drow[d];
            int nCol = col + dcol[d];

            if (nRow >= 0 && nRow < R && nCol >= 0 && nCol < C) {
                int idx = arr[nRow][nCol] - 'A';

                if (!alphaUsed[idx]) {
                    alphaUsed[idx] = true;
                    dfs(nRow, nCol, cnt + 1);
                    alphaUsed[idx] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        alphaUsed[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(answer);
    }
}