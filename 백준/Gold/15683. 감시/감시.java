import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Cctv {
    int r, c, type;
    public Cctv(int r, int c, int type) {
        this.r = r;
        this.c = c;
        this.type = type;
    }
}

public class Main {
    static int N, M;
    static int minBlindSpot;
    // 방향 벡터: 상(0), 우(1), 하(2), 좌(3)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        List<Cctv> cctvs = new ArrayList<>();

        // 먼저 지도를 모두 입력받고 1~4번 CCTV만 리스트에 넣음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());

                if (map[i][k] >= 1 && map[i][k] <= 4) {
                    cctvs.add(new Cctv(i, k, map[i][k]));
                }
            }
        }

        // 지도가 완성된 후, 지도를 순회하며 5번 CCTV를 일괄 처리
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (map[i][k] == 5) {
                    processCctv5(map, i, k);
                }
            }
        }

        // 남은 사각지대 개수 초기화
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    minBlindSpot++;
                }
            }
        }

        // DFS 시작 (0번 인덱스 CCTV부터 탐색)
        dfs(0, map, cctvs);

        System.out.println(minBlindSpot);
    }

    // 5번 CCTV를 사방으로 뻗어나가게 하는 로직
    static void processCctv5(int[][] map, int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (map[nr][nc] == 6) break; // 벽이면 중단
                if (map[nr][nc] == 0) map[nr][nc] = -1; // 빈칸만 감시 영역(-1)으로 표시
                nr += dr[d];
                nc += dc[d];
            }
        }
    }

    static void dfs(int idx, int[][] map, List<Cctv> cctvs) {

        if(idx == cctvs.size()) {

            int cnt = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            minBlindSpot = Math.min(minBlindSpot, cnt);

            return;
        }

        Cctv cctv = cctvs.get(idx);

        // 90도씩 4번 회전
        for (int i = 0; i < 4; i++) {

            int[][] newMap = copyMap(map);

            switch (cctv.type) {
                case 1:
                    watch(newMap, cctv.r, cctv.c, i);
                    break;

                case 2:
                    watch(newMap, cctv.r, cctv.c, i % 4);
                    watch(newMap, cctv.r, cctv.c, (i + 2) % 4);
                    break;

                case 3:
                    watch(newMap, cctv.r, cctv.c, i);
                    watch(newMap, cctv.r, cctv.c, (i + 1) % 4);
                    break;

                case 4:
                    watch(newMap, cctv.r, cctv.c, i % 4);
                    watch(newMap, cctv.r, cctv.c, (i + 1) % 4);
                    watch(newMap, cctv.r, cctv.c, (i + 2) % 4);
                    break;
            }

            dfs(idx + 1, newMap, cctvs);
        }

    }

    // 감시 하는 방향으로 뻗어나가는 함수
    static void watch(int[][] map, int r, int c, int rotation) {
        int nr = r + dr[rotation];
        int nc = c + dc[rotation];

        while(nr >= 0 && nc >= 0 && nr < N && nc < M) {
            if (map[nr][nc] == 6) {
                break;
            }

            if(map[nr][nc] == 0) {
                map[nr][nc] = -1;
            }

            nr += dr[rotation];
            nc += dc[rotation];
        }
    }

    // 배열 깊은 복사
    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        return newMap;
    }
}