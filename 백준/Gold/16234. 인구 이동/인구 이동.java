import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<int[]> union; // 현재 탐색 중인 연합의 좌표들 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            boolean isMoved = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 아직 방문하지 않았고, BFS를 통해 연합을 형성할 수 있는지 확인
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (union.size() > 1) { // 연합군이 2개 이상일 때만 인구 이동 발생
                            changePopulation(sum);
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) break; // 더 이상 이동이 없으면 종료
            result++;
        }
        System.out.println(result);
    }

    static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        union = new ArrayList<>(); // 연합 국가 좌표 저장용

        q.offer(new int[]{r, c});
        union.add(new int[]{r, c});
        visited[r][c] = true;
        int sum = map[r][c];

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    int diff = Math.abs(map[curr[0]][curr[1]] - map[nr][nc]);
                    if (diff >= L && diff <= R) {
                        q.offer(new int[]{nr, nc});
                        union.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        sum += map[nr][nc];
                    }
                }
            }
        }
        return sum;
    }

    // 연합 내 인구수 갱신
    static void changePopulation(int sum) {
        int avg = sum / union.size();
        for (int[] pos : union) {
            map[pos[0]][pos[1]] = avg;
        }
    }
}