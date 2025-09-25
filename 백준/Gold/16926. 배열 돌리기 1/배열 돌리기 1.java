import java.io.*;
import java.util.*;

public class Main {

    // 회전시키는 함수
    private static void rotate(int[][] map, int minRow, int minCol, int maxRow, int maxCol) {

        int temp = map[minRow][minCol]; // 마지막에 밑으로 한 칸 이동시킬 값

        // 윗면 왼쪽으로 이동
        for (int i = minCol + 1; i <= maxCol; i++) {
            map[minRow][i - 1] = map[minRow][i];
        }

        // 오른쪽면 위로 이동
        for (int i = minRow + 1; i <= maxRow; i++) {
            map[i - 1][maxCol] = map[i][maxCol];
        }

        // 밑면 오른쪽으로 이동
        for (int i = maxCol - 1; i >= minCol; i--) {
            map[maxRow][i + 1] = map[maxRow][i];
        }

        // 왼쪽면 아래로 이동
        for (int i = maxRow - 1; i >= minRow; i--) {
            map[i + 1][minCol] = map[i][minCol];
        }

        // temp 채워주기
        map[minRow + 1][minCol] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        int R = Integer.parseInt(st.nextToken()); // 회전 수
        int[][] map = new int[N][M];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(N, M) / 2; // 총 layer 수

        // R회 회전
        for (int r = 0; r < R; r++) {
            for (int layer = 0; layer < layers; layer++) {
                rotate(map, layer, layer, N - layer - 1, M - layer - 1);
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                bw.write(map[i][k] + " ");
            }
            bw.newLine();
        }
        bw.close();
    }
}
